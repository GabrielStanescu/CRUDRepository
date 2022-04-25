package com.crudrepo.user.service;

import com.crudrepo.user.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByFirstName(String firstName);

    Optional<User> findByEmailAndPassword(String email, String password);
}
