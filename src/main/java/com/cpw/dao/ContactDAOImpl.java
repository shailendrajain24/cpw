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
				+ " EMAIL_OPT_OUT,CREATED_BY, SKYPE_ID,MODIFY_BY,CREATED_DATE,MODIFY_DATE,SECONDARY_EMAIL,LAST_ACTIVITY_TIME,TWITTER, "
				+ "MAILING_ADDRESS_STREET,MAILING_ADDRESS_CITY,MAILING_ADDRESS_STATE, MAILING_ADDRESS_ZIP, MAILING_ADDRESS_COUNTRY,"
				+ "OTHER_ADDRESS_STREET,OTHER_ADDRESS_CITY,OTHER_ADDRESS_STATE, OTHER_ADDRESS_ZIP, OTHER_ADDRESS_COUNTRY,"
				+ " DESCRIPTION" + " from  CONTACT  WHERE CREATED_BY = ?";
		try {
			List<Contact> contactList = jdbcTemplateObject.query(trackingSql, new Object[] { createdBy },
					new ContactMapper());
			return contactList;
		} catch (EmptyResultDataAccessException e) {
			logger.error("No contactList in system");
			return null;
		}
	}

	@Override
	public int upsertContact(Contact contactRequest) {
		logger.debug("Entering into contact DAO");
		CpwTemplete<Contact> cpwTemplete = new CpwTempleteImpl<Contact>();
		String q1 = "select * from contact where CONTACT_ID=?";
		Contact contactInSystem = null;
		try {
			contactInSystem = jdbcTemplateObject.queryForObject(q1, new Object[] { contactRequest.getContactId() },
					new ContactMapper());
		} catch (EmptyResultDataAccessException e) {
			contactInSystem = null;
		}
		try {
			int count = -1;
			if (contactInSystem != null && contactInSystem.getContactId() == contactRequest.getContactId()) {
				logger.debug("UPDATE values" + contactRequest.getContactId());
				String updateSql = "UPDATE CONTACT SET IMAGE=?, CONTACT_OWNER=?,LEAD_SOURCE=?, FIRST_NAME=?, LAST_NAME=?, TITLE=?,"
						+ " EMAIL=?,DEPARTMENT=?, PHONE=?,HOME_PHONE=?, FAX=?, MOBILE=?, DATE_OF_BIRTH=?, ASSISTANT=?,ASST_PHONE=?,REPORTS_TO,"
						+ " EMAIL_OPT_OUT=?, SKYPE_ID=?,MODIFY_BY=?,MODIFY_DATE=?,SECONDARY_EMAIL=?,LAST_ACTIVITY_TIME=?,TWITTER=?,"
						+ "MAILING_ADDRESS_STREET=?, MAILING_ADDRESS_CITY=?, MAILING_ADDRESS_STATE=?, MAILING_ADDRESS_ZIP=?, MAILING_ADDRESS_COUNTRY=?,"
						+ "OTHER_ADDRESS_STREET=?, OTHER_ADDRESS_CITY=?, OTHER_ADDRESS_STATE=?, OTHER_ADDRESS_ZIP=?, OTHER_ADDRESS_COUNTRY=?,"
						+ " DESCRIPTION=?," + " WHERE CONTACT_ID=?";
				return jdbcTemplateObject.update(updateSql,
						contactRequest.getImage() == null ? contactInSystem.getImage() : contactRequest.getImage(),
						contactRequest.getContactOwner() == null ? contactInSystem.getContactOwner()
								: contactRequest.getContactOwner(),
						contactRequest.getLeadSource() == null ? contactInSystem.getLeadSource()
								: contactRequest.getLeadSource(),
						contactRequest.getFirstName() == null ? contactInSystem.getFirstName()
								: contactRequest.getFirstName(),
						contactRequest.getLastName() == null ? contactInSystem.getLastName()
								: contactRequest.getLastName(),
						contactRequest.getTitle() == null ? contactInSystem.getTitle() : contactRequest.getTitle(),
						contactRequest.getEmail() == null ? contactInSystem.getEmail() : contactRequest.getEmail(),
						contactRequest.getDepartment() == null ? contactInSystem.getDepartment()
								: contactRequest.getDepartment(),
						contactRequest.getPhone() == null ? contactInSystem.getPhone() : contactRequest.getPhone(),
						contactRequest.getHomePhone() == null ? contactInSystem.getHomePhone()
								: contactRequest.getHomePhone(),
						contactRequest.getFax() == null ? contactInSystem.getFax() : contactRequest.getFax(),
						contactRequest.getMobile() == null ? contactInSystem.getMobile() : contactRequest.getMobile(),
						contactRequest.getDateOfBirth() == null ? contactInSystem.getDateOfBirth()
								: contactRequest.getDateOfBirth(),
						contactRequest.getAssistant() == null ? contactInSystem.getAssistant()
								: contactRequest.getAssistant(),
						contactRequest.getAsstPhone() == null ? contactInSystem.getAsstPhone()
								: contactRequest.getAsstPhone(),
						contactRequest.getReportsTo() == null ? contactInSystem.getReportsTo()
								: contactRequest.getReportsTo(),
						contactRequest.isEmailOptOut() == false ? contactInSystem.isEmailOptOut()
								: contactRequest.isEmailOptOut(),
						contactRequest.getSkypeId() == null ? contactInSystem.getSkypeId()
								: contactRequest.getSkypeId(),
						contactRequest.getModifyBy() == null ? contactInSystem.getModifyBy()
								: contactRequest.getModifyBy(),
						contactRequest.getModifyDate() == 0 ? contactInSystem.getModifyDate()
								: contactRequest.getModifyDate(),
						contactRequest.getSecondaryEmail() == null ? contactInSystem.getSecondaryEmail()
								: contactRequest.getSecondaryEmail(),
						contactRequest.getLastActivityTime() == null ? contactInSystem.getLastActivityTime()
								: contactRequest.getLastActivityTime(),
						contactRequest.getTwitter() == null ? contactInSystem.getTwitter()
								: contactRequest.getTwitter(),
						contactRequest.getMailingAddressStreet() == null ? contactInSystem.getMailingAddressStreet()
								: contactRequest.getMailingAddressStreet(),
						contactRequest.getMailingAddressCity() == null ? contactInSystem.getMailingAddressCity()
								: contactRequest.getMailingAddressCity(),
						contactRequest.getMailingAddressState() == null ? contactInSystem.getMailingAddressState()
								: contactRequest.getMailingAddressState(),
						contactRequest.getMailingAddressZip() == null ? contactInSystem.getMailingAddressZip()
								: contactRequest.getMailingAddressZip(),
						contactRequest.getMailingAddressCountry() == null ? contactInSystem.getMailingAddressCountry()
								: contactRequest.getMailingAddressCountry(),
						contactRequest.getOtherAddressStreet() == null ? contactInSystem.getOtherAddressStreet()
								: contactRequest.getOtherAddressStreet(),
						contactRequest.getOtherAddressCity() == null ? contactInSystem.getOtherAddressCity()
								: contactRequest.getOtherAddressCity(),
						contactRequest.getOtherAddressState() == null ? contactInSystem.getOtherAddressState()
								: contactRequest.getOtherAddressState(),
						contactRequest.getOtherAddressZip() == null ? contactInSystem.getOtherAddressZip()
								: contactRequest.getOtherAddressZip(),
						contactRequest.getOtherAddressCountry() == null ? contactInSystem.getOtherAddressCountry()
								: contactRequest.getOtherAddressCountry(),
						contactRequest.getDescription() == null ? contactInSystem.getDescription()
								: contactRequest.getDescription(),
						contactRequest.getContactId());
			} else {
				Object[] values = new Object[39];
				values[0] = contactRequest.getImage();
				values[1] = contactRequest.getContactId();
				values[2] = contactRequest.getContactOwner();
				values[3] = contactRequest.getLeadSource();
				values[4] = contactRequest.getFirstName();
				values[5] = contactRequest.getLastName();
				values[6] = contactRequest.getAccountName();
				values[7] = contactRequest.getEmail();
				values[8] = contactRequest.getTitle();
				values[9] = contactRequest.getDepartment();
				values[10] = contactRequest.getPhone();
				values[11] = contactRequest.getHomePhone();
				values[12] = contactRequest.getOtherPhone();
				values[13] = contactRequest.getFax();
				values[14] = contactRequest.getMobile();
				values[15] = contactRequest.getDateOfBirth();
				values[16] = contactRequest.getAssistant();
				values[17] = contactRequest.getAsstPhone();
				values[18] = contactRequest.getReportsTo();
				values[19] = contactRequest.isEmailOptOut();
				values[20] = contactRequest.getCreatedBy();
				values[21] = contactRequest.getCreatedDate();
				values[22] = contactRequest.getModifyBy();
				values[23] = contactRequest.getModifyDate();
				values[24] = contactRequest.getSkypeId();
				values[25] = contactRequest.getSecondaryEmail();
				values[26] = contactRequest.getLastActivityTime();
				values[27] = contactRequest.getTwitter();
				values[28] = contactRequest.getMailingAddressStreet();
				values[29] = contactRequest.getMailingAddressCity();
				values[30] = contactRequest.getMailingAddressState();
				values[31] = contactRequest.getMailingAddressZip();
				values[32] = contactRequest.getMailingAddressCountry();
				values[33] = contactRequest.getOtherAddressStreet();
				values[34] = contactRequest.getOtherAddressCity();
				values[35] = contactRequest.getOtherAddressState();
				values[36] = contactRequest.getOtherAddressZip();
				values[37] = contactRequest.getOtherAddressCountry();
				values[38] = contactRequest.getDescription();

				logger.debug("INSERT values" + values[1]);
				String insertSql = "INSERT INTO CONTACT (IMAGE, CONTACT_ID, CONTACT_OWNER,LEAD_SOURCE,FIRST_NAME, LAST_NAME,ACCOUNT_NAME,EMAIL, TITLE,"
						+ "DEPARTMENT,PHONE,HOME_PHONE,OTHER_PHONE,FAX,MOBILE,DATE_OF_BIRTH,ASSISTANT,ASST_PHONE,REPORTS_TO,"
						+ "EMAIL_OPT_OUT,CREATED_BY,CREATED_DATE,MODIFY_BY,MODIFY_DATE,SKYPE_ID,SECONDARY_EMAIL,LAST_ACTIVITY_TIME,TWITTER,"
						+ "MAILING_ADDRESS_STREET,MAILING_ADDRESS_CITY,MAILING_ADDRESS_STATE,MAILING_ADDRESS_ZIP,MAILING_ADDRESS_COUNTRY,"
						+ "OTHER_ADDRESS_STREET,OTHER_ADDRESS_CITY,OTHER_ADDRESS_STATE,OTHER_ADDRESS_ZIP,OTHER_ADDRESS_COUNTRY,"
						+ "DESCRIPTION)"
						+ "VALUES (?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?,?,?,?,?);";
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
