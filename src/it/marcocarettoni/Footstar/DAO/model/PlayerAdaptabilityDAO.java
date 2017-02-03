package it.marcocarettoni.Footstar.DAO.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.marcocarettoni.Footstar.xml.model.IModelXML;
import it.marcocarettoni.Footstar.xml.model.player.Player.Adaptabilities.Adaptability;

public class PlayerAdaptabilityDAO extends IDAO {

	public static final String table_name = "D_PLAYER_ADAPT";

	private Integer playerId;
	private String value;
	private Integer country;
	private Short active;
	private Integer days;

	public PlayerAdaptabilityDAO() {
	}

	public PlayerAdaptabilityDAO(ResultSet rs) throws SQLException {
		setByResultSet(rs);
	}

	public PlayerAdaptabilityDAO(Adaptability cy, Integer _playerid) {
		setByXML(cy, _playerid);
	}

	public void setByResultSet(ResultSet rs) throws SQLException {
		playerId = rs.getInt("playerId");
		value = rs.getString("value");
		country = rs.getInt("country");
		active = rs.getShort("active");
		days = rs.getInt("days");
	}

	@Override
	protected void setByXML(IModelXML cyz) {
	}

	@Override
	protected void setByXML(IModelXML cyz, int _playerid) {
		Adaptability cy = (Adaptability) cyz;
		playerId = _playerid;
		value = cy.getValue();
		country = cy.getCountry();
		active = cy.getActive();
		days = cy.getDays();
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getCountry() {
		return country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	public Short getActive() {
		return active;
	}

	public void setActive(Short active) {
		this.active = active;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}
}
