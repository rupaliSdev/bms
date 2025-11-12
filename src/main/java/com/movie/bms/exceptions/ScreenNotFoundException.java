package com.movie.bms.exceptions;

public class ScreenNotFoundException extends RuntimeException {
    public ScreenNotFoundException(String message) {
        super(message);
    }
}
