package com.movie.bms.exceptions;

public class VenueNotAvailableException extends RuntimeException {
    public VenueNotAvailableException(String message) {
        super(message);
    }
}
