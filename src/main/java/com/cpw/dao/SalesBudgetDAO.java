package com.cpw.dao;

import javax.sql.DataSource;

import com.cpw.jdbc.model.SalesBudget;

public interface SalesBudgetDAO {

	public void setDataSource(DataSource ds);

	public int salesBudget(SalesBudget salesBudget);

}
