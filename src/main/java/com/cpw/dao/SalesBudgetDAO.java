package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.SalesBudget;

public interface SalesBudgetDAO {

	public void setDataSource(DataSource ds);

	public int salesBudget(SalesBudget salesBudget);
	
	public List<SalesBudget> salesBudgetList(long id);
	
	public int removeSalesBudget(long id);

}
