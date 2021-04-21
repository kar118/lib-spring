package com.example.libspring.controllers;

import com.example.libspring.exceptions.LibraryException;
import com.example.libspring.models.MyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {LibraryException.class})
    public ResponseEntity<Object> handleLibraryException(LibraryException exception)  {
        MyException exceptionResponse = new MyException(exception.getMessage(), exception.getHttpStatus().value());
        return new ResponseEntity<>(exceptionResponse, exception.getHttpStatus());
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleException() {
        MyException exceptionResponse = new MyException("Invalid request", HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
