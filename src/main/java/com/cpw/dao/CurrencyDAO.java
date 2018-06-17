package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.Currency;

public interface CurrencyDAO {

	public void setDataSource(DataSource ds);

	public List<Currency> currencyList();

}
