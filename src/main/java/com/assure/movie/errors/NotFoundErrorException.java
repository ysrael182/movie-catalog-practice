package com.assure.movie.errors;

/**
 * @author Israel Yasis
 */
public class NotFoundErrorException extends RuntimeException {

    public NotFoundErrorException(String errorMessage) {
        super(errorMessage);
    }
}
