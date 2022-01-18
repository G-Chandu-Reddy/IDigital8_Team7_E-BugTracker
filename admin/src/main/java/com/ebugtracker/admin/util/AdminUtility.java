package com.ebugtracker.admin.util;

import com.ebugtracker.admin.dao.IBugRepository;
import com.ebugtracker.admin.dao.ICustomerRepository;
import com.ebugtracker.admin.entity.Bug;
import com.ebugtracker.admin.entity.Customer;
import com.ebugtracker.admin.exceptions.BugNotFoundException;
import com.ebugtracker.admin.exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AdminUtility {

    @Autowired
    IBugRepository bugRepository;

    @Autowired
    ICustomerRepository customerRepository;

    public Bug findBugById(Long ticketId){
        Optional<Bug> optional=bugRepository.findById(ticketId);
        if(optional.isEmpty()){
            throw new BugNotFoundException("Bug Not Found for Ticket Id : "+ticketId);
        }
        return optional.get();
    }

    public List<Bug> getAllBugs(){
        return bugRepository.findAll();
    }

    public Customer sendMessageToCustomer(Long customerId, String msg) {
        Optional<Customer> optional=customerRepository.findById(customerId);
        if(optional.isEmpty()){
            throw new CustomerNotFoundException("Customer is not found");
        }
        Customer customer=optional.get();
        List<String > messages=customer.getMessagesReceived();
        messages.add(msg);
        customer.setMessagesReceived(messages);
        customerRepository.save(customer);
        return customer;
    }
}
