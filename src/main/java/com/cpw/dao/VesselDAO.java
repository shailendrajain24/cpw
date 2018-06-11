package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.Vessel;

public interface VesselDAO {

	public void setDataSource(DataSource ds);

	public List<Vessel> vesselList();

}
