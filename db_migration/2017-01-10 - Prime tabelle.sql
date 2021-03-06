CREATE TABLE D_TRAINING 
(
  ID NUMBER NOT NULL,
  IDL NUMBER NOT NULL,
  DESCR VARCHAR2(50),
  CONSTRAINT D_TRAINING_PK PRIMARY KEY 
  (ID, IDL) ENABLE 
);

CREATE TABLE D_LANGUAGE
(
  ID NUMBER NOT NULL,
  IDL NUMBER NOT NULL,
  DESCR VARCHAR2(50),
  CONSTRAINT D_LANGUAGE_PK PRIMARY KEY 
  (ID, IDL) ENABLE 
);

CREATE TABLE D_COUNTRY
(
  ID NUMBER NOT NULL,  
  IDL NUMBER NOT NULL,
  NUM_DIV NUMBER NOT NULL,
  DESCR VARCHAR2(50),
  CONSTRAINT D_COUNTRY_PK PRIMARY KEY 
  (ID, IDL) ENABLE 
);

CREATE TABLE D_CITY
(
  ID NUMBER NOT NULL,  
  IDL NUMBER NOT NULL,
  ID_COUNTRY NUMBER NOT NULL,
  DESCR VARCHAR2(50),
  CONSTRAINT D_CITY_PK PRIMARY KEY 
  (ID, IDL) ENABLE 
);

CREATE TABLE D_EXPERIENCE
(
  ID NUMBER NOT NULL,  
  IDL NUMBER NOT NULL,
  DESCR VARCHAR2(50),
  CONSTRAINT D_EXPERIENCE_PK PRIMARY KEY 
  (ID, IDL) ENABLE 
);

CREATE TABLE D_POSITION
(
  ID NUMBER NOT NULL,  
  IDL NUMBER NOT NULL,
  DESCR VARCHAR2(50),
  CONSTRAINT D_POSITION_PK PRIMARY KEY 
  (ID, IDL) ENABLE 
);

CREATE TABLE D_SIDE
(
  ID NUMBER NOT NULL,  
  IDL NUMBER NOT NULL,
  DESCR VARCHAR2(50),
  CONSTRAINT D_SIDE_PK PRIMARY KEY 
  (ID, IDL) ENABLE 
);

CREATE TABLE D_FUTURE
(
  ID NUMBER NOT NULL,  
  IDL NUMBER NOT NULL,	
  DESCR VARCHAR2(150),
  CONSTRAINT D_FUTURE_PK PRIMARY KEY 
  (ID, IDL) ENABLE 
);

CREATE TABLE D_SKILL
(
  ID NUMBER NOT NULL,  
  IDL NUMBER NOT NULL,
  DESCR VARCHAR2(150),
  CONSTRAINT D_SKILL_PK PRIMARY KEY 
  (ID, IDL) ENABLE 
);

CREATE TABLE D_DBDATA
(
  MIN_PLAYER_ID NUMBER NOT NULL,  
  MAX_PLAYER_ID NUMBER NOT NULL,
  MIN_TEAM_ID NUMBER NOT NULL,
  MAX_TEAM_ID NUMBER NOT NULL, 
  IDL NUMBER NOT NULL
);

CREATE TABLE D_GAME_TEAM
(
  matchId NUMBER NOT NULL,
  data_m varchar2(50),
  season NUMBER,
  played NUMBER,
  type varchar2(50),
  round NUMBER,
  homeTeam varchar2(50),
  homeTeamId NUMBER,
  homeCity NUMBER,
  awayTeam varchar2(50),
  awayTeamId NUMBER,
  awayCity NUMBER,
  homeGoals NUMBER,
  awayGoals NUMBER,
  CONSTRAINT D_GAME_TEAM_PK PRIMARY KEY (matchId) ENABLE 
);

