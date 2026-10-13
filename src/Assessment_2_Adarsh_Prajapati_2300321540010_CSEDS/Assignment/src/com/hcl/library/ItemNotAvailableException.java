package com.hcl.library;

public class ItemNotAvailableException extends LibraryException {
    public ItemNotAvailableException(String message) {
        super(message);
    }

    public ItemNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
