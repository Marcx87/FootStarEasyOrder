package it.marcocarettoni.Footstar.xml.controller;

import java.sql.Connection;

public class ThreadController extends Thread {

	private int scelta;
	private Connection c;
	private PlayerXMLController pd;
	
	public ThreadController(int _scelta, PlayerXMLController _pd, Connection _c) {
		pd = _pd;
		c = _c;
		scelta = _scelta;
	}
	
	public void run()
	{
	//synchronized(pd.idx)
		//{
		if (scelta == 0)
			pd.getSoapDati();
		else
			pd.processDB(c);
		//}
	}
}
