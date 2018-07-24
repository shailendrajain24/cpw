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
	public List<Lead> leadList(long createdBy) {
		logger.debug("Entering into leadList " + createdBy);
		final String trackingSql = "Select IMAGE, LEAD_ID, LEAD_OWNER, COMPANY, FNAME, LNAME, TITLE, EMAIL, PHONE, FAX, MOBILE, WEBSITE, "
				+ "LEAD_SOURCE, LEAD_STATUS, INDUSTRY, NO_OF_EMP, ANNUAL_REVENUE, RATING, EMAIL_OUTPUT, SKYPE_ID, ADDRESS_STREET, ADDRESS_CITY, "
				+ "ADDRESS_STATE, ADDRESS_ZIPCODE, ADDRESS_COUNTRY, DESCRIPTION, CR_DATE, MD_DATE, CR_BY"
				+ " from  LEAD  WHERE LEAD_ID = ?";
		try {
			List<Lead> leadList = jdbcTemplateObject.query(trackingSql, new Object[] { createdBy }, new LeadMapper());
			return leadList;
		} catch (EmptyResultDataAccessException e) {
			logger.error("No leadList in system");
			return null;
		}
	}

	@Override
	public int upsertLead(Lead leadRequest) {
		logger.debug("Entering into lead DAO");
		CpwTemplete<Lead> cpwTemplete = new CpwTempleteImpl<Lead>();
		String q1 = "select * from lead where lead_id=?";
		Lead leadInSystem = null;
		try {
			leadInSystem = jdbcTemplateObject.queryForObject(q1, new Object[] { leadRequest.getLeadId() },
					new LeadMapper());
		} catch (EmptyResultDataAccessException e) {
			leadInSystem = null;
		}
		try {
			int count = -1;
			if (leadInSystem != null && leadInSystem.getLeadId() == leadRequest.getLeadId()) {
				logger.debug("UPDATE values" + leadRequest.getLeadId());
				String updateSql = "UPDATE LEAD SET IMAGE=?, LEAD_OWNER=?, COMPANY=?, FNAME=?, LNAME=?, TITLE=?,"
						+ " EMAIL=?, PHONE=?, FAX=?, MOBILE=?, WEBSITE=?, LEAD_SOURCE=?, LEAD_STATUS=?, INDUSTRY=?, NO_OF_EMP=?"
						+ ", ANNUAL_REVENUE=?, RATING=?, EMAIL_OUTPUT=?, SKYPE_ID=?, ADDRESS_STREET=?, ADDRESS_CITY=?,"
						+ " ADDRESS_STATE=?, ADDRESS_ZIPCODE=?, ADDRESS_COUNTRY=?, DESCRIPTION=?, MD_DATE=?"
						+ " WHERE LEAD_ID=?";
				return jdbcTemplateObject.update(updateSql,
						leadRequest.getUploadedInputStream() == null ? leadInSystem.getUploadedInputStream()
								: leadRequest.getUploadedInputStream(),
						leadRequest.getLeadOwner() == null ? leadInSystem.getLeadOwner() : leadRequest.getLeadOwner(),
						leadRequest.getCompany() == null ? leadInSystem.getCompany() : leadRequest.getCompany(),
						leadRequest.getFirstName() == null ? leadInSystem.getFirstName() : leadRequest.getFirstName(),
						leadRequest.getLastName() == null ? leadInSystem.getLastName() : leadRequest.getLastName(),
						leadRequest.getTitle() == null ? leadInSystem.getTitle() : leadRequest.getTitle(),
						leadRequest.getEmail() == null ? leadInSystem.getEmail() : leadRequest.getEmail(),
						leadRequest.getPhone() == null ? leadInSystem.getPhone() : leadRequest.getPhone(),
						leadRequest.getFax() == null ? leadInSystem.getFax() : leadRequest.getFax(),
						leadRequest.getMobile() == null ? leadInSystem.getMobile() : leadRequest.getMobile(),
						leadRequest.getWebsite() == null ? leadInSystem.getWebsite() : leadRequest.getWebsite(),
						leadRequest.getLeadSource() == null ? leadInSystem.getLeadSource()
								: leadRequest.getLeadSource(),
						leadRequest.getLeadStatus() == null ? leadInSystem.getLeadStatus()
								: leadRequest.getLeadStatus(),
						leadRequest.getIndustry() == null ? leadInSystem.getIndustry() : leadRequest.getIndustry(),
						leadRequest.getNoOfEmployees() == 0 ? leadInSystem.getNoOfEmployees()
								: leadRequest.getNoOfEmployees(),
						leadRequest.getAnnualRevenue() == null ? leadInSystem.getAnnualRevenue()
								: leadRequest.getAnnualRevenue(),
						leadRequest.getRating() == null ? leadInSystem.getRating() : leadRequest.getRating(),
						leadRequest.isEmailOptOut() == false ? leadInSystem.isEmailOptOut()
								: leadRequest.isEmailOptOut(),
						leadRequest.getSkypeId() == null ? leadInSystem.getSkypeId() : leadRequest.getSkypeId(),
						leadRequest.getAddressStreet() == null ? leadInSystem.getAddressStreet()
								: leadRequest.getAddressStreet(),
						leadRequest.getAddressCity() == null ? leadInSystem.getAddressCity()
								: leadRequest.getAddressCity(),
						leadRequest.getAddressState() == null ? leadInSystem.getAddressState()
								: leadRequest.getAddressState(),
						leadRequest.getAddressZipCode() == null ? leadInSystem.getAddressZipCode()
								: leadRequest.getAddressZipCode(),
						leadRequest.getAddressCounty() == null ? leadInSystem.getAddressCounty()
								: leadRequest.getAddressCounty(),
						leadRequest.getDescription() == null ? leadInSystem.getDescription()
								: leadRequest.getDescription(),
						leadRequest.getModifyDate() == null ? leadInSystem.getModifyDate()
								: leadRequest.getModifyDate(),
						leadRequest.getLeadId());
			} else {
				Object[] values = new Object[29];
				values[0] = leadRequest.getUploadedInputStream();
				values[1] = leadRequest.getLeadId();
				values[2] = leadRequest.getLeadOwner();
				values[3] = leadRequest.getCompany();
				values[4] = leadRequest.getFirstName();
				values[5] = leadRequest.getLastName();
				values[6] = leadRequest.getTitle();
				values[7] = leadRequest.getEmail();
				values[8] = leadRequest.getPhone();
				values[9] = leadRequest.getFax();
				values[10] = leadRequest.getMobile();
				values[11] = leadRequest.getWebsite();
				values[12] = leadRequest.getLeadSource();
				values[13] = leadRequest.getLeadStatus();
				values[14] = leadRequest.getIndustry();
				values[15] = leadRequest.getNoOfEmployees();
				values[16] = leadRequest.getAnnualRevenue();
				values[17] = leadRequest.getRating();
				values[18] = leadRequest.isEmailOptOut();
				values[19] = leadRequest.getSkypeId();
				values[20] = leadRequest.getAddressStreet();
				values[21] = leadRequest.getAddressCity();
				values[22] = leadRequest.getAddressState();
				values[23] = leadRequest.getAddressZipCode();
				values[24] = leadRequest.getAddressCounty();
				values[25] = leadRequest.getDescription();
				values[26] = leadRequest.getCreateDate();
				values[27] = leadRequest.getModifyDate();
				values[28] = leadRequest.getCreatedBy();
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
