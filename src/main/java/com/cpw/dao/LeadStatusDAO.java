package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.LeadStatus;

public interface LeadStatusDAO {

	public void setDataSource(DataSource ds);

	public List<LeadStatus> leadStatusList();

}
