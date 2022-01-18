package com.ebugtracker.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ebugtracker.login.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

	@Query("select u from UserEntity u where u.username= :username")
	UserEntity findByUsername(String username);
}