CREATE TABLE D_TEAM
(
	TEAM_USERID NUMBER,
	TEAM_PLAYERID NUMBER,
	TEAM_USERALIAS VARCHAR(100),
	TEAM_ID NUMBER,
	B_TEAM NUMBER,
	MAIN_TEAM_ID NUMBER,
	TEAM_NAME VARCHAR(100),
	TEAM_LONG_NAME VARCHAR(100),
	TEAM_COUNTRY_ID NUMBER,
	TEAM_CITY NUMBER,
	STADIUM_NAME VARCHAR(100),
	STADIUM_NORTH NUMBER,
	STADIUM_SOUTH NUMBER,
	STADIUM_EAST NUMBER,
	STADIUM_WEST NUMBER,
	STADIUM_NEAST NUMBER,
	STADIUM_NWEST NUMBER,
	STADIUM_SEAST NUMBER,
	STADIUM_SWEST NUMBER,
	SUPPORTERS NUMBER,
	AVERAGE_ATTENDANCE NUMBER,
	DIVISION NUMBER,
	SERIES NUMBER,
	POSITION NUMBER,
	GAMES_WITHOUT_WINNING NUMBER,
	GAMES_WITHOUT_LOSING NUMBER,
	WINS_IN_A_ROW NUMBER,
	DRAWS_IN_A_ROW NUMBER,
	LOSTS_IN_A_ROW NUMBER,
	LAST_GAME NUMBER,
	LAST_GAME_TYPE NUMBER,
	WT_MONDAY1 NUMBER,
	WT_MONDAY2 NUMBER,
	WT_MONDAY3 NUMBER,
	WT_TUESDAY1 NUMBER,
	WT_TUESDAY2 NUMBER,
	WT_TUESDAY3 NUMBER,
	WT_WEDNESDAY1 NUMBER,
	WT_WEDNESDAY2 NUMBER,
	WT_WEDNESDAY3 NUMBER,
	WT_THURSDAY1 NUMBER,
	WT_THURSDAY2 NUMBER,
	WT_THURSDAY3 NUMBER,
	WT_FRIDAY1 NUMBER,
	WT_FRIDAY2 NUMBER,
	WT_FRIDAY3 NUMBER,
	WT_SATURDAY1 NUMBER,
	WT_SATURDAY2 NUMBER,
	WT_SATURDAY3 NUMBER,
	WT_SUNDAY1 NUMBER,
	WT_SUNDAY2 NUMBER,
	WT_SUNDAY3 NUMBER,
	WT_LAST_CHANGED VARCHAR(100),
  CONSTRAINT D_TEAM_PK PRIMARY KEY 
  (TEAM_ID) ENABLE 
);

CREATE TABLE D_PLAYER_TALENT
(
	PLAYERID NUMBER,
	ID NUMBER,
 CONSTRAINT D_PLAYER_TALENT_PK PRIMARY KEY 
  (PLAYERID, ID) ENABLE 
);

CREATE TABLE D_PLAYER_NT
(
	PLAYERID NUMBER,
	ID NUMBER,
	CAPS NUMBER,
	CAPSSUB21 NUMBER,
	CAPSSUB18 NUMBER,
	GOALS NUMBER,
	GOALSSUB21 NUMBER,
	GOALSSUB18 NUMBER,
	ASSISTSNT NUMBER,
	
 CONSTRAINT D_PLAYER_NT_PK PRIMARY KEY 
  (PLAYERID, ID) ENABLE 
);

CREATE TABLE D_PLAYER_ADAPT
(
	PLAYERID NUMBER,
	COUNTRY NUMBER,
	ACTIVE NUMBER,
	DAYS NUMBER,
	VALUE VARCHAR2(200),
 CONSTRAINT D_PLAYER_ADAPT_PK PRIMARY KEY 
  (PLAYERID, COUNTRY) ENABLE 
);

