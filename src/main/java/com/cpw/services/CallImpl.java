package com.cpw.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.CallDAOImpl;
import com.cpw.jdbc.model.Call;
import com.cpw.model.CallRequest;
import com.cpw.model.CallResponse;

public class CallImpl {
	
	public CallImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	private final ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
	private final CallDAOImpl callDao=(CallDAOImpl)context.getBean("callDAOImpl");
	
	public int upsertCall(CallRequest callRequest)
	{
		logger.debug("Entering into upsert");
		
		return callDao.upsertCall(map(callRequest));
		
	}
	
	public int removeCall(long callId)
	{
		logger.debug("Entering into Remove call");
		return callDao.removeCall(callId);
		
	}
	
	public List<CallResponse> callList(long callId)
	{
		logger.debug("Entering into CallList");
		final List<Call> callList=callDao.callList(callId);
		return map(callList);
		
	}
	
	private List<CallResponse> map(List<Call> callList)
	{
		List<CallResponse> callResponseList=Collections.emptyList();
		if(callList!=null && !callList.isEmpty())
		{
			callResponseList =new ArrayList<CallResponse>();
			for(Call call:callList)
			{
				CallResponse trackingResponse=map(call);
				callResponseList.add(trackingResponse);
			}
			callList.clear();
		}
		
		return callResponseList;
		
	}
	private CallResponse map(Call call)
	{
		CallResponse callResponse=new CallResponse();
		if(call!=null)
		{
			callResponse.setCallId(call.getCallId());
			callResponse.setType(call.getType());
			callResponse.setContact(call.getContact());
			callResponse.setSubject(call.getSubject());
			callResponse.setCallPurpose(call.getCallPurpose());
			callResponse.setAccount(call.getAccount());
			callResponse.setCallType(call.getCallType());
			callResponse.setCallStartTime(call.getCallStartTime());
			callResponse.setCallDuration(call.getCallDuration());
			callResponse.setDescription(call.getDescription());
			callResponse.setCallResult(call.getCallResult());
			callResponse.setBillable(call.isBillable());
			callResponse.setReminder(call.getReminder());
			callResponse.setNotes(call.getNotes());
			callResponse.setCreatedBy(call.getCreatedBy());
			callResponse.setModifiedBy(call.getModifiedBy());
			callResponse.setCreatedTime(call.getCreatedTime());
			callResponse.setModifiedTime(call.getModifiedTime());
		}
		return callResponse;
		
	}
	
	private Call map(CallRequest callRequest)
	{
		Call call=new Call();
		
		if(callRequest!=null)
		{
			call.setCallId(callRequest.getCallId());
			call.setType(callRequest.getType());
			call.setContact(callRequest.getContact());
			call.setSubject(callRequest.getSubject());
			call.setCallPurpose(callRequest.getCallPurpose());
			call.setAccount(callRequest.getAccount());
			call.setCallType(callRequest.getCallType());
			call.setCallStartTime(callRequest.getCallStartTime());
			call.setCallDuration(callRequest.getCallDuration());
			call.setDescription(callRequest.getDescription());
			call.setCallResult(callRequest.getCallResult());
			call.setBillable(callRequest.isBillable());
			call.setReminder(callRequest.getReminder());
			call.setNotes(callRequest.getNotes());
			call.setCreatedBy(callRequest.getCreatedBy());
			call.setModifiedBy(callRequest.getModifiedBy());
            call.setCreatedTime(callRequest.getModifiedTime());
            call.setModifiedTime(callRequest.getModifiedTime());
		}
		return call;
		
	}
	

}
