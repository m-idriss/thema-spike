package com.dime.thema.feature_word.exception.handler;

import com.dime.thema.feature_word.exception.ResourceNotFoundException;
import com.dime.thema.feature_word.shared.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<Object> entityNotFoundException(ResourceNotFoundException e) {
        ResponseMessage responseMessage = ResponseMessage.builder()
                .message(e.getMessage())
                .timestamp(new Date())
                .code(404)
                .build();
        return new ResponseEntity<>(responseMessage, HttpStatus.NOT_FOUND);
    }
}
