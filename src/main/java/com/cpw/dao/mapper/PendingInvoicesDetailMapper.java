package com.cpw.dao.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.PendingInvoicesDetail;

public class PendingInvoicesDetailMapper implements RowMapper<PendingInvoicesDetail> {

	@Override
	public PendingInvoicesDetail mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final PendingInvoicesDetail penInvDetail = new PendingInvoicesDetail();
		penInvDetail.setBookingId(resultSet.getString("BOOKING_ID"));
		penInvDetail.setBookingNumber(resultSet.getString("BOOKING_NO"));
		penInvDetail.setInvoiceNumber(resultSet.getString("IV_NO"));
		penInvDetail.setLocalAmount(resultSet.getString("LOCAL_AMOUNT"));
		Date date = resultSet.getDate("DUE_DATE");
		if (date!= null) {
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			penInvDetail.setDueDate(df.format(date));
		}
		return penInvDetail;
	}

}
