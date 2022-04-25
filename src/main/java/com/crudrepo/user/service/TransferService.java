package com.crudrepo.user.service;

import com.crudrepo.user.exceptions.InvalidJWTException;
import com.crudrepo.user.exceptions.UnauthorizedException;
import com.crudrepo.user.model.Account;
import com.crudrepo.user.model.JWTResponse;
import com.crudrepo.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class TransferService {

    @Autowired
    @Qualifier("internal")
    Transfer internalTransfer;

    @Autowired
    @Qualifier("external")
    Transfer externalTransfer;

    @Autowired
    JWTService jwtService;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserRepository userRepository;

    private boolean isInternal(String i1, String i2) {
        return i1.charAt(0) == i2.charAt(0) && i1.charAt(1) == i2.charAt(1);
    }

    public boolean sendMoney(String dest, String src, double amount) {
        Optional<Account> srcAcc = accountRepository.findByIBAN(src);
        if (srcAcc.get().getBalance() < amount)
            return false;
        return isInternal(dest, src) ?
                internalTransfer.sendMoney(dest, srcAcc.get(), amount) :
                externalTransfer.sendMoney(dest, srcAcc.get(), amount);
    }

    public void checkUserAuthorization(JWTResponse jwtResponse, String srcIban) throws InvalidJWTException, GeneralSecurityException, UnauthorizedException {
        // check for jwt integrity
        User jwtUser = jwtService.getUserByJWT(jwtResponse);
        Optional<User> dbUser = userRepository.findById(jwtUser.getId());
        if (dbUser.isEmpty())
            throw new InvalidJWTException("Couldn't find an user with the specified ID.");
        if (jwtUser.matches(dbUser.get())) {
            // check if user is authorized to use srcIban
            int userId = jwtUser.getId();
            Optional<Account> account = accountRepository.findByIBAN(srcIban);
            if (account.isEmpty() || account.get().getUserId() != userId) {
                throw new UnauthorizedException("User is not authorized to use specified IBAN.");
            }
        } else {
            throw new InvalidJWTException("User details are invalid.");
        }
    }
}
