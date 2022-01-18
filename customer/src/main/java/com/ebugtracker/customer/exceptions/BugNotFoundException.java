package com.ebugtracker.customer.exceptions;

public class BugNotFoundException extends RuntimeException {
    public BugNotFoundException(String msg){
        super(msg);
    }
}
