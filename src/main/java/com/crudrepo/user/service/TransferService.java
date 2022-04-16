package com.crudrepo.user.service;

import com.crudrepo.user.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransferService {
    @Autowired
    AccountRepository accountRepository;

    private Account getAccountByIban(String iban) {
        Optional<Account> optionalAccount = accountRepository.findByIBAN(iban);
        return optionalAccount.orElse(null);
    }

    public boolean sendMoney(String dest, String src, double amount) {
        Account destAcc = getAccountByIban(dest);
        Account srcAcc = getAccountByIban(src);
        if (destAcc == null || srcAcc == null)
            return false;
        if (srcAcc.getBalance() < amount)
            return false;

        // TO-DO
        // link to internal/external service

        return true;
    }
}
