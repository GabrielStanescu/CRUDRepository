package com.crudrepo.user.model;

import lombok.Getter;

@Getter
public class TransferDetails {
    private String srcIban;
    private String destIban;
    private Double amount;
}
