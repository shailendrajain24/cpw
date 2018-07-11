package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.Currency;

public class CurrencyMapper implements RowMapper<Currency> {

	public Currency mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final Currency currency = new Currency();
		currency.setCurrencyId(resultSet.getInt("CURRENCY_ID"));
		currency.setCurrencyCode(resultSet.getString("CODE"));
		return currency;
	}

}
