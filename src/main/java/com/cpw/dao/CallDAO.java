package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.Call;

public interface CallDAO {
	
	public void setDataSource(DataSource ds);
	
	public int upsertCall(Call call);
	
	public List<Call> callList(long callId);
	
	public int removeCall(long callId);

}
