package it.marcocarettoni.Footstar.DAO.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.marcocarettoni.Footstar.xml.model.IModelXML;
import it.marcocarettoni.Footstar.xml.model.player.Player;
import it.marcocarettoni.Footstar.xml.model.player.Player.Adaptabilities.Adaptability;
import it.marcocarettoni.Footstar.xml.model.player.Player.NationalTeams.Country;
import it.marcocarettoni.Footstar.xml.model.player.Player.Talents.Talent;

public class PlayerDAO extends IDAO {

	public static final String table_name = "D_PLAYER";

	private Integer playerId;
	private Long userId;
	private String lastLogin;
	private String registrationDate;
	private Integer teamId;
	private String teamName;
	private String playerName;
	private String positionFull;
	private Short position;
	private Double sideLeft;
	private Double sideRight;
	private Double sideCenter;
	private Short age;
	private Short birthCity;
	private Short birthCity_caps;
	private Short birthCity_capsU21;
	private Short birthCity_capsU18;
	private Short birthCity_goals;
	private Short birthCity_goalsU21;
	private Short birthCity_goalsU18;
	private Short birthDay;
	private Short birthMonth;
	private Short birthYear;
	private Short newBirthDay;
	private Short newBirthYear;
	private Short nationality;
	private Short injured;
	private Short injured_games;
	private Short suspended;
	private Short suspended_games;
	private Short suspendedInt;
	private Short suspendedInt_games;
	private Short fitness;
	private Short morale;
	private Short adapt;
	private List<PlayerAdaptabilityDAO> adaptabilities;
	private Short confidence;
	private Short favoriteFoot;
	private Integer intRank;
	private Short natRank;
	private Short handling;
	private Short outOfArea;
	private Short reflexes;
	private Short agility;
	private Short tackling;
	private Short heading;
	private Short shortPasses;
	private Short positioning;
	private Short finishing;
	private Short technique;
	private Short speed;
	private Short strength;
	private Short throwing;
	private Short gameVision;
	private Short longPasses;
	private Short crosses;
	private Short longShots;
	private Short dribbling;
	private Short jumping;
	private Short acceleration;
	private Short marking;
	private Short setPieces;
	private Short firstTouch;
	private Short commandOfArea;
	private Short consistency;
	private Short flair;
	private Short concentration;
	private Short anticipation;
	private Short decisions;
	private Short composure;
	private Short bravery;
	private Short creativity;
	private Short influence;
	private String skillsWeek;
	private List<PlayerTalentsDAO> talents;
	private Short experience;
	private Long value;
	private Integer wage;
	private Short contract;
	private Short contractRole;
	private String lastContractDate;
	private Short youthTeam;
	private Short transferList;
	private Short release;
	private Short loanList;
	private Short loanFrom;
	private Short loanTo;
	private Short loanReturnDate;
	private Short lastTraining;
	private String dateLastTraining;
	private Short doubleNat;
	private Short countryNt;
	private Short ntSquad;
	private Short goals;
	private Short goalsCareer;
	private Short assists;
	private Short assistsCareer;
	private List<PlayerNTDAO> nationalTeams;

	public PlayerDAO() {
	}

	public PlayerDAO(ResultSet rs) throws SQLException {
		setByResultSet(rs);
	}

	public PlayerDAO(Player cy) {
		setByXML(cy);
	}

