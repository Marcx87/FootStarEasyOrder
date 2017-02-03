package it.marcocarettoni.Footstar.DAO.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IModelDAO {

	
	public void setByResultSet(ResultSet rs) throws SQLException;
	
}
