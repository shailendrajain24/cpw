package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.Deal;

public interface DealDAO {
	
	public void setDataSource(DataSource ds);
	
	public int upsert(Deal deal);
	
	public List<Deal> dealList(long dealId);
	
	public int removeList(long dealId);

}
