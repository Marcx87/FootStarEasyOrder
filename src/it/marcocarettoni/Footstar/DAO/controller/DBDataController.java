package it.marcocarettoni.Footstar.DAO.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.marcocarettoni.Footstar.DAO.DataPool.DB;
import it.marcocarettoni.Footstar.DAO.model.DBDataDAO;
import it.marcocarettoni.Footstar.DAO.model.IModelDAO;
import it.marcocarettoni.Footstar.xml.model.denominazioni.Data.DatabaseData;

public class DBDataController extends DAOController {

	public DBDataController() {
		super(DBDataController.class, DBDataDAO.table_name);
	}

	public void processData(Connection c, DatabaseData lista, int language) throws SQLException {
		addRow(c, new DBDataDAO(lista, language));
	}
	
	public DBDataDAO getRow() throws SQLException
	{
		Connection c = null;		
		PreparedStatement s = null;
		ResultSet rs = null;
		try {
			c = DB.dbConnect();
			s = c.prepareStatement("SELECT * FROM " + table_name + 
					" where rownum < 2 ");

			rs = s.executeQuery();
			if (rs.next())
			{
				return new DBDataDAO(rs);
			}			
		} catch (SQLException e) {
			logger.error("getRow", e);
			throw e;
		} finally {
			DB.closeResource(rs);
			DB.closeResource(s);
			DB.closeResource(c);
		}
		throw new SQLException("No DBData Configuration found!");
	}

	public void addRow(Connection c, IModelDAO ob) throws SQLException {
		DBDataDAO city = (DBDataDAO) ob;
		PreparedStatement s = null;
		try {
			s = c.prepareStatement(" INSERT INTO " + table_name + " ( " +
					" MIN_PLAYER_ID, MAX_PLAYER_ID, MIN_TEAM_ID, MAX_TEAM_ID, IDL " +
					" ) VALUES ( " +
					" ?, ?, ?, ?, ? " +
					" ) ");

			int i = 1;

			s.setInt(i++, city.getMIN_PLAYER_ID());
			s.setInt(i++, city.getMAX_PLAYER_ID());
			s.setInt(i++, city.getMIN_TEAM_ID());
			s.setInt(i++, city.getMAX_TEAM_ID());
			s.setInt(i++, city.getIDL());

			s.executeUpdate();
		} catch (SQLException e) {
			logger.error("addRow", e);
			throw e;
		} finally {
			DB.closeResource(s);
		}
	}

}
