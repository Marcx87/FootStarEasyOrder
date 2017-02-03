package it.marcocarettoni.Footstar.xml.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import it.marcocarettoni.Footstar.DAO.DataPool.DB;
import it.marcocarettoni.Footstar.DAO.controller.CityController;
import it.marcocarettoni.Footstar.DAO.controller.CountryController;
import it.marcocarettoni.Footstar.DAO.controller.DBDataController;
import it.marcocarettoni.Footstar.DAO.controller.ExperienceController;
import it.marcocarettoni.Footstar.DAO.controller.FutureController;
import it.marcocarettoni.Footstar.DAO.controller.GameController;
import it.marcocarettoni.Footstar.DAO.controller.IDBController;
import it.marcocarettoni.Footstar.DAO.controller.LanguageController;
import it.marcocarettoni.Footstar.DAO.controller.PlayerController;
import it.marcocarettoni.Footstar.DAO.controller.PositionController;
import it.marcocarettoni.Footstar.DAO.controller.SideController;
import it.marcocarettoni.Footstar.DAO.controller.SkillController;
import it.marcocarettoni.Footstar.DAO.controller.TeamController;
import it.marcocarettoni.Footstar.DAO.controller.TrainingController;
import it.marcocarettoni.Footstar.DAO.model.IModelDAO;
import it.marcocarettoni.Footstar.xml.model.IModelXML;

public abstract class XMLIController {

	protected final Logger logger;

	public AtomicInteger idx;
	public boolean parsedToEnd = false;
	public int end;
	public List<IModelXML> lista;
	private ConcurrentHashMap<Long, Long> aggiunti = new ConcurrentHashMap<Long, Long>();

	protected XMLIController(Class<?> clz) {
		logger = Logger.getLogger(clz);
	}

	public abstract void getSoapDati();

	public static void emptyTables(Connection c) throws SQLException {
		new CityController().emptyTable(c);
		new CountryController().emptyTable(c);
		new DBDataController().emptyTable(c);
		new FutureController().emptyTable(c);
		new LanguageController().emptyTable(c);
		new SkillController().emptyTable(c);
		new ExperienceController().emptyTable(c);
		new PositionController().emptyTable(c);
		new SideController().emptyTable(c);
		new TrainingController().emptyTable(c);
		new GameController().emptyTable(c);
		new TeamController().emptyTable(c);
		new PlayerController().emptyTable(c);
	}

	public String getSOAP(String URL) throws IOException {
		URL url;
		InputStream is = null;
		BufferedReader br;
		String line;
		try {
			url = new URL(URL);
			is = url.openStream();
			br = new BufferedReader(new InputStreamReader(is, "ISO-8859-1"));
			String result = "";
			while ((line = br.readLine()) != null) {
				result += line + "\n";
			}
			return result = result.replace(",", ".");
		} catch (IOException e) {
			throw e;
		} finally {
			DB.closeResource(is);
		}

	}

	protected JAXBElement<?> parseSOAP(Class<?> clasz, String xml, int idTeam) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(clasz);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			DocumentBuilder build = DocumentBuilderFactory.newInstance().newDocumentBuilder();

			Document doc = build.parse(new ByteArrayInputStream(xml.getBytes("ISO-8859-1")));

			org.w3c.dom.Element node = doc.getDocumentElement();

			JAXBElement<?> jaxbelement = (JAXBElement<?>) jaxbUnmarshaller.unmarshal(node, clasz);

			return jaxbelement;
		} catch (JAXBException | SAXException | IOException | ParserConfigurationException e) {
			logger.error("Parse SOAP Error: ", e);
		}
		return null;
	}

	public void processDB(Connection c, IDBController pc, Class<?> clsz, String typeAdded)
	{
		int rowsAdded = 0;
		while (!parsedToEnd || lista.size() > 0){
			try {
				if (lista.size() > 0)
				{
					IModelXML pxml = lista.remove(0);
					if (pxml.getIDRow() > 0 && !aggiunti.containsKey(pxml.getIDRow()))
					{
						IModelDAO pdao = (IModelDAO) clsz.getConstructor(pxml.getClass()).newInstance(new Object[]{pxml});						
						pc.addRow(c, pdao);
						
						aggiunti.put(pxml.getIDRow(), pxml.getIDRow());
						logger.info("[" + Thread.currentThread().getId() + "] Adding " + typeAdded + ": " + pxml.getIDRow());
					}
					else
					{
						logger.info("[" + Thread.currentThread().getId() + "] Already Added " + typeAdded + ": " + pxml.getIDRow());
					}					
					if (++rowsAdded % 300 == 0)
					{
						logger.fatal(typeAdded + " ADD N: " + rowsAdded);
						DB.commit(c);
					}
				}
				else
					Thread.sleep(1000);
			} catch (SQLException e) {			
				logger.error("SQLException processDB * IDBController: " + pc.getClass().getCanonicalName() + " typeAdded: " + typeAdded, e);
			} catch (InterruptedException e) {
				logger.error("InterruptedException processDB * IDBController: " + pc.getClass().getCanonicalName() + " typeAdded: " + typeAdded, e);
			} catch (Exception e) {
				logger.error("Exception processDB * IDBController: " + pc.getClass().getCanonicalName() + " typeAdded: " + typeAdded, e);
			}
		}
	}
}
