package com.dxc.service;

import com.dxc.exception.IncorrectPasswordException;
import com.dxc.exception.UserExistsException;
import com.dxc.exception.UserNotFoundException;
import com.dxc.model.User;

public interface UserService {

	User registerUser(User user) throws UserExistsException;
	User authenticateUser(String email,String password)throws UserNotFoundException,IncorrectPasswordException;
	
}