	public void setByResultSet(ResultSet rs) throws SQLException {
		playerId = rs.getInt("playerId");
		userId = rs.getLong("userId");
		lastLogin = rs.getString("lastLogin");
		registrationDate = rs.getString("registrationDate");
		teamId = rs.getInt("teamId");
		teamName = rs.getString("teamName");
		playerName = rs.getString("playerName");
		positionFull = rs.getString("positionFull");
		position = rs.getShort("position");
		sideLeft = rs.getDouble("sideLeft");
		sideRight = rs.getDouble("sideRight");
		sideCenter = rs.getDouble("sideCenter");
		age = rs.getShort("age");
		birthCity = rs.getShort("birthCity");
		birthCity_caps = rs.getShort("birthCity_caps");
		birthCity_capsU21 = rs.getShort("birthCity_capsU21");
		birthCity_capsU18 = rs.getShort("birthCity_capsU18");
		birthCity_goals = rs.getShort("birthCity_goals");
		birthCity_goalsU21 = rs.getShort("birthCity_goalsU21");
		birthCity_goalsU18 = rs.getShort("birthCity_goalsU18");
		birthDay = rs.getShort("birthDay");
		birthMonth = rs.getShort("birthMonth");
		birthYear = rs.getShort("birthYear");
		newBirthDay = rs.getShort("newBirthDay");
		newBirthYear = rs.getShort("newBirthYear");
		nationality = rs.getShort("nationality");
		injured = rs.getShort("injured");
		injured_games = rs.getShort("injured_games");
		suspended = rs.getShort("suspended");
		suspended_games = rs.getShort("suspended_games");
		suspendedInt = rs.getShort("suspendedInt");
		suspendedInt_games = rs.getShort("suspendedInt_games");
		fitness = rs.getShort("fitness");
		morale = rs.getShort("morale");
		adapt = rs.getShort("adapt");
		confidence = rs.getShort("confidence");
		favoriteFoot = rs.getShort("favoriteFoot");
		intRank = rs.getInt("intRank");
		natRank = rs.getShort("natRank");
		handling = rs.getShort("handling");
		outOfArea = rs.getShort("outOfArea");
		reflexes = rs.getShort("reflexes");
		agility = rs.getShort("agility");
		tackling = rs.getShort("tackling");
		heading = rs.getShort("heading");
		shortPasses = rs.getShort("shortPasses");
		positioning = rs.getShort("positioning");
		finishing = rs.getShort("finishing");
		technique = rs.getShort("technique");
		speed = rs.getShort("speed");
		strength = rs.getShort("strength");
		throwing = rs.getShort("throwing");
		gameVision = rs.getShort("gameVision");
		longPasses = rs.getShort("longPasses");
		crosses = rs.getShort("crosses");
		longShots = rs.getShort("longShots");
		dribbling = rs.getShort("dribbling");
		jumping = rs.getShort("jumping");
		acceleration = rs.getShort("acceleration");
		marking = rs.getShort("marking");
		setPieces = rs.getShort("setPieces");
		firstTouch = rs.getShort("firstTouch");
		commandOfArea = rs.getShort("commandOfArea");
		consistency = rs.getShort("consistency");
		flair = rs.getShort("flair");
		concentration = rs.getShort("concentration");
		anticipation = rs.getShort("anticipation");
		decisions = rs.getShort("decisions");
		composure = rs.getShort("composure");
		bravery = rs.getShort("bravery");
		creativity = rs.getShort("creativity");
		influence = rs.getShort("influence");
		skillsWeek = rs.getString("skillsWeek");
		experience = rs.getShort("experience");
		value = rs.getLong("value");
		wage = rs.getInt("wage");
		contract = rs.getShort("contract");
		contractRole = rs.getShort("contractRole");
		lastContractDate = rs.getString("lastContractDate");
		youthTeam = rs.getShort("youthTeam");
		transferList = rs.getShort("transferList");
		release = rs.getShort("release");
		loanList = rs.getShort("loanList");
		loanFrom = rs.getShort("loanFrom");
		loanTo = rs.getShort("loanTo");
		loanReturnDate = rs.getShort("loanReturnDate");
		lastTraining = rs.getShort("lastTraining");
		dateLastTraining = rs.getString("dateLastTraining");
		doubleNat = rs.getShort("doubleNat");
		countryNt = rs.getShort("countryNt");
		ntSquad = rs.getShort("ntSquad");
		goals = rs.getShort("goals");
		goalsCareer = rs.getShort("goalsCareer");
		assists = rs.getShort("assists");
		assistsCareer = rs.getShort("assistsCareer");

	}

