package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.Sector;

public interface SectorDAO {

	public void setDataSource(DataSource ds);

	public List<Sector> sectorList();

}
