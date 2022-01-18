package com.ebugtracker.customer.controller;

import com.ebugtracker.customer.exceptions.BugNotFoundException;
import com.ebugtracker.customer.exceptions.CustomerNotFoundException;
import com.ebugtracker.customer.exceptions.InvalidBugPriorityException;
import com.ebugtracker.customer.exceptions.InvalidBugStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class CentralizedExceptionHandling {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public String handleConstraintViolationException(ConstraintViolationException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(BugNotFoundException.class)
    public String handleBugNotFoundException(BugNotFoundException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CustomerNotFoundException.class)
    public String handleCustomerNotFoundException(CustomerNotFoundException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidBugPriorityException.class)
    public String handleInvalidBugPriorityException(InvalidBugPriorityException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidBugStatusException.class)
    public String handleInvalidBugStatusException(InvalidBugStatusException e){
        return e.getMessage();
    }

}
