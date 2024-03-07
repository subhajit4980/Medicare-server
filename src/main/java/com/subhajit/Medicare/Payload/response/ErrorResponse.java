package com.subhajit.Medicare.Payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse{
    String message;
    String errorCode;
    HttpStatus status;
    HttpStatusCode statusCode;
}
