package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bean.UserBean;
import com.repo.UserRepo;

@RestController
public class SessionController {

	@Autowired
	UserRepo userRepo;
	
	@RequestMapping(method = RequestMethod.POST, value="/signUp")
	public UserBean signUp(@RequestBody UserBean userbean){
		
	userRepo.addUser(userbean);
	
	
	
		
		return userbean;
		
		
		
		
	}
	
}
