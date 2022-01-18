package com.ebugtracker.staff.exceptions;

public class StaffNotFoundException extends RuntimeException{
    public StaffNotFoundException(String msg){
        super(msg);
    }
}
