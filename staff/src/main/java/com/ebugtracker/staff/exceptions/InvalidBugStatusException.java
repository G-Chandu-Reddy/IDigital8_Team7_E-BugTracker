package com.ebugtracker.staff.exceptions;

public class InvalidBugStatusException extends RuntimeException{
    public InvalidBugStatusException(String msg){
        super(msg);
    }
}
