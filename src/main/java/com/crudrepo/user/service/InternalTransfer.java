package com.crudrepo.user.service;

import com.crudrepo.user.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Qualifier("internal")
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

        // update balances
        src.setBalance(src.getBalance() - amount);
        destAcc.setBalance(destAcc.getBalance() + amount);

        // updating database
        accountRepository.save(src);
        accountRepository.save(destAcc);
        return true;
    }
}
