package com.ebugtracker.admin.exceptions;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String msg){
        super(msg);
    }
}
