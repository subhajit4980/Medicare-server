package com.subhajit.Medicare.Exceptions;

import com.subhajit.Medicare.Payload.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CartException.class)
    public ResponseEntity<ErrorResponse> handleCartException(CartException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ex.getErrorCode(),ex.getStatus(),ex.getStatusCode());
        return new ResponseEntity<>(errorResponse, ex.getStatus());
    }
    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ErrorResponse> productException(ProductException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ex.getErrorCode(),ex.getStatus(),ex.getStatusCode());
        return new ResponseEntity<>(errorResponse, ex.getStatus());
    }
    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorResponse> handleUserException(UserException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ex.getErrorCode(),ex.getStatus(),ex.getStatusCode());
        return new ResponseEntity<>(errorResponse, ex.getStatus());
    }
}
