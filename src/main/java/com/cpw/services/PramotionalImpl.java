package com.cpw.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.PramotionalDAOImpl;
import com.cpw.jdbc.model.Pramotional;
import com.cpw.model.PramotionalRequest;
import com.cpw.model.PramotionalResponse;

public class PramotionalImpl {
	public PramotionalImpl() {
	}

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private final ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	private final PramotionalDAOImpl pramotionalDAO = (PramotionalDAOImpl) context.getBean("pramotionalDAOImpl");
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

	public List<PramotionalResponse> pramotionalList(long primaryId)
	{
		logger.debug("Entering into List");
		final List<Pramotional> pramotionalList=pramotionalDAO.pramotionalList(primaryId);
		return map(pramotionalList);		
	}

	private List<PramotionalResponse> map(List<Pramotional> pramotionalList){

		List<PramotionalResponse> pramotionalResponse=Collections.emptyList();
		if(pramotionalList!=null && !pramotionalList.isEmpty())
		{
			pramotionalResponse=new ArrayList<PramotionalResponse>();
			for(Pramotional pramotional : pramotionalList)
			{
				PramotionalResponse pramotionalResponseList=map(pramotional);
				pramotionalResponse.add(pramotionalResponseList);
			}
			pramotionalList.clear();
		}
		return pramotionalResponse;

	}

	private PramotionalResponse map(Pramotional pramotional)
	{
		PramotionalResponse pramotionalResponse=new PramotionalResponse();
		if(pramotional!=null)
		{
			pramotionalResponse.setPrimaryId(pramotional.getPrimaryId());
			pramotionalResponse.setFromEmailId(pramotional.getFromEmailId());
			pramotionalResponse.setToEmailId(pramotional.getToEmailId());
			pramotionalResponse.setCommercialNvo(pramotional.getCommercialNvo());
			pramotionalResponse.setSendBy(pramotional.getSendBy());
			pramotionalResponse.setSubject(pramotional.getSubject());
			pramotionalResponse.setCountryId(pramotional.getCountryId());
			pramotionalResponse.setCategoryId(pramotional.getCategoryId());
			pramotionalResponse.setAttachment(pramotional.getAttachment());
			pramotionalResponse.setAddAttachment(pramotional.getAddAttachment());
			pramotionalResponse.setBody(pramotional.getBody());
			pramotionalResponse.setLocId(pramotional.getLocId());
			pramotionalResponse.setFyId(pramotional.getFyId());
			pramotionalResponse.setFyPrdId(pramotional.getFyPrdId());
			pramotionalResponse.setCreatedBy(pramotional.getCreatedBy());
			pramotionalResponse.setCreatedDate(pramotional.getCreatedDate());
			pramotionalResponse.setCreatedTime(pramotional.getCreatedTime());
			pramotionalResponse.setModifyBy(pramotional.getModifyBy());
			pramotionalResponse.setModifyDate(pramotional.getModifyDate());
			pramotionalResponse.setModifyTime(pramotional.getModifyTime());
		}
		return pramotionalResponse;

	}


}
