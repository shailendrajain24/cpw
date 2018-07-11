package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.CustChallangeStatus;

public interface CustChallangeStatusDAO {

	public void setDataSource(DataSource ds);

	public List<CustChallangeStatus> custChallangeStatusList();

}
