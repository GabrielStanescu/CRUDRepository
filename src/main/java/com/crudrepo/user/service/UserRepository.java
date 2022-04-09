package com.crudrepo.user.service;

import com.crudrepo.user.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByFirstName(String firstName);
}
