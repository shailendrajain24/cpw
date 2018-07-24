package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.Trace;

public interface TraceDAO {

	public void setDataSource(DataSource ds);

	public List<Trace> traceDetail(String transactionId, int type);

}
