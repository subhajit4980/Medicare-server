package com.subhajit.Medicare.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserException extends RuntimeException {
    private final String errorCode;
    public UserException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
