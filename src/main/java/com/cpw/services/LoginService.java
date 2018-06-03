package com.cpw.services;

import com.cpw.model.LoginRequest;
import com.cpw.model.LoginResponse;

public interface LoginService {
	public LoginResponse authenticateUser (LoginRequest loginRequest); 
}
