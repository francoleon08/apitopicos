package com.francoleon.apitopicos.error;

public class DuplicateKeyException extends Exception{
    public DuplicateKeyException(String message) {
        super(message);
    }
}
