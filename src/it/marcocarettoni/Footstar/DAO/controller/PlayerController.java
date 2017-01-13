package it.marcocarettoni.Footstar.DAO.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;

import it.marcocarettoni.Footstar.DAO.DataPool.DB;
import it.marcocarettoni.Footstar.DAO.model.PlayerDAO;
import it.marcocarettoni.Footstar.xml.model.player.Player;

public class PlayerController extends DAOController {

	private HashSet<Integer> aggiunti = null;

	public PlayerController() {
		super(PlayerController.class, PlayerDAO.table_name);
		aggiunti = new HashSet<Integer>();
	}

	public void processData(Connection c, List<Player> lista) throws SQLException {
		for (Player row : lista) {
			if (row != null && row.getPlayerId() != null) {
				if (!aggiunti.contains(row.getPlayerId())) {
					logger.debug("Inserito PlayerID: " + row.getPlayerId());
					addRow(c, new PlayerDAO(row));
					aggiunti.add(row.getPlayerId());
				} else {
					logger.debug("Player gia inserito PlayerID: " + row.getPlayerId());
				}
			} else {
				logger.debug("Player inesistente: " + row.getPlayerId());
			}
		}
	}
	
	private void addRow(Connection c, PlayerDAO ob) throws SQLException {
		PreparedStatement s = null;
		try {
			// TODO implementare insert in team dat
			s = c.prepareStatement(" INSERT INTO " + table_name + " ( " +
					
					" ) VALUES ( " +
					
					" ) ");

			int i = 1;

			

			s.executeUpdate();
			addRowAdapt(c, ob);
			addRowNT(c, ob);
			addRowTalent(c, ob);
		} catch (SQLException e) {
			logger.error("addRow", e);
			throw e;
		} finally {
			DB.closeResource(s);
		}
	}
	
	private void addRowAdapt(Connection c, PlayerDAO ob) throws SQLException {
		PreparedStatement s = null;
		try {
			// TODO implementare insert in team dat
			s = c.prepareStatement(" INSERT INTO " + table_name + " ( " +
					
					" ) VALUES ( " +
					
					" ) ");

			int i = 1;

			

			s.executeUpdate();
		} catch (SQLException e) {
			logger.error("addRowAdapt", e);
			throw e;
		} finally {
			DB.closeResource(s);
		}
	}
	
	private void addRowNT(Connection c, PlayerDAO ob) throws SQLException {
		PreparedStatement s = null;
		try {
			// TODO implementare insert in team dat
			s = c.prepareStatement(" INSERT INTO " + table_name + " ( " +
					
					" ) VALUES ( " +
					
					" ) ");

			int i = 1;

			

			s.executeUpdate();
		} catch (SQLException e) {
			logger.error("addRowNT", e);
			throw e;
		} finally {
			DB.closeResource(s);
		}
	}
	
	private void addRowTalent(Connection c, PlayerDAO ob) throws SQLException {
		PreparedStatement s = null;
		try {
			// TODO implementare insert in team dat
			s = c.prepareStatement(" INSERT INTO " + table_name + " ( " +
					
					" ) VALUES ( " +
					
					" ) ");

			int i = 1;

			

			s.executeUpdate();
		} catch (SQLException e) {
			logger.error("addRowTalent", e);
			throw e;
		} finally {
			DB.closeResource(s);
		}
	}

}
