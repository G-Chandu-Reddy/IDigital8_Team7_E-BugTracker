package com.ebugtracker.admin.exceptions;

public class InvalidBugPriorityException extends RuntimeException{
    public InvalidBugPriorityException(String msg){
        super(msg);
    }
}
