package com.example.libspring.exceptions;

import org.springframework.http.HttpStatus;

public class LibraryException extends RuntimeException {
    private HttpStatus httpStatus;
    public LibraryException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public LibraryException(String message, Throwable cause, HttpStatus httpStatus) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
