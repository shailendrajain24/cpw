package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.Salutation;

public class SalutationMapper implements RowMapper<Salutation> {

	public Salutation mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final Salutation salutation = new Salutation();
		salutation.setSalutationName(resultSet.getString("NAME"));
		salutation.setId(resultSet.getInt("ID"));
		return salutation;
	}

}
