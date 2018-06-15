package com.cpw.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.UserDetailDAOImpl;
import com.cpw.jdbc.model.UserDetail;
import com.cpw.jdbc.model.UserRole;
import com.cpw.model.LoginRequest;
import com.cpw.model.LoginResponse;

public class LoginServiceImpl implements LoginService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private static final String SUCCESS_STATUS = "SUCESS";
	private static final String FAILED_STATUS = "FAILED";

	public LoginResponse authenticateUser(LoginRequest loginRequest) {
		logger.debug("Entering into authenticateUser");
		if (loginRequest.getUserName().isEmpty() || loginRequest.getPassword().isEmpty()) {
			logger.error("UserName or Password is empty");
			return null;
		}
		/*
		 * UserDetailDAOImpl userDetailDAOImpl = null; try
		 * (ClassPathXmlApplicationContext context = new
		 * ClassPathXmlApplicationContext("Beans.xml")) { userDetailDAOImpl =
		 * (UserDetailDAOImpl) context.getBean("userDetailDAOImpl"); }
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		UserDetailDAOImpl userDetailDAOImpl = (UserDetailDAOImpl) context.getBean("userDetailDAOImpl");
		UserDetail userDetail = userDetailDAOImpl.getUserDetail(loginRequest.getUserName());
		if (userDetail != null && loginRequest.getUserName().equalsIgnoreCase(userDetail.getUserName())
				&& loginRequest.getPassword().equals(userDetail.getPassword())) {
			logger.debug("User is validate successfully");
			UserRole userRole = null;
			if (userDetail.getUserId() != 0) {
				userRole = userDetailDAOImpl.getUserRole(userDetail.getUserId());
			}
			LoginResponse loginResponse = new LoginResponse();
			loginResponse.setStatus(SUCCESS_STATUS);
			if (userRole != null) {
				loginResponse.setCode((int) userRole.getRoleId());
			}
			loginResponse.setUserId(String.valueOf(userDetail.getUserId()));
			loginResponse.setUserName(loginRequest.getUserName());
			loginResponse.setUserType(userDetail.getUserType());
			return loginResponse;
		} else {
			LoginResponse loginResponse = new LoginResponse();
			loginResponse.setStatus(FAILED_STATUS);
			loginResponse.setUserId(loginRequest.getUserName());
			loginResponse.setUserName(loginRequest.getUserName());
			return loginResponse;
		}
	}

}
