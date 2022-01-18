package com.ebugtracker.login;

import com.ebugtracker.login.entity.UserEntity;
import com.ebugtracker.login.entity.UserRequest;
import com.ebugtracker.login.repository.UserRepository;
import com.ebugtracker.login.service.CustomUserDetailsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class EBugTrackerApplicationTests {

	@Mock
	UserRepository userDao;

	@InjectMocks
	@Spy
	CustomUserDetailsService service;

	@Mock
	PasswordEncoder bcryptEncoder;

	@Test
	public void testLoadUserByUserName() {
		String userName="Mrudula";
		UserEntity user=mock(UserEntity.class);
		UserDetails details=mock(UserDetails.class);

		when(userDao.findByUsername(userName)).thenReturn(user);
		UserDetails result=service.loadUserByUsername(userName);
		assertEquals(user,result);

	}

	@Test
	public void testSave(){
		UserRequest request=new UserRequest();
		request.setUsername("Mrudula");
		request.setPassword("Mrudula@123");
		request.setRole("admin");

		UserEntity user=new UserEntity();
		user.setUsername(request.getUsername());
		user.setPassword(request.getPassword());
		user.setRole(request.getRole());

		when(bcryptEncoder.encode(user.getPassword())).thenReturn("some encrypted password");
		when(userDao.save(user)).thenReturn();
		UserEntity result=service.saveUser(request);
		assertEquals(user.getUsername(),result.getUsername());

	}

}
