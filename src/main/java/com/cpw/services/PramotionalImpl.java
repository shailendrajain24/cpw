package com.cpw.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.PramotionalDAOImpl;
import com.cpw.dao.TraceDAOImpl;
import com.cpw.jdbc.model.Pramotional;
import com.cpw.jdbc.model.Trace;
import com.cpw.model.PramotionalRequest;
import com.cpw.model.TraceResponse;

public class PramotionalImpl {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public String pramotional(PramotionalRequest pramotionalRequest) {
		logger.debug("Entering into pramotional");
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		PramotionalDAOImpl pramotionalDAOImpl = (PramotionalDAOImpl) context.getBean("pramotionalDAOImpl");
		return pramotionalDAOImpl.pramotinal(map(pramotionalRequest));
	}

	private Pramotional map(PramotionalRequest pramotionalRequest) {
		Pramotional pramotional = new Pramotional();
		if (pramotionalRequest != null) {
			pramotional.setAddAttachment(pramotionalRequest.getAddAttachment());
			pramotional.setAttachment(pramotionalRequest.getAttachment());
			pramotional.setBody(pramotionalRequest.getBody());
			pramotional.setCategoryId(pramotionalRequest.getCategoryId());
			pramotional.setCommercialNvo(pramotionalRequest.getCommercialNvo());
			pramotional.setCountryId(pramotionalRequest.getCountryId());
			pramotional.setCreatedBy(pramotionalRequest.getCreatedBy());
			pramotional.setCreatedTime(pramotionalRequest.getCreatedTime());
			pramotional.setFromEmailId(pramotionalRequest.getFromEmailId());
			pramotional.setFyId(pramotionalRequest.getFyId());
			pramotional.setFyPrdId(pramotionalRequest.getFyPrdId());
			pramotional.setLocId(pramotionalRequest.getLocId());
			pramotional.setModifyBy(pramotionalRequest.getModifyBy());
			pramotional.setModifyDate(pramotionalRequest.getModifyDate());
			pramotional.setModifyTime(pramotionalRequest.getModifyTime());
			pramotional.setPrimaryId(pramotionalRequest.getPrimaryId());
			pramotional.setSendBy(pramotionalRequest.getSendBy());
			pramotional.setSubject(pramotionalRequest.getSubject());
			pramotional.setToEmailId(pramotionalRequest.getToEmailId());
		}
		return pramotional;

	}

}
