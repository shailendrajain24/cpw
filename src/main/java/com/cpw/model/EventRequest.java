package com.cpw.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventRequest {
	private long eventId;
	private String title;
	private String location;
	private boolean allDay;
	private long fromDate;
	private long toDate;
	private String host;
	private String participants;
	private String contact;
	private String account;
	private String repeat;
	private String description;
	private String reminder;
	private long participantId;
	private String participantName;
	private String createdBy;
	private long createdTime;
	private String modifyBy;
	private long modifyTime;
	private String notes;
	private String attachments;
	
	@JsonCreator
	public EventRequest(@JsonProperty("eventId")long eventId,@JsonProperty("title")String title,
			@JsonProperty("location")String location,@JsonProperty("allDay")boolean allDay,
			@JsonProperty("fromDate")long fromDate,@JsonProperty("toDate")long toDate,
			@JsonProperty("host")String host,@JsonProperty("participants")String participants,
			@JsonProperty("contact")String contact,@JsonProperty("account")String account,
			@JsonProperty("repeat")String repeat,@JsonProperty("description")String description,
			@JsonProperty("reminder")String reminder,@JsonProperty("participantId")long participantId,
			@JsonProperty("participantName")String participantName,@JsonProperty("createdBy")String createdBy,
			@JsonProperty("createdTime")long createdTime,@JsonProperty("modifyBy")String modifyBy,
			@JsonProperty("modifyTime")long modifyTime,@JsonProperty("notes")String notes,
			@JsonProperty("attachments")String attachments)
	{
		this.eventId=eventId;
		this.title=title;
		this.location=location;
		this.allDay=allDay;
		this.fromDate=fromDate;
		this.toDate=toDate;
		this.host=host;
		this.participants=participants;
		this.contact=contact;
		this.account=account;
		this.repeat=repeat;
		this.description=description;
		this.reminder=reminder;
		this.participantId=participantId;
		this.participantName=participantName;
		this.createdBy=createdBy;
		this.createdTime=createdTime;
		this.modifyBy=modifyBy;
		this.modifyTime=modifyTime;
		this.notes=notes;
		this.attachments=attachments;
		
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isAllDay() {
		return allDay;
	}

	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}

	public long getFromDate() {
		return fromDate;
	}

	public void setFromDate(long fromDate) {
		this.fromDate = fromDate;
	}

	public long getToDate() {
		return toDate;
	}

	public void setToDate(long toDate) {
		this.toDate = toDate;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getParticipants() {
		return participants;
	}

	public void setParticipants(String participants) {
		this.participants = participants;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getRepeat() {
		return repeat;
	}

	public void setRepeat(String repeat) {
		this.repeat = repeat;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReminder() {
		return reminder;
	}

	public void setReminder(String reminder) {
		this.reminder = reminder;
	}

	public long getParticipantId() {
		return participantId;
	}

	public void setParticipantId(long participantId) {
		this.participantId = participantId;
	}

	public String getParticipantName() {
		return participantName;
	}

	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public long getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(long createdTime) {
		this.createdTime = createdTime;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public long getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(long modifyTime) {
		this.modifyTime = modifyTime;
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
