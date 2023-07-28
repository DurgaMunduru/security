package com.dxc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.exception.IncorrectPasswordException;
import com.dxc.exception.UserExistsException;
import com.dxc.exception.UserNotFoundException;
import com.dxc.model.User;
import com.dxc.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;

	
	public User registerUser(User user) throws UserExistsException {
		final boolean existById = this.userRepository.existsById(user.getUserId());
		if(existById) {
			throw new UserExistsException("User Already Exists");
		}
		return this.userRepository.save(user);
	}

	
	public User authenticateUser(String email, String password)
			throws UserNotFoundException, IncorrectPasswordException {
		final Optional<User> optionalUser = this.userRepository.findByEmailAndPassword(email, password);
		if(optionalUser.isEmpty()) {
			throw new UserNotFoundException("User Not Found");
		}
		return optionalUser.get();
	}
	
	

}
