package it.marcocarettoni.Footstar.DAO.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.marcocarettoni.Footstar.xml.model.team.TeamData;

public class TeamDAO extends IDAO {

	public static final String table_name = "D_TEAM";

	private Integer team_userid;
	private Integer team_playerid;
	private String team_useralias;
	private Integer team_id;
	private Integer b_team;
	private Integer main_team_id;
	private String team_name;
	private String team_long_name;
	private Integer team_country_id;
	private Integer team_city;
	private String stadium_name;
	private Integer stadium_north;
	private Integer stadium_south;
	private Integer stadium_east;
	private Integer stadium_west;
	private Integer stadium_neast;
	private Integer stadium_nwest;
	private Integer stadium_seast;
	private Integer stadium_swest;
	private Integer supporters;
	private Integer average_attendance;
	private Integer division;
	private Integer series;
	private Integer position;
	private Integer games_without_winning;
	private Integer games_without_losing;
	private Integer wins_in_a_row;
	private Integer draws_in_a_row;
	private Integer losts_in_a_row;
	private long last_game;
	private Integer last_game_type;
	private Integer wt_Monday1;
	private Integer wt_Monday2;
	private Integer wt_Monday3;
	private Integer wt_Tuesday1;
	private Integer wt_Tuesday2;
	private Integer wt_Tuesday3;
	private Integer wt_Wednesday1;
	private Integer wt_Wednesday2;
	private Integer wt_Wednesday3;
	private Integer wt_Thursday1;
	private Integer wt_Thursday2;
	private Integer wt_Thursday3;
	private Integer wt_Friday1;
	private Integer wt_Friday2;
	private Integer wt_Friday3;
	private Integer wt_Saturday1;
	private Integer wt_Saturday2;
	private Integer wt_Saturday3;
	private Integer wt_Sunday1;
	private Integer wt_Sunday2;
	private Integer wt_Sunday3;
	private String wt_last_changed;

	public TeamDAO() {
	}

	public TeamDAO(ResultSet rs) throws SQLException {
		setByResultSet(rs);
	}

	public TeamDAO(TeamData cy) {
		setByXML(cy);
	}

	public void setByResultSet(ResultSet rs) throws SQLException {
		team_userid = rs.getInt("team_userid");
		team_playerid = rs.getInt("team_playerid");
		team_useralias = rs.getString("team_useralias");
		team_id = rs.getInt("team_id");
		b_team = rs.getInt("b_team");
		main_team_id = rs.getInt("main_team_id");
		team_name = rs.getString("team_name");
		team_long_name = rs.getString("team_long_name");
		team_country_id = rs.getInt("team_country_id");
		team_city = rs.getInt("team_city");
		stadium_name = rs.getString("stadium_name");
		stadium_north = rs.getInt("stadium_north");
		stadium_south = rs.getInt("stadium_south");
		stadium_east = rs.getInt("stadium_east");
		stadium_west = rs.getInt("stadium_west");
		stadium_neast = rs.getInt("stadium_neast");
		stadium_nwest = rs.getInt("stadium_nwest");
		stadium_seast = rs.getInt("stadium_seast");
		stadium_swest = rs.getInt("stadium_swest");
		supporters = rs.getInt("supporters");
		average_attendance = rs.getInt("average_attendance");
		division = rs.getInt("division");
		series = rs.getInt("series");
		position = rs.getInt("position");
		games_without_winning = rs.getInt("games_without_winning");
		games_without_losing = rs.getInt("games_without_losing");
		wins_in_a_row = rs.getInt("wins_in_a_row");
		draws_in_a_row = rs.getInt("draws_in_a_row");
		losts_in_a_row = rs.getInt("losts_in_a_row");
		last_game = rs.getInt("last_game");
		last_game_type = rs.getInt("last_game_type");
		wt_Monday1 = rs.getInt("wt_Monday1");
		wt_Monday2 = rs.getInt("wt_Monday2");
		wt_Monday3 = rs.getInt("wt_Monday3");
		wt_Tuesday1 = rs.getInt("wt_Tuesday1");
		wt_Tuesday2 = rs.getInt("wt_Tuesday2");
		wt_Tuesday3 = rs.getInt("wt_Tuesday3");
		wt_Wednesday1 = rs.getInt("wt_Wednesday1");
		wt_Wednesday2 = rs.getInt("wt_Wednesday2");
		wt_Wednesday3 = rs.getInt("wt_Wednesday3");
		wt_Thursday1 = rs.getInt("wt_Thursday1");
		wt_Thursday2 = rs.getInt("wt_Thursday2");
		wt_Thursday3 = rs.getInt("wt_Thursday3");
		wt_Friday1 = rs.getInt("wt_Friday1");
		wt_Friday2 = rs.getInt("wt_Friday2");
		wt_Friday3 = rs.getInt("wt_Friday3");
		wt_Saturday1 = rs.getInt("wt_Saturday1");
		wt_Saturday2 = rs.getInt("wt_Saturday2");
		wt_Saturday3 = rs.getInt("wt_Saturday3");
		wt_Sunday1 = rs.getInt("wt_Sunday1");
		wt_Sunday2 = rs.getInt("wt_Sunday2");
		wt_Sunday3 = rs.getInt("wt_Sunday3");
		wt_last_changed = rs.getString("wt_last_changed");
	}

