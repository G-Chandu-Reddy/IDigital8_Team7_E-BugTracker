package com.ebugtracker.admin.exceptions;

public class InvalidBugStatusException extends RuntimeException{
    public InvalidBugStatusException(String msg){
        super(msg);
    }
}
