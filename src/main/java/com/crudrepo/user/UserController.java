package com.crudrepo.user;

import com.crudrepo.user.exceptions.UnauthorizedException;
import com.crudrepo.user.model.JWTRequest;
import com.crudrepo.user.model.User;
import com.crudrepo.user.service.UserService;
import com.crudrepo.user.streamservice.UserStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserStreamService userStreamService;

    @PostMapping("/login")
    public void userLogin(@RequestBody JWTRequest authRequest, HttpServletResponse responseToken) throws UnauthorizedException {
        Optional<User> userOptional = userService.isUserValid(authRequest.getUsername(), authRequest.getPassword());
        if (userOptional.isPresent()) {
            String token = userService.getToken(userOptional.get());
            System.out.println(token);
            responseToken.addHeader("Authorization", token);
        }
        else {
            throw new UnauthorizedException("Username or password are incorrect.");
        }
    }

    @PostMapping()
    public ResponseEntity<?> createUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }

    @GetMapping("/list")
    public List<User> getUsersByName(@RequestParam("name") String name) {
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
