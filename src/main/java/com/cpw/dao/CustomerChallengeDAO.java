package com.cpw.dao;

import javax.sql.DataSource;

import com.cpw.jdbc.model.CustomerChallenge;

public interface CustomerChallengeDAO {

	public void setDataSource(DataSource ds);

	public int customerChallenge(CustomerChallenge customerChallenge);

}
