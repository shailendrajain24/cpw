package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
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
		String sql = "INSERT INTO SALES_BUDGET_HDR (SB_ID, BUDGET_NO, YEAR, BUDGET_TYPE, SALESMAN_ID, SECTOR_ID, CURRENCY_ID,"
				+ " ROE, FILE_NAME, NOTE, LOC_ID, FY_ID, FY_PRD_ID, CR_BY, CR_DATE, CR_TIME, MD_BY, MD_DATE, MD_TIME)"
				+ "VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
		try {
			logger.debug("Before Calling upsert");
			int count = cpwTemplete.upsert(sql, values, jdbcTemplateObject);
			logger.debug("Record creation status: " + count);
			return count;
		} catch (DataAccessException e) {
			logger.error("Exception at time of creation" + e);
			return 0;
		}
	}

	@Override
	public List<SalesBudget> salesBudgetList(long id) {
		try {
			logger.debug("Entering into SalesBudgetList");
			String sql="SELECT * FROM SALES_BUDGET_HDR WHERE SB_ID=?";
			List<SalesBudget> salesBudegetList=jdbcTemplateObject.query(sql, new Object[]{id}, new SalesBudgetMapper());
			return salesBudegetList;
			
		} catch (Exception e) {
			logger.debug("No List in system");
			e.printStackTrace();
		}
		return null;
	}

}
