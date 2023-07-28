package com.dxc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.exception.IncorrectPasswordException;
import com.dxc.exception.UserExistsException;
import com.dxc.exception.UserNotFoundException;
import com.dxc.model.User;
import com.dxc.model.UserCredential;
import com.dxc.service.TokenGeneratorService;
import com.dxc.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@Autowired
	private TokenGeneratorService tokenGenerator;
	
	
	@PostMapping("register")
	public User registerUser(@RequestBody User user) throws UserExistsException {
		return this.service.registerUser(user);
	}
	
	@PostMapping("login")
	public Map<String,String> authenticateUser(@RequestBody UserCredential credentails) throws UserNotFoundException, IncorrectPasswordException{
		final User user = this.service.authenticateUser(credentails.getEmail(), credentails.getPassword());
		return this.tokenGenerator.generateToken(user);
	}
	
	
	
}
