package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.Contact;

public class ContactMapper implements RowMapper<Contact> {

	public Contact mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final Contact contact = new Contact();
		contact.setImage(resultSet.getBlob("IMAGE"));
		contact.setContactId(resultSet.getLong("CONTACT_ID"));
		contact.setContactOwner(resultSet.getString("CONTACT_OWNER"));
		contact.setLeadSource(resultSet.getString("LEAD_SOURCE"));
		contact.setFirstName(resultSet.getString("FIRST_NAME"));
		contact.setLastName(resultSet.getString("LAST_NAME"));
		contact.setAccountName(resultSet.getString("ACCOUNT_NAME"));
		contact.setEmail(resultSet.getString("EMAIL"));
		contact.setTitle(resultSet.getString("TITLE"));
		contact.setDepartment(resultSet.getString("DEPARTMENT"));
		contact.setPhone(resultSet.getString("PHONE"));
		contact.setHomePhone(resultSet.getString("HOME_PHONE"));
		contact.setOtherPhone(resultSet.getString("OTHER_PHONE"));
	    contact.setFax(resultSet.getString("FAX"));
		contact.setMobile(resultSet.getString("MOBILE"));
		contact.setDateOfBirth(resultSet.getString("DATE_OF_BIRTH"));
		contact.setAssistant(resultSet.getString("ASSISTANT"));
		contact.setAsstPhone(resultSet.getString("ASST_PHONE"));
		contact.setReportsTo(resultSet.getString("REPORTS_TO"));
		contact.setEmailOptOut(resultSet.getBoolean("EMAIL_OPT_OUT"));
		contact.setCreatedBy(resultSet.getString("CREATED_BY"));
		contact.setCreatedDate(resultSet.getLong("CREATED_DATE"));
		contact.setModifyBy(resultSet.getString("MODIFY_BY"));
		contact.setModifyDate(resultSet.getLong("MODIFY_DATE"));
		contact.setSkypeId(resultSet.getString("SKYPE_ID"));
		contact.setSecondaryEmail(resultSet.getString("SECONDARY_EMAIL"));
		contact.setLastActivityTime(resultSet.getString("LAST_ACTIVITY_TIME"));
		contact.setTwitter(resultSet.getString("TWITTER"));
		contact.setMailingAddressStreet(resultSet.getString("MAILING_ADDRESS_STREET"));
		contact.setMailingAddressCity(resultSet.getString("MAILING_ADDRESS_CITY"));
		contact.setMailingAddressState(resultSet.getString("MAILING_ADDRESS_STATE"));
		contact.setMailingAddressZip(resultSet.getString("MAILING_ADDRESS_ZIP"));
		contact.setMailingAddressCountry(resultSet.getString("MAILING_ADDRESS_COUNTRY"));
		contact.setOtherAddressStreet(resultSet.getString("OTHER_ADDRESS_STREET"));
		contact.setOtherAddressCity(resultSet.getString("OTHER_ADDRESS_CITY"));
		contact.setOtherAddressState(resultSet.getString("OTHER_ADDRESS_STATE"));
		contact.setOtherAddressZip(resultSet.getString("OTHER_ADDRESS_ZIP"));
		contact.setOtherAddressCountry(resultSet.getString("OTHER_ADDRESS_COUNTRY"));
		contact.setDescription(resultSet.getString("DESCRIPTION"));
		contact.setAccountId(resultSet.getLong("PARENT_ID"));
		contact.setSalutation(resultSet.getString("SALUTATION"));
		
		return contact;
	}

}
