package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.PortMaster;

public interface PortMasterDAO {

	public void setDataSource(DataSource ds);

	public List<PortMaster> allPortMaster();

}
