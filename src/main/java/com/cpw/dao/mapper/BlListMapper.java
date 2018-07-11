package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.BlList;

public class BlListMapper implements RowMapper<BlList> {

	public BlList mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final BlList blList = new BlList();
		blList.setBookingDate(resultSet.getDate("BOOKING_DATE"));
		blList.setBookingNumber(resultSet.getString("BOOKING_NO"));
		blList.setEta(resultSet.getDate("ETA"));
		blList.setEtd(resultSet.getDate("ETD"));
		return blList;
	}

}
