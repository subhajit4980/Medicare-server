package com.subhajit.Medicare.Exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
public class ProductException extends RuntimeException {
    private  String errorCode="INVALID_REQUEST";
    private HttpStatus status;
    private HttpStatusCode statusCode;

    public ProductException(String message, String errorCode,HttpStatus status) {
        super(message);
        this.errorCode = errorCode;
        this.status=status;
        this.statusCode=status;
    }
}
