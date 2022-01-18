package com.ebugtracker.customer.exceptions;

public class InvalidBugPriorityException extends RuntimeException{
    public InvalidBugPriorityException(String msg){
        super(msg);
    }
}
