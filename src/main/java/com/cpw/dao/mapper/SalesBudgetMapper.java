package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.SalesBudget;

public class SalesBudgetMapper implements RowMapper<SalesBudget> {

	public SalesBudget mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final SalesBudget salesBudget = new SalesBudget();
		salesBudget.setId(resultSet.getLong("SB_ID"));
		salesBudget.setBudgetNumber(resultSet.getString("BUDGET_NO"));
		salesBudget.setYear(resultSet.getString("YEAR"));
		salesBudget.setBudgetType(resultSet.getInt("BUDGET_TYPE"));
		salesBudget.setSalesmanId(resultSet.getLong("SALESMAN_ID"));
		salesBudget.setSectorId(resultSet.getInt("SECTOR_ID"));
		salesBudget.setCurrencyId(resultSet.getInt("CURRENCY_ID"));
		salesBudget.setRoe(resultSet.getDouble("ROE"));
		salesBudget.setFileName(resultSet.getString("FILE_NAME"));
		salesBudget.setNote(resultSet.getString("NOTE"));
		salesBudget.setLocId(resultSet.getLong("LOC_ID"));
		salesBudget.setFyId(resultSet.getLong("FY_ID"));
		salesBudget.setFyPrdId(resultSet.getLong("FY_PRD_ID"));
		salesBudget.setCreatedBy(resultSet.getLong("CR_BY"));
		salesBudget.setCreatedDate(resultSet.getString("CR_DATE"));
		salesBudget.setCreatedTime(resultSet.getString("CR_TIME"));
		salesBudget.setModifyBy(resultSet.getLong("MD_BY"));
		salesBudget.setModifyDate(resultSet.getString("MD_DATE"));
		salesBudget.setModifyTime(resultSet.getString("MD_TIME"));
		return salesBudget;
	}

}
