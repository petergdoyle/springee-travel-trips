package com.springeetravel.dataaccess.exceptions;

public class PreexistingEntityException extends RuntimeException {
    public PreexistingEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    public PreexistingEntityException(String message) {
        super(message);
    }
}