	@Override
	protected void setByXML(IModelXML cy, int xx) {}
	
	@Override
	protected void setByXML(IModelXML cyx) {		
		Player cy = (Player) cyx;
		playerId = cy.getPlayerId();
		userId = (cy.getUserId() == null ? -1 : cy.getUserId());
		lastLogin = (cy.getLastLogin() == null ? "" : cy.getLastLogin());
		registrationDate = (cy.getRegistrationDate() == null ? "" : cy.getRegistrationDate());
		teamId = (cy.getTeamId() == null ? -1 : cy.getTeamId());
		teamName = (cy.getTeamName() == null ? "" : cy.getTeamName());
		playerName = (cy.getPlayerName() == null ? "" : cy.getPlayerName());
		positionFull = (cy.getPositionFull() == null ? "" : cy.getPositionFull());
		position = (cy.getPosition().getValueAttribute() == null ? -1 : cy.getPosition().getValueAttribute());
		sideLeft = (cy.getSideLeft().getPer() == null ? -1 : Double.parseDouble(cy.getSideLeft().getPer()));
		sideRight = (cy.getSideRight().getPer() == null ? -1 : Double.parseDouble(cy.getSideRight().getPer()));
		sideCenter = (cy.getSideCenter().getPer() == null ? -1 : Double.parseDouble(cy.getSideCenter().getPer()));
		age = (cy.getAge() == null ? -1 : cy.getAge());
		birthCity = cy.getBirthCity().getValue();
		birthCity_caps = (cy.getBirthCity().getCaps() == null ? -1 : cy.getBirthCity().getCaps());
		birthCity_capsU21 = (cy.getBirthCity().getCapsU21() == null ? -1 : cy.getBirthCity().getCapsU21());
		birthCity_capsU18 = (cy.getBirthCity().getCapsU18() == null ? -1 : cy.getBirthCity().getCapsU18());
		birthCity_goals = (cy.getBirthCity().getGoals() == null ? -1 : cy.getBirthCity().getGoals());
		birthCity_goalsU21 = (cy.getBirthCity().getGoalsU21() == null ? -1 : cy.getBirthCity().getGoalsU21());
		birthCity_goalsU18 = (cy.getBirthCity().getGoalsU18() == null ? -1 : cy.getBirthCity().getGoalsU18());
		birthDay = (cy.getBirthDay() == null ? -1 : cy.getBirthDay());
		birthMonth = (cy.getBirthMonth() == null ? -1 : cy.getBirthMonth());
		birthYear = (cy.getBirthYear() == null ? -1 : cy.getBirthYear());
		newBirthDay = (cy.getNewBirthDay() == null ? -1 : cy.getNewBirthDay());
		newBirthYear = (cy.getNewBirthYear() == null ? -1 : cy.getNewBirthYear());
		nationality = (cy.getNationality() == null ? -1 : cy.getNationality());
		injured = cy.getInjured().getValue();
		injured_games = (cy.getInjured().getGames() == null ? -1 : cy.getInjured().getGames());
		suspended = cy.getSuspended().getValue();
		suspended_games = (cy.getSuspended().getGames() == null ? -1 : cy.getSuspended().getGames());
		suspendedInt =  cy.getSuspendedInt().getValue();
		suspendedInt_games = (cy.getSuspendedInt().getGames() == null ? -1 : cy.getSuspendedInt().getGames());
		fitness = (cy.getFitness() == null ? -1 : cy.getFitness());
		morale = (cy.getMorale() == null ? -1 : cy.getMorale());
		adapt = (cy.getAdapt() == null ? -1 : cy.getAdapt());
		confidence = (cy.getConfidence().getId() == null ? -1 : cy.getConfidence().getId());
		favoriteFoot = (cy.getFavoriteFoot() == null ? -1 : cy.getFavoriteFoot());
		intRank = (cy.getIntRank() == null ? -1 : cy.getIntRank());
		natRank = (cy.getNatRank() == null ? -1 : cy.getNatRank());
		handling = (cy.getHandling() == null ? -1 : cy.getHandling());
		outOfArea = (cy.getOutOfArea() == null ? -1 : cy.getOutOfArea());
		reflexes = (cy.getReflexes() == null ? -1 : cy.getReflexes());
		agility = (cy.getAgility() == null ? -1 : cy.getAgility());
		tackling = (cy.getTackling() == null ? -1 : cy.getTackling());
		heading = (cy.getHeading() == null ? -1 : cy.getHeading());
		shortPasses = (cy.getShortPasses() == null ? -1 : cy.getShortPasses());
		positioning = (cy.getPositioning() == null ? -1 : cy.getPositioning());
		finishing = (cy.getFinishing() == null ? -1 : cy.getFinishing());
		technique = (cy.getTechnique() == null ? -1 : cy.getTechnique());
		speed = (cy.getSpeed() == null ? -1 : cy.getSpeed());
		strength = (cy.getStrength() == null ? -1 : cy.getStrength());
		throwing = (cy.getThrowing() == null ? -1 : cy.getThrowing());
		gameVision = (cy.getGameVision() == null ? -1 : cy.getGameVision());
		longPasses = (cy.getLongPasses() == null ? -1 : cy.getLongPasses());
		crosses = (cy.getCrosses() == null ? -1 : cy.getCrosses());
		longShots = (cy.getLongShots() == null ? -1 : cy.getLongShots());
		dribbling = (cy.getDribbling() == null ? -1 : cy.getDribbling());
		jumping = (cy.getJumping() == null ? -1 : cy.getJumping());
		acceleration = (cy.getAcceleration() == null ? -1 : cy.getAcceleration());
		marking = (cy.getMarking() == null ? -1 : cy.getMarking());
		setPieces = (cy.getSetPieces() == null ? -1 : cy.getSetPieces());
		firstTouch = (cy.getFirstTouch() == null ? -1 : cy.getFirstTouch());
		commandOfArea = (cy.getCommandOfArea() == null ? -1 : cy.getCommandOfArea());
		consistency = (cy.getConsistency() == null ? -1 : cy.getConsistency());
		flair = (cy.getFlair() == null ? -1 : cy.getFlair());
		concentration = (cy.getConcentration() == null ? -1 : cy.getConcentration());
		anticipation = (cy.getAnticipation() == null ? -1 : cy.getAnticipation());
		decisions = (cy.getDecisions() == null ? -1 : cy.getDecisions());
		composure = (cy.getComposure() == null ? -1 : cy.getComposure());
		bravery = (cy.getBravery() == null ? -1 : cy.getBravery());
		creativity = (cy.getCreativity() == null ? -1 : cy.getCreativity());
		influence = (cy.getInfluence() == null ? -1 : cy.getInfluence());
		skillsWeek = (cy.getSkillsWeek() == null ? "" : cy.getSkillsWeek());
		experience = (cy.getExperience().getLevel() == null ? -1 : cy.getExperience().getLevel());
		value = (cy.getValue().getEUR() == null ? -1 : cy.getValue().getEUR());
		wage = (cy.getWage().getEUR() == null ? -1 : cy.getWage().getEUR());
		contract = (cy.getContract() == null ? -1 : cy.getContract());
		contractRole = (cy.getContractRole() == null ? -1 : cy.getContractRole());
		lastContractDate = (cy.getLastContractDate() == null ? "" : cy.getLastContractDate());
		youthTeam = (cy.getYouthTeam() == null ? -1 : cy.getYouthTeam());
		transferList = (cy.getTransferList() == null ? -1 : cy.getTransferList());
		release = (cy.getRelease() == null ? -1 : cy.getRelease());
		loanList = (cy.getLoanList() == null ? -1 : cy.getLoanList());
		loanFrom = (cy.getLoanFrom() == null ? -1 : cy.getLoanFrom());
		loanTo = (cy.getLoanTo() == null ? -1 : cy.getLoanTo());
		loanReturnDate = (cy.getLoanReturnDate() == null ? -1 : cy.getLoanReturnDate());
		lastTraining = (cy.getLastTraining() == null ? -1 : cy.getLastTraining());
		dateLastTraining = (cy.getDateLastTraining() == null ? "" : cy.getDateLastTraining());
		doubleNat = (cy.getDoubleNat().getCountry() == null ? -1 : cy.getDoubleNat().getCountry());
		countryNt = (cy.getCountryNt() == null ? -1 : cy.getCountryNt());
		ntSquad = (cy.getNtSquad() == null ? -1 : cy.getNtSquad());
		goals = (cy.getGoals() == null ? -1 : cy.getGoals());
		goalsCareer = (cy.getGoalsCareer() == null ? -1 : cy.getGoalsCareer());
		assists = (cy.getAssists() == null ? -1 : cy.getAssists());
		assistsCareer = (cy.getAssistsCareer() == null ? -1 : cy.getAssistsCareer());

		adaptabilities = new ArrayList<PlayerAdaptabilityDAO>();

		for (Adaptability ob : cy.getAdaptabilities().getAdaptability())
			adaptabilities.add(new PlayerAdaptabilityDAO(ob, cy.getPlayerId()));

		talents = new ArrayList<PlayerTalentsDAO>();
		for (Talent ob : cy.getTalents().getTalent())
			talents.add(new PlayerTalentsDAO(ob, cy.getPlayerId()));

		nationalTeams = new ArrayList<PlayerNTDAO>();
		for (Country ob : cy.getNationalTeams().getCountry())
			nationalTeams.add(new PlayerNTDAO(ob, cy.getPlayerId()));
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPositionFull() {
		return positionFull;
	}

	public void setPositionFull(String positionFull) {
		this.positionFull = positionFull;
	}

	public Short getPosition() {
		return position;
	}

	public void setPosition(Short position) {
		this.position = position;
	}

	public Double getSideLeft() {
		return sideLeft;
	}

	public void setSideLeft(Double sideLeft) {
		this.sideLeft = sideLeft;
	}

	public Double getSideRight() {
		return sideRight;
	}

	public void setSideRight(Double sideRight) {
		this.sideRight = sideRight;
	}

	public Double getSideCenter() {
		return sideCenter;
	}

	public void setSideCenter(Double sideCenter) {
		this.sideCenter = sideCenter;
	}

	public Short getAge() {
		return age;
	}

	public void setAge(Short age) {
		this.age = age;
	}

	public Short getBirthCity() {
		return birthCity;
	}

	public void setBirthCity(Short birthCity) {
		this.birthCity = birthCity;
	}

	public Short getBirthCity_caps() {
		return birthCity_caps;
	}

	public void setBirthCity_caps(Short birthCity_caps) {
		this.birthCity_caps = birthCity_caps;
	}

	public Short getBirthCity_capsU21() {
		return birthCity_capsU21;
	}

	public void setBirthCity_capsU21(Short birthCity_capsU21) {
		this.birthCity_capsU21 = birthCity_capsU21;
	}

	public Short getBirthCity_capsU18() {
		return birthCity_capsU18;
	}

	public void setBirthCity_capsU18(Short birthCity_capsU18) {
		this.birthCity_capsU18 = birthCity_capsU18;
	}

	public Short getBirthCity_goals() {
		return birthCity_goals;
	}

	public void setBirthCity_goals(Short birthCity_goals) {
		this.birthCity_goals = birthCity_goals;
	}

	public Short getBirthCity_goalsU21() {
		return birthCity_goalsU21;
	}

	public void setBirthCity_goalsU21(Short birthCity_goalsU21) {
		this.birthCity_goalsU21 = birthCity_goalsU21;
	}

	public Short getBirthCity_goalsU18() {
		return birthCity_goalsU18;
	}

	public void setBirthCity_goalsU18(Short birthCity_goalsU18) {
		this.birthCity_goalsU18 = birthCity_goalsU18;
	}

	public Short getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Short birthDay) {
		this.birthDay = birthDay;
	}

