package it.marcocarettoni.Footstar.DAO.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.marcocarettoni.Footstar.DAO.DataPool.DB;
import it.marcocarettoni.Footstar.DAO.model.GameDAO;
import it.marcocarettoni.Footstar.DAO.model.IModelDAO;

public class GameController extends DAOController implements IDBController {

	public GameController() {
		super(GameController.class, GameDAO.table_name);
	}

	public void addRow(Connection c, IModelDAO ob) throws SQLException {
		GameDAO gd = (GameDAO) ob;
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

			s.setLong(i++, gd.getMatchId());
			s.setString(i++, gd.getData_m());
			s.setInt(i++, gd.getSeason());
			s.setInt(i++, gd.getPlayed());
			s.setString(i++, gd.getType()); // 5 
			s.setInt(i++, gd.getRound());
			s.setString(i++, gd.getHomeTeam());
			s.setInt(i++, gd.getHomeTeamId());
			s.setInt(i++, gd.getHomeCity());
			s.setString(i++, gd.getAwayTeam()); // 10
			s.setInt(i++, gd.getAwayTeamId());
			s.setInt(i++, gd.getAwayCity());
			s.setInt(i++, gd.getHomeGoals());
			s.setInt(i++, gd.getAwayGoals()); // 14

			s.executeUpdate();
		} catch (SQLException e) {
			logger.error("addRow", e);
			throw e;
		} finally {
			DB.closeResource(s);
		}
	}

}
