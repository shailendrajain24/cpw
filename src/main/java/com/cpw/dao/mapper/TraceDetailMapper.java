package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.Trace;

public class TraceDetailMapper implements RowMapper<Trace> {

	public Trace mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final Trace trace = new Trace();
		trace.setJobId(resultSet.getString("JOB_ID"));
		trace.setCartingDate(resultSet.getString("CARTING_DATE"));
		trace.setCustomerClearanceDate(resultSet.getString("CUSTOMS_CLEARANCE_DATE"));
		trace.setShippingBillNumber(resultSet.getString("SHIPPING_BILL_NO"));
		trace.setSobDate(resultSet.getString("SOB_DATE"));
		trace.setContainerNumber(resultSet.getString("CONTAINER_NO"));
		trace.setVolume(resultSet.getString("VOLUME"));
		trace.setBookingDate(resultSet.getString("BOOKING_DATE"));
		trace.setCreateDate(resultSet.getString("CREATED_DATE"));
		trace.setBookingNumber(resultSet.getString("BOOKING_NO"));
		trace.setGrWt(resultSet.getString("GR_WT"));
		return trace;
	}

}
