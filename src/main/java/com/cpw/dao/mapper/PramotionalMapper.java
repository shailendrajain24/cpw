package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.Pramotional;

public class PramotionalMapper implements RowMapper<Pramotional> {

	public Pramotional mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final Pramotional pramotional = new Pramotional();
		pramotional.setPrimaryId(resultSet.getLong("PRM_ID"));
		pramotional.setFromEmailId(resultSet.getString("FROM_MAIL_ID"));
		pramotional.setToEmailId(resultSet.getString("TO_MAIL_ID"));
		pramotional.setCommercialNvo(resultSet.getInt("COMMERCIAL_NVO"));
		pramotional.setSendBy(resultSet.getInt("SEND_BY"));
		pramotional.setSubject(resultSet.getString("SUBJECT"));
		pramotional.setCountryId(resultSet.getInt("COUNTRY_ID"));
		pramotional.setCategoryId(resultSet.getInt("CATEGORY_ID"));
		pramotional.setAttachment(resultSet.getString("ATTACHMENT"));
		pramotional.setAddAttachment(resultSet.getString("ADD_ATTACHMENT"));
		pramotional.setBody(resultSet.getString("BODY"));
		pramotional.setLocId(resultSet.getLong("LOC_ID"));
		pramotional.setFyId(resultSet.getLong("FY_ID"));
		pramotional.setFyPrdId(resultSet.getLong("FY_PRD_ID"));
		pramotional.setCreatedBy(resultSet.getLong("CR_BY"));
		pramotional.setCreatedDate(resultSet.getString("CR_DATE"));
		pramotional.setCreatedTime(resultSet.getString("CR_TIME"));
		pramotional.setModifyBy(resultSet.getLong("MD_BY"));
		pramotional.setModifyDate(resultSet.getString("MD_DATE"));
		pramotional.setModifyTime(resultSet.getString("MD_TIME"));
		return pramotional;
	}

}
