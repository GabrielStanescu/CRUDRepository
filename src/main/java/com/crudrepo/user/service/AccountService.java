package com.crudrepo.user.service;

import com.crudrepo.user.model.Account;
import com.crudrepo.user.model.JWTRequest;
import com.crudrepo.user.model.JWTResponse;
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

    public boolean isValidJWT(JWTResponse jwtResponse) throws NoSuchAlgorithmException, InvalidKeyException {
        jwtService.getUserByJWT(jwtResponse);
        return true;
    }
}
