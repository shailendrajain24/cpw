package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.Sector;

public class SectorMapper implements RowMapper<Sector> {

	public Sector mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final Sector sector = new Sector();
		sector.setSectorId(resultSet.getInt("SECTOR_ID"));
		sector.setSectorName(resultSet.getString("NAME"));
		return sector;
	}

}
