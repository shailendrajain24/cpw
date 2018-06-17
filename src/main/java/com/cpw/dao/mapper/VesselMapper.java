package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.Vessel;

public class VesselMapper implements RowMapper<Vessel> {

	public Vessel mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final Vessel vessel = new Vessel();
		vessel.setVesselName(resultSet.getString("NAME"));
		vessel.setVesselId(resultSet.getInt("VESSEL_ID"));
		return vessel;
	}

}
