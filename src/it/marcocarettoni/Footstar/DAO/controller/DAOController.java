package it.marcocarettoni.Footstar.DAO.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import it.marcocarettoni.Footstar.DAO.DataPool.DB;

public abstract class DAOController implements IDBController {

	protected Logger logger;
	protected String table_name;
	
	public DAOController(Class<?> cl, String _table_name) {
		logger = Logger.getLogger(cl);
		table_name = _table_name;
	}

	public boolean emptyTable(Connection c) throws SQLException {
		PreparedStatement s = null;
		ResultSet rs = null;
		try {
			logger.debug("Empty table : " + table_name);
			
			String SQL = " DELETE FROM " + table_name;
			
			s = c.prepareStatement(SQL);			
			
			s.executeUpdate();
			return true;
		} catch (SQLException e) {
			logger.error("emptyTable", e);
			throw e;
		} finally {
			DB.closeResource(rs);
			DB.closeResource(s);
		}
	}
}
