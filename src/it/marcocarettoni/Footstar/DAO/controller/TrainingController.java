package it.marcocarettoni.Footstar.DAO.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.marcocarettoni.Footstar.DAO.DataPool.DB;
import it.marcocarettoni.Footstar.DAO.model.IModelDAO;
import it.marcocarettoni.Footstar.DAO.model.TrainingDAO;
import it.marcocarettoni.Footstar.xml.model.denominazioni.Data.Trainings;
import it.marcocarettoni.Footstar.xml.model.denominazioni.Data.Trainings.TrainingItem;

public class TrainingController extends DAOController {

	public TrainingController() {
		super(TrainingController.class, TrainingDAO.table_name);
	}

	public void processData(Connection c, Trainings lista, int language) throws SQLException {
		for (TrainingItem row : lista.getTrainingItem()) {
			addRow(c, new TrainingDAO(row, language));
		}
	}

	public void addRow(Connection c, IModelDAO ob) throws SQLException {
		TrainingDAO city = (TrainingDAO) ob;
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
