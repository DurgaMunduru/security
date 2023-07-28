package com.dxc.exception;

public class UserExistsException extends Exception {

	String msg;

	public UserExistsException() {
		super();
	}

	public UserExistsException(String msg) {
		super(msg);
		
	}
	
}
