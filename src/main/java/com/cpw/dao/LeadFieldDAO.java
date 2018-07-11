package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.LeadField;

public interface LeadFieldDAO {

	public void setDataSource(DataSource ds);

	public List<LeadField> leadFieldList();

}
