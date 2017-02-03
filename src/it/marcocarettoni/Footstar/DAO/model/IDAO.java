package it.marcocarettoni.Footstar.DAO.model;

import it.marcocarettoni.Footstar.xml.model.IModelXML;

public abstract class IDAO implements IModelDAO {

	public static final String table_name = "";
	
	protected abstract void setByXML(IModelXML cyz);
	protected abstract void setByXML(IModelXML cyz, int prop);
}
