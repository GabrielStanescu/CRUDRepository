package com.crudrepo.user.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private short age;
    private String email;
    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    @Column(name = "user_id")
    List<Account> accountList;
}
