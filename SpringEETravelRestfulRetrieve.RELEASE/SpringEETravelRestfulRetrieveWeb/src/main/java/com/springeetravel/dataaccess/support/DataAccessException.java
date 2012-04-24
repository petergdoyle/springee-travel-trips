/*
 */
package com.springeetravel.dataaccess.support;

/**
 *
 * @author peter
 */
public class DataAccessException extends RuntimeException {

    public DataAccessException(String message) {
        super(message);
    }

    public DataAccessException(Throwable cause) {
        super(cause);
    }
}
