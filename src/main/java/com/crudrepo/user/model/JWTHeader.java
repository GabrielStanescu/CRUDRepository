package com.crudrepo.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JWTHeader {
    private String typ;
    private String alg;
}
