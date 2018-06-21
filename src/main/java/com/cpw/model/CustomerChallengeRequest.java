/**
 * 
 */
package com.cpw.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

/**
 * @author Unknown
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerChallengeRequest {
	private long id;
	private String code;
	private long customerId;
	private long contactId;
	@JsonSerialize(using = DateSerializer.class)
	private Date logDate;
	private int status;
	private long priority;
	private int origin;
	private int typeId;
	private String reason;
	@JsonSerialize(using = DateSerializer.class)
	private Date dueDate;
	private long inchargeId;
	private String ccEmail;
	private String subject;
	private String description;
	private String internalNote;
	private String customerFeedback;
	@JsonSerialize(using = DateSerializer.class)
	private Date closeDate;
	private String note;
	private long locId;
	private long fyId;
	private long time;// Database CREATED_TIME
	private int isDeleted;
	private long createdBy;
	@JsonSerialize(using = DateSerializer.class)
	private Date createdDate;
	private String createdTime;
	private long modifyBy;
	@JsonSerialize(using = DateSerializer.class)
	private Date modifyDate;
	private String modifyTime;

	@JsonCreator
	public CustomerChallengeRequest(@JsonProperty("id") long id, @JsonProperty("code") String code,
			@JsonProperty("customerId") long customerId, @JsonProperty("contactId") long contactId,
			@JsonProperty("logDate") Date logDate, @JsonProperty("status") int status,
			@JsonProperty("priority") long priority, @JsonProperty("origin") int origin,
			@JsonProperty("typeId") int typeId, @JsonProperty("reason") String reason,
			@JsonProperty("dueDate") Date dueDate, @JsonProperty("inchargeId") long inchargeId,
			@JsonProperty("ccEmail") String ccEmail, @JsonProperty("subject") String subject,
			@JsonProperty("description") String description, @JsonProperty("internalNote") String internalNote,
			@JsonProperty("customerFeedback") String customerFeedback, @JsonProperty("closeDate") Date closeDate,
			@JsonProperty("note") String note, @JsonProperty("locId") long locId, @JsonProperty("fyId") long fyId,
			@JsonProperty("time") long time, @JsonProperty("isDeleted") int isDeleted,
			@JsonProperty("createdBy") long createdBy, @JsonProperty("createdDate") Date createdDate,
			@JsonProperty("createdTime") String createdTime, @JsonProperty("modifyBy") long modifyBy,
			@JsonProperty("modifyDate") Date modifyDate, @JsonProperty("modifyTime") String modifyTime

	) {
		this.id = id;
		this.code = code;
		this.customerId = customerId;
		this.contactId = contactId;
		this.logDate = logDate;
		this.status = status;
		this.priority = priority;
		this.origin = origin;
		this.typeId = typeId;
		this.reason = reason;
		this.dueDate = dueDate;
		this.inchargeId = inchargeId;
		this.ccEmail = ccEmail;
		this.subject = subject;
		this.description = description;
		this.internalNote = internalNote;
		this.customerFeedback = customerFeedback;
		this.closeDate = closeDate;
		this.note = note;
		this.locId = locId;
		this.fyId = fyId;
		this.time = time;
		this.isDeleted = isDeleted;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.createdTime = createdTime;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
		this.modifyTime = modifyTime;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}

	public long getPriority() {
		return priority;
	}

	public void setPriority(long priority) {
		this.priority = priority;
	}

	public int getOrigin() {
		return origin;
	}

	public void setOrigin(int origin) {
		this.origin = origin;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public long getInchargeId() {
		return inchargeId;
	}

	public void setInchargeId(long inchargeId) {
		this.inchargeId = inchargeId;
	}

	public String getCcEmail() {
		return ccEmail;
	}

	public void setCcEmail(String ccEmail) {
		this.ccEmail = ccEmail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInternalNote() {
		return internalNote;
	}
	
	public void setInternalNote(String internalNote) {
		this.internalNote = internalNote;
	}

	public String getCustomerFeedback() {
		return customerFeedback;
	}

	public void setCustomerFeedback(String customerFeedback) {
		this.customerFeedback = customerFeedback;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public long getLocId() {
		return locId;
	}

	public void setLocId(long locId) {
		this.locId = locId;
	}

	public long getFyId() {
		return fyId;
	}

	public void setFyId(long fyId) {
		this.fyId = fyId;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
	
	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public long getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(long modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

}
