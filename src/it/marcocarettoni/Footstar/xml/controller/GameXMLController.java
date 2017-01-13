package it.marcocarettoni.Footstar.xml.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.bind.JAXBElement;

import it.marcocarettoni.Footstar.DAO.DataPool.DB;
import it.marcocarettoni.Footstar.DAO.controller.GameController;
import it.marcocarettoni.Footstar.DAO.model.DBDataDAO;
import it.marcocarettoni.Footstar.xml.model.game.Data;

public class GameXMLController extends XMLIController {

	public GameXMLController() {
		super(GameXMLController.class);
	}

	@Override
	protected void parseDati(Connection c, DBDataDAO dbData) throws SQLException {
		int inizio = dbData.getMIN_TEAM_ID();
		int fine = dbData.getMAX_TEAM_ID();
		
		GameController gc = new GameController();
		
		for (int i = inizio+99 ; i <= fine ; i = (i+100>fine?fine+1:i + 100))
		{
			ArrayList<Data> lista = getSoapDati(i-100, i);
			logger.debug("Processing TeamFixtures");
			gc.processData(c, lista);
			DB.commit(c);
		}
	}

	private ArrayList<Data> getSoapDati(int start, int end) {
		ArrayList<Data> lista = new ArrayList<Data>();
		logger.debug("Init getTeamFixtures");
		for (int i = start; i <= end; i++) {
			try {
				logger.debug("getTeamFixtures - idTeam: " + i);
				String result = getSOAP("http://www.footstar.org/xml_feed.asp?type=4&username=Psycho87&password=tester&program_id=275&language=1&team_id=" + i);
				JAXBElement<?> parsed = parseSOAP(Data.class, result, i);
				if (parsed != null)
					lista.add((Data) parsed.getValue());
			} catch (IOException ioe) {
				logger.error("IOException getTeamFixtures idTeam: " + i, ioe);
			}
		}
		return lista;
	}

}
