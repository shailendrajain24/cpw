/**
 * 
 */
package com.cpw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cpw.model.LoginRequest;
import com.cpw.model.LoginResponse;
import com.cpw.services.LoginService;
import com.cpw.services.LoginServiceImpl;

/**
 * @author Unknown
 *
 */
@RestController
public class LoginController {
	private static final String SUCCESS_STATUS = "SUCESS";
	private static final String FAILED_STATUS = "FAILED";
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/authentication/{userId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoginResponse> authenticateUser(@PathVariable(value = "userId") String userId,
			@RequestBody LoginRequest request) {

		logger.debug("Entering into Login");
		try {
			if (request.getUserName().isEmpty() || request.getPassword().isEmpty()) {
				return new ResponseEntity<LoginResponse>(HttpStatus.NOT_FOUND);
			} else if (userId != null && userId.equals(request.getUserName())) {
				logger.debug("UserName: " + request.getUserName());
				LoginService loginService = new LoginServiceImpl();
				LoginResponse loginResponse = loginService.authenticateUser(request);
				logger.debug("Service Status: " + loginResponse.getStatus());
				if (loginResponse.getStatus().equals(SUCCESS_STATUS)) {
					return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.OK);
				} else if (loginResponse.getStatus().equals(FAILED_STATUS)) {
					return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.NOT_FOUND);
				}
			}
			return null;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/test")
	public String test() {
		return "CPW Service Available...";
	}

}
