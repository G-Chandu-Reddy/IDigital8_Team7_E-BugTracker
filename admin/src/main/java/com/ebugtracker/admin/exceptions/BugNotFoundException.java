package com.ebugtracker.admin.exceptions;

public class BugNotFoundException extends RuntimeException {
    public BugNotFoundException(String msg){
        super(msg);
    }
}
