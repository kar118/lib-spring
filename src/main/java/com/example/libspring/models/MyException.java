package com.example.libspring.models;

public class MyException {
    private final String message;
    private final Integer httpStatus;

    public MyException(String message, Integer httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return this.message;
    }

    public Integer getHttpStatus() {
        return this.httpStatus;
    }
}
