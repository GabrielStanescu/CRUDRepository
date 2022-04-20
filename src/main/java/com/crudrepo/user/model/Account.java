package com.crudrepo.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name="accounts")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue()
    private int id;
    @Column(name = "user_id")
    private int userId;
    private String currency;
    private String IBAN;
    private double balance;
}