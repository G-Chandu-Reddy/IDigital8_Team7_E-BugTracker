package com.ebugtracker.customer.controller;

import com.ebugtracker.customer.dto.AddBugRequest;
import com.ebugtracker.customer.entity.Bug;
import com.ebugtracker.customer.entity.Customer;
import com.ebugtracker.customer.service.IBugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customer")
@RestController
public class CustomerRestController {

    @Autowired
    private IBugService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/reportBug/{customerId}")
    public Bug reportBug(@PathVariable Long customerId,@RequestBody AddBugRequest requestData){
        return service.reportBug(customerId,requestData);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/changeStatusToClosed/{ticketId}")
    public String changeBugStatusToClosed(@PathVariable Long ticketId){
        service.changeBugStatusToClosed(ticketId);
        return "Bug Status Changed Successfully";
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/viewStatusOfRaisedBugs/{customerId}")
    public List<Bug> viewStatusOfRaisedBugs(@PathVariable Long customerId){
        return service.viewStatusOfRaisedBugs(customerId);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer){
        return service.addCustomer(customer);
    }

}
