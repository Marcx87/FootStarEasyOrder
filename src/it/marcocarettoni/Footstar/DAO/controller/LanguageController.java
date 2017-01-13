package it.marcocarettoni.Footstar.DAO.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.marcocarettoni.Footstar.DAO.DataPool.DB;
import it.marcocarettoni.Footstar.DAO.model.LanguageDAO;
import it.marcocarettoni.Footstar.xml.model.denominazioni.Data.Languages;
import it.marcocarettoni.Footstar.xml.model.denominazioni.Data.Languages.LanguageItem;

public class LanguageController extends DAOController {

	public LanguageController() {
		super(LanguageController.class, LanguageDAO.table_name);
	}

	public void processData(Connection c, Languages lista, int language) throws SQLException {
		for (LanguageItem row : lista.getLanguageItem()) {
			addRow(c, new LanguageDAO(row, language));
		}
	}

	private void addRow(Connection c, LanguageDAO city) throws SQLException {
		PreparedStatement s = null;
		try {
			s = c.prepareStatement(" INSERT INTO " + table_name + " ( " +
					" ID, IDL, DESCR " +
					" ) VALUES ( " +
					" ?, ?, ? " +
					" ) ");

			int i = 1;

			s.setInt(i++, city.getID());
			s.setInt(i++, city.getIDL());
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
