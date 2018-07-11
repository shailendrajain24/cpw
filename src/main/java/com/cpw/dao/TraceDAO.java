package com.cpw.dao;

import javax.sql.DataSource;

import com.cpw.jdbc.model.Trace;

public interface TraceDAO {

	public void setDataSource(DataSource ds);

	public Trace traceDetail(String transactionId, int type);

}
