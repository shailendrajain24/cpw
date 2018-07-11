package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.CustChallangeOrigin;

public interface CustChallangeOriginDAO {

	public void setDataSource(DataSource ds);

	public List<CustChallangeOrigin> custChallangeOriginList();

}