	public Short getBirthMonth() {
		return birthMonth;
	}

	public void setBirthMonth(Short birthMonth) {
		this.birthMonth = birthMonth;
	}

	public Short getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(Short birthYear) {
		this.birthYear = birthYear;
	}

	public Short getNewBirthDay() {
		return newBirthDay;
	}

	public void setNewBirthDay(Short newBirthDay) {
		this.newBirthDay = newBirthDay;
	}

	public Short getNewBirthYear() {
		return newBirthYear;
	}

	public void setNewBirthYear(Short newBirthYear) {
		this.newBirthYear = newBirthYear;
	}

	public Short getNationality() {
		return nationality;
	}

	public void setNationality(Short nationality) {
		this.nationality = nationality;
	}

	public Short getInjured() {
		return injured;
	}

	public void setInjured(Short injured) {
		this.injured = injured;
	}

	public Short getInjured_games() {
		return injured_games;
	}

	public void setInjured_games(Short injured_games) {
		this.injured_games = injured_games;
	}

	public Short getSuspended() {
		return suspended;
	}

	public void setSuspended(Short suspended) {
		this.suspended = suspended;
	}

	public Short getSuspended_games() {
		return suspended_games;
	}

	public void setSuspended_games(Short suspended_games) {
		this.suspended_games = suspended_games;
	}

