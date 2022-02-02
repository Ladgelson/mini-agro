package com.mini.agro.backend.exception;

import com.mongodb.MongoWriteException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({MongoWriteException.class})
    public ResponseEntity<CustomBusinessException> handleException(MongoWriteException exception) {
        return ResponseEntity
                .badRequest()
                .body(new CustomBusinessException(exception.getMessage(), Instant.now()));
    }
}
