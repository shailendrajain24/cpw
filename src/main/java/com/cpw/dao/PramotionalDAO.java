package com.cpw.dao;

import javax.sql.DataSource;

import com.cpw.jdbc.model.Pramotional;

public interface PramotionalDAO {

	public void setDataSource(DataSource ds);

	public String pramotinal(Pramotional pramotional);

}
