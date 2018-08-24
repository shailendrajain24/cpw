package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.CustomerChallengeMapper;
import com.cpw.jdbc.model.CustomerChallenge;

public class CustomerChallengeDAOImpl implements CustomerChallengeDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public int customerChallenge(CustomerChallenge customerChallenge) {
		logger.debug("Entering into customerChallenge DAO");
		CpwTemplete<CustomerChallenge> cpwTemplete = new CpwTempleteImpl<CustomerChallenge>();
		
		String q1 = "SELECT *FROM CUST_CHALLENGE_HDR WHERE CUSTOMER_CHALLENGE_ID=?";
		CustomerChallenge custChallenge = null;
		try {
			custChallenge = jdbcTemplateObject.queryForObject(q1, new Object[] { customerChallenge.getId()}, new CustomerChallengeMapper());
		} catch (EmptyResultDataAccessException e) {
			custChallenge = null;
		}
		try {
			int count = -1;
			if(custChallenge!=null && custChallenge.getId()==customerChallenge.getId())
			{
				logger.debug("UPDATE values" + customerChallenge.getId());
				String updateSql="UPDATE CUST_CHALLENGE_HDR SET CODE=?,CUSTOMER_ID=?,CONTACT_ID=?,"
						+ "LOG_DATE=?,STATUS=?,PRIORITY=?,ORIGIN=?,TYPE_ID=?,REASON=?,"
						+ "DUE_DATE=?,INCHARGE_ID=?,CC_MAIL=?,SUBJECT=?,DESCRIPTION=?,"
						+ "INTERNAL_NOTE=?,CUSTOMER_FEEDBACK=?,CLOSED_DATE=?,NOTE=?,"
						+ "LOC_ID=?,FY_ID=?,CREATED_TIME=?,IS_DELETED=?,CR_BY=?,CR_DATE=?,"
						+ "CR_TIME=?,MD_BY=?,MD_DATE=?,MD_TIME=? WHERE CUSTOMER_CHALLENGE_ID=? ";
				return jdbcTemplateObject.update(updateSql, customerChallenge.getCode(),
						customerChallenge.getCustomerId(),
						customerChallenge.getContactId(),
						customerChallenge.getLogDate(),
						customerChallenge.getStatus(),
						customerChallenge.getPriority(),
						customerChallenge.getOrigin(),
						customerChallenge.getTypeId(),
						customerChallenge.getReason(),
						customerChallenge.getDueDate(),
						customerChallenge.getInchargeId(),
						customerChallenge.getCcEmail(),
						customerChallenge.getSubject(),
						customerChallenge.getDescription(),
						customerChallenge.getInternalNote(),
						customerChallenge.getCustomerFeedback(),
						customerChallenge.getCloseDate(),
						customerChallenge.getNote(),
						customerChallenge.getLocId(),
						customerChallenge.getFyId(),
						customerChallenge.getTime(),
						customerChallenge.getIsDeleted(),
						customerChallenge.getCreatedBy(),
						customerChallenge.getCreatedDate(),
						customerChallenge.getCreatedTime(),
						customerChallenge.getModifyBy(),
						customerChallenge.getModifyDate(),
						customerChallenge.getModifyTime(),
						customerChallenge.getId());
			}else {
				
				Object [] values = new Object [29];
				values [0] = customerChallenge.getId();
				values [1] = customerChallenge.getCode();
				values [2] = customerChallenge.getCustomerId();
				values [3] = customerChallenge.getContactId();
				values [4] = customerChallenge.getLogDate();
				values [5] = customerChallenge.getStatus();
				values [6] = customerChallenge.getPriority();
				values [7] = customerChallenge.getOrigin();
				values [8] = customerChallenge.getTypeId();
				values [9] = customerChallenge.getReason();
				values [10] = customerChallenge.getDueDate();
				values [11] = customerChallenge.getInchargeId();
				values [12] = customerChallenge.getCcEmail();
				values [13] = customerChallenge.getSubject();
				values [14] = customerChallenge.getDescription();
				values [15] = customerChallenge.getInternalNote();
				values [16] = customerChallenge.getCustomerFeedback();
				values [17] = customerChallenge.getCloseDate();
				values [18] = customerChallenge.getNote();
				values [19] = customerChallenge.getLocId();
				values [20] = customerChallenge.getFyId();
				values [21] = customerChallenge.getTime();
				values [22] = customerChallenge.getIsDeleted();
				values [23] = customerChallenge.getCreatedBy();
				values [24] = customerChallenge.getCreatedDate();
				values [25] = customerChallenge.getCreatedTime();
				values [26] = customerChallenge.getModifyBy();
				values [27] = customerChallenge.getModifyDate();
				values [28] = customerChallenge.getModifyTime();
				logger.debug("INSERT values" + values[1]);
				String sql = "INSERT INTO CUST_CHALLENGE_HDR" + 
						"(CUSTOMER_CHALLENGE_ID, CODE, CUSTOMER_ID, CONTACT_ID, LOG_DATE, STATUS, PRIORITY, ORIGIN, TYPE_ID, REASON,"
						+ " DUE_DATE, INCHARGE_ID, CC_MAIL, SUBJECT, DESCRIPTION, INTERNAL_NOTE, CUSTOMER_FEEDBACK, CLOSED_DATE, NOTE,"
						+ " LOC_ID, FY_ID, CREATED_TIME, IS_DELETED, CR_BY, CR_DATE, CR_TIME, MD_BY, MD_DATE, MD_TIME)" 
						+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			
					logger.debug("Before Calling upsert");
					 count = cpwTemplete.upsert(sql, values, jdbcTemplateObject);
					logger.debug("Record creation status: "+count);
					
				}
			logger.debug("Before Calling upsert");

			return count;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<CustomerChallenge> customerChallengeList(long id) {
		CpwTemplete<CustomerChallenge> cpwTemplete = new CpwTempleteImpl<CustomerChallenge>();
		

	try {
		if(id==-1){
			logger.debug("Entering into ChallengeList ");
			final String sql = "SELECT * FROM CUST_CHALLENGE_HDR";
			List<CustomerChallenge> challengeList = cpwTemplete.getRecordList(sql, jdbcTemplateObject,new CustomerChallengeMapper());
			return challengeList;
		}else
		{
			logger.debug("Entering into challengeList" +id);
			final String sql = "SELECT * FROM CUST_CHALLENGE_HDR WHERE CUSTOMER_CHALLENGE_ID>?";
			List<CustomerChallenge> challengeList = jdbcTemplateObject.query(sql, new Object[] {id},
					new CustomerChallengeMapper());
			return challengeList;
		}
	} catch (Exception e) {
		logger.debug("No list in System" +e);
		e.printStackTrace();
	}
		
		return null;
	}

	@Override
	public int removeCustomerChallenge(long id) {
		logger.debug("Entering into remove CustomerChallenge");
		String sql="DELETE FROM CUST_CHALLENGE_HDR WHERE CUSTOMER_CHALLENGE_ID=? ";
		try {
			return jdbcTemplateObject.update(sql, id);
		} catch (Exception e) {
			logger.error("No CustomerChallenge available in system coresponding to id: " + id);
			e.printStackTrace();
			return 0;
		}

	}

}
