package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.PortMaster;

public class PortMasterMapper implements RowMapper<PortMaster> {

	public PortMaster mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final PortMaster portMaster = new PortMaster();
		portMaster.setPortId(resultSet.getLong("PORT_ID"));
		portMaster.setCode(resultSet.getString("CODE"));
		portMaster.setCountryName(resultSet.getString("COUNTRY_NAME"));
		portMaster.setCityName(resultSet.getString("NAME"));
		/*portMaster.setCountry(resultSet.getInt("COUNTRY"));
		portMaster.setEdiPortCode(resultSet.getString("EDI_PORT_CODE"));
		portMaster.setTransportCode(resultSet.getString("TRANSPORT_MODE"));
		portMaster.setDryPort(resultSet.getString("ISDRYPORT"));
		portMaster.setGroupCode(resultSet.getString("GROUP_CODE"));
		portMaster.setSailingDay(resultSet.getLong("SAILING_DAY"));
		portMaster.setTransportCode(resultSet.getString("ACTIVE"));
		portMaster.setNote(resultSet.getString("NOTE"));
		portMaster.setLocId(resultSet.getInt("LOC_ID"));
		portMaster.setDeleted(resultSet.getString("IS_DELETED"));
		portMaster.setCreatedBy(resultSet.getInt("CREATED_BY"));
		portMaster.setCreateDate(resultSet.getDate("CREATED_DATE").toString());
		portMaster.setCreateTime(resultSet.getTime("CREATED_TIME").toString());
		portMaster.setModifyBy(resultSet.getInt("MODIFIED_BY"));
		portMaster.setModifyDate(resultSet.getDate("MODIFIED_DATE").toString());
		portMaster.setModifyTime(resultSet.getTime("MODIFIED_TIME").toString());
		portMaster.setLastSyncTimeStamp(resultSet.getString("LAST_SYNC_TIMESTAMP"));
*/
		return portMaster;
	}

}
