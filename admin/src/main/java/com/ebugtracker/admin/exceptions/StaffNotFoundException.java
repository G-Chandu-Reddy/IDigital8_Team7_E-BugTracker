package com.ebugtracker.admin.exceptions;

public class StaffNotFoundException extends RuntimeException{
    public StaffNotFoundException(String msg){
        super(msg);
    }
}
