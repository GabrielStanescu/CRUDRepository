package com.crudrepo.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id &&
                userId == account.userId &&
                account.balance == balance &&
                currency.equals(account.currency) &&
                IBAN.equals(account.IBAN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, currency, IBAN, balance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userId=" + userId +
                ", currency='" + currency + '\'' +
                ", IBAN='" + IBAN + '\'' +
                ", balance=" + balance +
                '}';
    }
}