package com.subhajit.Medicare.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CartException.class)
    public ResponseEntity<Object> handleCartException(CartException ex) {
        return new ResponseEntity<>(ex.getMessage() + " - Error code: " + ex.getErrorCode(), HttpStatus.BAD_REQUEST);
    }
}
