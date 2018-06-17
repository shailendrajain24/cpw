package com.cpw.dao.procedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import com.cpw.dao.mapper.ScheduleSearchMapper;

public class SailingScheduleSearchProcedure extends StoredProcedure {
	/**
	 * Constructor for this StoredProcedure class.
	 */
	@SuppressWarnings("rawtypes")
	public SailingScheduleSearchProcedure(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate, "Sp_sailing_schedule_search");

		// Parameters should be declared in same order here that
		// they are declared in the stored procedure.
		//
		// Note: resultSet must be defined first!
		//
		// define params with syntax: param_name, param_type
		//

		RowMapper rowMapper = new ScheduleSearchMapper();
		declareParameter(new SqlReturnResultSet("RESULT_LIST", rowMapper));
		declareParameter(new SqlParameter("POL_CODE", Types.INTEGER));
		declareParameter(new SqlParameter("POD_CODE", Types.INTEGER));
		declareParameter(new SqlParameter("ETD", Types.DATE));
		declareParameter(new SqlParameter("ETA", Types.DATE));
		declareParameter(new SqlParameter("NAME", Types.VARCHAR));
		//declareParameter(new SqlOutParameter("RETURN_CODE", Types.INTEGER));
		//declareParameter(new SqlOutParameter("RETURN_MESSAGE", Types.VARCHAR));

		// now compile stored proc
		compile();
	}

	/**
	 * Execute stored procedure.
	 *
	 * @return Results of running stored procedure.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	/*public Map searchScheduleList(int vesselId, int polId, int podId, java.sql.Date fromEtd, java.sql.Date toEtd, java.sql.Date fromEta,
			java.sql.Date toEta) {*/
	public Map searchScheduleList(int vesselId, int polId, int podId, String fromEtd, String toEtd, String fromEta,
			String toEta) {
		// set the input params
		Map inParameters = new HashMap();
		inParameters.put("Vessel_Id", new Integer(vesselId));
		inParameters.put("POL_ID", new Integer(polId));
		inParameters.put("@POD_ID", new Integer(podId));
		inParameters.put("@FromETD", fromEtd);
		inParameters.put("@@ToETD", toEtd);
		inParameters.put("@@FromETA", fromEta);
		inParameters.put("@@ToETA", toEta);

		// now execute
		Map out = execute(inParameters); // Call on parent class

		return out;
	}
}
