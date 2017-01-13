package it.marcocarettoni.Footstar.DAO.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.marcocarettoni.Footstar.xml.model.player.Player.NationalTeams.Country;

public class PlayerNTDAO extends IDAO {

	public static final String table_name = "D_PLAYER_NT";

	private Integer playerId;
	private Short id;
	private Short caps;
	private Short capsSub21;
	private Short capsSub18;
	private Short goals;
	private Short goalsSub21;
	private Short goalsSub18;
	private Short assistsNt;

	public PlayerNTDAO() {
	}

	public PlayerNTDAO(ResultSet rs) throws SQLException {
		setByResultSet(rs);
	}

	public PlayerNTDAO(Integer _playerid, Country cy) {
		setByXML(_playerid, cy);
	}

	public void setByResultSet(ResultSet rs) throws SQLException {
		playerId = rs.getInt("playerId");
		id = rs.getShort("id");
		caps = rs.getShort("caps");
		capsSub21 = rs.getShort("capsSub21");
		capsSub18 = rs.getShort("capsSub18");
		goals = rs.getShort("goals");
		goalsSub21 = rs.getShort("goalsSub2");
		goalsSub18 = rs.getShort("goalsSub1");
		assistsNt = rs.getShort("assistsNt");
	}

	public void setByXML(Integer _playerid, Country cy) {
		playerId = _playerid;
		id = cy.getId();
		caps = cy.getCaps();
		capsSub21 = cy.getCapsSub21();
		capsSub18 = cy.getCapsSub18();
		goals = cy.getGoals();
		goalsSub21 = cy.getGoalsSub21();
		goalsSub18 = cy.getGoalsSub18();
		assistsNt = cy.getAssistsNt();
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public Short getCaps() {
		return caps;
	}

	public void setCaps(Short caps) {
		this.caps = caps;
	}

	public Short getCapsSub21() {
		return capsSub21;
	}

	public void setCapsSub21(Short capsSub21) {
		this.capsSub21 = capsSub21;
	}

	public Short getCapsSub18() {
		return capsSub18;
	}

	public void setCapsSub18(Short capsSub18) {
		this.capsSub18 = capsSub18;
	}

	public Short getGoals() {
		return goals;
	}

	public void setGoals(Short goals) {
		this.goals = goals;
	}

	public Short getGoalsSub21() {
		return goalsSub21;
	}

	public void setGoalsSub21(Short goalsSub21) {
		this.goalsSub21 = goalsSub21;
	}

	public Short getGoalsSub18() {
		return goalsSub18;
	}

	public void setGoalsSub18(Short goalsSub18) {
		this.goalsSub18 = goalsSub18;
	}

	public Short getAssistsNt() {
		return assistsNt;
	}

	public void setAssistsNt(Short assistsNt) {
		this.assistsNt = assistsNt;
	}

}
