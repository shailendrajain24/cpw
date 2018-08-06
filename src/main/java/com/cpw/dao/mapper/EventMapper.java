package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.Event;

public class EventMapper implements RowMapper<Event>{

	@Override
	public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
		final Event event=new Event();
		event.setEventId(rs.getLong("EVENT_ID"));
		event.setTitle(rs.getString("TITLE"));
		event.setLocation(rs.getString("LOCATION"));
		event.setAllDay(rs.getBoolean("ALL_DAY"));
		event.setFromDate(rs.getLong("FROM_DATE"));
		event.setToDate(rs.getLong("TO_DATE"));
		event.setHost(rs.getString("HOST"));
		event.setParticipants(rs.getString("PARTICIPANTS"));
		event.setContact(rs.getString("CONTACT"));
	    event.setAccount(rs.getString("ACCOUNT"));
	    event.setRepeat(rs.getString("REPEAT"));
	    event.setDescription(rs.getString("DESCRIPTION"));
	    event.setReminder(rs.getString("REMINDER"));
	    event.setParticipantId(rs.getLong("PARTICIPANT_ID"));
	    event.setParticipantName(rs.getString("PARTICIPANT_NAME"));
	    event.setCreatedBy(rs.getString("CREATED_BY"));
	    event.setCreatedTime(rs.getLong("CREATED_TIME"));
	    event.setModifyBy(rs.getString("MODIFY_BY"));
		event.setModifyTime(rs.getLong("MODIFY_TIME"));
	    event.setNotes(rs.getString("NOTES"));
	    event.setAttachments(rs.getString("ATTACHMENTS"));
	    
		
	    
		return event;
	}
	

}
