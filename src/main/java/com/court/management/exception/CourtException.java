package com.court.management.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CourtException extends RuntimeException{

    public CourtException() {
    }

    public CourtException(String message) {
        super(message);
    }

    public CourtException(String message, Throwable cause) {
        super(message, cause);
    }

    public CourtException(Throwable cause) {
        super(cause);
    }

    public CourtException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
