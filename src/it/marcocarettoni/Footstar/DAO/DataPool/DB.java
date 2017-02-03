package it.marcocarettoni.Footstar.DAO.DataPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import it.marcocarettoni.Footstar.util.Config;

public class DB extends Config {

	private static final Logger logger = Logger.getLogger(DB.class);

	public DB() {
	}

	public static Connection dbConnect() throws SQLException {
		try {

			Class.forName(Config.DB_DRIVER_CLASS);
			return DriverManager.getConnection(Config.DB_CONNSTRING, Config.DB_USER, Config.DB_PASSWORD);
		} catch (SQLException e) {
			logger.error("dbConnect", e);
			throw (e);
		} catch (ClassNotFoundException e)
		{
			logger.error("dbConnect", e);
			throw (new SQLException(e));
		}
	}

	public static boolean setAutoCommit(Connection c, boolean comm) {
		try {
			c.setAutoCommit(comm);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public static boolean commit(Connection c) {
		try {
			logger.debug("Commiting changes");
			c.commit();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public static boolean rollback(Connection c) {
		try {
			logger.debug("Rollback changes");
			c.rollback();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public static void closeResource(AutoCloseable obj) {

		try {
			if (obj != null) {
				obj.close();
				obj = null;
			}
		} catch (SQLException e) {
			logger.error("closeResource", e);
		} catch (Exception e) {
			logger.error("closeResource", e);
		}
	}
}
