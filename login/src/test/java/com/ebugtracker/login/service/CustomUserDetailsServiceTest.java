package com.ebugtracker.login.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ebugtracker.login.Exception.UserNotFoundException;
import com.ebugtracker.login.entity.UserEntity;
import com.ebugtracker.login.repository.UserRepository;

@SpringBootTest
class CustomUserDetailsServiceTest {

	@Autowired
	private CustomUserDetailsService custserv;
	
	@MockBean
	private UserRepository userrepo;
	
	@Test
	public void getUserByUserName() {
		String name="admin";
		UserEntity user= userrepo.findByUsername(name);
		assertEquals(name,user.getUsername());
		//fail("Not yet implemented");
	}

}
