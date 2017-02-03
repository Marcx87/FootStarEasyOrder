package it.marcocarettoni.Footstar.app;

import java.sql.Connection;

import it.marcocarettoni.Footstar.DAO.controller.IDBController;
import it.marcocarettoni.Footstar.xml.controller.XMLIController;

public class ThreadController extends Thread {

	private int scelta;
	private Connection c;
	private XMLIController XMLctrl;
	private IDBController DBctrl;
	private Class<?> modelDao;
	private String typeObject;
	
	public ThreadController(XMLIController _XMLctrl, IDBController _DBctrl, Class<?> _modelDao, int _scelta, Connection _c, String _typeObject) {
		XMLctrl = _XMLctrl;
		DBctrl = _DBctrl;
		modelDao = _modelDao;
		c = _c;
		scelta = _scelta;
		typeObject = _typeObject;
	}
	
	public void run()
	{
		if (scelta == 0)
			XMLctrl.getSoapDati();
		else
			XMLctrl.processDB(c, DBctrl, modelDao, typeObject);	
	}
}
