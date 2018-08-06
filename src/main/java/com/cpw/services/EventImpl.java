package com.cpw.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.EventDAOImpl;
import com.cpw.jdbc.model.Event;
import com.cpw.model.EventRequest;
import com.cpw.model.EventResponse;

public class EventImpl {
	public EventImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	private final EventDAOImpl eventDao=(EventDAOImpl)context.getBean("eventDAOImpl");

	public int upsertEvent(EventRequest eventRequest) {
		logger.debug("Entering into Event");
		return eventDao.upsertEvent(map(eventRequest));
	}

	public int removeEvent(long eventId) {
		logger.debug("Entering into Remove");
		return eventDao.removeEvent(eventId);
	}

	public List<EventResponse> eventList(long eventId) {
		logger.debug("Entering into Event List");
		final List<Event> eventList = eventDao.eventList(eventId);
		return map(eventList);

	}
	private List<EventResponse> map(List<Event> eventList) {
		List<EventResponse> eventResponseList = Collections.emptyList();
		if (eventList != null && !eventList.isEmpty()) {
			eventResponseList = new ArrayList<EventResponse>();
			for (Event event : eventList) {
				EventResponse trackingResponse = map(event);
				eventResponseList.add(trackingResponse);
			}
			eventList.clear();
		}
		return eventResponseList;

	}
	private EventResponse map(Event event) {
		EventResponse eventResponse = new EventResponse();
		if (event != null) {
			eventResponse.setEventId(event.getEventId());
			eventResponse.setTitle(event.getTitle());
			eventResponse.setLocation(event.getLocation());
			eventResponse.setAllDay(event.isAllDay());
			eventResponse.setFromDate(event.getFromDate());
			eventResponse.setToDate(event.getToDate());
			eventResponse.setHost(event.getHost());
			eventResponse.setParticipants(event.getParticipants());
			eventResponse.setContact(event.getContact());
			eventResponse.setAccount(event.getAccount());
			eventResponse.setRepeat(event.getRepeat());
			eventResponse.setDescription(event.getDescription());
			eventResponse.setReminder(event.getReminder());
			eventResponse.setParticipantId(event.getParticipantId());
			eventResponse.setParticipantName(event.getParticipantName());
			eventResponse.setCreatedBy(event.getCreatedBy());
			eventResponse.setCreatedTime(event.getCreatedTime());
			eventResponse.setModifyBy(event.getModifyBy());
			eventResponse.setModifyTime(event.getModifyTime());
			eventResponse.setNotes(event.getNotes());
			eventResponse.setAttachments(event.getAttachments());



		}
		return eventResponse;

	}
	private Event map(EventRequest eventRequest)
	{
		Event event=new Event();
		if(eventRequest!=null)
		{
			event.setEventId(eventRequest.getEventId());
			event.setTitle(eventRequest.getTitle());
			event.setLocation(eventRequest.getLocation());
			event.setAllDay(eventRequest.isAllDay());
			event.setFromDate(eventRequest.getFromDate());
			event.setToDate(eventRequest.getToDate());
			event.setHost(eventRequest.getHost());
			event.setParticipants(eventRequest.getParticipants());
			event.setContact(eventRequest.getContact());
			event.setAccount(eventRequest.getAccount());
			event.setRepeat(eventRequest.getRepeat());
			event.setDescription(eventRequest.getDescription());
			event.setReminder(eventRequest.getReminder());
			event.setParticipantId(eventRequest.getParticipantId());
			event.setParticipantName(eventRequest.getParticipantName());
			event.setCreatedBy(eventRequest.getCreatedBy());
			event.setCreatedTime(eventRequest.getCreatedTime());
			event.setModifyBy(eventRequest.getModifyBy());
			event.setModifyTime(eventRequest.getModifyTime() );
			event.setNotes(eventRequest.getNotes());
			event.setAttachments(eventRequest.getAttachments());
		}
		return event;
	}




}
