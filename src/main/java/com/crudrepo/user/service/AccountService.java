package com.crudrepo.user.service;

import com.crudrepo.user.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserRepository userRepository;

    public boolean createAccount(Integer id, String currency) {
        Account account = new Account();
        if (userRepository.findById(id).isEmpty())
            return false;
        account.setUserId(id);
        account.setCurrency(currency);
        account.setIBAN(ibanGenerator());
        return true;
    }

    public String ibanGenerator() {
        StringBuilder iban = new StringBuilder("RO"); // can be edited manually
        Random rand = new Random();
        int i, n;

        while (true) {
            for (i = 0; i < 14; i++) {
                n = rand.nextInt(10);
                iban.append(n);
            }
            if (!ibanDuplicate(iban.toString()))
                break;
            iban = new StringBuilder("RO");
        }

        return iban.toString();
    }

    public boolean ibanDuplicate(String iban) {
        Optional<Account> op = accountRepository.findByIBAN(iban);
        return op.isPresent();
    }
}