	public void setByXML(TeamData cy) {

		team_userid = cy.getTeamUserid();
		team_playerid = cy.getTeamPlayerid();
		team_useralias = cy.getTeamUseralias();
		team_id = cy.getTeamId();
		b_team = cy.getBTeam().getValue();
		main_team_id = cy.getBTeam().getMainTeamId();
		team_name = cy.getTeamName();
		team_long_name = cy.getTeamLongName();
		team_country_id = cy.getTeamCountryId();
		team_city = cy.getTeamCity();
		stadium_name = cy.getStadium().getName();
		stadium_north = cy.getStadium().getNorth();
		stadium_south = cy.getStadium().getSouth();
		stadium_east = cy.getStadium().getEast();
		stadium_west = cy.getStadium().getWest();
		stadium_neast = cy.getStadium().getNeast();
		stadium_nwest = cy.getStadium().getNwest();
		stadium_seast = cy.getStadium().getSeast();
		stadium_swest = cy.getStadium().getSwest();
		supporters = cy.getSupporters();
		average_attendance = cy.getAverageAttendance();
		division = cy.getDivision();
		series = cy.getSeries();
		position = cy.getPosition();
		games_without_winning = cy.getGamesWithoutWinning();
		games_without_losing = cy.getGamesWithoutLosing();
		wins_in_a_row = cy.getWinsInARow();
		draws_in_a_row = cy.getDrawsInARow();
		losts_in_a_row = cy.getLostsInARow();
		last_game = cy.getLastGame();
		last_game_type = cy.getLastGameType();
		if (cy.getWeeklyTraining() != null) {
			wt_Monday1 = (cy.getWeeklyTraining().getMonday1() == null ? -1 : cy.getWeeklyTraining().getMonday1());
			wt_Monday2 = (cy.getWeeklyTraining().getMonday2() == null ? -1 : cy.getWeeklyTraining().getMonday2());
			wt_Monday3 = (cy.getWeeklyTraining().getMonday3() == null ? -1 : cy.getWeeklyTraining().getMonday3());
			wt_Tuesday1 = (cy.getWeeklyTraining().getTuesday1() == null ? -1 : cy.getWeeklyTraining().getTuesday1());
			wt_Tuesday2 = (cy.getWeeklyTraining().getTuesday2() == null ? -1 : cy.getWeeklyTraining().getTuesday2());
			wt_Tuesday3 = (cy.getWeeklyTraining().getTuesday3() == null ? -1 : cy.getWeeklyTraining().getTuesday3());
			wt_Wednesday1 = (cy.getWeeklyTraining().getWednesday1() == null ? -1 : cy.getWeeklyTraining().getWednesday1());
			wt_Wednesday2 = (cy.getWeeklyTraining().getWednesday2() == null ? -1 : cy.getWeeklyTraining().getWednesday2());
			wt_Wednesday3 = (cy.getWeeklyTraining().getWednesday3() == null ? -1 : cy.getWeeklyTraining().getWednesday3());
			wt_Thursday1 = (cy.getWeeklyTraining().getThursday1() == null ? -1 : cy.getWeeklyTraining().getThursday1());
			wt_Thursday2 = (cy.getWeeklyTraining().getThursday2() == null ? -1 : cy.getWeeklyTraining().getThursday2());
			wt_Thursday3 = (cy.getWeeklyTraining().getThursday3() == null ? -1 : cy.getWeeklyTraining().getThursday3());
			wt_Friday1 = (cy.getWeeklyTraining().getFriday1() == null ? -1 : cy.getWeeklyTraining().getFriday1());
			wt_Friday2 = (cy.getWeeklyTraining().getFriday2() == null ? -1 : cy.getWeeklyTraining().getFriday2());
			wt_Friday3 = (cy.getWeeklyTraining().getFriday3() == null ? -1 : cy.getWeeklyTraining().getFriday3());
			wt_Saturday1 = (cy.getWeeklyTraining().getSaturday1() == null ? -1 : cy.getWeeklyTraining().getSaturday1());
			wt_Saturday2 = (cy.getWeeklyTraining().getSaturday2() == null ? -1 : cy.getWeeklyTraining().getSaturday2());
			wt_Saturday3 = (cy.getWeeklyTraining().getSaturday3() == null ? -1 : cy.getWeeklyTraining().getSaturday3());
			wt_Sunday1 = (cy.getWeeklyTraining().getSunday1() == null ? -1 : cy.getWeeklyTraining().getSunday1());
			wt_Sunday2 = (cy.getWeeklyTraining().getSunday2() == null ? -1 : cy.getWeeklyTraining().getSunday2());
			wt_Sunday3 = (cy.getWeeklyTraining().getSunday3() == null ? -1 : cy.getWeeklyTraining().getSunday3());
			wt_last_changed = (cy.getWeeklyTraining().getLastChanged() == null ? "" : cy.getWeeklyTraining().getLastChanged());
		}
	}

