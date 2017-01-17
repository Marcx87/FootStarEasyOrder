package it.marcocarettoni.Footstar.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import it.marcocarettoni.Footstar.DAO.DataPool.DB;
import it.marcocarettoni.Footstar.DAO.controller.DBDataController;
import it.marcocarettoni.Footstar.DAO.model.DBDataDAO;
import it.marcocarettoni.Footstar.xml.controller.PlayerXMLController;
import it.marcocarettoni.Footstar.xml.controller.ThreadController;

public class AggiornamentoController {

	public static void main(String[] args) {

	}

	public void aggiornaDatabase() {
		Connection c = null;
		try {
			c = DB.dbConnect();
			if (DB.setAutoCommit(c, false)) {

				//				emptyTables(c);
				//				
				//				new DenominazioniXMLController().parseDati(c, null);							
				//				DB.commit(c);
				//				
				DBDataDAO dbdata = new DBDataController().getRow();
				//				new GameXMLController().parseDati(c, dbdata);
				//				DB.commit(c);
				//				new TeamXMLController().parseDati(c, dbdata);

				PlayerXMLController pd = new PlayerXMLController(c, dbdata);

				ArrayList<ThreadController> liThr = new ArrayList<ThreadController>();
				for (int i = 0; i < 100; i++) {
					ThreadController th = new ThreadController(0, pd, null);
					th.start();
					liThr.add(th);
				}

				ThreadController th = new ThreadController(1, pd, c);
				th.start();
				liThr.add(th);

				for (ThreadController th1 : liThr)
					th1.join();

				System.out.println("Terminato Threading");
				DB.commit(c);
			}
			DB.commit(c);
		} catch (SQLException e) {
			DB.rollback(c);
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			DB.closeResource(c);
		}
	}
}
