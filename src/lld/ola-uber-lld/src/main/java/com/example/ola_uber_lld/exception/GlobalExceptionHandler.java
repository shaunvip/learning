package com.example.ola_uber_lld.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {DataNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public Map resourceNotFoundException(DataNotFoundException ex, WebRequest request) {
       Map<String, Object> map= new HashMap<>();
       map.put("date", LocalDateTime.now());
       map.put("status", HttpStatus.NOT_FOUND);
       map.put("msg", ex.getMessage());
        return map;
    }
}
