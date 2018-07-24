package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.Event;

public interface EventDAO {
	public void setDataSource(DataSource ds);

	public int upsertEvent(Event event);

	public List<Event> eventList(long eventId);

	public int removeEvent(long eventId);


}
