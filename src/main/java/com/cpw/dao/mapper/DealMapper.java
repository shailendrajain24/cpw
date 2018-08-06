package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.Deal;

public class DealMapper implements RowMapper<Deal>{

	@Override
	public Deal mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		
		final Deal deal=new Deal();

		deal.setDealId(resultSet.getLong("DEAL_ID"));
		deal.setDealOwner(resultSet.getString("DEAL_OWNER"));
		deal.setAmount(resultSet.getInt("AMOUNT"));
		deal.setDealName(resultSet.getString("DEAL_NAME"));
		deal.setClosingDate(resultSet.getLong("CLOSING_DATE"));
		deal.setAccountName(resultSet.getString("ACCOUNT_NAME"));
		deal.setStage(resultSet.getString("STAGE"));
		deal.setType(resultSet.getString("TYPE"));
		deal.setProbability(resultSet.getInt("PROBABILITY"));
		deal.setNextStep(resultSet.getString("NEXT_STEP"));
		deal.setExpectedRevenue(resultSet.getString("EXPECTED_REVENUE"));
		deal.setLeadSource(resultSet.getString("LEAD_SOURCE"));
		deal.setCampaignSource(resultSet.getString("COMPAIGN_SOURCE"));
		deal.setContactName(resultSet.getString("CONTACT_NAME"));
		deal.setDescription(resultSet.getString("DESCRIPTION"));
		deal.setCreatedBy(resultSet.getString("CREATED_BY"));
		deal.setModifiedBy(resultSet.getString("MODIFIED_BY"));
		deal.setCreatedTime(resultSet.getLong("CREATED_TIME"));
		deal.setModifiedTime(resultSet.getLong("MODIFIED_TIME"));
		deal.setNotes(resultSet.getString("NOTES"));
		deal.setAttachments(resultSet.getString("ATTACHMENTS"));
	
		

		return deal;
	}

}
