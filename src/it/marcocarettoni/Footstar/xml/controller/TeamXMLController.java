package it.marcocarettoni.Footstar.xml.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.bind.JAXBElement;

import it.marcocarettoni.Footstar.DAO.DataPool.DB;
import it.marcocarettoni.Footstar.DAO.controller.TeamController;
import it.marcocarettoni.Footstar.DAO.model.DBDataDAO;
import it.marcocarettoni.Footstar.xml.model.team.TeamData;


public class TeamXMLController extends XMLIController {

	public TeamXMLController() {
		super(TeamXMLController.class);
	}

	protected void parseDati(Connection c, DBDataDAO dbData) throws SQLException {
		int inizio = 2601; //dbData.getMIN_TEAM_ID();
		int fine = dbData.getMAX_TEAM_ID();
		
		TeamController tc = new TeamController();
		
		for (int i = inizio + 99 ; i <= fine ; i = (i+100>fine?fine+1:i + 100))
		{
			ArrayList<TeamData> lista = getSoapDati(i-99, i);
			logger.debug("Processing TeamData");
			tc.processData(c, lista);
			DB.commit(c);
		}
	}

	private ArrayList<TeamData> getSoapDati(int start, int end) {
		ArrayList<TeamData> lista = new ArrayList<TeamData>();
		logger.debug("Init getTeamData");
		for (int i = start; i <= end; i++) {
			try {
				logger.debug("getTeamData - idTeam: " + i);
				String result = getSOAP("http://www.footstar.org/xml_feed.asp?type=2&username=Psycho87&password=tester&program_id=275&language=1&team_id=" + i);
				JAXBElement<?> parsed = parseSOAP(TeamData.class, result, i);
				if (parsed != null)
					lista.add((TeamData) parsed.getValue());
			} catch (IOException ioe) {
				logger.error("IOException getTeamData idTeam: " + i, ioe);
			}
		}
		return lista;
	}

}
