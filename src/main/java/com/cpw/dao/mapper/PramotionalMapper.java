package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.Pramotional;

public class PramotionalMapper implements RowMapper<Pramotional> {

	public Pramotional mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Pramotional pramotional = new Pramotional();
		pramotional.setPrimaryId(resultSet.getString("PRM_ID"));
		pramotional.setFromEmailId(resultSet.getString("FROM_MAIL_ID"));
		pramotional.setToEmailId(resultSet.getString("TO_MAIL_ID"));
		pramotional.setCommercialNvo(resultSet.getString("COMMERCIAL_NVO"));
		pramotional.setSendBy(resultSet.getString("SEND_BY"));
		pramotional.setSubject(resultSet.getString("SUBJECT"));
		pramotional.setCountryId(resultSet.getString("COUNTRY_ID"));
		pramotional.setCategoryId(resultSet.getString("CATEGORY_ID"));
		pramotional.setAttachment(resultSet.getString("ATTACHMENT"));
		pramotional.setAddAttachment(resultSet.getString("ADD_ATTACHMENT"));
		pramotional.setBody(resultSet.getString("BODY"));
		pramotional.setLocId(resultSet.getString("LOC_ID"));
		pramotional.setFyId(resultSet.getString("FY_ID"));
		pramotional.setFyPrdId(resultSet.getString("FY_PRD_ID"));
		pramotional.setCreatedBy(resultSet.getString("CR_BY"));
		pramotional.setCreatedDate(resultSet.getDate("CR_DATE"));
		pramotional.setCreatedTime(resultSet.getString("CR_TIME"));
		pramotional.setModifyBy(resultSet.getString("MD_BY"));
		pramotional.setModifyDate(resultSet.getDate("MD_DATE"));
		pramotional.setModifyTime(resultSet.getString("MD_TIME"));
		return pramotional;
	}

}
