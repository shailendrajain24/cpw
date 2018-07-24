package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.AddAccount;

public interface AddAccountDAO {
	public void setDataSource(DataSource ds);

	public int upsertAccount(AddAccount account);

	public List<AddAccount> accountList(long id);

	public int removeAccount(long id);

}
