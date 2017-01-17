package it.marcocarettoni.Footstar.xml.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;

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
import it.marcocarettoni.Footstar.DAO.controller.LanguageController;
import it.marcocarettoni.Footstar.DAO.controller.PositionController;
import it.marcocarettoni.Footstar.DAO.controller.SideController;
import it.marcocarettoni.Footstar.DAO.controller.SkillController;
import it.marcocarettoni.Footstar.DAO.controller.TeamController;
import it.marcocarettoni.Footstar.DAO.controller.TrainingController;
import it.marcocarettoni.Footstar.DAO.model.DBDataDAO;

public abstract class XMLIController {

	protected final Logger logger;

	public static void main(String[] args) {
		Connection c = null;
		try {
			c = DB.dbConnect();
			if (DB.setAutoCommit(c, false)) {

				//				emptyTables(c);
				//				
				//				new DenominazioniXMLController().parseDati(c, null);							
				//				DB.commit(c);
				//				
				DBDataDAO dbdata = new DBDataController().getRow();
				//				new GameXMLController().parseDati(c, dbdata);
				//				DB.commit(c);
				//				new TeamXMLController().parseDati(c, dbdata);
				new PlayerXMLController().parseDati(c, dbdata);
				DB.commit(c);
			}
			DB.commit(c);
		} catch (SQLException e) {
			DB.rollback(c);
			e.printStackTrace();
		} finally {
			DB.closeResource(c);
		}
	}

	public XMLIController(Class<?> clz) {
		logger = Logger.getLogger(clz);
	}

	protected abstract void parseDati(Connection c, DBDataDAO dbData) throws SQLException;

	private static void emptyTables(Connection c) throws SQLException {
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
		DB.commit(c);
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

			//Data jaxbelement = (Data) jaxbUnmarshaller.unmarshal(node);
			JAXBElement<?> jaxbelement = (JAXBElement<?>) jaxbUnmarshaller.unmarshal(node, clasz);

			return jaxbelement;
		} catch (JAXBException | SAXException | IOException | ParserConfigurationException e) {
			logger.error("Parse SOAP Error: ", e);
		}
		return null;
	}
}
