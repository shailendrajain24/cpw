package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.PendingInvoicesDetail;

public class PendingInvoicesDetailMapper implements RowMapper<PendingInvoicesDetail> {

	@Override
	public PendingInvoicesDetail mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		PendingInvoicesDetail penInvDetail = new PendingInvoicesDetail();
		penInvDetail.setBookingId(resultSet.getString("BOOKING_ID"));
		penInvDetail.setBookingNumber(resultSet.getString("BOOKING_NO"));
		penInvDetail.setInvoiceNumber(resultSet.getString("IV_NO"));
		penInvDetail.setLocalAmount(resultSet.getString("LOCAL_AMOUNT"));
		return penInvDetail;
	}

}
