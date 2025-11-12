package com.movie.bms.exceptions;

public class InvalidShowRequestException extends RuntimeException {
    public InvalidShowRequestException(String message) {
        super(message);
    }
}
