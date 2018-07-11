package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.Industry;

public class IndustryMapper implements RowMapper<Industry> {

	public Industry mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final Industry industry = new Industry();
		industry.setIndustryName(resultSet.getString("NAME"));
		industry.setId(resultSet.getInt("ID"));
		return industry;
	}

}
