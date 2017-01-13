package it.marcocarettoni.Footstar.DAO.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.marcocarettoni.Footstar.DAO.DataPool.DB;
import it.marcocarettoni.Footstar.DAO.model.SideDAO;
import it.marcocarettoni.Footstar.xml.model.denominazioni.Data.Sides;
import it.marcocarettoni.Footstar.xml.model.denominazioni.Data.Sides.Side;

public class SideController extends DAOController {

	public SideController() {
		super(SideController.class, SideDAO.table_name);
	}

	public void processData(Connection c, Sides lista, int language) throws SQLException {
		for (Side row : lista.getSide()) {
			addRow(c, new SideDAO(row, language));
		}
	}

	private void addRow(Connection c, SideDAO city) throws SQLException {
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
