/**
 * 
 */
package com.cpw.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Unknown
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginRequest {
	String userId;
	String password;
	@JsonCreator
	 public LoginRequest(@JsonProperty("userId") String userId, @JsonProperty("password") String password) {
	  this.userId = userId;
	  this.password = password;
	 }

	 public LoginRequest() {

	 }
	public String getUserName() {
		return userId;
	}
	public void setUserName(String userName) {
		this.userId = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
