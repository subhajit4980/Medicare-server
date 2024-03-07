package com.subhajit.Medicare.Exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
public class CartException extends RuntimeException {

    private final String errorCode;
    private HttpStatus status;
    private HttpStatusCode statusCode;

    public CartException(String message, String errorCode, HttpStatus status) {
        super(message);
        this.errorCode = errorCode;
        this.status=status;
        this.statusCode=status;
    }

}