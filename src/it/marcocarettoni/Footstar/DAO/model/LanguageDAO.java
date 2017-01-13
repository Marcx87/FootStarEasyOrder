package it.marcocarettoni.Footstar.DAO.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.marcocarettoni.Footstar.xml.model.denominazioni.Data.Languages.LanguageItem;

public class LanguageDAO extends IDAO {

	public static final String table_name = "D_LANGUAGE";

	private int ID;
	private int IDL;
	private String DESCR;

	public LanguageDAO() {
	}

	public LanguageDAO(ResultSet rs) throws SQLException {
		setByResultSet(rs);
	}

	public LanguageDAO(LanguageItem cy, int language) {
		setByXML(cy, language);
	}
	
	public void setByResultSet(ResultSet rs) throws SQLException {
		ID = rs.getInt("ID");
		IDL = rs.getInt("IDL");
		DESCR = rs.getString("DESCR");
	}
	
	public void setByXML(LanguageItem cy, int language) {
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
