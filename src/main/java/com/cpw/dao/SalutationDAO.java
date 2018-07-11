package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.Salutation;

public interface SalutationDAO {

	public void setDataSource(DataSource ds);

	public List<Salutation> salutationList();

}
