package com.crudrepo.user;

import com.crudrepo.user.model.User;
import com.crudrepo.user.service.UserService;
import com.crudrepo.user.streamservice.UserStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserStreamService userStreamService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>("User successfully created", HttpStatus.OK);
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }

    @PostMapping("/list")
    public List<User> getUsersByName(@RequestParam(name = "name") String name) {
        return userService.getUsersByName(name);
    }

    @GetMapping("/streams/initials")
    public List<String> getUsersByInitials() {
        return userStreamService.getUsersInitials();
    }

    @GetMapping("streams/gmails")
    public Long getNoOfUsersByGmail() {
        return userStreamService.getNoOfUsersByGmail();
    }

    @GetMapping("streams/lastnames")
    public List<String> getLastNames() {
        return userStreamService.getLastNames();
    }

    @GetMapping("streams/initials/firstnames")
    public String getFirstNameInitials() {
        return userStreamService.getFirstNameInitials();
    }

    @GetMapping("streams/task5")
    public Long getNoOfUsersTask5() {
        return userStreamService.getNoOfUsersTask5();
    }
}
