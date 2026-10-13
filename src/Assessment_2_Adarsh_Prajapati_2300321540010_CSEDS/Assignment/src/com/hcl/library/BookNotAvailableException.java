package com.hcl.library;

// Aliased subclass to satisfy both BookNotAvailableException and ItemNotAvailableException requirements
public class BookNotAvailableException extends ItemNotAvailableException {
    public BookNotAvailableException(String message) {
        super(message);
    }

    public BookNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
