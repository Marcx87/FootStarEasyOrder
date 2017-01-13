package it.marcocarettoni.Footstar.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import it.marcocarettoni.Footstar.DAO.DataPool.DB;

public class Utils {

	public static String getSOAP(String URL) throws IOException {
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
			return result;
		} catch (IOException e) {
			throw e;
		} finally {
			DB.closeResource(is);
		}

	}
}
