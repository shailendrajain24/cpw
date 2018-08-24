package com.cpw.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ParticipantsRequest {

	@JsonIgnoreProperties(ignoreUnknown = true)
	private long participantId;
	private String participants;
	
	@JsonCreator
	public ParticipantsRequest(@JsonProperty("participantId")long participantId,@JsonProperty("participants")String participants)
	{
	this.participantId=participantId;
	this.participants=this.participants;
	}
	public long getParticipantId() {
		return participantId;
	}
	public void setParticipantId(long participantId) {
		this.participantId = participantId;
	}
	public String getParticipants() {
		return participants;
	}
	public void setParticipants(String participants) {
		this.participants = participants;
	}
	
	
}
