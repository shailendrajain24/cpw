package com.cpw.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.EventDAOImpl;

public class EventImpl {
	public EventImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	private final EventDAOImpl eventDao=(EventDAOImpl)context.getBean("eventDAOImpl");
	

}
