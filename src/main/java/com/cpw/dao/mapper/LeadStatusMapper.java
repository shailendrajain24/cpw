package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.LeadStatus;

public class LeadStatusMapper implements RowMapper<LeadStatus> {

	public LeadStatus mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final LeadStatus leadStatus = new LeadStatus();
		leadStatus.setStatusName(resultSet.getString("NAME"));
		leadStatus.setId(resultSet.getInt("ID"));
		return leadStatus;
	}

}
