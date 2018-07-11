package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.Trace;

public class TraceDetailMapper implements RowMapper<Trace> {

	public Trace mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final Trace trace = new Trace();
/*		
		trackingDetail.setTrackType(resultSet.getString("TYPE"));
		trackingDetail.setMaxLength(resultSet.getInt("MAX_LENGTH"));
		trackingDetail.setMinLength(resultSet.getInt("MIN_LENGTH"));
		trackingDetail.setType(resultSet.getString("CONTENT_TYPE"));
		trackingDetail.setStartWith(resultSet.getString("START_FROM"));
		trackingDetail.setStartWithLength(resultSet.getString("START_CHAR_LENGTH"));
		trackingDetail.setTrackingId(resultSet.getInt("TYPE_ID"));*/
		
		trace.setCfsReceivedId(resultSet.getString("CFS_RECEIVED_ID"));
		trace.setSlrNumber(resultSet.getString("SRL_NO"));
		trace.setBookingId(resultSet.getString("BOOKING_ID"));
		trace.setJobId(resultSet.getString("JOB_ID"));
		trace.setShippingBillNumber(resultSet.getString("SHIPPING_BILL_NO"));
		trace.setShippingBillDate(resultSet.getDate("SHIPPING_BILL_DATE"));
		trace.setCartingDate(resultSet.getDate("CARTING_DATE"));
		trace.setCustomerClearanceDate(resultSet.getDate("CUSTOMS_CLEARANCE_DATE"));
		trace.setHdrCfsReceivedId(resultSet.getString("HDR_CFS_RECEIVED_ID"));//AS
		trace.setReceiptNumber(resultSet.getString("RECEIPT_NO"));
		trace.setReceiptDate(resultSet.getDate("RECEIPT_DATE"));
		trace.setCfsPolCode(resultSet.getString("CFS_POL_CODE"));//AS
		trace.setCfsPodCode(resultSet.getString("CFS_POD_CODE"));//AS
		trace.setCfsFdcCode(resultSet.getString("CFS_FDC_CODE"));//AS
		trace.setStatus(resultSet.getInt("STATUS"));
		/*
		resultSet.getString("STATUS"));
		resultSet.getString("BOOKING_HDR_ID"));//AS
		resultSet.getString("BOOKING_NO"));
		resultSet.getDate("BOOKING_DATE"));
		resultSet.getString("BOOKING_POL_CODE"));//AS
		resultSet.getString("BOOKING_POD_CODE"));//AS
		resultSet.getString("BOOKING_FDC_CODE"));
		resultSet.getString("MBL_NO"));
		resultSet.getString("BOOK_JOB_ID"));
		resultSet.getString("HBL_NO_OTHERS"));
		resultSet.getString("JOB_HDR_ID"));
		resultSet.getString("JOB_NO"));
		resultSet.getString("JOB_POL_CODE"));//AS
		resultSet.getString("JOB_FDC_CODE"));//AS
		resultSet.getString("JOB_POD_CODE"));//AS
		resultSet.getString("SOB_DATE"));
		resultSet.getDate("CREATED_DATE"));
		resultSet.getString("CLP_ID"));
		resultSet.getString("CLP_HDR_ID"));
		resultSet.getString("CLP_HDR_SRL_NO"));
		resultSet.getString("CLP_DTL_ID"));
		resultSet.getString("CLP_DTL_SRL_NO"));
		resultSet.getString("GR_WT"));
		resultSet.getString("VOLUME"));
		resultSet.getString("CLP_TYPE"));
		resultSet.getString("PROCURMENT_ID"));
		resultSet.getString("SERIAL_NO"));
		resultSet.getString("CONTAINER_NO")); */
		return trace;
	}

}
