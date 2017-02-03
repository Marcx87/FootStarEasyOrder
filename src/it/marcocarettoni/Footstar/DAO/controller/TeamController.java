package it.marcocarettoni.Footstar.DAO.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.marcocarettoni.Footstar.DAO.DataPool.DB;
import it.marcocarettoni.Footstar.DAO.model.IModelDAO;
import it.marcocarettoni.Footstar.DAO.model.TeamDAO;

public class TeamController extends DAOController {

	public TeamController() {
		super(TeamController.class, TeamDAO.table_name);
	}

	public void addRow(Connection c, IModelDAO obj) throws SQLException {
		TeamDAO ob = (TeamDAO) obj;
		PreparedStatement s = null;
		try {
			s = c.prepareStatement(" INSERT INTO " + table_name + " ( " +
					" team_userid, team_playerid, team_useralias, team_id, b_team, " +
					" main_team_id, team_name, team_long_name, team_country_id, team_city, " +
					" stadium_name, stadium_north, stadium_south, stadium_east, stadium_west, " +
					" stadium_neast, stadium_nwest, stadium_seast, stadium_swest, supporters, " +
					" average_attendance, division, series, position, games_without_winning, " +
					" games_without_losing, wins_in_a_row, draws_in_a_row, losts_in_a_row, last_game, " +
					" last_game_type, wt_Monday1, wt_Monday2, wt_Monday3, wt_Tuesday1, " +
					" wt_Tuesday2, wt_Tuesday3, wt_Wednesday1, wt_Wednesday2, wt_Wednesday3, " +
					" wt_Thursday1, wt_Thursday2, wt_Thursday3, wt_Friday1, wt_Friday2, " +
					" wt_Friday3, wt_Saturday1, wt_Saturday2, wt_Saturday3, wt_Sunday1, " +
					" wt_Sunday2, wt_Sunday3, wt_last_changed " +
					" ) VALUES ( " +
					" ?, ?, ?, ?, ?, " +
					" ?, ?, ?, ?, ?, " +
					" ?, ?, ?, ?, ?, " +
					" ?, ?, ?, ?, ?, " +
					" ?, ?, ?, ?, ?, " +
					" ?, ?, ?, ?, ?, " +
					" ?, ?, ?, ?, ?, " +
					" ?, ?, ?, ?, ?, " +
					" ?, ?, ?, ?, ?, " +
					" ?, ?, ?, ?, ?, " +
					" ?, ?, ? " +
					" ) ");

			int i = 1;

			s.setInt(i++, ob.getTeam_userid());
			s.setInt(i++, ob.getTeam_playerid());
			s.setString(i++, ob.getTeam_useralias());
			s.setInt(i++, ob.getTeam_id());
			s.setInt(i++, ob.getB_team());
			s.setInt(i++, ob.getMain_team_id());
			s.setString(i++, ob.getTeam_name());
			s.setString(i++, ob.getTeam_long_name());
			s.setInt(i++, ob.getTeam_country_id());
			s.setInt(i++, ob.getTeam_city());
			s.setString(i++, ob.getStadium_name());
			s.setInt(i++, ob.getStadium_north());
			s.setInt(i++, ob.getStadium_south());
			s.setInt(i++, ob.getStadium_east());
			s.setInt(i++, ob.getStadium_west());
			s.setInt(i++, ob.getStadium_neast());
			s.setInt(i++, ob.getStadium_nwest());
			s.setInt(i++, ob.getStadium_seast());
			s.setInt(i++, ob.getStadium_swest());
			s.setInt(i++, ob.getSupporters());
			s.setInt(i++, ob.getAverage_attendance());
			s.setInt(i++, ob.getDivision());
			s.setInt(i++, ob.getSeries());
			s.setInt(i++, ob.getPosition());
			s.setInt(i++, ob.getGames_without_winning());
			s.setInt(i++, ob.getGames_without_losing());
			s.setInt(i++, ob.getWins_in_a_row());
			s.setInt(i++, ob.getDraws_in_a_row());
			s.setInt(i++, ob.getLosts_in_a_row());
			s.setLong(i++, ob.getLast_game());
			s.setInt(i++, ob.getLast_game_type());
			s.setInt(i++, ob.getWt_Monday1());
			s.setInt(i++, ob.getWt_Monday2());
			s.setInt(i++, ob.getWt_Monday3());
			s.setInt(i++, ob.getWt_Tuesday1());
			s.setInt(i++, ob.getWt_Tuesday2());
			s.setInt(i++, ob.getWt_Tuesday3());
			s.setInt(i++, ob.getWt_Wednesday1());
			s.setInt(i++, ob.getWt_Wednesday2());
			s.setInt(i++, ob.getWt_Wednesday3());
			s.setInt(i++, ob.getWt_Thursday1());
			s.setInt(i++, ob.getWt_Thursday2());
			s.setInt(i++, ob.getWt_Thursday3());
			s.setInt(i++, ob.getWt_Friday1());
			s.setInt(i++, ob.getWt_Friday2());
			s.setInt(i++, ob.getWt_Friday3());
			s.setInt(i++, ob.getWt_Saturday1());
			s.setInt(i++, ob.getWt_Saturday2());
			s.setInt(i++, ob.getWt_Saturday3());
			s.setInt(i++, ob.getWt_Sunday1());
			s.setInt(i++, ob.getWt_Sunday2());
			s.setInt(i++, ob.getWt_Sunday3());
			s.setString(i++, ob.getWt_last_changed());

			s.executeUpdate();
		} catch (SQLException e) {
			logger.error("addRow", e);
			throw e;
		} finally {
			DB.closeResource(s);
		}
	}

}
