package it.marcocarettoni.Footstar.DAO.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.marcocarettoni.Footstar.xml.model.denominazioni.Data.Cities.City;

public class CityDAO extends IDAO {
	
	public static final String table_name = "D_CITY";
	
	private int ID;
	private int IDL;
	private int ID_COUNTRY;
	private String DESCR;

	public CityDAO() {
	}

	public CityDAO(ResultSet rs) throws SQLException {
		setByResultSet(rs);
	}
	
	public CityDAO(City cy, int language) {
		setByXML(cy, language);
	}

	public void setByResultSet(ResultSet rs) throws SQLException {
		ID = rs.getInt("ID");
		IDL = rs.getInt("IDL");
		ID_COUNTRY = rs.getInt("ID_COUNTRY");
		DESCR = rs.getString("DESCR");
	}
	
	public void setByXML(City cy, int language) {		
		ID = cy.getId();
		IDL = language;
		ID_COUNTRY = cy.getCountryId();
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

	public int getID_COUNTRY() {
		return ID_COUNTRY;
	}

	public void setID_COUNTRY(int iD_COUNTRY) {
		ID_COUNTRY = iD_COUNTRY;
	}

	public String getDESCR() {
		return DESCR;
	}

	public void setDESCR(String dESCR) {
		DESCR = dESCR;
	}

}
