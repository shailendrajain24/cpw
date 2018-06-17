package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.TrackingDetail;

public class TrackingDetailMapper implements RowMapper<TrackingDetail> {

	public TrackingDetail mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final TrackingDetail trackingDetail = new TrackingDetail();
		trackingDetail.setTrackType(resultSet.getString("TYPE"));
		trackingDetail.setMaxLength(resultSet.getInt("MAX_LENGTH"));
		trackingDetail.setMinLength(resultSet.getInt("MIN_LENGTH"));
		trackingDetail.setType(resultSet.getString("CONTENT_TYPE"));
		trackingDetail.setStartWith(resultSet.getString("START_FROM"));
		trackingDetail.setStartWithLength(resultSet.getString("START_CHAR_LENGTH"));
		trackingDetail.setTrackingId(resultSet.getInt("TYPE_ID"));
		return trackingDetail;
	}

}
