package com.crudrepo.user.exceptions;

public class InvalidJWTException extends Exception{
    public InvalidJWTException(String message) {
        super(message);
    }
}
