package com.activeedge.activeedge_exercise.exception;

import org.springframework.http.HttpStatus;

public class StockException extends RuntimeException {

    private HttpStatus status;

    public StockException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}

