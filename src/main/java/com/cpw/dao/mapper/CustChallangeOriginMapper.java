package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.CustChallangeOrigin;

public class CustChallangeOriginMapper implements RowMapper<CustChallangeOrigin> {

	public CustChallangeOrigin mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final CustChallangeOrigin custChallangeOrigin = new CustChallangeOrigin();
		custChallangeOrigin.setOriginId(resultSet.getInt("PRIORTY_ID"));
		custChallangeOrigin.setOriginName(resultSet.getString("NAME"));
		return custChallangeOrigin;
	}

}
