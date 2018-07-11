package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.Industry;

public interface IndustryDAO {

	public void setDataSource(DataSource ds);

	public List<Industry> industryList();

}
