package com.crudrepo.user.service;

import com.crudrepo.user.exceptions.InvalidJWTException;
import com.crudrepo.user.model.Account;
import com.crudrepo.user.model.JWTRequest;
import com.crudrepo.user.model.JWTResponse;
import com.crudrepo.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JWTService jwtService;

    public boolean createAccount(Integer id, String currency, String prefix) {
        Account account = new Account();
        if (userRepository.findById(id).isEmpty())
            return false;
        account.setUserId(id);
        account.setCurrency(currency);
        account.setIBAN(ibanGenerator(prefix));
        accountRepository.save(account);
        return true;
    }

    public String ibanGenerator(String prefix) {
        StringBuilder iban = new StringBuilder(prefix); // can be edited manually
        Random rand = new Random();
        int i, n;

        while (true) {
            for (i = 0; i < 14; i++) {
                n = rand.nextInt(10);
                iban.append(n);
            }
            if (!ibanDuplicate(iban.toString()))
                break;
            iban = new StringBuilder(prefix);
        }

        return iban.toString();
    }

    public boolean ibanDuplicate(String iban) {
        Optional<Account> op = accountRepository.findByIBAN(iban);
        return op.isPresent();
    }

    public List<Account> getAccounts(int id) {
        return accountRepository.findAllByUserId(id);
    }

    public int getUserIdFromJwt(JWTResponse jwtResponse) throws NoSuchAlgorithmException, InvalidKeyException, InvalidJWTException {
        User jwtUser = jwtService.getUserByJWT(jwtResponse);
        int id = jwtUser.getId();
        Optional<User> dbUser = userRepository.findById(id);
        if (dbUser.isEmpty())
            throw new InvalidJWTException("Couldn't find an user with the specified ID.");
        if (areUsersMatching(jwtUser, dbUser.get())) {
            return id;
        } else {
            throw new InvalidJWTException("User details are invalid.");
        }
    }

    private boolean areUsersMatching(User u1, User u2) {
        return u1.getFirstName().equals(u2.getFirstName())
                && u1.getLastName().equals(u2.getLastName())
                && u1.getEmail().equals(u2.getEmail())
                && u1.getAge() == u2.getAge();
    }
}
