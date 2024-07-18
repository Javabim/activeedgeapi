package com.activeedge.activeedge_exercise.exception;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StockException.class)
    public ResponseEntity<String> handleStockException(StockException ex) {
        return ResponseEntity.status(ex.getStatus()).body(ex.getMessage());
    }

}

