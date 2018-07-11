package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.AccountType;


public class AccountTypeMapper implements RowMapper<AccountType>{

	@Override
	public AccountType mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final AccountType accountType = new AccountType();
		accountType.setAccTypeList(resultSet.getString("ACC_TYPE_LIST"));
		accountType.setId(resultSet.getInt("ID"));
		return accountType;
	}
	
	

}
