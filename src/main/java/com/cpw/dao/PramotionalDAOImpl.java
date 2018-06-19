package com.cpw.dao;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.jdbc.model.Pramotional;

public class PramotionalDAOImpl implements PramotionalDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private JdbcTemplate jdbcTemplateObject;

	//private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public int pramotinal(Pramotional pramotional) {
		logger.debug("Entering into pramotinal DAO");
		CpwTemplete<Pramotional> cpwTemplete = new CpwTempleteImpl<Pramotional>();
		String sql = "INSERT INTO PROMOTION_MAIL" + 
				"(PRM_ID, FROM_MAIL_ID, TO_MAIL_ID, COMMERCIAL_NVO, SEND_BY, SUBJECT, COUNTRY_ID, CATEGORY_ID, "
				+ "ATTACHMENT, ADD_ATTACHMENT, BODY, LOC_ID, FY_ID, FY_PRD_ID, CR_BY, CR_DATE, CR_TIME, MD_BY, MD_DATE, MD_TIME) "
				+ "VALUES(?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object [] values = new Object [20];
		values [0] = pramotional.getPrimaryId();
		values [1] = pramotional.getFromEmailId();
		values [2] = pramotional.getToEmailId();
		values [3] = pramotional.getCommercialNvo();
		values [4] = pramotional.getSendBy();
		values [5] = pramotional.getSubject();
		values [6] = pramotional.getCountryId();
		values [7] = pramotional.getCategoryId();
		values [8] = pramotional.getAttachment();
		values [9] = pramotional.getAddAttachment();
		values [10] = pramotional.getBody();
		values [11] = pramotional.getLocId();
		values [12] = pramotional.getFyId();
		values [13] = pramotional.getFyPrdId();
		values [14] = pramotional.getCreatedBy();
		values [15] = pramotional.getCreatedDate();
		values [16] = pramotional.getCreatedTime();
		values [17] = pramotional.getModifyBy();
		values [18] = pramotional.getModifyDate();
		values [19] = pramotional.getModifyTime();
		try {
			logger.debug("Before Calling upsert");
			int count = cpwTemplete.upsert(sql, values, jdbcTemplateObject);
			logger.debug("Record creation status: "+count);
			return count ;
		} catch (DataAccessException e) {
			logger.error("Exception at time of creation"+ e);
			return 0;
		}
	}

}
