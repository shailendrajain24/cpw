package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.LeadSource;

public class LeadSourceMapper implements RowMapper<LeadSource> {

	public LeadSource mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final LeadSource leadSource = new LeadSource();
		leadSource.setSourceName(resultSet.getString("NAME"));
		leadSource.setId(resultSet.getInt("ID"));
		return leadSource;
	}

}
