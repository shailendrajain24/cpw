package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.CustChallangePriorty;

public interface CustChallangePriortyDAO {

	public void setDataSource(DataSource ds);

	public List<CustChallangePriorty> custChallangePriortyList();

}