	public Short getSuspendedInt() {
		return suspendedInt;
	}

	public void setSuspendedInt(Short suspendedInt) {
		this.suspendedInt = suspendedInt;
	}

	public Short getSuspendedInt_games() {
		return suspendedInt_games;
	}

	public void setSuspendedInt_games(Short suspendedInt_games) {
		this.suspendedInt_games = suspendedInt_games;
	}

	public Short getFitness() {
		return fitness;
	}

	public void setFitness(Short fitness) {
		this.fitness = fitness;
	}

	public Short getMorale() {
		return morale;
	}

	public void setMorale(Short morale) {
		this.morale = morale;
	}

	public Short getAdapt() {
		return adapt;
	}

	public void setAdapt(Short adapt) {
		this.adapt = adapt;
	}

	public List<PlayerAdaptabilityDAO> getAdaptabilities() {
		return adaptabilities;
	}

	public void setAdaptabilities(List<PlayerAdaptabilityDAO> adaptabilities) {
		this.adaptabilities = adaptabilities;
	}

	public Short getConfidence() {
		return confidence;
	}

	public void setConfidence(Short confidence) {
		this.confidence = confidence;
	}

	public Short getFavoriteFoot() {
		return favoriteFoot;
	}

	public void setFavoriteFoot(Short favoriteFoot) {
		this.favoriteFoot = favoriteFoot;
	}

