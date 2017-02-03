package it.marcocarettoni.Footstar.xml.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.bind.JAXBElement;

import it.marcocarettoni.Footstar.DAO.model.DBDataDAO;
import it.marcocarettoni.Footstar.xml.model.IModelXML;
import it.marcocarettoni.Footstar.xml.model.player.Player;

public class PlayerXMLController extends XMLIController {

	private final String URL = "http://www.footstar.org/xml_feed.asp?type=3&username=Psycho87&password=tester&program_id=275&language=1&player_id=";

	public PlayerXMLController(Connection c, DBDataDAO dbData) {
		super(PlayerXMLController.class);
		lista = Collections.synchronizedList(new ArrayList<IModelXML>());

		idx = new AtomicInteger(dbData.getMIN_PLAYER_ID());
		end = dbData.getMAX_PLAYER_ID();
	}

	public void getSoapDati() {
		while (this.idx.get() <= end) {
			int idx = this.idx.getAndIncrement();
			try {

				logger.info("[" + Thread.currentThread().getId() + "]Get Soap Dati PlayeriD: " + idx);
				String result = getSOAP(URL + idx);
				JAXBElement<?> parsed = parseSOAP(Player.class, result, idx);
				if (parsed != null)
					lista.add((Player) parsed.getValue());

				if (idx == end)
					parsedToEnd = true;
			} catch (IOException ioe) {
				logger.error("IOException getPlayerData PlayeriD: " + idx, ioe);
			}

		}
	}
}