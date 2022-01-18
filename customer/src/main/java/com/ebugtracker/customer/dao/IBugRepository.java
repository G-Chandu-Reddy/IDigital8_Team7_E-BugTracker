package com.ebugtracker.customer.dao;

import com.ebugtracker.customer.entity.Bug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBugRepository extends JpaRepository<Bug,Long> {
}
