package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.Stage;

public interface StageDAO {
	public void setDataSource(DataSource ds);

	public List<Stage> stageList();

}
