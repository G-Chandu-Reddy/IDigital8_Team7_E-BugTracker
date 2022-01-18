package com.ebugtracker.staff.service;

import com.ebugtracker.staff.entity.Bug;
import com.ebugtracker.staff.entity.Staff;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public interface IStaffService {
    Staff findStaffById(@NotNull @Min(1) Long id);

    Bug provideBugRemedy(@NotNull @Min(1)Long ticketId,@NotBlank String remedy);

    Staff assignBugToStaff(@NotNull @Min(1)Long staffId,@NotNull @Min(1) Long ticketId);
}
