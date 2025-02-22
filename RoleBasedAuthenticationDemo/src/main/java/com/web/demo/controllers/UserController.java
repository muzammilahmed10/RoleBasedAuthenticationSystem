package com.web.demo.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.demo.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userserv;
	
	@PostMapping("/user/login")
	public String authenticateUser(@RequestBody Map<String, String> request) {
		String name = request.get("name");
		String password = request.get("password");
		String role =  userserv.authenticateUser(name, password);
		if(role.equalsIgnoreCase("customer")) {
			return "Welcome to customer dashboard";
		}
		else if(role.equalsIgnoreCase("admin")) {
			return "Welcome to admin dashboard";
		}
		else {
			return "invalid username or password";
		}
	}
}
