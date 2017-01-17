package it.marcocarettoni.Footstar.DAO.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;

import it.marcocarettoni.Footstar.DAO.DataPool.DB;
import it.marcocarettoni.Footstar.DAO.model.PlayerAdaptabilityDAO;
import it.marcocarettoni.Footstar.DAO.model.PlayerDAO;
import it.marcocarettoni.Footstar.DAO.model.PlayerNTDAO;
import it.marcocarettoni.Footstar.DAO.model.PlayerTalentsDAO;
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
			s = c.prepareStatement(" INSERT INTO " + table_name + " ( " +
						" PLAYERID, " + 
						" USERID, " + 
						" LASTLOGIN, " + 
						" REGISTRATIONDATE, " + 
						" TEAMID, " + 
						" TEAMNAME, " + 
						" PLAYERNAME, " + 
						" POSITIONFULL, " + 
						" POSITION, " + 
						" SIDELEFT, " + 
						" SIDERIGHT, " + 
						" SIDECENTER, " + 
						" AGE, " + 
						" BIRTHCITY, " + 
						" BIRTHCITY_CAPS, " + 
						" BIRTHCITY_CAPSU21, " + 
						" BIRTHCITY_CAPSU18, " + 
						" BIRTHCITY_GOALS, " + 
						" BIRTHCITY_GOALSU21, " + 
						" BIRTHCITY_GOALSU18, " + 
						" BIRTHDAY, " + 
						" BIRTHMONTH, " + 
						" BIRTHYEAR, " + 
						" NEWBIRTHDAY, " + 
						" NEWBIRTHYEAR, " + 
						" NATIONALITY, " + 
						" INJURED, " + 
						" INJURED_GAMES, " + 
						" SUSPENDED, " + 
						" SUSPENDED_GAMES, " + 
						" SUSPENDEDINT, " + 
						" SUSPENDEDINT_GAMES, " + 
						" FITNESS, " + 
						" MORALE, " + 
						" ADAPT, " + 
						" CONFIDENCE, " + 
						" FAVORITEFOOT, " + 
						" INTRANK, " + 
						" NATRANK, " + 
						" HANDLING, " + 
						" OUTOFAREA, " + 
						" REFLEXES, " + 
						" AGILITY, " + 
						" TACKLING, " + 
						" HEADING, " + 
						" SHORTPASSES, " + 
						" POSITIONING, " + 
						" FINISHING, " + 
						" TECHNIQUE, " + 
						" SPEED, " + 
						" STRENGTH, " + 
						" THROWING, " + 
						" GAMEVISION, " + 
						" LONGPASSES, " + 
						" CROSSES, " + 
						" LONGSHOTS, " + 
						" DRIBBLING, " + 
						" JUMPING, " + 
						" ACCELERATION, " + 
						" MARKING, " + 
						" SETPIECES, " + 
						" FIRSTTOUCH, " + 
						" COMMANDOFAREA, " + 
						" CONSISTENCY, " + 
						" FLAIR, " + 
						" CONCENTRATION, " + 
						" ANTICIPATION, " + 
						" DECISIONS, " + 
						" COMPOSURE, " + 
						" BRAVERY, " + 
						" CREATIVITY, " + 
						" INFLUENCE, " + 
						" SKILLSWEEK, " + 
						" EXPERIENCE, " + 
						" VALUE, " + 
						" WAGE, " + 
						" CONTRACT, " + 
						" CONTRACTROLE, " + 
						" LASTCONTRACTDATE, " + 
						" YOUTHTEAM, " + 
						" TRANSFERLIST, " + 
						" RELEASE, " + 
						" LOANLIST, " + 
						" LOANFROM, " + 
						" LOANTO, " + 
						" LOANRETURNDATE, " + 
						" LASTTRAINING, " + 
						" DATELASTTRAINING, " + 
						" DOUBLENAT, " + 
						" COUNTRYNT, " + 
						" NTSQUAD, " + 
						" GOALS, " + 
						" GOALSCAREER, " + 
						" ASSISTS, " + 
						" ASSISTSCAREER " + 
					" ) VALUES ( " +
						" ?, ?, ?, ?, ?, " +
						" ?, ?, ?, ?, ?, " +
						" ?, ?, ?, ?, ?, " +
						" ?, ?, ?, ?, ?, " +
						" ?, ?, ?, ?, ?, " +
						" ?, ?, ?, ?, ?, " +
						" ?, ?, ?, ?, ?, " +
						" ?, ?, ?, ?, ?, " +
						" ?, ?, ?, ?, ?, " +
						" ?, ?, ?, ?, ?, " +
						" ?, ?, ?, ?, ?, " +
						" ?, ?, ?, ?, ?, " +
						" ?, ?, ?, ?, ?, " +
						" ?, ?, ?, ?, ?, " +
						" ?, ?, ?, ?, ?, " +
						" ?, ?, ?, ?, ?, " +
						" ?, ?, ?, ?, ?, " +
						" ?, ?, ?, ?, ?, " +
						" ?, ?, ?, ?, ? " +
					" ) ");

			int i = 1;

			s.setInt(i++, ob.getPlayerId());
			s.setLong(i++, ob.getUserId());
			s.setString(i++, ob.getLastLogin());
			s.setString(i++, ob.getRegistrationDate());
			s.setInt(i++, ob.getTeamId());
			s.setString(i++, ob.getTeamName());
			s.setString(i++, ob.getPlayerName());
			s.setString(i++, ob.getPositionFull());
			s.setShort(i++, ob.getPosition());
			s.setDouble(i++, ob.getSideLeft());
			s.setDouble(i++, ob.getSideRight());
			s.setDouble(i++, ob.getSideCenter());
			s.setShort(i++, ob.getAge());
			s.setShort(i++, ob.getBirthCity());
			s.setShort(i++, ob.getBirthCity_caps());
			s.setShort(i++, ob.getBirthCity_capsU21());
			s.setShort(i++, ob.getBirthCity_capsU18());
			s.setShort(i++, ob.getBirthCity_goals());
			s.setShort(i++, ob.getBirthCity_goalsU21());
			s.setShort(i++, ob.getBirthCity_goalsU18());
			s.setShort(i++, ob.getBirthDay());
			s.setShort(i++, ob.getBirthMonth());
			s.setShort(i++, ob.getBirthYear());
			s.setShort(i++, ob.getNewBirthDay());
			s.setShort(i++, ob.getNewBirthYear());
			s.setShort(i++, ob.getNationality());
			s.setShort(i++, ob.getInjured());
			s.setShort(i++, ob.getInjured_games());
			s.setShort(i++, ob.getSuspended());
			s.setShort(i++, ob.getSuspended_games());
			s.setShort(i++, ob.getSuspendedInt());
			s.setShort(i++, ob.getSuspendedInt_games());
			s.setShort(i++, ob.getFitness());
			s.setShort(i++, ob.getMorale());
			s.setShort(i++, ob.getAdapt());
			s.setShort(i++, ob.getConfidence());
			s.setShort(i++, ob.getFavoriteFoot());
			s.setInt(i++, ob.getIntRank());
			s.setShort(i++, ob.getNatRank());
			s.setShort(i++, ob.getHandling());
			s.setShort(i++, ob.getOutOfArea());
			s.setShort(i++, ob.getReflexes());
			s.setShort(i++, ob.getAgility());
			s.setShort(i++, ob.getTackling());
			s.setShort(i++, ob.getHeading());
			s.setShort(i++, ob.getShortPasses());
			s.setShort(i++, ob.getPositioning());
			s.setShort(i++, ob.getFinishing());
			s.setShort(i++, ob.getTechnique());
			s.setShort(i++, ob.getSpeed());
			s.setShort(i++, ob.getStrength());
			s.setShort(i++, ob.getThrowing());
			s.setShort(i++, ob.getGameVision());
			s.setShort(i++, ob.getLongPasses());
			s.setShort(i++, ob.getCrosses());
			s.setShort(i++, ob.getLongShots());
			s.setShort(i++, ob.getDribbling());
			s.setShort(i++, ob.getJumping());
			s.setShort(i++, ob.getAcceleration());
			s.setShort(i++, ob.getMarking());
			s.setShort(i++, ob.getSetPieces());
			s.setShort(i++, ob.getFirstTouch());
			s.setShort(i++, ob.getCommandOfArea());
			s.setShort(i++, ob.getConsistency());
			s.setShort(i++, ob.getFlair());
			s.setShort(i++, ob.getConcentration());
			s.setShort(i++, ob.getAnticipation());
			s.setShort(i++, ob.getDecisions());
			s.setShort(i++, ob.getComposure());
			s.setShort(i++, ob.getBravery());
			s.setShort(i++, ob.getCreativity());
			s.setShort(i++, ob.getInfluence());
			s.setString(i++, ob.getSkillsWeek());
			s.setShort(i++, ob.getExperience());
			s.setLong(i++, ob.getValue());
			s.setInt(i++, ob.getWage());
			s.setShort(i++, ob.getContract());
			s.setShort(i++, ob.getContractRole());
			s.setString(i++, ob.getLastContractDate());
			s.setShort(i++, ob.getYouthTeam());
			s.setShort(i++, ob.getTransferList());
			s.setShort(i++, ob.getRelease());
			s.setShort(i++, ob.getLoanList());
			s.setShort(i++, ob.getLoanFrom());
			s.setShort(i++, ob.getLoanTo());
			s.setShort(i++, ob.getLoanReturnDate());
			s.setShort(i++, ob.getLastTraining());
			s.setString(i++, ob.getDateLastTraining());
			s.setShort(i++, ob.getDoubleNat());
			s.setShort(i++, ob.getCountryNt());
			s.setShort(i++, ob.getNtSquad());
			s.setShort(i++, ob.getGoals());
			s.setShort(i++, ob.getGoalsCareer());
			s.setShort(i++, ob.getAssists());
			s.setShort(i++, ob.getAssistsCareer());
			
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
		for (PlayerAdaptabilityDAO t : ob.getAdaptabilities()) {
			PreparedStatement s = null;
			try {
				s = c.prepareStatement(" INSERT INTO " + PlayerAdaptabilityDAO.table_name + " ( " +
						" PLAYERID, COUNTRY, ACTIVE, DAYS, VALUE " +
						" ) VALUES ( " +
						" ?, ?, ?, ?, ? " +
						" ) ");

				int i = 1;

				s.setInt(i++, t.getPlayerId());
				s.setInt(i++, t.getCountry());
				s.setShort(i++, t.getActive());
				s.setInt(i++, t.getDays());
				s.setString(i++, t.getValue());

				logger.debug("Insert Adaptability Player: " + t.getPlayerId() + " - ID Country: " + t.getCountry());

				s.executeUpdate();
			} catch (SQLException e) {
				logger.error("ERRORE Insert Adaptability Player: " + t.getPlayerId() + " - ID Country: " + t.getCountry(), e);
				throw e;
			} finally {
				DB.closeResource(s);
			}
		}
	}

	private void addRowNT(Connection c, PlayerDAO ob) throws SQLException {
		for (PlayerNTDAO t : ob.getNationalTeams()) {
			PreparedStatement s = null;
			try {
				s = c.prepareStatement(" INSERT INTO " + PlayerNTDAO.table_name + " ( " +
						" PLAYERID, ID, CAPS, CAPSSUB21, CAPSSUB18, " +
						" GOALS, GOALSSUB21, GOALSSUB18, ASSISTSNT " +
						" ) VALUES ( " +
						" ?, ?, ?, ?, ?, " +
						" ?, ?, ?, ? " +
						" ) ");

				int i = 1;
				s.setInt(i++, t.getPlayerId());
				s.setShort(i++, t.getId());
				s.setShort(i++, t.getCaps());
				s.setShort(i++, t.getCapsSub21());
				s.setShort(i++, t.getCapsSub18());
				s.setShort(i++, t.getGoals());
				s.setShort(i++, t.getGoalsSub21());
				s.setShort(i++, t.getGoalsSub18());
				s.setShort(i++, t.getAssistsNt());

				logger.debug("Insert NationalTeam Player: " + t.getPlayerId() + " - ID NT: " + t.getId());
				s.executeUpdate();
			} catch (SQLException e) {
				logger.error("ERRORE Insert NationalTeam Player: " + t.getPlayerId() + " - ID NT: " + t.getId(), e);
				throw e;
			} finally {
				DB.closeResource(s);
			}
		}
	}

	private void addRowTalent(Connection c, PlayerDAO ob) throws SQLException {
		for (PlayerTalentsDAO t : ob.getTalents()) {
			PreparedStatement s = null;
			try {
				s = c.prepareStatement(" INSERT INTO " + PlayerTalentsDAO.table_name + " ( " +
						" PLAYERID, ID " +
						" ) VALUES ( " +
						" ?, ? " +
						" ) ");

				int i = 1;

				s.setInt(i++, t.getPlayerId());
				s.setInt(i++, t.getId());
				logger.debug("Insert Talent Player: " + t.getPlayerId() + " - ID: " + t.getId());
				s.executeUpdate();
			} catch (SQLException e) {
				logger.error("ERRORE Insert Talent Player: " + t.getPlayerId() + " - ID: " + t.getId(), e);
				throw e;
			} finally {
				DB.closeResource(s);
			}
		}
	}

}
