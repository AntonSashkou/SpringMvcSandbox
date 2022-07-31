package com.sashkou.sandbox.exception;

//@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Demo not found")
public class DemoNotFoundException extends RuntimeException {
    public DemoNotFoundException(String message) {
        super(message);
    }
}
