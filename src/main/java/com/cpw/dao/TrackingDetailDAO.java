package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.TrackingDetail;

public interface TrackingDetailDAO {

	public void setDataSource(DataSource ds);

	public List<TrackingDetail> trackingDetail();

}
