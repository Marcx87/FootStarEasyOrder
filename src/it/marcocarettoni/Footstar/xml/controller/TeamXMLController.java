package it.marcocarettoni.Footstar.xml.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.bind.JAXBElement;

import it.marcocarettoni.Footstar.DAO.model.DBDataDAO;
import it.marcocarettoni.Footstar.xml.model.IModelXML;
import it.marcocarettoni.Footstar.xml.model.team.TeamData;

public class TeamXMLController extends XMLIController {

	private final String URL = "http://www.footstar.org/xml_feed.asp?type=2&username=Psycho87&password=tester&program_id=275&language=1&team_id=";

	public TeamXMLController(Connection c, DBDataDAO dbData) {
		super(TeamXMLController.class);
		lista = Collections.synchronizedList(new ArrayList<IModelXML>());
		
		idx = new AtomicInteger(dbData.getMIN_TEAM_ID());
		end = dbData.getMAX_TEAM_ID();
	}

	public void getSoapDati() {
		while (this.idx.get() <= end) {
			int idx = this.idx.getAndIncrement();
			try {
				logger.info("[" + Thread.currentThread().getId() + "] Get Soap Dati TeamData: " + idx);
				String result = getSOAP(URL + idx);
				JAXBElement<?> parsed = parseSOAP(TeamData.class, result, idx);
				if (parsed != null) {
					TeamData team = (TeamData) parsed.getValue();
					if (team != null && team != null) {
						lista.add(team);
					}
				}

				if (idx == end)
					parsedToEnd = true;
			} catch (IOException ioe) {
				logger.error("IOException getTeamData idTeam: " + idx, ioe);
			}
		}
	}
}
