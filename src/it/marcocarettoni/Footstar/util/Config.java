package it.marcocarettoni.Footstar.util;

public class Config {

	protected final static String DB_DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
	protected final static String DB_CONNSTRING = "jdbc:oracle:thin:@//127.0.0.1:1521/xe";
	protected final static String DB_USER = "fs";
	protected final static String DB_PASSWORD = "fs";

	//	private final static String PATH_FILE = "D://config.properties";

	//	protected final static String DB_CONNSTRING;
	//	protected final static String DB_USER;
	//	protected final static String DB_PASSWORD;
	//	
	//	static
	//	{
	//		Properties prop = null;
	//		try {
	//			prop = Utils.getPropertiesFile(PATH_FILE);
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		}
	//		if (prop != null)
	//		{
	//			DB_CONNSTRING = prop.getProperty("dbhost");
	//			DB_USER = prop.getProperty("dbuser");
	//			DB_PASSWORD = prop.getProperty("dbpassword");
	//		} 
	//		else
	//		{
	//			DB_CONNSTRING = "";
	//			DB_USER = "";
	//			DB_PASSWORD = "";
	//		}
	//	}
	
	

}
