package it.marcocarettoni.Footstar.DAO.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.marcocarettoni.Footstar.DAO.DataPool.DB;
import it.marcocarettoni.Footstar.DAO.model.SkillDAO;
import it.marcocarettoni.Footstar.xml.model.denominazioni.Data.MentalSkills;
import it.marcocarettoni.Footstar.xml.model.denominazioni.Data.MentalSkills.Skill;

public class SkillController extends DAOController {

	public SkillController() {
		super(SkillController.class, SkillDAO.table_name);
	}

	public void processData(Connection c, MentalSkills lista, int language) throws SQLException {
		for (Skill row : lista.getSkill()) {
			addRow(c, new SkillDAO(row, language));
		}
	}

	private void addRow(Connection c, SkillDAO city) throws SQLException {
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
