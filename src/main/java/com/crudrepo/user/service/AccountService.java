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

    public void createAccount(Integer id, String currency) {
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
