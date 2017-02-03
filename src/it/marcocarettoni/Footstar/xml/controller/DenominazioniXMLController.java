package it.marcocarettoni.Footstar.xml.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import it.marcocarettoni.Footstar.DAO.controller.CityController;
import it.marcocarettoni.Footstar.DAO.controller.CountryController;
import it.marcocarettoni.Footstar.DAO.controller.DBDataController;
import it.marcocarettoni.Footstar.DAO.controller.ExperienceController;
import it.marcocarettoni.Footstar.DAO.controller.FutureController;
import it.marcocarettoni.Footstar.DAO.controller.LanguageController;
import it.marcocarettoni.Footstar.DAO.controller.PositionController;
import it.marcocarettoni.Footstar.DAO.controller.SideController;
import it.marcocarettoni.Footstar.DAO.controller.SkillController;
import it.marcocarettoni.Footstar.DAO.controller.TrainingController;
import it.marcocarettoni.Footstar.DAO.model.DBDataDAO;
import it.marcocarettoni.Footstar.xml.model.denominazioni.Data;

public class DenominazioniXMLController extends XMLIController {

	private final int[] languages = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 20, 22, 23, 24, 25, 26, 27, 30, 31, 33, 34, 36, 37, 38, 39,
			40, 41,
			44, 45, 46, 47, 48 };

	private ArrayList<Data> lista = new ArrayList<Data>();
	
	public DenominazioniXMLController() {
		super(DenominazioniXMLController.class);
	}
	
	public void parseDati(Connection c, DBDataDAO dbData) throws SQLException {
		logger.debug("Processing Lista Denominazioni");

		for (int i = 0; i < lista.size(); i++) {
			logger.debug("Processing Lista Denominazioni - Lingua : " + languages[i]);
			
			new CityController().processData(c, lista.get(i).getCities(), languages[i]);
			new CountryController().processData(c, lista.get(i).getCountries(), languages[i]);
			new DBDataController().processData(c, lista.get(i).getDatabaseData(), languages[i]);
			new FutureController().processData(c, lista.get(i).getFuture(), languages[i]);
			new LanguageController().processData(c, lista.get(i).getLanguages(), languages[i]);
			new SkillController().processData(c, lista.get(i).getMentalSkills(), languages[i]);
			new ExperienceController().processData(c, lista.get(i).getPlayerExperience(), languages[i]);
			new PositionController().processData(c, lista.get(i).getPositions(), languages[i]);
			new SideController().processData(c, lista.get(i).getSides(), languages[i]);
			new TrainingController().processData(c, lista.get(i).getTrainings(), languages[i]);
		}
	}

	public void getSoapDati() {
		logger.debug("Init get Denominazioni");
		for (int i = 1; i <= languages.length; i++) {
			try {
				logger.debug("Denominazioni Lingua: " + i);
				String result = getSOAP("http://www.footstar.org/xml_feed.asp?type=6&username=Psycho87&password=tester&program_id=275&language=" + i);
				lista.add((Data) parseSOAP(Data.class, result, i).getValue());
			} catch (IOException ioe) {
				logger.error("IOException Denominazioni idLang: " + i, ioe);
			}
		}
	}

}
