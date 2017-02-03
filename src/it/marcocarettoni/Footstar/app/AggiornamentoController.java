package it.marcocarettoni.Footstar.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import it.marcocarettoni.Footstar.DAO.DataPool.DB;
import it.marcocarettoni.Footstar.DAO.controller.DBDataController;
import it.marcocarettoni.Footstar.DAO.controller.GameController;
import it.marcocarettoni.Footstar.DAO.controller.IDBController;
import it.marcocarettoni.Footstar.DAO.controller.PlayerController;
import it.marcocarettoni.Footstar.DAO.controller.TeamController;
import it.marcocarettoni.Footstar.DAO.model.DBDataDAO;
import it.marcocarettoni.Footstar.DAO.model.GameDAO;
import it.marcocarettoni.Footstar.DAO.model.PlayerDAO;
import it.marcocarettoni.Footstar.DAO.model.TeamDAO;
import it.marcocarettoni.Footstar.xml.controller.GameXMLController;
import it.marcocarettoni.Footstar.xml.controller.PlayerXMLController;
import it.marcocarettoni.Footstar.xml.controller.TeamXMLController;
import it.marcocarettoni.Footstar.xml.controller.XMLIController;

public class AggiornamentoController {

	private Logger logger = Logger.getLogger(AggiornamentoController.class);
	
	public static void main(String[] args) {
		new AggiornamentoController().aggiornaDatabase();
	}

	public void aggiornaDatabase() {
		Connection c = null;
		try {
			c = DB.dbConnect();
			if (DB.setAutoCommit(c, false)) {

//				XMLIController.emptyTables(c);
//				
//				DB.commit(c);
//				
//				DenominazioniXMLController dc = new DenominazioniXMLController();
//				dc.getSoapDati();			
//				dc.parseDati(c, null);
//					
//				DB.commit(c);
				
				DBDataDAO dbdata = new DBDataController().getRow();
				
//				aggiornaDatiThread(new GameXMLController(c, dbdata), new GameController(), GameDAO.class, c, "Game");
//				DB.commit(c);
//				aggiornaDatiThread(new TeamXMLController(c, dbdata), new TeamController(), TeamDAO.class, c, "Team");
//				DB.commit(c);
				aggiornaDatiThread(new PlayerXMLController(c, dbdata), new PlayerController(), PlayerDAO.class, c, "Player");

				System.out.println("Terminato Threading Totale");
			}
			DB.commit(c);
		} catch (SQLException e) {
			DB.rollback(c);
			logger.error("aggiornaDatabase SQLException", e);
		} catch (InterruptedException e) {
			DB.rollback(c);
			logger.error("aggiornaDatabase InterruptedException", e);
		} finally {
			DB.closeResource(c);
		}
	}
	
	private void aggiornaDatiThread(XMLIController xmlC, IDBController dbC, Class<?> imodel, Connection c, String typeObject) throws InterruptedException
	{
		logger.debug("Inizio Threading " + typeObject);
		ArrayList<ThreadController> liThr = new ArrayList<ThreadController>();
		for (int i = 0; i < 100; i++) {
			ThreadController th = new ThreadController(xmlC, dbC, imodel, 0, c, typeObject);
			th.start();
			liThr.add(th);
		}

		ThreadController th = new ThreadController(xmlC, dbC, imodel, 1, c, typeObject);
		th.start();
		liThr.add(th);

		for (ThreadController th1 : liThr)
			th1.join();
		
		logger.debug("Terminato Threading " + typeObject);
	}
}
