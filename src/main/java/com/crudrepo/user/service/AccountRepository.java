package com.crudrepo.user.service;

import com.crudrepo.user.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Integer> {
    Optional<Account> findByIBAN(String iban);

    List<Account> findAllByUserId(int userId);
}
