package com.ebugtracker.customer.service;

import com.ebugtracker.customer.constants.BugPriority;
import com.ebugtracker.customer.constants.BugStatus;
import com.ebugtracker.customer.dao.IBugRepository;
import com.ebugtracker.customer.dao.ICustomerRepository;
import com.ebugtracker.customer.dto.AddBugRequest;
import com.ebugtracker.customer.entity.Bug;
import com.ebugtracker.customer.entity.Customer;
import com.ebugtracker.customer.exceptions.BugNotFoundException;
import com.ebugtracker.customer.exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BugServiceImpl implements IBugService{

    @Autowired
    private IBugRepository bugRepository;

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Bug reportBug(Long customerId, AddBugRequest bugRequest) {
        Bug bug=new Bug();
        bug.setBugPriority(BugPriority.toEnum(bugRequest.getBugPriority()));
        bug.setRelatedDepartment(bugRequest.getRelatedDepartment());
        bug.setSnippet(bugRequest.getSnippet());
        bug.setBugStatus(BugStatus.OPEN);
        Bug result=bugRepository.save(bug);
        Customer customer=findCustomerById(customerId);
        customer.getTicketsRaised().add(bug.getTicketNo());
        customerRepository.save(customer);
        return bug;
    }

    public Customer findCustomerById(Long customerId){
        Optional<Customer> optional=customerRepository.findById(customerId);
        if(optional.isEmpty()){
            throw new CustomerNotFoundException("Customer is not found");
        }
        return optional.get();
    }

    @Override
    public void changeBugStatusToClosed(Long ticketId) {
        Bug bug=findBugById(ticketId);
        bug.setBugStatus(BugStatus.CLOSED);
        bugRepository.save(bug);
    }

    public Bug findBugById(Long ticketId){
        Optional<Bug> optional=bugRepository.findById(ticketId);
        if(optional.isEmpty()){
            throw new BugNotFoundException("Bug Not Found for Ticket Id : "+ticketId);
        }
        return optional.get();
    }

    @Override
    public List<Bug> viewStatusOfRaisedBugs(Long customerId) {
        Customer customer=findCustomerById(customerId);
        List<Bug>bugList=new ArrayList<>();
        Set<Long> ticketsList=customer.getTicketsRaised();
        for(Long ticketNo:ticketsList){
            Bug bug=findBugById(ticketNo);
            bugList.add(bug);
        }
        return bugList;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
