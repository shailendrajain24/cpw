package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.Contact;

public interface ContactDAO {

	public void setDataSource(DataSource ds);

	public int upsertContact(Contact contact);

	public List<Contact> contactList(String createdBy);
	
	public int removeContact(long contactId);
}
