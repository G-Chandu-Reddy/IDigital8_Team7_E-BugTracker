package com.ebugtracker.admin.dao;

import com.ebugtracker.admin.entity.Bug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBugRepository extends JpaRepository<Bug,Long> {
}
