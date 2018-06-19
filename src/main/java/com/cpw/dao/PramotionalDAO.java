package com.cpw.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.jdbc.model.Pramotional;

public interface PramotionalDAO {

	public void setDataSource(DataSource ds);

	public int pramotinal(Pramotional pramotional);

}
