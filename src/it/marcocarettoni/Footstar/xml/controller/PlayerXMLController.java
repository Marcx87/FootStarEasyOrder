package it.marcocarettoni.Footstar.xml.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.bind.JAXBElement;

import it.marcocarettoni.Footstar.DAO.DataPool.DB;
import it.marcocarettoni.Footstar.DAO.controller.PlayerController;
import it.marcocarettoni.Footstar.DAO.model.DBDataDAO;
import it.marcocarettoni.Footstar.DAO.model.PlayerDAO;
import it.marcocarettoni.Footstar.xml.model.player.Player;

public class PlayerXMLController extends XMLIController {

	public AtomicInteger idx;
	public boolean parsedToEnd = false;
	public int end;
	public List<Player> lista;
	
	public PlayerXMLController(Connection c, DBDataDAO dbData) {
		super(PlayerXMLController.class);
		lista = Collections.synchronizedList(new ArrayList<Player>());
		
		idx = new AtomicInteger(dbData.getMIN_PLAYER_ID());
		end = dbData.getMAX_PLAYER_ID();
	}

	protected void getSoapDati() {
		
		logger.info("Init Get Soap Dati Player");
		logger.debug("Init getPlayerData");
		while (this.idx.get() <= end)
		{
			int idx = this.idx.getAndIncrement();
			try {
				
				logger.info("[" + Thread.currentThread().getId() + "]Get Soap Dati PlayeriD: " + idx);
				logger.debug("getPlayerData - idPlayer: " + idx);
				String result = getSOAP(
						"http://www.footstar.org/xml_feed.asp?type=3&username=Psycho87&password=tester&program_id=275&language=1&player_id=" + idx);
				JAXBElement<?> parsed = parseSOAP(Player.class, result, idx);
				if (parsed != null)
					lista.add((Player) parsed.getValue());			
				
				if (idx == end)
					parsedToEnd = true;
			} catch (IOException ioe) {
				logger.error("IOException getTeamData idTeam: " + idx, ioe);
			}
			
		}
	}
	
	protected void processDB(Connection c)
	{
		PlayerController pc = new PlayerController(); 
		int i = 0;
		while (!parsedToEnd || lista.size() > 0){
			try {
				if (lista.size() > 0)
				{
					PlayerDAO pdao = new PlayerDAO(lista.remove(0));
					pc.addRow(c, pdao);
					logger.info("[" + Thread.currentThread().getId() + "]Adding PlayeriD: " + pdao.getPlayerId());
					i++;
					if (i % 1000 == 0)
					{
						logger.info("Committing 1000 players");
						logger.info("Committing 1000 players");
						logger.info("Committing 1000 players");
						logger.info("Committing 1000 players");
						logger.info("Committing 1000 players");
						logger.info("Committing 1000 players");
						logger.info("Committing 1000 players");
						DB.commit(c);
					}
				}
				else
					Thread.sleep(1000);
			} catch (SQLException e) {			
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}