package com.crudrepo.user.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name="accounts")
@Entity
public class Account {
    @Id
    @GeneratedValue()
    private int id;
    private int userId;
    private String currency;
    private String IBAN;
}