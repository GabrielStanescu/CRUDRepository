package com.crudrepo.user.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private short age;
    private String email;
    private String password;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    List<Account> accountList;

    public boolean matches(User user) {
        return firstName.equals(user.getFirstName())
                && lastName.equals(user.getLastName())
                && email.equals(user.getEmail())
                && age == user.getAge();
    }
}
