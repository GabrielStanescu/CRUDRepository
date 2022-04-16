package com.crudrepo.user.service;

import com.crudrepo.user.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransferService {
    Transfer transfer;

    @Autowired
    AccountRepository accountRepository;

    private Account getAccountByIban(String iban) {
        Optional<Account> optionalAccount = accountRepository.findByIBAN(iban);
        return optionalAccount.orElse(null);
    }

    public boolean sendMoney(String dest, String src, double amount) {
        Account srcAcc = getAccountByIban(src);
        if (srcAcc == null || srcAcc.getBalance() < amount)
            return false;

        // TO-DO
        // link to internal/external service
        return transfer.sendMoney(dest, srcAcc, amount);
    }
}
