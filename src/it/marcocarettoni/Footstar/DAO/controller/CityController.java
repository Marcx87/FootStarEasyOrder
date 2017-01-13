package it.marcocarettoni.Footstar.DAO.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.marcocarettoni.Footstar.DAO.DataPool.DB;
import it.marcocarettoni.Footstar.DAO.model.CityDAO;
import it.marcocarettoni.Footstar.xml.model.denominazioni.Data.Cities;
import it.marcocarettoni.Footstar.xml.model.denominazioni.Data.Cities.City;

public class CityController extends DAOController {

	public CityController() {
		super(CityController.class, CityDAO.table_name);
	}

	public void processData(Connection c, Cities lista, int language) throws SQLException {
		for (City row : lista.getCity()) {
			addRow(c, new CityDAO(row, language));
		}
	}

	private void addRow(Connection c, CityDAO city) throws SQLException {
		PreparedStatement s = null;
		try {
			s = c.prepareStatement(" INSERT INTO " + table_name + " ( " +
					" ID, IDL, ID_COUNTRY, DESCR " +
					" ) VALUES ( " +
					" ?, ?, ?, ? " +
					" ) ");

			int i = 1;

			s.setInt(i++, city.getID());
			s.setInt(i++, city.getIDL());
			s.setInt(i++, city.getID_COUNTRY());
			s.setString(i++, city.getDESCR());

			s.executeUpdate();
		} catch (SQLException e) {
			logger.error("addRow", e);
			throw e;
		} finally {
			DB.closeResource(s);
		}
	}

}
