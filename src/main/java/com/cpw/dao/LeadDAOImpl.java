package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.LeadMapper;
import com.cpw.jdbc.model.Lead;

public class LeadDAOImpl implements LeadDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Lead> leadList(String createdBy) {
		logger.debug("Entering into leadList " + createdBy);
		final String trackingSql = "Select IMAGE, LEAD_ID, LEAD_OWNER, COMPANY, FNAME, LNAME, TITLE, EMAIL, PHONE, FAX, MOBILE, WEBSITE, "
				+ "LEAD_SOURCE, LEAD_STATUS, INDUSTRY, NO_OF_EMP, ANNUAL_REVENUE, RATING, EMAIL_OUTPUT, SKYPE_ID, ADDRESS_STREET, ADDRESS_CITY, "
				+ "ADDRESS_STATE, ADDRESS_ZIPCODE, ADDRESS_COUNTRY, DESCRIPTION, CR_DATE, MD_DATE, CR_BY"
				+ " from  LEAD  WHERE CR_BY = ?";
		try {
			List<Lead> leadList = jdbcTemplateObject.query(trackingSql, new Object[] { createdBy }, new LeadMapper());
			return leadList;
		} catch (EmptyResultDataAccessException e) {
			logger.error("No leadList in system");
			return null;
		}
	}

	@Override
	public int upsertLead(Lead lead) {
		logger.debug("Entering into lead DAO");
		CpwTemplete<Lead> cpwTemplete = new CpwTempleteImpl<Lead>();
		/*
		 * String sql = "MERGE INTO LEAD AS L USING (" +
		 * "SELECT ? IMAGE, ? LEAD_ID, ? LEAD_OWNER, ? COMPANY, ? FNAME, ? LNAME, ? TITLE, ? EMAIL, ? PHONE, ? FAX, ? MOBILE, "
		 * +
		 * "? WEBSITE, ? LEAD_SOURCE, ? LEAD_STATUS, ? INDUSTRY, ? NO_OF_EMP, ? ANNUAL_REVENUE, ? RATING, ? EMAIL_OUTPUT, ? SKYPE_ID, "
		 * +
		 * "? ADDRESS_STREET, ? ADDRESS_CITY, ? ADDRESS_STATE, ? ADDRESS_ZIPCODE, ? ADDRESS_COUNTRY, ? DESCRIPTION, ? CR_DATE, "
		 * + "? MD_DATE, ? CR_BY FROM DUAL ) AS E ON L.LEAD_ID = E.LEAD_ID " +
		 * "WHEN MATCHED THEN " +
		 * "UPDATE SET L.IMAGE = E.IMAGE , L.LEAD_OWNER = E.LEAD_OWNER , L.COMPANY = E.COMPANY , L.FNAME = E.FNAME , "
		 * +
		 * "L.LNAME = E.LNAME , L.TITLE = E.TITLE , L.EMAIL = E.EMAIL , L.PHONE = E.PHONE , L.FAX = E.FAX , L.MOBILE = E.MOBILE , "
		 * +
		 * "L.WEBSITE = E.WEBSITE , L.LEAD_SOURCE = E.LEAD_SOURCE , L.LEAD_STATUS = E.LEAD_STATUS , L.INDUSTRY = E.INDUSTRY , "
		 * +
		 * "L.NO_OF_EMP = E.NO_OF_EMP , L.ANNUAL_REVENUE = E.ANNUAL_REVENUE , L.RATING = E.RATING , L.EMAIL_OUTPUT = E.EMAIL_OUTPUT , "
		 * +
		 * "L.SKYPE_ID = E.SKYPE_ID , L.ADDRESS_STREET = E.ADDRESS_STREET , L.ADDRESS_CITY = E.ADDRESS_CITY , L.ADDRESS_STATE = E.ADDRESS_STATE , "
		 * +
		 * "L.ADDRESS_ZIPCODE = E.ADDRESS_ZIPCODE , L.ADDRESS_COUNTRY = E.ADDRESS_COUNTRY , L.DESCRIPTION = E.DESCRIPTION, L.CR_DATE = E.CR_DATE, "
		 * + "L.MD_DATE= E.MD_DATE, L.CR_BY= E.CR_BY " + "WHEN NOT MATCHED THEN " +
		 * "INSERT (IMAGE, LEAD_ID, LEAD_OWNER, COMPANY, FNAME, LNAME, TITLE, EMAIL, PHONE, FAX, MOBILE, WEBSITE, LEAD_SOURCE, LEAD_STATUS, "
		 * +
		 * "INDUSTRY, NO_OF_EMP, ANNUAL_REVENUE, RATING, EMAIL_OUTPUT, SKYPE_ID, ADDRESS_STREET, ADDRESS_CITY, ADDRESS_STATE, ADDRESS_ZIPCODE, "
		 * + "ADDRESS_COUNTRY, DESCRIPTION, CR_DATE, MD_DATE, CR_BY)" +
		 * "VALUES (E.IMAGE, E.LEAD_ID, E.LEAD_OWNER, E.COMPANY, E.FNAME, E.LNAME, E.TITLE, E.EMAIL, E.PHONE, E.FAX, E.MOBILE, E.WEBSITE, E.LEAD_SOURCE, "
		 * +
		 * "E.LEAD_STATUS, E.INDUSTRY, E.NO_OF_EMP, E.ANNUAL_REVENUE, E.RATING, E.EMAIL_OUTPUT, E.SKYPE_ID, E.ADDRESS_STREET, E.ADDRESS_CITY, "
		 * +
		 * "E.ADDRESS_STATE, E.ADDRESS_ZIPCODE, E.ADDRESS_COUNTRY, E.DESCRIPTION, E.CR_DATE, E.MD_DATE, E.CR_BY);"
		 * ;
		 */
		String q1 = "select * from lead where lead_id=?";
		Lead l = null;
		try {
			l = jdbcTemplateObject.queryForObject(q1, new Object[] { lead.getLeadId() }, new LeadMapper());
		} catch (EmptyResultDataAccessException e) {
			l = null;
		}
		try {
			int count = -1;
			if (l != null && l.getLeadId() == lead.getLeadId()) {
				logger.debug("UPDATE values" + lead.getLeadId());
				String updateSql = "UPDATE LEAD SET IMAGE=?, LEAD_OWNER=?, COMPANY=?, FNAME=?, LNAME=?, TITLE=?,"
						+ " EMAIL=?, PHONE=?, FAX=?, MOBILE=?, WEBSITE=?, LEAD_SOURCE=?, LEAD_STATUS=?, INDUSTRY=?, NO_OF_EMP=?"
						+ ", ANNUAL_REVENUE=?, RATING=?, EMAIL_OUTPUT=?, SKYPE_ID=?, ADDRESS_STREET=?, ADDRESS_CITY=?,"
						+ " ADDRESS_STATE=?, ADDRESS_ZIPCODE=?, ADDRESS_COUNTRY=?, DESCRIPTION=?, MD_DATE=?"
						+ " WHERE LEAD_ID=?";
				return jdbcTemplateObject.update(updateSql, lead.getUploadedInputStream(),
						lead.getLeadOwner(),lead.getCompany(),lead.getFirstName(),
						lead.getLastName(),lead.getTitle(),lead.getEmail(),
						lead.getPhone(),lead.getFax(),lead.getMobile(),
						lead.getWebsite(),lead.getLeadSource(),lead.getLeadStatus(),
						lead.getIndustry(),lead.getNoOfEmployees(),lead.getAnnualRevenue(),
						lead.getRating(),lead.isEmailOptOut(),lead.getSkypeId(),
						lead.getAddressStreet(),lead.getAddressCity(),lead.getAddressState(),
						lead.getAddressZipCode(),lead.getAddressCounty(),lead.getDescription(),
						lead.getModifyDate(),lead.getLeadId());
			} else {
				Object[] values = new Object[29];
				values[0] = lead.getUploadedInputStream();
				values[1] = lead.getLeadId();
				values[2] = lead.getLeadOwner();
				values[3] = lead.getCompany();
				values[4] = lead.getFirstName();
				values[5] = lead.getLastName();
				values[6] = lead.getTitle();
				values[7] = lead.getEmail();
				values[8] = lead.getPhone();
				values[9] = lead.getFax();
				values[10] = lead.getMobile();
				values[11] = lead.getWebsite();
				values[12] = lead.getLeadSource();
				values[13] = lead.getLeadStatus();
				values[14] = lead.getIndustry();
				values[15] = lead.getNoOfEmployees();
				values[16] = lead.getAnnualRevenue();
				values[17] = lead.getRating();
				values[18] = lead.isEmailOptOut();
				values[19] = lead.getSkypeId();
				values[20] = lead.getAddressStreet();
				values[21] = lead.getAddressCity();
				values[22] = lead.getAddressState();
				values[23] = lead.getAddressZipCode();
				values[24] = lead.getAddressCounty();
				values[25] = lead.getDescription();
				values[26] = lead.getCreateDate();
				values[27] = lead.getModifyDate();
				values[28] = lead.getCreatedBy();
				logger.debug("INSERT values" + values[1]);
				String insertSql = "INSERT INTO LEAD (IMAGE, LEAD_ID, LEAD_OWNER, COMPANY, FNAME, LNAME, TITLE,"
						+ " EMAIL, PHONE, FAX, MOBILE, WEBSITE, LEAD_SOURCE, LEAD_STATUS, INDUSTRY, NO_OF_EMP, ANNUAL_REVENUE,"
						+ " RATING, EMAIL_OUTPUT, SKYPE_ID, ADDRESS_STREET, ADDRESS_CITY, ADDRESS_STATE, ADDRESS_ZIPCODE,"
						+ " ADDRESS_COUNTRY, DESCRIPTION, CR_DATE, MD_DATE, CR_BY)"
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
				count = cpwTemplete.upsert(insertSql, values, jdbcTemplateObject);
				logger.debug("Record creation status: " + count);
			}
			logger.debug("Before Calling upsert");

			return count;
		} catch (DataAccessException e) {
			// logger.error("Exception at time of creation" + e);
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int removeLead(long leadId) {
		logger.debug("Entering into remove Lead");
		final String trackingSql = "DELETE FROM LEAD WHERE LEAD_ID = ?";
		try {
			return jdbcTemplateObject.update(trackingSql, leadId);
		} catch (DataAccessException e) {
			logger.error("No Lead available in system coresponding to lead id: " + leadId);
			return 0;
		}

	}

}
