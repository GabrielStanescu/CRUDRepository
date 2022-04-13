package com.crudrepo.user.streamservice;

import com.crudrepo.user.model.User;
import com.crudrepo.user.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class UserStreamService {
    @Autowired
    UserRepository userRepository;

    public List<String> getUsersInitials() {
        Iterable<User> allUsers = userRepository.findAll();
        return StreamSupport.stream(allUsers.spliterator(), false)
                .map(user -> user.getFirstName().charAt(0) + "" + user.getLastName().charAt(0))
                .collect(Collectors.toList());
    }

    public Long getNoOfUsersByGmail() {
        Iterable<User> allUsers = userRepository.findAll();
        return StreamSupport.stream(allUsers.spliterator(), false)
                .filter(user -> user.getEmail().contains("@gmail."))
                .count();
    }

    public List<String> getLastNames() {
        Iterable<User> allUsers = userRepository.findAll();
        return StreamSupport.stream(allUsers.spliterator(), false)
                .map(User::getLastName)
                .distinct()
                .collect(Collectors.toList());
    }

    public String getFirstNameInitials() {
        Iterable<User> allUsers = userRepository.findAll();
        return StreamSupport.stream(allUsers.spliterator(), false)
                .map(user -> user.getFirstName().charAt(0) + "")
                .collect(Collectors.joining());
    }

    public Long getNoOfUsersTask5() {
        Iterable<User> allUsers = userRepository.findAll();
        return StreamSupport.stream(allUsers.spliterator(), false)
                .filter(user -> user.getFirstName().toLowerCase().contains("a"))
                .filter(user -> user.getAge() < 20)
                .count();
    }
}
