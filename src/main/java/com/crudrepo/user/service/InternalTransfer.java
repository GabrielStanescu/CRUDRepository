package com.crudrepo.user.service;

import com.crudrepo.user.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InternalTransfer implements Transfer{
    @Autowired
    AccountRepository accountRepository;

    @Override
    public boolean sendMoney(String dest, Account src, double amount) {
        Optional<Account> optional = accountRepository.findByIBAN(dest);
        if (optional.isEmpty())
            return false;
        Account destAcc = optional.get();
        src.setBalance(src.getBalance() - amount);
        destAcc.setBalance(destAcc.getBalance() + amount);
        return true;
    }
}
