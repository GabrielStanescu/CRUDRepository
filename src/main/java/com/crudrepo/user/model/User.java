package com.crudrepo.user.model;

import lombok.Getter;

@Getter
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private short age;
    private String email;
    private String password;
}
