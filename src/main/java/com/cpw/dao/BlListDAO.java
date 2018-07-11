package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.BlList;

public interface BlListDAO {

	public void setDataSource(DataSource ds);

	public List<BlList> getBlList(String userType, int userId);

}
