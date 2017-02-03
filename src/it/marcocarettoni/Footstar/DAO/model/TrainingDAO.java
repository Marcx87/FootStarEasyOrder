package it.marcocarettoni.Footstar.DAO.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.marcocarettoni.Footstar.xml.model.IModelXML;
import it.marcocarettoni.Footstar.xml.model.denominazioni.Data.Trainings.TrainingItem;

public class TrainingDAO extends IDAO {

	public static final String table_name = "D_TRAINING";

	private int ID;
	private int IDL;
	private String DESCR;

	public TrainingDAO() {
	}

	public TrainingDAO(ResultSet rs) throws SQLException {
		setByResultSet(rs);
	}

	public TrainingDAO(TrainingItem cy, int language) {
		setByXML(cy, language);
	}

	public void setByResultSet(ResultSet rs) throws SQLException {
		ID = rs.getInt("ID");
		IDL = rs.getInt("IDL");
		DESCR = rs.getString("DESCR");
	}

	@Override
	protected void setByXML(IModelXML cy) {}

	@Override
	protected void setByXML(IModelXML cyz, int language) {
		TrainingItem cy = (TrainingItem) cyz;
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
