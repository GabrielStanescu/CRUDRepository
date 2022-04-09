package com.crudrepo.user.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
