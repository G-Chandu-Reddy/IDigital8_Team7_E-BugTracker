package com.ebugtracker.admin.dao;

import com.ebugtracker.admin.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStaffRepository extends JpaRepository<Staff,Long> {

    public List<Staff> findByStaffName(String name);

}
