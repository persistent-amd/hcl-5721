package com.hcl.library;

public class InvalidMemberException extends LibraryException {
    public InvalidMemberException(String message) {
        super(message);
    }

    public InvalidMemberException(String message, Throwable cause) {
        super(message, cause);
    }
}
