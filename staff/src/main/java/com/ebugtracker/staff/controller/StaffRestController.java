package com.ebugtracker.staff.controller;

import com.ebugtracker.staff.entity.Bug;
import com.ebugtracker.staff.entity.Staff;
import com.ebugtracker.staff.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/staff")
@RestController
public class StaffRestController {
    @Autowired
    private IStaffService service;

    @ResponseStatus(HttpStatus.FOUND)
    @PostMapping("/findStaffById/{id}")
    public Staff findStaffById(@PathVariable Long id){
        return service.findStaffById(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/provideBugRemedy/{ticketId}")
    public Bug provideBugRemedy (@PathVariable Long ticketId, @RequestBody String remedy){
        return service.provideBugRemedy(ticketId,remedy);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/assign/{staffId}/{ticketId}")
    public Staff assignBugToStaff(@PathVariable Long staffId,@PathVariable Long ticketId){
        return service.assignBugToStaff(staffId,ticketId);
    }


}