	public Integer getIntRank() {
		return intRank;
	}

	public void setIntRank(Integer intRank) {
		this.intRank = intRank;
	}

	public Short getNatRank() {
		return natRank;
	}

	public void setNatRank(Short natRank) {
		this.natRank = natRank;
	}

	public Short getHandling() {
		return handling;
	}

	public void setHandling(Short handling) {
		this.handling = handling;
	}

	public Short getOutOfArea() {
		return outOfArea;
	}

	public void setOutOfArea(Short outOfArea) {
		this.outOfArea = outOfArea;
	}

	public Short getReflexes() {
		return reflexes;
	}

	public void setReflexes(Short reflexes) {
		this.reflexes = reflexes;
	}

	public Short getAgility() {
		return agility;
	}

	public void setAgility(Short agility) {
		this.agility = agility;
	}

	public Short getTackling() {
		return tackling;
	}

	public void setTackling(Short tackling) {
		this.tackling = tackling;
	}

	public Short getHeading() {
		return heading;
	}

	public void setHeading(Short heading) {
		this.heading = heading;
	}

	public Short getShortPasses() {
		return shortPasses;
	}

	public void setShortPasses(Short shortPasses) {
		this.shortPasses = shortPasses;
	}

	public Short getPositioning() {
		return positioning;
	}

