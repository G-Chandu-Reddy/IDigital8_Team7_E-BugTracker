package com.ebugtracker.customer.dao;


import com.ebugtracker.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
}
