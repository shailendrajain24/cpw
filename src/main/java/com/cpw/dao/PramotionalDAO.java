package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.Pramotional;

public interface PramotionalDAO {

	public void setDataSource(DataSource ds);

	public int pramotinal(Pramotional pramotional);
	
	public List<Pramotional> pramotionalList(long primaryId);
	
	public int removePramotional(long primaryId);

}
