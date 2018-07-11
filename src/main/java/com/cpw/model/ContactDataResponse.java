/**
 * 
 */
package com.cpw.model;


import java.sql.Blob;


/**
 * @author Unknown
 *
 */
public class ContactDataResponse {
	private Blob image;
	
	private long contactId;
	private String contactOwner;
	private String leadSource;
	private String firstName;
	private String lastName;
	private String accountName;
	private String email;
	private String title;
	private String department;
	private String phone;
	private String homePhone;
	private String otherPhone;
	private String fax;
	private String mobile;
	private String dateOfBirth;
	private String assistant;
	private String asstPhone;
	private String reportsTo;
	private boolean emailOptOut;
	private String createdBy;
	private long createdDate;
	private String modifyBy;
	private long modifyDate;
	private String skypeId;
	private String secondaryEmail;
	private String lastActivityTime;
	private String twitter;
	private String mailingAddressStreet;
	private String mailingAddressCity;
	private String mailingAddressState;
	private String mailingAddressZip;
	private String mailingAddressCounty;
	private String otherAddressStreet;
	private String otherAddressCity;
	private String otherAddressState;
	private String otherAddressZip;
	private String otherAddressCounty;
	private String description;
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	public long getContactId() {
		return contactId;
	}
	public void setContactId(long contactId) {
		this.contactId = contactId;
	}
	public String getContactOwner() {
		return contactOwner;
	}
	public void setContactOwner(String contactOwner) {
		this.contactOwner = contactOwner;
	}
	public String getLeadSource() {
		return leadSource;
	}
	public void setLeadSource(String leadSource) {
		this.leadSource = leadSource;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getOtherPhone() {
		return otherPhone;
	}
	public void setOtherPhone(String otherPhone) {
		this.otherPhone = otherPhone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAssistant() {
		return assistant;
	}
	public void setAssistant(String assistant) {
		this.assistant = assistant;
	}
	public String getAsstPhone() {
		return asstPhone;
	}
	public void setAsstPhone(String asstPhone) {
		this.asstPhone = asstPhone;
	}
	public String getReportsTo() {
		return reportsTo;
	}
	public void setReportsTo(String reportsTo) {
		this.reportsTo = reportsTo;
	}
	public boolean isEmailOptOut() {
		return emailOptOut;
	}
	public void setEmailOptOut(boolean emailOptOut) {
		this.emailOptOut = emailOptOut;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public long getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(long createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}
	public long getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(long modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getSkypeId() {
		return skypeId;
	}
	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}
	public String getSecondaryEmail() {
		return secondaryEmail;
	}
	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}
	public String getLastActivityTime() {
		return lastActivityTime;
	}
	public void setLastActivityTime(String lastActivityTime) {
		this.lastActivityTime = lastActivityTime;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getMailingAddressStreet() {
		return mailingAddressStreet;
	}
	public void setMailingAddressStreet(String mailingAddressStreet) {
		this.mailingAddressStreet = mailingAddressStreet;
	}
	public String getMailingAddressCity() {
		return mailingAddressCity;
	}
	public void setMailingAddressCity(String mailingAddressCity) {
		this.mailingAddressCity = mailingAddressCity;
	}
	public String getMailingAddressState() {
		return mailingAddressState;
	}
	public void setMailingAddressState(String mailingAddressState) {
		this.mailingAddressState = mailingAddressState;
	}
	public String getMailingAddressZip() {
		return mailingAddressZip;
	}
	public void setMailingAddressZip(String mailingAddressZip) {
		this.mailingAddressZip = mailingAddressZip;
	}
	public String getMailingAddressCounty() {
		return mailingAddressCounty;
	}
	public void setMailingAddressCounty(String mailingAddressCounty) {
		this.mailingAddressCounty = mailingAddressCounty;
	}
	public String getOtherAddressStreet() {
		return otherAddressStreet;
	}
	public void setOtherAddressStreet(String otherAddressStreet) {
		this.otherAddressStreet = otherAddressStreet;
	}
	public String getOtherAddressCity() {
		return otherAddressCity;
	}
	public void setOtherAddressCity(String otherAddressCity) {
		this.otherAddressCity = otherAddressCity;
	}
	public String getOtherAddressState() {
		return otherAddressState;
	}
	public void setOtherAddressState(String otherAddressState) {
		this.otherAddressState = otherAddressState;
	}
	public String getOtherAddressZip() {
		return otherAddressZip;
	}
	public void setOtherAddressZip(String otherAddressZip) {
		this.otherAddressZip = otherAddressZip;
	}
	public String getOtherAddressCounty() {
		return otherAddressCounty;
	}
	public void setOtherAddressCounty(String otherAddressCounty) {
		this.otherAddressCounty = otherAddressCounty;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
