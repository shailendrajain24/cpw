package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.Call;

public class CallMapper implements RowMapper<Call>{

	@Override
	public Call mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final Call call=new Call();
		
		call.setCallId(resultSet.getLong("CALL_ID"));
		call.setType(resultSet.getString("TYPE"));
		call.setContact(resultSet.getString("CONTACT"));
		call.setSubject(resultSet.getString("SUBJECT"));
		call.setCallPurpose(resultSet.getString("CALL_PURPOSE"));
		call.setAccount(resultSet.getString("ACCOUNT"));
		call.setCallType(resultSet.getString("CALL_TYPE"));
		call.setCallStartTime(resultSet.getLong("CALL_START_TIME"));
		call.setCallDuration(resultSet.getLong("CALL_DURATION"));
		call.setDescription(resultSet.getString("DESCRIPTION"));
		call.setCallResult(resultSet.getString("CALL_RESULT"));
		call.setBillable(resultSet.getBoolean("BILLABLE"));
		call.setReminder(resultSet.getString("REMINDER"));
		call.setNotes(resultSet.getString("NOTES"));
		call.setCreatedBy(resultSet.getString("CREATED_BY"));
		call.setModifiedBy(resultSet.getString("MODIFIED_BY"));
		call.setCreatedTime(resultSet.getLong("CREATED_TIME"));
		call.setModifiedTime(resultSet.getLong("MODIFIED_TIME"));
		
		
		return call;
	}
	

}
