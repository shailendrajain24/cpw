package com.cpw.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cpw.model.EventRequest;
import com.cpw.model.EventResponse;
import com.cpw.services.EventImpl;

@RestController
public class EventController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "addEvent", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
	public ResponseEntity<?> upsertEvent(@RequestBody EventRequest request) {

		logger.debug("Entering into Event");
		try {

			EventImpl eventImpl = new EventImpl();
			int response = eventImpl.upsertEvent(request);
			if (response>0) {
				return new ResponseEntity<Object>(HttpStatus.CREATED);
			} else { 
				return new ResponseEntity<Object>(HttpStatus.NOT_ACCEPTABLE);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "events/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<? extends EventResponse>> events(@PathVariable("id") long eventId) {
		logger.debug("Entering into event list");
		try {
			EventImpl eventImpl = new EventImpl();
			List<EventResponse> eventResponse = eventImpl.eventList(eventId);
			if (eventResponse != null && !eventResponse.isEmpty()) {
				return new ResponseEntity<List<? extends EventResponse>>(eventResponse, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<? extends EventResponse>>(eventResponse, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "removeEvent/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> removeEvent(@PathVariable("id") long eventId) {
		logger.debug("Entering into remove");
		try {
			EventImpl eventImpl = new EventImpl();
			int response = eventImpl.removeEvent(eventId);
			if (response>0) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}



}
