package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.AccountType;

public interface AccountTypeDAO {
	public void setDataSource(DataSource ds);

	public List<AccountType> accountTypeList();

}
