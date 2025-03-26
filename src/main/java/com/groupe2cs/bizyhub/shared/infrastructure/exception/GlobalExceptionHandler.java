package com.groupe2cs.bizyhub.shared.infrastructure.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;


@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<String> genericException(Exception e) {
        log.error("Unexpected error: {}", e.getMessage(), e);
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

    }
}
