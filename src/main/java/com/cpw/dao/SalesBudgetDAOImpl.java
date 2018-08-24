package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.SalesBudgetMapper;
import com.cpw.jdbc.model.SalesBudget;

public class SalesBudgetDAOImpl implements SalesBudgetDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public int salesBudget(SalesBudget salesBudget) {
		logger.debug("Entering into salesBudget DAO");
		CpwTemplete<SalesBudget> cpwTemplete = new CpwTempleteImpl<SalesBudget>();
		String s1="SELECT *FROM SALES_BUDGET_HDR WHERE SB_ID=? ";
		SalesBudget budget=null;
		try {
			budget=jdbcTemplateObject.queryForObject(s1, new Object[]{salesBudget.getId()}, new SalesBudgetMapper());

		} catch (EmptyResultDataAccessException e) {
			budget=null;
		}
		try {
			int count=-1;
			if(budget!=null && budget.getId()==salesBudget.getId())
			{
				logger.debug("Update Values:" +salesBudget.getId());
				String sql="UPDATE SALES_BUDGET_HDR SET BUDGET_NO=?,YEAR=?,BUDGET_TYPE=?,SALESMAN_ID=?,SECTOR_ID=?,"
						+ "CURRENCY_ID=?,ROE=?,FILE_NAME=?,NOTE=?,LOC_ID=?,FY_ID=?,FY_PRD_ID=?,CR_BY=?,CR_DATE=?,"
						+ "CR_TIME=?,MD_BY=?,MD_DATE=?,MD_TIME=? WHERE SB_ID=?";

				return jdbcTemplateObject.update(sql, salesBudget.getBudgetNumber(),
						salesBudget.getYear(),salesBudget.getBudgetType(),
						salesBudget.getSalesmanId(),salesBudget.getSectorId(),
						salesBudget.getCurrencyId(),salesBudget.getRoe(),
						salesBudget.getFileName(),salesBudget.getNote(),
						salesBudget.getLocId(),salesBudget.getFyId(),
						salesBudget.getFyPrdId(),salesBudget.getCreatedBy(),
						salesBudget.getCreatedDate(),salesBudget.getCreatedTime(),
						salesBudget.getModifyBy(),salesBudget.getModifyDate(),
						salesBudget.getModifyTime(),salesBudget.getId());
			}else{
				String sql = "INSERT INTO SALES_BUDGET_HDR (SB_ID, BUDGET_NO, YEAR, BUDGET_TYPE, SALESMAN_ID, SECTOR_ID, CURRENCY_ID,"
						+ " ROE, FILE_NAME, NOTE, LOC_ID, FY_ID, FY_PRD_ID, CR_BY, CR_DATE, CR_TIME, MD_BY, MD_DATE, MD_TIME)"
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				Object[] values = new Object[19];
				values[0] = salesBudget.getId();
				values[1] = salesBudget.getBudgetNumber();
				values[2] = salesBudget.getYear();
				values[3] = salesBudget.getBudgetType();
				values[4] = salesBudget.getSalesmanId();
				values[5] = salesBudget.getSectorId();
				values[6] = salesBudget.getCurrencyId();
				values[7] = salesBudget.getRoe();
				values[8] = salesBudget.getFileName();
				values[9] = salesBudget.getNote();
				values[10] = salesBudget.getLocId();
				values[11] = salesBudget.getFyId();
				values[12] = salesBudget.getFyPrdId();
				values[13] = salesBudget.getCreatedBy();
				values[14] = salesBudget.getCreatedDate();
				values[15] = salesBudget.getCreatedTime();
				values[16] = salesBudget.getModifyBy();
				values[17] = salesBudget.getModifyDate();
				values[18] = salesBudget.getModifyTime();

				logger.debug("Before Calling upsert");

				count = cpwTemplete.upsert(sql, values, jdbcTemplateObject);
				logger.debug("Record creation status: " + count);
			}
			return count;
		} catch (DataAccessException e) {
			logger.error("Exception at time of creation" + e);
			return 0;
		}
	}

	@Override
	public List<SalesBudget> salesBudgetList(long id) {
		CpwTemplete<SalesBudget> cpwTemplete = new CpwTempleteImpl<SalesBudget>();

		try {
			if(id==-1){
				logger.debug("Entering into salesBudgetList ");
				final String sql = "SELECT * FROM SALES_BUDGET_HDR";
				List<SalesBudget> budgetList = cpwTemplete.getRecordList(sql, jdbcTemplateObject,new SalesBudgetMapper());
				return budgetList;
			}else
			{
				logger.debug("Entering into BudgetList" +id);
				final String sql = "SELECT * FROM SALES_BUDGET_HDR WHERE SB_ID>?";
				List<SalesBudget> budgetList = jdbcTemplateObject.query(sql, new Object[] {id},
						new SalesBudgetMapper());
				return budgetList;
			}
		}  catch (DataAccessException e) {
			logger.debug("No List in system");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int removeSalesBudget(long id) {
		logger.debug("Enter into remove List");
		final String sql="DELETE FROM SALES_BUDGET_HDR WHERE SB_ID=?";

		return jdbcTemplateObject.update(sql, id);
	}

}
