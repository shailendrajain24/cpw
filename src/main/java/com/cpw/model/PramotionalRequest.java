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
public class PramotionalRequest {
	private long primaryId;
	private String fromEmailId;
	private String ToEmailId;
	private int commercialNvo;
	private int sendBy;
	private String subject;
	private int countryId;
	private int categoryId;
	private String attachment;
	private String addAttachment;
	private String body;
	private long locId;
	private long fyId;
	private long fyPrdId;
	private long createdBy;
	@JsonSerialize(using=DateSerializer.class)
	private Date createdDate;
	private String createdTime;
	private long modifyBy;
	@JsonSerialize(using=DateSerializer.class)
	private Date modifyDate;
	private String modifyTime;
	@JsonCreator
	 public PramotionalRequest(@JsonProperty("primaryId") long primaryId, @JsonProperty("fromEmailId") String fromEmailId
			 , @JsonProperty("toEmailId") String ToEmailId, @JsonProperty("commercialNvo") int commercialNvo
			 , @JsonProperty("sendBy") int sendBy, @JsonProperty("subject") String subject
			 , @JsonProperty("countryId") int countryId, @JsonProperty("categoryId") int categoryId
			 , @JsonProperty("attachment") String attachment, @JsonProperty("addAttachment") String addAttachment
			 , @JsonProperty("body") String body, @JsonProperty("locId") long locId
			 , @JsonProperty("fyId") long fyId, @JsonProperty("fyPrdId") long fyPrdId
			 , @JsonProperty("createdBy") long createdBy, @JsonProperty("createdDate") Date createdDate
			 , @JsonProperty("createdTime") String createdTime, @JsonProperty("modifyBy") long modifyBy
			 , @JsonProperty("modifyDate") Date modifyDate, @JsonProperty("modifyTime") String modifyTime) {
	  this.primaryId = primaryId;
	  this.fromEmailId = fromEmailId;
	  this.ToEmailId = ToEmailId;
	  this.commercialNvo = commercialNvo;
	  this.sendBy = sendBy;
	  this.subject = subject;
	  this.countryId = countryId;
	  this.categoryId = categoryId;
	  
	  this.attachment = attachment;
	  this.addAttachment = addAttachment;
	  this.body = body;
	  this.locId = locId;
	  this.fyId = fyId;
	  this.fyPrdId = fyPrdId;
	  this.createdBy = createdBy;
	  this.createdDate = createdDate;
	  this.createdTime = createdTime;
	  this.modifyBy = modifyBy;
	  this.modifyDate = modifyDate;
	  this.modifyTime = modifyTime;
	 }
	public long getPrimaryId() {
		return primaryId;
	}
	public void setPrimaryId(long primaryId) {
		this.primaryId = primaryId;
	}
	public String getFromEmailId() {
		return fromEmailId;
	}
	public void setFromEmailId(String fromEmailId) {
		this.fromEmailId = fromEmailId;
	}
	public String getToEmailId() {
		return ToEmailId;
	}
	public void setToEmailId(String toEmailId) {
		ToEmailId = toEmailId;
	}
	public int getCommercialNvo() {
		return commercialNvo;
	}
	public void setCommercialNvo(int commercialNvo) {
		this.commercialNvo = commercialNvo;
	}
	public int getSendBy() {
		return sendBy;
	}
	public void setSendBy(int sendBy) {
		this.sendBy = sendBy;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public String getAddAttachment() {
		return addAttachment;
	}
	public void setAddAttachment(String addAttachment) {
		this.addAttachment = addAttachment;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
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
	public long getFyPrdId() {
		return fyPrdId;
	}
	public void setFyPrdId(long fyPrdId) {
		this.fyPrdId = fyPrdId;
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
