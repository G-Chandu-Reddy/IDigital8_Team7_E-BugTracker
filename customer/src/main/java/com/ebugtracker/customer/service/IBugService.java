package com.ebugtracker.customer.service;

import com.ebugtracker.customer.dto.AddBugRequest;
import com.ebugtracker.customer.entity.Bug;
import com.ebugtracker.customer.entity.Customer;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface IBugService {
    Bug reportBug(@NotNull @Min(1) Long customerId,@Valid AddBugRequest requestData);
    void changeBugStatusToClosed(@NotNull @Min(1)Long ticketId);

    List<Bug> viewStatusOfRaisedBugs(@NotNull @Min(1) Long customerId);

    Customer addCustomer(@Valid Customer customer);
}
