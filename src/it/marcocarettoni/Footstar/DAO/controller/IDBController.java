package it.marcocarettoni.Footstar.DAO.controller;

import java.sql.Connection;
import java.sql.SQLException;

import it.marcocarettoni.Footstar.DAO.model.IModelDAO;

public interface IDBController {
	
	public void addRow(Connection c, IModelDAO obj) throws SQLException;
	
}
