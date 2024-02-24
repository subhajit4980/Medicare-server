package com.subhajit.Medicare.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductException extends RuntimeException {
    private  String errorCode="INVALID_REQUEST";

    public ProductException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
