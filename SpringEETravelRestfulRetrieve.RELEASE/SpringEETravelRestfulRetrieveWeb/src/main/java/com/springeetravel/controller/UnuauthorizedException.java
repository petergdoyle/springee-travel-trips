/*
 */
package com.springeetravel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author peter
 */
@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UnuauthorizedException extends RuntimeException {

    public UnuauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnuauthorizedException(String message) {
        super(message);
    }
}
