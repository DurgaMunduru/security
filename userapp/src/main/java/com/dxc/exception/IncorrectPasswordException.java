package com.dxc.exception;

public class IncorrectPasswordException extends Exception {
	String msg;

	public IncorrectPasswordException() {
		super();
	}

	public IncorrectPasswordException(String msg) {
		super(msg);
		
}
}