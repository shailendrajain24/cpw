package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.CustChallangePriorty;

public class CustChallangePriortyMapper implements RowMapper<CustChallangePriorty> {

	public CustChallangePriorty mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final CustChallangePriorty custChallangePriorty = new CustChallangePriorty();
		custChallangePriorty.setPriortyId(resultSet.getInt("PRIORTY_ID"));
		custChallangePriorty.setPriortyName(resultSet.getString("NAME"));
		return custChallangePriorty;
	}

}
