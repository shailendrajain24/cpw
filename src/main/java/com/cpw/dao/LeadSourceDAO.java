package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.LeadSource;

public interface LeadSourceDAO {

	public void setDataSource(DataSource ds);

	public List<LeadSource> leadSourceList();

}
