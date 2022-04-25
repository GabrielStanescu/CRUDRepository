package com.crudrepo.user.service;

import com.crudrepo.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    JWTService jwtService;

    public void createUser(User user) {
        userRepository.save(user);
    }

    public User getUser(int id) {
       Optional<User> op = userRepository.findById(id);
       return op.orElse(null);
    }

    public List<User> getUsersByName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    public Optional<User> isUserValid(String username, String password) {
        return userRepository.findByEmailAndPassword(username, password);
    }

    public String getToken(User user) {
        return jwtService.generateToken(user);
    }
}
