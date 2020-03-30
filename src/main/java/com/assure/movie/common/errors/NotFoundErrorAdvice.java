package com.assure.movie.common.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Israel Yasis
 */
@ControllerAdvice
public class NotFoundErrorAdvice {

    @ResponseBody
    @ExceptionHandler(NotFoundErrorException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String employeeNotFoundHandler(NotFoundErrorException excepcion) {
        return excepcion.getMessage();
    }
}
