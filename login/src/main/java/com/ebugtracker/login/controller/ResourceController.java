package com.ebugtracker.login.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
	
	@RequestMapping("/homepage")
	public String home()
	{
		return "Welcomw to homepage!!";
	}

	@RequestMapping("/hellostaff")
	public String getStaff()
	{
		return "Hello Staff";
	}
	
	@RequestMapping("/helloadmin")
	public String getAdmin()
	{
		return "Hello Admin";
	}
	
	@RequestMapping("/hellocustomer")
	public String getCustomer()
	{
		return "Hello Customer";
	}
}
