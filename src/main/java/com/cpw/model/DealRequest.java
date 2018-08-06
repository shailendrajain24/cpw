package com.cpw.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown= true)
public class DealRequest {

	private long dealId;
	private String dealOwner;
	private int amount;
	private String dealName;
	private long closingDate;
	private String accountName;
	private String stage;
	private String type;
	private int probability;
	private String nextStep;
	private String expectedRevenue;
	private String leadSource;
	private String campaignSource;
	private String contactName;
	private String description;
	private String createdBy;
	private String modifiedBy;
	private long createdTime;
	private long modifiedTime;
	private String notes;
	private String attachments;

	@JsonCreator
	public DealRequest(@JsonProperty("dealId")long dealId,@JsonProperty("dealOwner") String dealOwner,
			@JsonProperty("amount")int amount,@JsonProperty("dealName")String dealName,
			@JsonProperty("closingDate")long closingDate,@JsonProperty("accountName")String accountName,
			@JsonProperty("stage")String stage,@JsonProperty("type")String type,
			@JsonProperty("probability")int probability,@JsonProperty("nextStep")String nextStep,
			@JsonProperty("expectedRevenue")String expectedRevenue,@JsonProperty("leadSource")String leadSource,
			@JsonProperty("campaignSource")String campaignSource,@JsonProperty("contactName")String contactName,
			@JsonProperty("description")String description,@JsonProperty("createdBy")String createdBy,
			@JsonProperty("modifiedBy")String modifiedBy,@JsonProperty("createdTime")long createdTime,
			@JsonProperty("modifiedTime")long modifiedTime,@JsonProperty("notes")String notes,
			@JsonProperty("attachments")String attachments)
	{
		this.dealId=dealId;
		this.dealOwner=dealOwner;
		this.amount=amount;
		this.dealName=dealName;
		this.closingDate=closingDate;
		this.accountName=accountName;
		this.stage=stage;
		this.type=type;
		this.probability=probability;
		this.nextStep=nextStep;
		this.expectedRevenue=expectedRevenue;
		this.leadSource=leadSource;
		this.campaignSource=campaignSource;
		this.contactName=contactName;
		this.description=description;
		this.createdBy=createdBy;
		this.modifiedBy=modifiedBy;
		this.createdTime=createdTime;
		this.modifiedTime=modifiedTime;
		this.notes=notes;
		this.attachments=attachments;

	}

	public long getDealId() {
		return dealId;
	}

	public void setDealId(long dealId) {
		this.dealId = dealId;
	}

	public String getDealOwner() {
		return dealOwner;
	}

	public void setDealOwner(String dealOwner) {
		this.dealOwner = dealOwner;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDealName() {
		return dealName;
	}

	public void setDealName(String dealName) {
		this.dealName = dealName;
	}

	public long getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(long closingDate) {
		this.closingDate = closingDate;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getProbability() {
		return probability;
	}

	public void setProbability(int probability) {
		this.probability = probability;
	}

	public String getNextStep() {
		return nextStep;
	}

	public void setNextStep(String nextStep) {
		this.nextStep = nextStep;
	}

	public String getExpectedRevenue() {
		return expectedRevenue;
	}

	public void setExpectedRevenue(String expectedRevenue) {
		this.expectedRevenue = expectedRevenue;
	}

	public String getLeadSource() {
		return leadSource;
	}

	public void setLeadSource(String leadSource) {
		this.leadSource = leadSource;
	}

	public String getCampaignSource() {
		return campaignSource;
	}

	public void setCampaignSource(String campaignSource) {
		this.campaignSource = campaignSource;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public long getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(long createdTime) {
		this.createdTime = createdTime;
	}

	public long getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(long modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getAttachments() {
		return attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}



}
