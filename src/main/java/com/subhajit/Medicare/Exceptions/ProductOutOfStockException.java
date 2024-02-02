package com.subhajit.Medicare.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOutOfStockException extends RuntimeException {
    private final String errorCode;

    public ProductOutOfStockException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
