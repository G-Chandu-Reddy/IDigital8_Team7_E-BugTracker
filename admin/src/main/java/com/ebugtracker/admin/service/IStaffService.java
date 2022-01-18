package com.ebugtracker.admin.service;

import com.ebugtracker.admin.entity.Bug;
import com.ebugtracker.admin.entity.Customer;
import com.ebugtracker.admin.entity.Staff;
import org.springframework.validation.annotation.Validated;


import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface IStaffService {

    Staff addStaff(@Valid Staff staff);
    Staff editStaff(@Valid Staff staff);
    void deleteStaff(@NotNull @Min(1) long id);
    Staff findStaffById(@NotNull @Min(1) long id);

    List<Staff> findAll();

    List<Bug> getBugReport();

    List<Bug> getBugReportByPriority(@NotBlank String level);

    Staff assignBugToStaff(@NotBlank String staffName, @NotNull @Min(1) Long ticketId);

    Customer sendMessageToCustomer(@NotBlank String customerName,@NotBlank String msg);
}
