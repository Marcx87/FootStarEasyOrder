package it.marcocarettoni.Footstar.xml.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.bind.JAXBElement;

import it.marcocarettoni.Footstar.DAO.DataPool.DB;
import it.marcocarettoni.Footstar.DAO.controller.PlayerController;
import it.marcocarettoni.Footstar.DAO.model.DBDataDAO;
import it.marcocarettoni.Footstar.xml.model.player.Player;


public class PlayerXMLController extends XMLIController {

	public PlayerXMLController() {
		super(PlayerXMLController.class);
	}

	@Override
	protected void parseDati(Connection c, DBDataDAO dbData) throws SQLException {
		int inizio = dbData.getMIN_PLAYER_ID();
		int fine = dbData.getMAX_PLAYER_ID();
		
		PlayerController pc = new PlayerController();
		
		for (int i = inizio + 99 ; i <= fine ; i = (i+100>fine?fine+1:i + 100))
		{
			ArrayList<Player> lista = getSoapDati(i-99, i);
			logger.debug("Processing PlayerData");
			pc.processData(c, lista);
			DB.commit(c);
		}
	}

	private ArrayList<Player> getSoapDati(int start, int end) {
		ArrayList<Player> lista = new ArrayList<Player>();
		logger.debug("Init getTeamData");
		for (int i = start; i <= end; i++) {
			try {
				logger.debug("getTeamData - idTeam: " + i);
				String result = getSOAP("http://www.footstar.org/xml_feed.asp?type=2&username=Psycho87&password=tester&program_id=275&language=1&team_id=" + i);
				JAXBElement<?> parsed = parseSOAP(Player.class, result, i);
				if (parsed != null)
					lista.add((Player) parsed.getValue());
			} catch (IOException ioe) {
				logger.error("IOException getTeamData idTeam: " + i, ioe);
			}
		}
		return lista;
	}

}
