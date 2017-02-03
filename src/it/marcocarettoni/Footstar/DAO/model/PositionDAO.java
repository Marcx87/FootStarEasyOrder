package it.marcocarettoni.Footstar.DAO.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.marcocarettoni.Footstar.xml.model.IModelXML;
import it.marcocarettoni.Footstar.xml.model.denominazioni.Data.Positions.Position;

public class PositionDAO extends IDAO {

	public static final String table_name = "D_POSITION";

	private int ID;
	private int IDL;
	private String DESCR;

	public PositionDAO() {
	}

	public PositionDAO(ResultSet rs) throws SQLException {
		setByResultSet(rs);
	}

	public PositionDAO(Position cy, int language) {
		setByXML(cy, language);
	}

	public void setByResultSet(ResultSet rs) throws SQLException {
		ID = rs.getInt("ID");
		IDL = rs.getInt("IDL");
		DESCR = rs.getString("DESCR");
	}

	@Override
	protected void setByXML(IModelXML cy){}
	
	@Override
	protected void setByXML(IModelXML cyz, int language) {
		Position cy = (Position) cyz;
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
