package com.ebugtracker.admin.controller;

import com.ebugtracker.admin.entity.Bug;
import com.ebugtracker.admin.entity.Customer;
import com.ebugtracker.admin.entity.Staff;
import com.ebugtracker.admin.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/admin")
@RestController
public class AdminRestController {
    @Autowired
    private IStaffService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addStaff")
    public Staff addStaff(@RequestBody Staff requestData){
        return  service.addStaff(requestData);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/editStaff")
    public Staff editStaff(@RequestBody Staff requestData){
        return service.editStaff(requestData);
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/deleteStaffById/{id}")
    public void deleteStaffById(@PathVariable Long id){
        service.deleteStaff(id);
    }
    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/findStaffById/{id}")
    public Staff findStaffById(@PathVariable Long id){
        return service.findStaffById(id);
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/findAllStaff")
    public List<Staff> findAllStaff(){
        return service.findAll();
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/bugReport")
    public List<Bug> fetchBugReport(){
        return service.getBugReport();
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/getReport/priority/{level}")
    public List<Bug> fetchBugReportByPriority(@PathVariable String level){
        return service.getBugReportByPriority(level);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/assign/{staffName}/{ticketId}")
    public Staff assignBugToStaff(@PathVariable String staffName,@PathVariable Long ticketId){
        return service.assignBugToStaff(staffName,ticketId);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/sendMessage/{customerName}")
    public Customer sendMessageToCustomer(@PathVariable String customerName,@RequestBody String msg){
        return service.sendMessageToCustomer(customerName,msg);
    }

}
