package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.ContactMapper;
import com.cpw.jdbc.model.Contact;

public class ContactDAOImpl implements ContactDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Contact> contactList(String createdBy) {
		logger.debug("Entering into contactList " + createdBy);
		final String trackingSql = "Select IMAGE, CONTACT_ID, CONTACT_OWNER, LEAD_SOURCE, FIRST_NAME, LAST_NAME, ACCOUNT_NAME, EMAIL,TITLE,DEPARTMENT, PHONE,HOME_PHONE,OTHER_PHONE, FAX, MOBILE, DATE_OF_BIRTH,ASSISTANT,ASST_PHONE,REPORTS_TO, "
				+ " EMAIL_OPT_OUT,CREATED_BY, SKYPE_ID,MODIFY_BY,CREATED_DATE,MODIFY_DATE,SECONDARY_EMAIL,LAST_ACTVITY_TIME,TWITTER, "
				+ "MAILING_ADDRESS_STREET,MAILING_ADDRESS_CITY,MAILING_ADDRESS_STATE, MAILING_ADDRESS_ZIP, MAILING_ADDRESS_COUNTRY,"
				+ "OTHER_ADDRESS_STREET,OTHER_ADDRESS_CITY,OTHER_ADDRESS_STATE, OTHER_ADDRESS_ZIP, OTHER_ADDRESS_COUNTRY,"
				+ " DESCRIPTION"
				+ " from  CONTACT  WHERE CREATED_BY = ?";
		try {
			List<Contact> contactList = jdbcTemplateObject.query(trackingSql, new Object[] { createdBy }, new ContactMapper());
			return contactList;
		} catch (EmptyResultDataAccessException e) {
			logger.error("No contactList in system");
			return null;
		}
	}

	@Override
	public int upsertContact(Contact contact) {
		logger.debug("Entering into contact DAO");
		CpwTemplete<Contact> cpwTemplete = new CpwTempleteImpl<Contact>();
		/*
		 * String sql = "MERGE INTO CONTACT AS L USING (" +
		 * "SELECT ? IMAGE, ? CONTACT_ID, ? CONTACT_OWNER, ? COMPANY, ? FNAME, ? LNAME, ? TITLE, ? EMAIL, ? PHONE, ? FAX, ? MOBILE, "
		 * +
		 * "? WEBSITE, ? CONTACT_SOURCE, ? CONTACT_STATUS, ? INDUSTRY, ? NO_OF_EMP, ? ANNUAL_REVENUE, ? RATING, ? EMAIL_OUTPUT, ? SKYPE_ID, "
		 * +
		 * "? ADDRESS_STREET, ? ADDRESS_CITY, ? ADDRESS_STATE, ? ADDRESS_ZIPCODE, ? ADDRESS_COUNTRY, ? DESCRIPTION, ? CR_DATE, "
		 * + "? MD_DATE, ? CR_BY FROM DUAL ) AS E ON L.CONTACT_ID = E.CONTACT_ID " +
		 * "WHEN MATCHED THEN " +
		 * "UPDATE SET L.IMAGE = E.IMAGE , L.CONTACT_OWNER = E.CONTACT_OWNER , L.COMPANY = E.COMPANY , L.FNAME = E.FNAME , "
		 * +
		 * "L.LNAME = E.LNAME , L.TITLE = E.TITLE , L.EMAIL = E.EMAIL , L.PHONE = E.PHONE , L.FAX = E.FAX , L.MOBILE = E.MOBILE , "
		 * +
		 * "L.WEBSITE = E.WEBSITE , L.CONTACT_SOURCE = E.CONTACT_SOURCE , L.CONTACT_STATUS = E.CONTACT_STATUS , L.INDUSTRY = E.INDUSTRY , "
		 * +
		 * "L.NO_OF_EMP = E.NO_OF_EMP , L.ANNUAL_REVENUE = E.ANNUAL_REVENUE , L.RATING = E.RATING , L.EMAIL_OUTPUT = E.EMAIL_OUTPUT , "
		 * +
		 * "L.SKYPE_ID = E.SKYPE_ID , L.ADDRESS_STREET = E.ADDRESS_STREET , L.ADDRESS_CITY = E.ADDRESS_CITY , L.ADDRESS_STATE = E.ADDRESS_STATE , "
		 * +
		 * "L.ADDRESS_ZIPCODE = E.ADDRESS_ZIPCODE , L.ADDRESS_COUNTRY = E.ADDRESS_COUNTRY , L.DESCRIPTION = E.DESCRIPTION, L.CR_DATE = E.CR_DATE, "
		 * + "L.MD_DATE= E.MD_DATE, L.CR_BY= E.CR_BY " + "WHEN NOT MATCHED THEN " +
		 * "INSERT (IMAGE, CONTACT_ID, CONTACT_OWNER, COMPANY, FNAME, LNAME, TITLE, EMAIL, PHONE, FAX, MOBILE, WEBSITE, CONTACT_SOURCE, CONTACT_STATUS, "
		 * +
		 * "INDUSTRY, NO_OF_EMP, ANNUAL_REVENUE, RATING, EMAIL_OUTPUT, SKYPE_ID, ADDRESS_STREET, ADDRESS_CITY, ADDRESS_STATE, ADDRESS_ZIPCODE, "
		 * + "ADDRESS_COUNTRY, DESCRIPTION, CR_DATE, MD_DATE, CR_BY)" +
		 * "VALUES (E.IMAGE, E.CONTACT_ID, E.CONTACT_OWNER, E.COMPANY, E.FNAME, E.LNAME, E.TITLE, E.EMAIL, E.PHONE, E.FAX, E.MOBILE, E.WEBSITE, E.CONTACT_SOURCE, "
		 * +
		 * "E.CONTACT_STATUS, E.INDUSTRY, E.NO_OF_EMP, E.ANNUAL_REVENUE, E.RATING, E.EMAIL_OUTPUT, E.SKYPE_ID, E.ADDRESS_STREET, E.ADDRESS_CITY, "
		 * +
		 * "E.ADDRESS_STATE, E.ADDRESS_ZIPCODE, E.ADDRESS_COUNTRY, E.DESCRIPTION, E.CR_DATE, E.MD_DATE, E.CR_BY);"
		 * ;
		 */
		String q1 = "select * from contact where CONTACT_ID=?";
		Contact l = null;
		try {
			l = jdbcTemplateObject.queryForObject(q1, new Object[] { contact.getContactId() }, new ContactMapper());
		} catch (EmptyResultDataAccessException e) {
			l = null;
		}
		try {
			int count = -1;
			if (l != null && l.getContactId() == contact.getContactId()) {
				
				
				
				
				logger.debug("UPDATE values" + contact.getContactId());
				String updateSql = "UPDATE CONTACT SET IMAGE=?, CONTACT_OWNER=?,LEAD_SOURCE=?, FIRST_NAME=?, LAST_NAME=?, TITLE=?,"
						+ " EMAIL=?,DEPARTMENT=?, PHONE=?,HOME_PHONE=?, FAX=?, MOBILE=?, DATE_OF_BIRTH=?, ASSISTANT=?,ASST_PHONE=?,REPORTS_TO,"
						+ " EMAIL_OPT_OUT=?, SKYPE_ID=?,MODIFY_BY=?,MODIFY_DATE=?,SECONDARY_EMAIL=?,LAST_ACTIVITY_TIME=?,TWITTER=?,"
						+ "MAILING_ADDRESS_STREET=?, MAILING_ADDRESS_CITY=?, MAILING_ADDRESS_STATE=?, MAILING_ADDRESS_ZIP=?, MAILING_ADDRESS_COUNTRY=?,"
						+ "OTHER_ADDRESS_STREET=?, OTHER_ADDRESS_CITY=?, OTHER_ADDRESS_STATE=?, OTHER_ADDRESS_ZIP=?, OTHER_ADDRESS_COUNTRY=?,"
						+ " DESCRIPTION=?,"
						+ " WHERE CONTACT_ID=?";
				return jdbcTemplateObject.update(updateSql, contact.getImage(),
						contact.getContactOwner(),contact.getLeadSource(),contact.getFirstName(),
						contact.getLastName(),contact.getTitle(),contact.getEmail(),contact.getDepartment(),
						contact.getPhone(),contact.getHomePhone(),contact.getFax(),contact.getMobile(),
						contact.getDateOfBirth(),contact.getAssistant(),contact.getAsstPhone(),
						contact.getReportsTo(),contact.isEmailOptOut(),
						contact.isEmailOptOut(),contact.getSkypeId(),contact.getModifyBy(),contact.getModifyDate(),contact.getSecondaryEmail(),contact.getLastActivityTime(),contact.getTwitter(),
						contact.getMailingAddressStreet(),contact.getMailingAddressCity(),contact.getMailingAddressState(),contact.getMailingAddressZip(),contact.getMailingAddressCounty(),
						contact.getOtherAddressStreet(),contact.getOtherAddressCity(),contact.getOtherAddressState(),contact.getOtherAddressZip(),contact.getOtherAddressCounty(),
						contact.getDescription(),
						contact.getContactId());
			} else {
				Object[] values = new Object[39];
				values[0] = contact.getImage();
				values[1] = contact.getContactId();
				values[2] = contact.getContactOwner();
				values[3] = contact.getLeadSource();
				values[4] = contact.getFirstName();
				values[5] = contact.getLastName();
				values[6]=contact.getAccountName();
				values[7] = contact.getEmail();
				values[8] = contact.getTitle();
				values[9]=contact.getDepartment();
			    values[10] = contact.getPhone();
				values[11] = contact.getHomePhone();
				values[12] = contact.getOtherPhone();
				values[13] = contact.getFax();
				values[14] = contact.getMobile();
				values[15] = contact.getDateOfBirth();
				values[16] = contact.getAssistant();
				values[17] = contact.getAsstPhone();
				values[18] = contact.getReportsTo();
				values[19] = contact.isEmailOptOut();
				values[20] = contact.getCreatedBy();
				values[21] = contact.getCreatedDate();
				values[22] = contact.getModifyBy();
				values[23] = contact.getModifyDate();
				values[24] = contact.getSkypeId();
				values[25] = contact.getSecondaryEmail();
				values[26] = contact.getLastActivityTime();
				values[27] = contact.getTwitter();
				values[28] = contact.getMailingAddressStreet();
				values[29] = contact.getMailingAddressCity();
				values[30] = contact.getMailingAddressState();
				values[31] = contact.getMailingAddressZip();
				values[32] = contact.getMailingAddressCounty();
				values[33] = contact.getOtherAddressStreet();
				values[34] = contact.getOtherAddressCity();
				values[35] = contact.getOtherAddressState();
				values[36] = contact.getOtherAddressZip();
				values[37] = contact.getOtherAddressCounty();
				values[38] = contact.getDescription();
				
								
				logger.debug("INSERT values" + values[1]);
				String insertSql = "INSERT INTO CONTACT (IMAGE, CONTACT_ID, CONTACT_OWNER,LEAD_SOURCE,  FIRST_NAME, LAST_NAME,ACCOUNT_NAME,EMAIL, TITLE,"
						+ " DEPARTMENT, PHONE,HOME_PHONE,OTHER_PHONE, FAX, MOBILE, DATE_OF_BIRTH,ASSISTANT,ASST_PHONE,REPORTS_TO,"
						+ "  EMAIL_OPT_OUT,CREATED_BY,CREATED_DATE,MODIFY_BY,MODIFY_DATE, SKYPE_ID,SECONDARY_EMAIL,LAST_ACTIVITY_TIME,TWITTER,"
						+ " MAILING_ADDRESS_STREET, MAILING_ADDRESS_CITY, MAILING_ADDRESS_STATE, MAILING_ADDRESS_ZIP, MAILING_ADDRESS_COUNTRY,"
						+ " OTHER_ADDRESS_STREET, OTHER_ADDRESS_CITY, OTHER_ADDRESS_STATE, OTHER_ADDRESS_ZIP, OTHER_ADDRESS_COUNTRY,"
						+ " DESCRIPTION)"
						+ "VALUES (?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?,?,?,?);";
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
	public int removeContact(long contactId) {
		logger.debug("Entering into remove Contact");
		final String trackingSql = "DELETE FROM CONTACT WHERE CONTACT_ID = ?";
		try {
			return jdbcTemplateObject.update(trackingSql, contactId);
		} catch (DataAccessException e) {
			logger.error("No Contact available in system coresponding to contact id: " + contactId);
			return 0;
		}

	}

}
