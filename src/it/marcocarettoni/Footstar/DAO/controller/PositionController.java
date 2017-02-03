package it.marcocarettoni.Footstar.DAO.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.marcocarettoni.Footstar.DAO.DataPool.DB;
import it.marcocarettoni.Footstar.DAO.model.IModelDAO;
import it.marcocarettoni.Footstar.DAO.model.PositionDAO;
import it.marcocarettoni.Footstar.xml.model.denominazioni.Data.Positions;
import it.marcocarettoni.Footstar.xml.model.denominazioni.Data.Positions.Position;

public class PositionController extends DAOController {

	public PositionController() {
		super(PositionController.class, PositionDAO.table_name);
	}

	public void processData(Connection c, Positions lista, int language) throws SQLException {
		for (Position row : lista.getPosition()) {
			addRow(c, new PositionDAO(row, language));
		}
	}

	public void addRow(Connection c, IModelDAO ob) throws SQLException {
		PositionDAO city = (PositionDAO) ob;
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
