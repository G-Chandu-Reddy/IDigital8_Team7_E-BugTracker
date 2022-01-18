package com.ebugtracker.staff.dao;

import com.ebugtracker.staff.entity.Bug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBugRepository extends JpaRepository<Bug,Long> {
}