	public void setPositioning(Short positioning) {
		this.positioning = positioning;
	}

	public Short getFinishing() {
		return finishing;
	}

	public void setFinishing(Short finishing) {
		this.finishing = finishing;
	}

	public Short getTechnique() {
		return technique;
	}

	public void setTechnique(Short technique) {
		this.technique = technique;
	}

	public Short getSpeed() {
		return speed;
	}

	public void setSpeed(Short speed) {
		this.speed = speed;
	}

	public Short getStrength() {
		return strength;
	}

	public void setStrength(Short strength) {
		this.strength = strength;
	}

	public Short getThrowing() {
		return throwing;
	}

	public void setThrowing(Short throwing) {
		this.throwing = throwing;
	}

	public Short getGameVision() {
		return gameVision;
	}

	public void setGameVision(Short gameVision) {
		this.gameVision = gameVision;
	}

	public Short getLongPasses() {
		return longPasses;
	}

	public void setLongPasses(Short longPasses) {
		this.longPasses = longPasses;
	}

	public Short getCrosses() {
		return crosses;
	}

	public void setCrosses(Short crosses) {
		this.crosses = crosses;
	}

	public Short getLongShots() {
		return longShots;
	}

	public void setLongShots(Short longShots) {
		this.longShots = longShots;
	}

	public Short getDribbling() {
		return dribbling;
	}

	public void setDribbling(Short dribbling) {
		this.dribbling = dribbling;
	}

	public Short getJumping() {
		return jumping;
	}

	public void setJumping(Short jumping) {
		this.jumping = jumping;
	}

	public Short getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(Short acceleration) {
		this.acceleration = acceleration;
	}

	public Short getMarking() {
		return marking;
	}

	public void setMarking(Short marking) {
		this.marking = marking;
	}

	public Short getSetPieces() {
		return setPieces;
	}

	public void setSetPieces(Short setPieces) {
		this.setPieces = setPieces;
	}

	public Short getFirstTouch() {
		return firstTouch;
	}

	public void setFirstTouch(Short firstTouch) {
		this.firstTouch = firstTouch;
	}

	public Short getCommandOfArea() {
		return commandOfArea;
	}

	public void setCommandOfArea(Short commandOfArea) {
		this.commandOfArea = commandOfArea;
	}

	public Short getConsistency() {
		return consistency;
	}

	public void setConsistency(Short consistency) {
		this.consistency = consistency;
	}

	public Short getFlair() {
		return flair;
	}

	public void setFlair(Short flair) {
		this.flair = flair;
	}

	public Short getConcentration() {
		return concentration;
	}

	public void setConcentration(Short concentration) {
		this.concentration = concentration;
	}

	public Short getAnticipation() {
		return anticipation;
	}

	public void setAnticipation(Short anticipation) {
		this.anticipation = anticipation;
	}

	public Short getDecisions() {
		return decisions;
	}

	public void setDecisions(Short decisions) {
		this.decisions = decisions;
	}

	public Short getComposure() {
		return composure;
	}

	public void setComposure(Short composure) {
		this.composure = composure;
	}

	public Short getBravery() {
		return bravery;
	}

	public void setBravery(Short bravery) {
		this.bravery = bravery;
	}

	public Short getCreativity() {
		return creativity;
	}

	public void setCreativity(Short creativity) {
		this.creativity = creativity;
	}

