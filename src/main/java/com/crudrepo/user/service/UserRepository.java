package com.crudrepo.user.service;

import com.crudrepo.user.model.User;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByFirstName(String firstName);
}
