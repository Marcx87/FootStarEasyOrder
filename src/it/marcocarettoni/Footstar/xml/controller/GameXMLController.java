package it.marcocarettoni.Footstar.xml.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.bind.JAXBElement;

import it.marcocarettoni.Footstar.DAO.model.DBDataDAO;
import it.marcocarettoni.Footstar.xml.model.IModelXML;
import it.marcocarettoni.Footstar.xml.model.game.Data;
import it.marcocarettoni.Footstar.xml.model.game.Data.Game;

public class GameXMLController extends XMLIController {

	private final String URL = "http://www.footstar.org/xml_feed.asp?type=4&username=Psycho87&password=tester&program_id=275&language=1&team_id=";

	public GameXMLController(Connection c, DBDataDAO dbData) {
		super(GameXMLController.class);
		lista = Collections.synchronizedList(new ArrayList<IModelXML>());

		idx = new AtomicInteger(dbData.getMIN_TEAM_ID());
		end = dbData.getMAX_TEAM_ID();
	}

	public void getSoapDati() {
		while (this.idx.get() <= end) {
			int idx = this.idx.getAndIncrement();
			try {
				logger.info("[" + Thread.currentThread().getId() + "] Get Soap Dati TeamFixtures: " + idx);
				String result = getSOAP(URL + idx);
				JAXBElement<?> parsed = parseSOAP(Data.class, result, idx);
				if (parsed != null) {
					Data dat_games = (Data) parsed.getValue();
					if (dat_games != null && dat_games.getGame() != null) {
						for (Game g : dat_games.getGame()) {
							lista.add(g);
						}
					}
				}

				if (idx == end)
					parsedToEnd = true;
			} catch (IOException ioe) {
				logger.error("IOException getTeamFixtures idTeam: " + idx, ioe);
			}
		}
	}
}
