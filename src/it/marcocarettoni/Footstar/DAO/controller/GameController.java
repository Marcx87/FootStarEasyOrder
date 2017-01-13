package it.marcocarettoni.Footstar.DAO.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;

import it.marcocarettoni.Footstar.DAO.DataPool.DB;
import it.marcocarettoni.Footstar.DAO.model.GameDAO;
import it.marcocarettoni.Footstar.xml.model.game.Data;
import it.marcocarettoni.Footstar.xml.model.game.Data.Game;

public class GameController extends DAOController {

	private HashSet<Long> aggiunti = null;
	
	public GameController() {
		super(GameController.class, GameDAO.table_name);
		aggiunti = new HashSet<Long>();
	}

	
	public void processData(Connection c, List<Data> lista) throws SQLException {
		
		for (int i = 0; i < lista.size(); i++) {
			logger.debug("Processing Match - Team : " + (i + 1));
			for (Game row : lista.get(i).getGame()) {			
				if (!aggiunti.contains(row.getMatchId())) {
					logger.debug("Inserito MatchID: " + row.getMatchId());
					addRow(c, new GameDAO(row));
					aggiunti.add(row.getMatchId());
				} else {
					logger.debug("Game gia inserito MatchID: " + row.getMatchId());
				}
			}
		}
	}

	private void addRow(Connection c, GameDAO ob) throws SQLException {
		PreparedStatement s = null;
		try {
			s = c.prepareStatement(" INSERT INTO " + table_name + " ( " +
					" matchId, data_m, season, played, type, " +
					" round, homeTeam, homeTeamId, homeCity, awayTeam, " +
					" awayTeamId, awayCity, homeGoals, awayGoals " +
					" ) VALUES ( " +
					" ?, ?, ?, ?, ?, " +
					" ?, ?, ?, ?, ?, " +
					" ?, ?, ?, ? " +
					" ) ");

			int i = 1;

			s.setLong(i++, ob.getMatchId());
			s.setString(i++, ob.getData_m());
			s.setInt(i++, ob.getSeason());
			s.setInt(i++, ob.getPlayed());
			s.setString(i++, ob.getType()); // 5 
			s.setInt(i++, ob.getRound());
			s.setString(i++, ob.getHomeTeam());
			s.setInt(i++, ob.getHomeTeamId());
			s.setInt(i++, ob.getHomeCity());
			s.setString(i++, ob.getAwayTeam()); // 10
			s.setInt(i++, ob.getAwayTeamId());
			s.setInt(i++, ob.getAwayCity());
			s.setInt(i++, ob.getHomeGoals());
			s.setInt(i++, ob.getAwayGoals()); // 14

			s.executeUpdate();
		} catch (SQLException e) {
			logger.error("addRow", e);
			throw e;
		} finally {
			DB.closeResource(s);
		}
	}

}
