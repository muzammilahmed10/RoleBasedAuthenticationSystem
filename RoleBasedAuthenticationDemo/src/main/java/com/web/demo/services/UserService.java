package com.web.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.demo.entites.User;
import com.web.demo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userrepo;
	
	public String authenticateUser(String name,String password) {
		User user=userrepo.findByName(name);
		if(user==null) {
			return "invalid user found with such username";
		} else {
		if(password.equals(user.getPassword())) {
			return user.getRole();
		}
		else {
			return "invalid Username or password";
		}
		}
		
	}
}
