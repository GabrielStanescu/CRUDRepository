package com.crudrepo.user.service;

import com.crudrepo.user.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {
}
