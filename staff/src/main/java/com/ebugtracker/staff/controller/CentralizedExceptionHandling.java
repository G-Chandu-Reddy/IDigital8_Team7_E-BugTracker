package com.ebugtracker.staff.controller;


import com.ebugtracker.staff.exceptions.BugNotFoundException;
import com.ebugtracker.staff.exceptions.InvalidBugPriorityException;
import com.ebugtracker.staff.exceptions.InvalidBugStatusException;
import com.ebugtracker.staff.exceptions.StaffNotFoundException;
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
    @ExceptionHandler(StaffNotFoundException.class)
    public String handleStaffNotFoundException(StaffNotFoundException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(BugNotFoundException.class)
    public String handleBugNotFoundException(BugNotFoundException e){
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
