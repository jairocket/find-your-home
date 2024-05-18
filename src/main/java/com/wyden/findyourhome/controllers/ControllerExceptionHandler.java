package com.wyden.findyourhome.controllers;

import com.wyden.findyourhome.exceptions.CostumerException;
import com.wyden.findyourhome.exceptions.ResourceNotFoundException;
import com.wyden.findyourhome.exceptions.StandardError;
import com.wyden.findyourhome.exceptions.TelephoneException.*;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler extends RuntimeException {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> handleException(ResourceNotFoundException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError error = new StandardError(
                status.value(),
                System.currentTimeMillis(),
                exception.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(CostumerException.class)
    public ResponseEntity<StandardError> handleCostumerException(CostumerException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        StandardError error = new StandardError(
                status.value(),
                System.currentTimeMillis(),
                exception.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(MultipleMainNumbersException.class)
    public ResponseEntity<StandardError> handleMultipleMainNumbersException(MultipleMainNumbersException ex, WebRequest request) {
        HttpStatus status = HttpStatus.CONFLICT; 

        StandardError error = new StandardError(
                status.value(),
                System.currentTimeMillis(),
                ex.getMessage(),
                request.getDescription(false)
        );

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(PhoneNumberAlreadyExistsException.class)
    public ResponseEntity<StandardError> handlePhoneNumberAlreadyExistsException(PhoneNumberAlreadyExistsException ex, WebRequest request) {
        HttpStatus status = HttpStatus.CONFLICT; 

        StandardError error = new StandardError(
                status.value(),
                System.currentTimeMillis(),
                ex.getMessage(),
                request.getDescription(false)
        );

        return ResponseEntity.status(status).body(error);
    }

}
