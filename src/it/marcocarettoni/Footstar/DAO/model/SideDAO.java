package it.marcocarettoni.Footstar.DAO.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.marcocarettoni.Footstar.xml.model.denominazioni.Data.Sides.Side;

public class SideDAO extends IDAO {

	public static final String table_name = "D_SIDE";

	private int ID;
	private int IDL;
	private String DESCR;

	public SideDAO() {
	}

	public SideDAO(ResultSet rs) throws SQLException {
		setByResultSet(rs);
	}
	
	public SideDAO(Side cy, int language) {
		setByXML(cy, language);
	}

	public void setByResultSet(ResultSet rs) throws SQLException {
		ID = rs.getInt("ID");
		IDL = rs.getInt("IDL");
		DESCR = rs.getString("DESCR");
	}

	public void setByXML(Side cy, int language) {
		ID = cy.getId();
		IDL = language;
		DESCR = cy.getValue();
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getIDL() {
		return IDL;
	}

	public void setIDL(int iDL) {
		IDL = iDL;
	}

	public String getDESCR() {
		return DESCR;
	}

	public void setDESCR(String dESCR) {
		DESCR = dESCR;
	}

}
