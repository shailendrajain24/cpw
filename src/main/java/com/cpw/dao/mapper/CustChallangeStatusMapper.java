package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.CustChallangeStatus;

public class CustChallangeStatusMapper implements RowMapper<CustChallangeStatus> {

	public CustChallangeStatus mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final CustChallangeStatus custChallangeStatus = new CustChallangeStatus();
		custChallangeStatus.setStatusId(resultSet.getInt("PRIORTY_ID"));
		custChallangeStatus.setStatusName(resultSet.getString("NAME"));
		return custChallangeStatus;
	}

}
