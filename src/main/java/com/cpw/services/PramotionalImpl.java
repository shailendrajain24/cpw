package com.cpw.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.PramotionalDAOImpl;
import com.cpw.jdbc.model.Pramotional;
import com.cpw.model.PramotionalRequest;

public class PramotionalImpl {
	public PramotionalImpl() {
	}

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private ApplicationContext context;
	// private JdbcTemplate jdbcTemplateObject;

	/*
	 * public PramotionalImpl(JdbcTemplate jdbcTemplateObject) {
	 * this.jdbcTemplateObject = jdbcTemplateObject; }
	 */

	/*
	 * public void setDataSource(DataSource dataSource) { this.jdbcTemplateObject =
	 * new JdbcTemplate(dataSource); }
	 */

	public int pramotional(PramotionalRequest pramotionalRequest) {
		logger.debug("Entering into pramotional");
		context = new ClassPathXmlApplicationContext("Beans.xml");
		PramotionalDAOImpl pramotionalDAO = (PramotionalDAOImpl) context.getBean("pramotionalDAOImpl");
		return pramotionalDAO.pramotinal(map(pramotionalRequest));
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
			if (pramotionalRequest.getCreatedDate() != null) {
				pramotional
						.setCreatedDate(DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(LocalDateTime
								.ofInstant(pramotionalRequest.getCreatedDate().toInstant(), ZoneId.systemDefault())));
			}
			pramotional.setCreatedTime(pramotionalRequest.getCreatedTime());
			pramotional.setFromEmailId(pramotionalRequest.getFromEmailId());
			pramotional.setFyId(pramotionalRequest.getFyId());
			pramotional.setFyPrdId(pramotionalRequest.getFyPrdId());
			pramotional.setLocId(pramotionalRequest.getLocId());
			pramotional.setModifyBy(pramotionalRequest.getModifyBy());
			if (pramotionalRequest.getCreatedDate() != null) {
				pramotional.setModifyDate(DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(LocalDateTime
						.ofInstant(pramotionalRequest.getModifyDate().toInstant(), ZoneId.systemDefault())));
			}
			pramotional.setModifyTime(pramotionalRequest.getModifyTime());
			pramotional.setPrimaryId(pramotionalRequest.getPrimaryId());
			pramotional.setSendBy(pramotionalRequest.getSendBy());
			pramotional.setSubject(pramotionalRequest.getSubject());
			pramotional.setToEmailId(pramotionalRequest.getToEmailId());
		}
		return pramotional;

	}

}
