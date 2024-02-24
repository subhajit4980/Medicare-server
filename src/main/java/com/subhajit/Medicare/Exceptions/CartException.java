package com.subhajit.Medicare.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartException extends RuntimeException {

    private final String errorCode;

    public CartException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}