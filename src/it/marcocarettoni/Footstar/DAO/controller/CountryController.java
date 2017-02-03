package it.marcocarettoni.Footstar.DAO.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.marcocarettoni.Footstar.DAO.DataPool.DB;
import it.marcocarettoni.Footstar.DAO.model.CountryDAO;
import it.marcocarettoni.Footstar.DAO.model.IModelDAO;
import it.marcocarettoni.Footstar.xml.model.denominazioni.Data.Countries;
import it.marcocarettoni.Footstar.xml.model.denominazioni.Data.Countries.Country;

public class CountryController extends DAOController {

	public CountryController() {
		super(CountryController.class, CountryDAO.table_name);
	}

	public void processData(Connection c, Countries lista, int language) throws SQLException {
		for (Country row : lista.getCountry()) {
			addRow(c, new CountryDAO(row, language));
		}
	}

	public void addRow(Connection c, IModelDAO ob) throws SQLException {
		CountryDAO city = (CountryDAO) ob;
		PreparedStatement s = null;
		try {
			s = c.prepareStatement(" INSERT INTO " + table_name + " ( " +
					" ID, IDL, NUM_DIV, DESCR " +
					" ) VALUES ( " +
					" ?, ?, ?, ? " +
					" ) ");

			int i = 1;

			s.setInt(i++, city.getID());
			s.setInt(i++, city.getIDL());
			s.setInt(i++, city.getNUM_DIV());
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
