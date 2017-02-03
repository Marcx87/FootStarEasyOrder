package it.marcocarettoni.Footstar.DAO.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.marcocarettoni.Footstar.xml.model.IModelXML;
import it.marcocarettoni.Footstar.xml.model.player.Player.Talents.Talent;

public class PlayerTalentsDAO extends IDAO {

	public static final String table_name = "D_PLAYER_TALENT";

	private Integer playerId;
	private Short id;

	public PlayerTalentsDAO() {
	}

	public PlayerTalentsDAO(ResultSet rs) throws SQLException {
		setByResultSet(rs);
	}

	public PlayerTalentsDAO(Talent cy, Integer _playerid) {
		setByXML(cy, _playerid);
	}

	public void setByResultSet(ResultSet rs) throws SQLException {
		playerId = rs.getInt("playerId");
		id = rs.getShort("id");
	}

	@Override
	protected void setByXML(IModelXML cyz) {}
	
	@Override
	protected void setByXML(IModelXML cyz, int _playerid) {
		Talent cy = (Talent) cyz;
		playerId = _playerid;
		id = cy.getId();
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

}
