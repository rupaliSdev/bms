package com.movie.bms.exceptions;

public class InvalidShowStatusException extends RuntimeException {
    public InvalidShowStatusException(String message) {
        super(message);
    }
}
