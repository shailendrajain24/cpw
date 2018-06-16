/**
 * 
 */
package com.cpw.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Unknown
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PramotionalRequest {
	private String primaryId;
	private String fromEmailId;
	private String ToEmailId;
	private String commercialNvo;
	private String sendBy;
	private String subject;
	private String countryId;
	private String categoryId;
	private String attachment;
	private String addAttachment;
	private String body;
	private String locId;
	private String fyId;
	private String fyPrdId;
	private String createdBy;
	private Date createdDate;
	private String createdTime;
	private String modifyBy;
	private Date modifyDate;
	private String modifyTime;
	public String getPrimaryId() {
		return primaryId;
	}
	public void setPrimaryId(String primaryId) {
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
	public String getCommercialNvo() {
		return commercialNvo;
	}
	public void setCommercialNvo(String commercialNvo) {
		this.commercialNvo = commercialNvo;
	}
	public String getSendBy() {
		return sendBy;
	}
	public void setSendBy(String sendBy) {
		this.sendBy = sendBy;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
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
	public String getLocId() {
		return locId;
	}
	public void setLocId(String locId) {
		this.locId = locId;
	}
	public String getFyId() {
		return fyId;
	}
	public void setFyId(String fyId) {
		this.fyId = fyId;
	}
	public String getFyPrdId() {
		return fyPrdId;
	}
	public void setFyPrdId(String fyPrdId) {
		this.fyPrdId = fyPrdId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
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
	public String getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(String modifyBy) {
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
