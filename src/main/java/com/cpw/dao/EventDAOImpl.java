package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.Event;

public class EventDAOImpl implements EventDAO{

	@Override
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int upsertEvent(Event event) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Event> eventList(long eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int removeEvent(long eventId) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
