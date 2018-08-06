package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.DealMapper;
import com.cpw.jdbc.model.Deal;

public class DealDAOImpl implements DealDAO{
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	private JdbcTemplate jdbcTemplateObject;
	@Override
	public void setDataSource(DataSource ds) {
		this.jdbcTemplateObject=new JdbcTemplate(ds);


	}

	@Override
	public int upsert(Deal deal) {
		logger.debug("Entering into Deal DAO");
		CpwTemplete<Deal> cpwTemplete=new CpwTempleteImpl<Deal>();

		String q1="SELECT *FROM DEALS WHERE DEAL_ID=?";

		Deal d=null;
		try {
			d=jdbcTemplateObject.queryForObject(q1, new Object[] {deal.getDealId()},new DealMapper());

		} catch (Exception e) {
			d=null;
		}
		try {
			int count=-1;
			if(d!=null && d.getDealId()==deal.getDealId())
			{
				logger.debug("Update values" +deal.getDealId());
				String sql="UPDATE DEALS SET DEAL_OWNER=?,AMOUNT=?,DEAL_NAME=?,CLOSING_DATE=?,ACCOUNT_NAME=?,"
						+ "STAGE=?,TYPE=?,PROBABILITY=?,NEXT_STEP=?,EXPECTED_REVENUE=?,LEAD_SOURCE=?,"
						+ "COMPAIGN_SOURCE=?,CONTACT_NAME=?,DESCRIPTION=?,CREATED_BY=?,MODIFIED_BY=?,"
						+ "CREATED_TIME=?,MODIFIED_TIME=?,NOTES=?,ATTACHMENTS=? WHERE DEAL_ID=?";

				return jdbcTemplateObject.update(sql, deal.getDealOwner(),
						deal.getAmount(),
						deal.getDealName(),
						deal.getClosingDate(),
						deal.getAccountName(),
						deal.getStage(),
						deal.getType(),
						deal.getProbability(),
						deal.getNextStep(),
						deal.getExpectedRevenue(),
						deal.getLeadSource(),
						deal.getCampaignSource(),
						deal.getContactName(),
						deal.getDescription(),
						deal.getCreatedBy(),
						deal.getModifiedBy(),
						deal.getCreatedTime(),
						deal.getModifiedTime(),
						deal.getNotes(),
						deal.getAttachments(),
						deal.getDealId());

			}else {
				Object[] values=new Object[21];

				values[0]=deal.getDealId();
				values[1]=deal.getDealOwner();
				values[2]=deal.getAmount();
				values[3]=deal.getDealName();
				values[4]=deal.getClosingDate();
				values[5]=deal.getAccountName();
				values[6]=deal.getStage();
				values[7]=deal.getType();
				values[8]=deal.getProbability();
				values[9]=deal.getNextStep();
				values[10]=deal.getExpectedRevenue();
				values[11]=deal.getLeadSource();
				values[12]=deal.getCampaignSource();
				values[13]=deal.getContactName();
				values[14]=deal.getDescription();
				values[15]=deal.getCreatedBy();
				values[16]=deal.getModifiedBy();
				values[17]=deal.getCreatedTime();
				values[18]=deal.getModifiedTime();
				values[19]=deal.getNotes();
				values[20]=deal.getAttachments();

				logger.debug("Insert Values" +values[1]);

				String sql="INSERT INTO DEALS(DEAL_ID,DEAL_OWNER,AMOUNT,DEAL_NAME,CLOSING_DATE,ACCOUNT_NAME,"
						+ "STAGE,TYPE,PROBABILITY,NEXT_STEP,EXPECTED_REVENUE,LEAD_SOURCE,COMPAIGN_SOURCE,"
						+ "CONTACT_NAME,DESCRIPTION,CREATED_BY,MODIFIED_BY,CREATED_TIME,MODIFIED_TIME,NOTES,"
						+ "ATTACHMENTS)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
				count=cpwTemplete.upsert(sql, values, jdbcTemplateObject);

				logger.debug("Record Creation Status" +count);

			}
			logger.debug("Before calling Upsert");

			return count;


		} catch (Exception e)
		{
			logger.debug("Exception at the time of creation"  +e);
			e.printStackTrace();
			return 0;
		}


	}

	@Override
	public List<Deal> dealList(long dealId) {
		logger.debug("Entering into DealList" +dealId);
		final String trackingSql="SELECT *FROM DEALS WHERE DEAL_ID=?";
		try{
			List<Deal> dealList=jdbcTemplateObject.query(trackingSql, new Object[]{dealId},new DealMapper());
			return dealList;
		}catch(Exception e){
			logger.debug("No dealList in system");
			return null;
		}

	}

	@Override
	public int removeList(long dealId) {
		logger.debug("Entering into Remove List");
		final String trackingSql="DELETE FROM DEALS WHERE DEAL_ID=?";
		try {
			return jdbcTemplateObject.update(trackingSql, dealId);

		} catch (Exception e) {
			logger.error("No Deal available in system coresponding to Deal id: " + dealId);
			return 0;
		}

	}

}
