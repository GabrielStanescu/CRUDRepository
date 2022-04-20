package com.crudrepo.user.service;

import com.crudrepo.user.model.User;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("production")
@Component
public abstract class UserProductionRepository implements UserRepository {
    public List<User> findByFirstName(String firstName) {
        return null;
    }

}
