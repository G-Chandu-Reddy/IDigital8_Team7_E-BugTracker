package com.ebugtracker.staff.dao;


import com.ebugtracker.staff.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStaffRepository extends JpaRepository<Staff,Long> {
}
