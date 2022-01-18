package com.ebugtracker.admin.dao;

import com.ebugtracker.admin.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    public List<Customer> findByCustomerName(String name);
}
