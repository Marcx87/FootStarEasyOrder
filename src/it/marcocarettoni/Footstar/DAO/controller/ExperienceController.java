package it.marcocarettoni.Footstar.DAO.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.marcocarettoni.Footstar.DAO.DataPool.DB;
import it.marcocarettoni.Footstar.DAO.model.ExperienceDAO;
import it.marcocarettoni.Footstar.xml.model.denominazioni.Data.PlayerExperience;
import it.marcocarettoni.Footstar.xml.model.denominazioni.Data.PlayerExperience.ExpItem;

public class ExperienceController extends DAOController {

	public ExperienceController() {
		super(ExperienceController.class, ExperienceDAO.table_name);
	}

	public void processData(Connection c, PlayerExperience lista, int language) throws SQLException {
		for (ExpItem row : lista.getExpItem()) {
			addRow(c, new ExperienceDAO(row, language));
		}
	}

	private void addRow(Connection c, ExperienceDAO city) throws SQLException {
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
