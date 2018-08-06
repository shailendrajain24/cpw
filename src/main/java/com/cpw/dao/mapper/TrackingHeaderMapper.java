package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.TrackingHeader;

public class TrackingHeaderMapper implements RowMapper<TrackingHeader>{

	@Override
	public TrackingHeader mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final TrackingHeader tracking=new TrackingHeader();
		tracking.setPolCode(resultSet.getString("POL_CODE"));
		tracking.setPodCode(resultSet.getString("POD_CODE"));
		tracking.setEtd(resultSet.getString("ETD"));
		tracking.setEta(resultSet.getString("ETA"));
		tracking.setCurrentStatus(resultSet.getString("CURRENCT_STATUS"));
		/*tracking.setCfcRecievedId(resultSet.getInt("CFS_RECEIVED_ID"));
		tracking.setScheduleId(resultSet.getInt("SCHEDULE_ID"));
		tracking.setScheduleUId(resultSet.getInt("SCHEDULE_UID "));
		tracking.setBookingId(resultSet.getLong("BOOKING_ID"));
		tracking.setJobId(resultSet.getLong("JOB_ID"));
		tracking.setClpDtlId(resultSet.getLong("CLP_DTL_ID"));
		tracking.setClpDtlSlrNo(resultSet.getLong("CLP_DTL_SRL_NO"));
		tracking.setSlrNo(resultSet.getLong("SRL_NO "));
		tracking.setClpType(resultSet.getInt("CLP_TYPE"));
		tracking.setProcurementId(resultSet.getLong("PROCURMENT_ID"));
		tracking.setClpHdrId(resultSet.getLong("CLP_HDR_ID"));
		tracking.setSerialNo(resultSet.getLong("SERIAL_NO "));
		tracking.setClpHdrSlrNo(resultSet.getLong("CLP_HDR_SRL_NO "));
		tracking.setBookingNo(resultSet.getString("BOOKING_NO"));*/
		return tracking;
	}

}
