package it.marcocarettoni.Footstar.DAO.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.marcocarettoni.Footstar.DAO.DataPool.DB;
import it.marcocarettoni.Footstar.DAO.model.FutureDAO;
import it.marcocarettoni.Footstar.DAO.model.IModelDAO;
import it.marcocarettoni.Footstar.xml.model.denominazioni.Data.Future;
import it.marcocarettoni.Footstar.xml.model.denominazioni.Data.Future.Future2;

public class FutureController extends DAOController {

	public FutureController() {
		super(FutureController.class, FutureDAO.table_name);
	}

	public void processData(Connection c, Future lista, int language) throws SQLException {
		for (Future2 row : lista.getFuture()) {
			addRow(c, new FutureDAO(row, language));
		}
	}

	public void addRow(Connection c, IModelDAO ob) throws SQLException {
		FutureDAO city = (FutureDAO) ob;
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
