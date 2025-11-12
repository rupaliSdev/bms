package com.movie.bms.exceptions;

public class ConcurrentBookingException extends RuntimeException {
    public ConcurrentBookingException(String message) {
        super(message);
    }
}
