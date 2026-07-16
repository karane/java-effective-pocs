package com.effectivejava.exceptiontranslation;

public class UserRepositoryException extends RuntimeException {

    public UserRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
