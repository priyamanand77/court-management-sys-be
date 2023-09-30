package com.court.management.exception;

import com.court.management.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {


    @ExceptionHandler(CourtException.class)
    public ResponseEntity<ErrorResponse> courtException(CourtException e) {
        ErrorResponse errorResponse = ErrorResponse.builder().status(HttpStatus.INTERNAL_SERVER_ERROR.value()).message(e.getMessage()).build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