CREATE TABLE D_PLAYER
(
	PLAYERID NUMBER,
	USERID NUMBER,
	LASTLOGIN VARCHAR2(4000),
	REGISTRATIONDATE VARCHAR2(4000),
	TEAMID NUMBER,
	TEAMNAME VARCHAR2(4000),
	PLAYERNAME VARCHAR2(4000),
	POSITIONFULL VARCHAR2(4000),
	POSITION NUMBER,
	SIDELEFT NUMBER,
	SIDERIGHT NUMBER,
	SIDECENTER NUMBER,
	AGE NUMBER,
	BIRTHCITY NUMBER,
	BIRTHCITY_CAPS NUMBER,
	BIRTHCITY_CAPSU21 NUMBER,
	BIRTHCITY_CAPSU18 NUMBER,
	BIRTHCITY_GOALS NUMBER,
	BIRTHCITY_GOALSU21 NUMBER,
	BIRTHCITY_GOALSU18 NUMBER,
	BIRTHDAY NUMBER,
	BIRTHMONTH NUMBER,
	BIRTHYEAR NUMBER,
	NEWBIRTHDAY NUMBER,
	NEWBIRTHYEAR NUMBER,
	NATIONALITY NUMBER,
	INJURED NUMBER,
	INJURED_GAMES NUMBER,
	SUSPENDED NUMBER,
	SUSPENDED_GAMES NUMBER,
	SUSPENDEDINT NUMBER,
	SUSPENDEDINT_GAMES NUMBER,
	FITNESS NUMBER,
	MORALE NUMBER,
	ADAPT NUMBER,
	CONFIDENCE NUMBER,
	FAVORITEFOOT NUMBER,
	INTRANK NUMBER,
	NATRANK NUMBER,
	HANDLING NUMBER,
	OUTOFAREA NUMBER,
	REFLEXES NUMBER,
	AGILITY NUMBER,
	TACKLING NUMBER,
	HEADING NUMBER,
	SHORTPASSES NUMBER,
	POSITIONING NUMBER,
	FINISHING NUMBER,
	TECHNIQUE NUMBER,
	SPEED NUMBER,
	STRENGTH NUMBER,
	THROWING NUMBER,
	GAMEVISION NUMBER,
	LONGPASSES NUMBER,
	CROSSES NUMBER,
	LONGSHOTS NUMBER,
	DRIBBLING NUMBER,
	JUMPING NUMBER,
	ACCELERATION NUMBER,
	MARKING NUMBER,
	SETPIECES NUMBER,
	FIRSTTOUCH NUMBER,
	COMMANDOFAREA NUMBER,
	CONSISTENCY NUMBER,
	FLAIR NUMBER,
	CONCENTRATION NUMBER,
	ANTICIPATION NUMBER,
	DECISIONS NUMBER,
	COMPOSURE NUMBER,
	BRAVERY NUMBER,
	CREATIVITY NUMBER,
	INFLUENCE NUMBER,
	SKILLSWEEK VARCHAR2(4000),
	EXPERIENCE NUMBER,
	VALUE NUMBER,
	WAGE NUMBER,
	CONTRACT NUMBER,
	CONTRACTROLE NUMBER,
	LASTCONTRACTDATE VARCHAR2(4000),
	YOUTHTEAM NUMBER,
	TRANSFERLIST NUMBER,
	RELEASE NUMBER,
	LOANLIST NUMBER,
	LOANFROM NUMBER,
	LOANTO NUMBER,
	LOANRETURNDATE NUMBER,
	LASTTRAINING NUMBER,
	DATELASTTRAINING NUMBER,
	DOUBLENAT NUMBER,
	COUNTRYNT NUMBER,
	NTSQUAD NUMBER,
	GOALS NUMBER,
	GOALSCAREER NUMBER,
	ASSISTS NUMBER,
	ASSISTSCAREER NUMBER,
 CONSTRAINT D_PLAYER_PK PRIMARY KEY 
  (PLAYERID) ENABLE 
);
