package com.ebugtracker.staff.exceptions;

public class InvalidBugPriorityException extends RuntimeException{
    public InvalidBugPriorityException(String msg){
        super(msg);
    }
}
