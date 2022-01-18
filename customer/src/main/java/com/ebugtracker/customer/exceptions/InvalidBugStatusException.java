package com.ebugtracker.customer.exceptions;

public class InvalidBugStatusException extends RuntimeException{
    public InvalidBugStatusException(String msg){
        super(msg);
    }
}
