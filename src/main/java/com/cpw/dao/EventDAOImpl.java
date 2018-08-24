package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.EventMapper;
import com.cpw.jdbc.model.Event;


public class EventDAOImpl implements EventDAO{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		this.jdbcTemplateObject=new JdbcTemplate(ds);


	}

	@Override
	public int upsertEvent(Event event) {
		logger.debug("Entering into account DAO");
		CpwTemplete<Event> cpwTemplete = new CpwTempleteImpl<Event>();
		String q1 = "SELECT *FROM EVENT WHERE EVENT_ID=?";
		Event e = null;
		try {
			e = jdbcTemplateObject.queryForObject(q1, new Object[] { event.getEventId() }, new EventMapper());
		} catch (EmptyResultDataAccessException e1) {
			e = null;
		}
		try {
			int count = -1;
			if (e != null && e.getEventId() == event.getEventId()) {
				logger.debug("UPDATE values" + event.getEventId());
				String updateSql = "UPDATE EVENT SET TITLE=?,LOCATION=?,ALL_DAY=?,FROM_DATE=?,"
						+ "TO_DATE=?,HOST=?,PARTICIPANTS=?,CONTACT=?,ACCOUNT=?,REPEAT=?,"
						+ "DESCRIPTION=?,REMINDER=?,PARTICIPANT_ID=?,PARTICIPANT_NAME=?,"
						+ "CREATED_BY=?,CREATED_TIME=?,MODIFY_BY=?,"
						+ "MODIFY_TIME=?,NOTES=?,ATTACHMENTS=? WHERE EVENT_ID=?";
				return jdbcTemplateObject.update(updateSql, event.getTitle(), 
						event.getLocation(),
						event.isAllDay(),
						event.getFromDate(),
						event.getToDate(), 
						event.getHost(),
						event.getParticipants(),
						event.getContact(),
						event.getAccount(),
						event.getRepeat(),
						event.getDescription(),
						event.getReminder(),
						event.getParticipantId(),
						event.getCreatedBy(),
						event.getCreatedTime(),
						event.getModifyBy(),
						event.getModifyTime(),
						event.getNotes(),
						event.getAttachments(),
						event.getEventId());
			}else {
				StringBuilder sb = new StringBuilder();
				

				
			
				sb.append( "INSERT INTO EVENT (EVENT_ID,TITLE,LOCATION,ALL_DAY,FROM_DATE,"
						+ "TO_DATE,HOST,NO_OF_PARTICIPANTS,CONTACT,ACCOUNT,REPEAT,DESCRIPTION,"
						+ "REMINDER,CREATED_BY,CREATED_TIME,"
						+ "MODIFY_BY,MODIFY_TIME,NOTES,ATTACHMENTS,CONTACT_ID,ACCOUNT_ID)"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				for(int i=0;i<event.getNoOfParticipants();i++)
				{
					
				
					System.out.println("hello");
					//ArrayList<String> list=event.getParticipants();
					//System.out.println(p.getParticipants());
				sb.append("INSERT INTO PARTICIPANTS_DTL(PARTICIPANT_ID,PARTICIPANTS)VALUES("+event.getParticipantId()+","+event.getParticipants()+"");
				//event.getParticipants();
				}
			long l=event.getEventId();
			System.err.println(l);
			/*String list=event.getParticipants().get(0);
			System.out.println(list);*/
			
				
				Object[] values = new Object[21];
				values[0]  = event.getEventId();
				values[1]  = event.getTitle();
				values[2]  = event.getLocation();
				values[3]  = event.isAllDay();
				values[4]  = event.getFromDate();
				values[5]  = event.getToDate();
				values[6]  = event.getHost();
				values[7]  = event.getNoOfParticipants();
				values[8]  = event.getContact();
				values[9]  = event.getAccount();
				values[10] = event.getRepeat();
				values[11] = event.getDescription();
				values[12] = event.getReminder();
				values[13] = event.getCreatedBy();
				values[14] = event.getCreatedTime();
				values[15] = event.getModifyBy();
				values[16] = event.getModifyTime();
				values[17] = event.getNotes();
				values[18] = event.getAttachments();
				values[19]=event.getContactId();
				values[20]=event.getAccountId();
			  /*  values[21]=event.getParticipantId();
			    values[22]=event.getParticipants();
				*/
				logger.debug("INSERT values" + values[1]);	
				count = cpwTemplete.upsert(sb.toString(), values, jdbcTemplateObject);
				logger.debug("Record creation status: " + count);
			}
			logger.debug("Before Calling upsert");

			return count;
		} catch (DataAccessException e1) {
			// logger.error("Exception at time of creation" + e);
			e1.printStackTrace();
			return 0;
		}

	}

	@Override
	public List<Event> eventList(long eventId) {

		CpwTemplete<Event> cpwTemplete = new CpwTempleteImpl<Event>();
		logger.debug("Entering into eventList " + eventId);

		try {
			if(eventId==-1){
				logger.debug("Entering into EventList ");
				final String sql = "SELECT * FROM EVENT";
				List<Event> eventList = cpwTemplete.getRecordList(sql, jdbcTemplateObject,new EventMapper());
				return eventList;
			}else
			{
				logger.debug("Entering into EventList" +eventId);
				final String sql = "SELECT * FROM EVENT WHERE EVENT_ID>?";
				List<Event> eventList = jdbcTemplateObject.query(sql, new Object[] {eventId},
						new EventMapper());
				return eventList;
			}
		} catch (EmptyResultDataAccessException e) {
			logger.error("No eventList in system");
			return null;
		}

	}

	@Override
	public int removeEvent(long eventId) {
		logger.debug("Entering into remove event");
		final String trackingSql = "DELETE FROM EVENT WHERE EVENT_ID=?";
		try {
			return jdbcTemplateObject.update(trackingSql, eventId);
		} catch (DataAccessException e) {
			logger.error("No Event available in system coresponding to Event id: " + eventId);
			return 0;
		}


	}


}
