package com.hcl.library;

public class InvalidReturnException extends LibraryException {
    public InvalidReturnException(String message) {
        super(message);
    }

    public InvalidReturnException(String message, Throwable cause) {
        super(message, cause);
    }
}
