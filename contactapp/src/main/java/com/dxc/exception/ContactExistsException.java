package com.dxc.exception;

public class ContactExistsException extends Exception {
    public ContactExistsException() {
        super();
    }

    public ContactExistsException(String message) {
        super(message);
    }
}