	public Short getInfluence() {
		return influence;
	}

	public void setInfluence(Short influence) {
		this.influence = influence;
	}

	public String getSkillsWeek() {
		return skillsWeek;
	}

	public void setSkillsWeek(String skillsWeek) {
		this.skillsWeek = skillsWeek;
	}

	public List<PlayerTalentsDAO> getTalents() {
		return talents;
	}

	public void setTalents(List<PlayerTalentsDAO> talents) {
		this.talents = talents;
	}

	public Short getExperience() {
		return experience;
	}

	public void setExperience(Short experience) {
		this.experience = experience;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public Integer getWage() {
		return wage;
	}

	public void setWage(Integer wage) {
		this.wage = wage;
	}

	public Short getContract() {
		return contract;
	}

	public void setContract(Short contract) {
		this.contract = contract;
	}

	public Short getContractRole() {
		return contractRole;
	}

	public void setContractRole(Short contractRole) {
		this.contractRole = contractRole;
	}

	public String getLastContractDate() {
		return lastContractDate;
	}

	public void setLastContractDate(String lastContractDate) {
		this.lastContractDate = lastContractDate;
	}

	public Short getYouthTeam() {
		return youthTeam;
	}

	public void setYouthTeam(Short youthTeam) {
		this.youthTeam = youthTeam;
	}

	public Short getTransferList() {
		return transferList;
	}

	public void setTransferList(Short transferList) {
		this.transferList = transferList;
	}

	public Short getRelease() {
		return release;
	}

	public void setRelease(Short release) {
		this.release = release;
	}

	public Short getLoanList() {
		return loanList;
	}

	public void setLoanList(Short loanList) {
		this.loanList = loanList;
	}

	public Short getLoanFrom() {
		return loanFrom;
	}

	public void setLoanFrom(Short loanFrom) {
		this.loanFrom = loanFrom;
	}

	public Short getLoanTo() {
		return loanTo;
	}

	public void setLoanTo(Short loanTo) {
		this.loanTo = loanTo;
	}

	public Short getLoanReturnDate() {
		return loanReturnDate;
	}

	public void setLoanReturnDate(Short loanReturnDate) {
		this.loanReturnDate = loanReturnDate;
	}

	public Short getLastTraining() {
		return lastTraining;
	}

	public void setLastTraining(Short lastTraining) {
		this.lastTraining = lastTraining;
	}

	public String getDateLastTraining() {
		return dateLastTraining;
	}

	public void setDateLastTraining(String dateLastTraining) {
		this.dateLastTraining = dateLastTraining;
	}

	public Short getDoubleNat() {
		return doubleNat;
	}

	public void setDoubleNat(Short doubleNat) {
		this.doubleNat = doubleNat;
	}

	public Short getCountryNt() {
		return countryNt;
	}

	public void setCountryNt(Short countryNt) {
		this.countryNt = countryNt;
	}

	public Short getNtSquad() {
		return ntSquad;
	}

	public void setNtSquad(Short ntSquad) {
		this.ntSquad = ntSquad;
	}

	public Short getGoals() {
		return goals;
	}

	public void setGoals(Short goals) {
		this.goals = goals;
	}

	public Short getGoalsCareer() {
		return goalsCareer;
	}

	public void setGoalsCareer(Short goalsCareer) {
		this.goalsCareer = goalsCareer;
	}

	public Short getAssists() {
		return assists;
	}

	public void setAssists(Short assists) {
		this.assists = assists;
	}

	public Short getAssistsCareer() {
		return assistsCareer;
	}

	public void setAssistsCareer(Short assistsCareer) {
		this.assistsCareer = assistsCareer;
	}

	public List<PlayerNTDAO> getNationalTeams() {
		return nationalTeams;
	}

	public void setNationalTeams(List<PlayerNTDAO> nationalTeams) {
		this.nationalTeams = nationalTeams;
	}

}
