package com.crudrepo.user.service;

import com.crudrepo.user.model.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("test")
@Component
public abstract class UserTestRepository implements UserRepository {
    public List<User> findByFirstName(String firstName) {
        List<User> userList = new ArrayList<>();
        User user = new User(1, firstName, "ln", (short) 21, "email", "pass", null);
        User user1 = new User(2, firstName, "name", (short) 22, "yahoo", "123", null);
        userList.add(user);
        userList.add(user1);
        return userList;
    }

    public Optional<User> findById(Integer id) {
        return Optional.of(new User(id, "Gabriel", "ln", (short) 21, "email", "pass", null));
    }
}
