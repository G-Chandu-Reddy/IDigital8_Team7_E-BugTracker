package com.ebugtracker.staff.exceptions;

public class BugNotFoundException extends RuntimeException {
    public BugNotFoundException(String msg){
        super(msg);
    }
}
