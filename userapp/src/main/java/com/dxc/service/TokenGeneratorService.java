package com.dxc.service;

import java.util.Map;

import com.dxc.model.User;

public interface TokenGeneratorService {
	Map<String,String> generateToken(User user);
}
