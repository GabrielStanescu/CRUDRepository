package com.crudrepo.user.service;

import com.crudrepo.user.model.Account;

public interface Transfer {
    boolean sendMoney(String dest, Account src, double amount);
}
