package com.wyden.findyourhome.exceptions.TelephoneException;

public class DuplicatePhoneNumberException extends RuntimeException {
    public DuplicatePhoneNumberException(String message) {
        super(message);
    }
}