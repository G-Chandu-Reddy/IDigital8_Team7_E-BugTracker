package com.ebugtracker.customer.constants;


import com.ebugtracker.customer.exceptions.InvalidBugStatusException;

public enum BugStatus {
    OPEN,ASSIGNED,CLOSED;

    public static BugStatus toEnum(String status){
        BugStatus[] statusList =BugStatus.values();
        for(BugStatus bugStatus : statusList){
            String name=bugStatus.name();
            if(status.equalsIgnoreCase(name)){
                return bugStatus;
            }

        }
        throw new InvalidBugStatusException("Invalid Bug Status "+status );
    }

}
