package it.marcocarettoni.Footstar.DAO.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.marcocarettoni.Footstar.xml.model.denominazioni.Data.DatabaseData;

public class DBDataDAO extends IDAO {

	public static final String table_name = "D_DBDATA";

	private int MIN_PLAYER_ID;
	private int MAX_PLAYER_ID;
	private int MIN_TEAM_ID;
	private int MAX_TEAM_ID;
	private int IDL;

	public DBDataDAO() {
	}

	public DBDataDAO(ResultSet rs) throws SQLException {
		setByResultSet(rs);
	}

	public DBDataDAO(DatabaseData cy, int language) {
		setByXML(cy, language);
	}

	public void setByResultSet(ResultSet rs) throws SQLException {
		MIN_PLAYER_ID = rs.getInt("MIN_PLAYER_ID");
		MAX_PLAYER_ID = rs.getInt("MAX_PLAYER_ID");
		MIN_TEAM_ID = rs.getInt("MIN_TEAM_ID");
		MAX_TEAM_ID = rs.getInt("MAX_TEAM_ID");
		IDL = rs.getInt("IDL");
	}

	public void setByXML(DatabaseData cy, int language) {
		MIN_PLAYER_ID = cy.getMinPlayerId();
		MAX_PLAYER_ID = cy.getMaxPlayerId();
		MIN_TEAM_ID = cy.getMinTeamId();
		MAX_TEAM_ID = cy.getMaxTeamId();
		IDL = language;
	}

	public int getMIN_PLAYER_ID() {
		return MIN_PLAYER_ID;
	}

	public void setMIN_PLAYER_ID(int mIN_PLAYER_ID) {
		MIN_PLAYER_ID = mIN_PLAYER_ID;
	}

	public int getMAX_PLAYER_ID() {
		return MAX_PLAYER_ID;
	}

	public void setMAX_PLAYER_ID(int mAX_PLAYER_ID) {
		MAX_PLAYER_ID = mAX_PLAYER_ID;
	}

	public int getMIN_TEAM_ID() {
		return MIN_TEAM_ID;
	}

	public void setMIN_TEAM_ID(int mIN_TEAM_ID) {
		MIN_TEAM_ID = mIN_TEAM_ID;
	}

	public int getMAX_TEAM_ID() {
		return MAX_TEAM_ID;
	}

	public void setMAX_TEAM_ID(int mAX_TEAM_ID) {
		MAX_TEAM_ID = mAX_TEAM_ID;
	}

	public int getIDL() {
		return IDL;
	}

	public void setIDL(int iDL) {
		IDL = iDL;
	}

}
