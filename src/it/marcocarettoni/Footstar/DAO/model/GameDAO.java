package it.marcocarettoni.Footstar.DAO.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.marcocarettoni.Footstar.xml.model.game.Data.Game;

public class GameDAO {

	public static final String table_name = "D_GAME_TEAM";
	
    private long matchId;
    private String data_m;
    private int season;
    private int played;
    private String type;
    private int round;
    private String homeTeam;
    private int homeTeamId;
    private int homeCity;
    private String awayTeam;
    private int awayTeamId;
    private int awayCity;
    private int homeGoals;
    private int awayGoals;
	
	public GameDAO() {
	}

	public GameDAO(ResultSet rs) throws SQLException {
		setByResultSet(rs);
	}

	public GameDAO(Game cy) {
		setByXML(cy);
	}

	public void setByResultSet(ResultSet rs) throws SQLException {
		matchId = rs.getLong("matchId");
		data_m = rs.getString("data_m");
		season = rs.getInt("season");
		played = rs.getInt("played");
		type = rs.getString("type");
		round = rs.getInt("round");
		homeTeam = rs.getString("homeTeam");
		homeTeamId = rs.getInt("homeTeamId");
		homeCity = rs.getInt("homeCity");
		awayTeam = rs.getString("awayTeam");
		awayTeamId = rs.getInt("awayTeamId");
		awayCity = rs.getInt("awayCity");
		homeGoals = rs.getInt("homeGoals");
		awayGoals = rs.getInt("awayGoals");
	}

	public void setByXML(Game cy) {
		matchId = cy.getMatchId();
		data_m = cy.getDate();
		season = cy.getSeason();
		played = cy.getPlayed();
		type = cy.getType();
		round = cy.getRound();
		homeTeam = cy.getHomeTeam();
		homeTeamId = cy.getHomeTeamId();
		homeCity = cy.getHomeCity();
		awayTeam = cy.getAwayTeam();
		awayTeamId = cy.getAwayTeamId();
		awayCity = cy.getAwayCity();
		homeGoals = cy.getHomeGoals();
		awayGoals = cy.getAwayGoals();
	}


	public long getMatchId() {
		return matchId;
	}

	public void setMatchId(long matchId) {
		this.matchId = matchId;
	}

	public String getData_m() {
		return data_m;
	}

	public void setData_m(String date) {
		this.data_m = date;
	}

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public int getPlayed() {
		return played;
	}

	public void setPlayed(int played) {
		this.played = played;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public int getHomeTeamId() {
		return homeTeamId;
	}

	public void setHomeTeamId(int homeTeamId) {
		this.homeTeamId = homeTeamId;
	}

	public int getHomeCity() {
		return homeCity;
	}

	public void setHomeCity(int homeCity) {
		this.homeCity = homeCity;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}

	public int getAwayTeamId() {
		return awayTeamId;
	}

	public void setAwayTeamId(int awayTeamId) {
		this.awayTeamId = awayTeamId;
	}

	public int getAwayCity() {
		return awayCity;
	}

	public void setAwayCity(int awayCity) {
		this.awayCity = awayCity;
	}

	public int getHomeGoals() {
		return homeGoals;
	}

	public void setHomeGoals(int homeGoals) {
		this.homeGoals = homeGoals;
	}

	public int getAwayGoals() {
		return awayGoals;
	}

	public void setAwayGoals(int awayGoals) {
		this.awayGoals = awayGoals;
	}

}
