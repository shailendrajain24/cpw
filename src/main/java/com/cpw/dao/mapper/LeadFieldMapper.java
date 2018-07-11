package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.LeadField;



	
	
	public class LeadFieldMapper implements RowMapper<LeadField> {

		public LeadField mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			final LeadField leadField = new LeadField();
			leadField.setFieldName(resultSet.getString("FIELD"));
			leadField.setId(resultSet.getInt("ID"));
			return leadField;
		}

	}