	public Integer getTeam_userid() {
		return team_userid;
	}

	public void setTeam_userid(Integer team_userid) {
		this.team_userid = team_userid;
	}

	public Integer getTeam_playerid() {
		return team_playerid;
	}

	public void setTeam_playerid(Integer team_playerid) {
		this.team_playerid = team_playerid;
	}

	public String getTeam_useralias() {
		return team_useralias;
	}

	public void setTeam_useralias(String team_useralias) {
		this.team_useralias = team_useralias;
	}

	public Integer getTeam_id() {
		return team_id;
	}

	public void setTeam_id(Integer team_id) {
		this.team_id = team_id;
	}

	public Integer getB_team() {
		return b_team;
	}

	public void setB_team(Integer b_team) {
		this.b_team = b_team;
	}

	public Integer getMain_team_id() {
		return main_team_id;
	}

	public void setMain_team_id(Integer main_team_id) {
		this.main_team_id = main_team_id;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getTeam_long_name() {
		return team_long_name;
	}

	public void setTeam_long_name(String team_long_name) {
		this.team_long_name = team_long_name;
	}

	public Integer getTeam_country_id() {
		return team_country_id;
	}

	public void setTeam_country_id(Integer team_country_id) {
		this.team_country_id = team_country_id;
	}

	public Integer getTeam_city() {
		return team_city;
	}

	public void setTeam_city(Integer team_city) {
		this.team_city = team_city;
	}

	public String getStadium_name() {
		return stadium_name;
	}

	public void setStadium_name(String stadium_name) {
		this.stadium_name = stadium_name;
	}

	public Integer getStadium_north() {
		return stadium_north;
	}

	public void setStadium_north(Integer stadium_north) {
		this.stadium_north = stadium_north;
	}

	public Integer getStadium_south() {
		return stadium_south;
	}

	public void setStadium_south(Integer stadium_south) {
		this.stadium_south = stadium_south;
	}

	public Integer getStadium_east() {
		return stadium_east;
	}

	public void setStadium_east(Integer stadium_east) {
		this.stadium_east = stadium_east;
	}

	public Integer getStadium_west() {
		return stadium_west;
	}

	public void setStadium_west(Integer stadium_west) {
		this.stadium_west = stadium_west;
	}

	public Integer getStadium_neast() {
		return stadium_neast;
	}

	public void setStadium_neast(Integer stadium_neast) {
		this.stadium_neast = stadium_neast;
	}

	public Integer getStadium_nwest() {
		return stadium_nwest;
	}

	public void setStadium_nwest(Integer stadium_nwest) {
		this.stadium_nwest = stadium_nwest;
	}

	public Integer getStadium_seast() {
		return stadium_seast;
	}

	public void setStadium_seast(Integer stadium_seast) {
		this.stadium_seast = stadium_seast;
	}

	public Integer getStadium_swest() {
		return stadium_swest;
	}

	public void setStadium_swest(Integer stadium_swest) {
		this.stadium_swest = stadium_swest;
	}

	public Integer getSupporters() {
		return supporters;
	}

	public void setSupporters(Integer supporters) {
		this.supporters = supporters;
	}

	public Integer getAverage_attendance() {
		return average_attendance;
	}

	public void setAverage_attendance(Integer average_attendance) {
		this.average_attendance = average_attendance;
	}

	public Integer getDivision() {
		return division;
	}

	public void setDivision(Integer division) {
		this.division = division;
	}

	public Integer getSeries() {
		return series;
	}

	public void setSeries(Integer series) {
		this.series = series;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Integer getGames_without_winning() {
		return games_without_winning;
	}

	public void setGames_without_winning(Integer games_without_winning) {
		this.games_without_winning = games_without_winning;
	}

	public Integer getGames_without_losing() {
		return games_without_losing;
	}

	public void setGames_without_losing(Integer games_without_losing) {
		this.games_without_losing = games_without_losing;
	}

	public Integer getWins_in_a_row() {
		return wins_in_a_row;
	}

	public void setWins_in_a_row(Integer wins_in_a_row) {
		this.wins_in_a_row = wins_in_a_row;
	}

	public Integer getDraws_in_a_row() {
		return draws_in_a_row;
	}

	public void setDraws_in_a_row(Integer draws_in_a_row) {
		this.draws_in_a_row = draws_in_a_row;
	}

	public Integer getLosts_in_a_row() {
		return losts_in_a_row;
	}

	public void setLosts_in_a_row(Integer losts_in_a_row) {
		this.losts_in_a_row = losts_in_a_row;
	}

	public long getLast_game() {
		return last_game;
	}

	public void setLast_game(long last_game) {
		this.last_game = last_game;
	}

	public Integer getLast_game_type() {
		return last_game_type;
	}

	public void setLast_game_type(Integer last_game_type) {
		this.last_game_type = last_game_type;
	}

	public Integer getWt_Monday1() {
		return wt_Monday1;
	}

	public void setWt_Monday1(Integer wt_Monday1) {
		this.wt_Monday1 = wt_Monday1;
	}

	public Integer getWt_Monday2() {
		return wt_Monday2;
	}

	public void setWt_Monday2(Integer wt_Monday2) {
		this.wt_Monday2 = wt_Monday2;
	}

	public Integer getWt_Monday3() {
		return wt_Monday3;
	}

	public void setWt_Monday3(Integer wt_Monday3) {
		this.wt_Monday3 = wt_Monday3;
	}

	public Integer getWt_Tuesday1() {
		return wt_Tuesday1;
	}

	public void setWt_Tuesday1(Integer wt_Tuesday1) {
		this.wt_Tuesday1 = wt_Tuesday1;
	}

	public Integer getWt_Tuesday2() {
		return wt_Tuesday2;
	}

	public void setWt_Tuesday2(Integer wt_Tuesday2) {
		this.wt_Tuesday2 = wt_Tuesday2;
	}

	public Integer getWt_Tuesday3() {
		return wt_Tuesday3;
	}

	public void setWt_Tuesday3(Integer wt_Tuesday3) {
		this.wt_Tuesday3 = wt_Tuesday3;
	}

	public Integer getWt_Wednesday1() {
		return wt_Wednesday1;
	}

	public void setWt_Wednesday1(Integer wt_Wednesday1) {
		this.wt_Wednesday1 = wt_Wednesday1;
	}

	public Integer getWt_Wednesday2() {
		return wt_Wednesday2;
	}

	public void setWt_Wednesday2(Integer wt_Wednesday2) {
		this.wt_Wednesday2 = wt_Wednesday2;
	}

	public Integer getWt_Wednesday3() {
		return wt_Wednesday3;
	}

	public void setWt_Wednesday3(Integer wt_Wednesday3) {
		this.wt_Wednesday3 = wt_Wednesday3;
	}

	public Integer getWt_Thursday1() {
		return wt_Thursday1;
	}

	public void setWt_Thursday1(Integer wt_Thursday1) {
		this.wt_Thursday1 = wt_Thursday1;
	}

	public Integer getWt_Thursday2() {
		return wt_Thursday2;
	}

	public void setWt_Thursday2(Integer wt_Thursday2) {
		this.wt_Thursday2 = wt_Thursday2;
	}

	public Integer getWt_Thursday3() {
		return wt_Thursday3;
	}

	public void setWt_Thursday3(Integer wt_Thursday3) {
		this.wt_Thursday3 = wt_Thursday3;
	}

	public Integer getWt_Friday1() {
		return wt_Friday1;
	}

	public void setWt_Friday1(Integer wt_Friday1) {
		this.wt_Friday1 = wt_Friday1;
	}

	public Integer getWt_Friday2() {
		return wt_Friday2;
	}

	public void setWt_Friday2(Integer wt_Friday2) {
		this.wt_Friday2 = wt_Friday2;
	}

	public Integer getWt_Friday3() {
		return wt_Friday3;
	}

	public void setWt_Friday3(Integer wt_Friday3) {
		this.wt_Friday3 = wt_Friday3;
	}

	public Integer getWt_Saturday1() {
		return wt_Saturday1;
	}

	public void setWt_Saturday1(Integer wt_Saturday1) {
		this.wt_Saturday1 = wt_Saturday1;
	}

	public Integer getWt_Saturday2() {
		return wt_Saturday2;
	}

	public void setWt_Saturday2(Integer wt_Saturday2) {
		this.wt_Saturday2 = wt_Saturday2;
	}

	public Integer getWt_Saturday3() {
		return wt_Saturday3;
	}

	public void setWt_Saturday3(Integer wt_Saturday3) {
		this.wt_Saturday3 = wt_Saturday3;
	}

	public Integer getWt_Sunday1() {
		return wt_Sunday1;
	}

	public void setWt_Sunday1(Integer wt_Sunday1) {
		this.wt_Sunday1 = wt_Sunday1;
	}

	public Integer getWt_Sunday2() {
		return wt_Sunday2;
	}

	public void setWt_Sunday2(Integer wt_Sunday2) {
		this.wt_Sunday2 = wt_Sunday2;
	}

	public Integer getWt_Sunday3() {
		return wt_Sunday3;
	}

	public void setWt_Sunday3(Integer wt_Sunday3) {
		this.wt_Sunday3 = wt_Sunday3;
	}

	public String getWt_last_changed() {
		return wt_last_changed;
	}

	public void setWt_last_changed(String wt_last_changed) {
		this.wt_last_changed = wt_last_changed;
	}

}
