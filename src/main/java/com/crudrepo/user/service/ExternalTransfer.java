package com.crudrepo.user.service;

import com.crudrepo.user.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExternalTransfer implements Transfer{
    @Autowired
    AccountRepository accountRepository;

    @Override
    public boolean sendMoney(String dest, Account src, double amount) {
        src.setBalance(src.getBalance() - amount);
        return true;
    }
}
