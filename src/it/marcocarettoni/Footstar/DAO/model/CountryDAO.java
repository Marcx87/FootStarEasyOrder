package it.marcocarettoni.Footstar.DAO.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.marcocarettoni.Footstar.xml.model.IModelXML;
import it.marcocarettoni.Footstar.xml.model.denominazioni.Data.Countries.Country;

public class CountryDAO extends IDAO {

	public static final String table_name = "D_COUNTRY";

	private int ID;
	private int IDL;
	private int NUM_DIV;
	private String DESCR;

	public CountryDAO() {
	}

	public CountryDAO(ResultSet rs) throws SQLException {
		setByResultSet(rs);
	}

	public CountryDAO(Country cy, int language) {
		setByXML(cy, language);
	}

	public void setByResultSet(ResultSet rs) throws SQLException {
		ID = rs.getInt("ID");
		IDL = rs.getInt("IDL");
		NUM_DIV = rs.getInt("NUM_DIV");
		DESCR = rs.getString("DESCR");
	}

	@Override
	protected void setByXML(IModelXML cyx){}
	
	@Override
	protected void setByXML(IModelXML cyz, int language) {
		Country cy = (Country) cyz;
		
		ID = cy.getId();
		IDL = language;
		NUM_DIV = cy.getNumDivs();
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

	public int getNUM_DIV() {
		return NUM_DIV;
	}

	public void setNUM_DIV(int nUM_DIV) {
		NUM_DIV = nUM_DIV;
	}

	public String getDESCR() {
		return DESCR;
	}

	public void setDESCR(String dESCR) {
		DESCR = dESCR;
	}

}
