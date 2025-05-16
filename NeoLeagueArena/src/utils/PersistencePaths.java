package utils;

public class PersistencePaths {

    // Base folders
    public static final String ARCHIVES_FOLDER = "archives/";
    public static final String USERS_FOLDER = ARCHIVES_FOLDER + "users/";

    // User-specific files
    public static final String PLAYERS_FILE = USERS_FOLDER + "players.dat";  
    public static final String COACHES_FILE = USERS_FOLDER + "coaches.dat";  
    public static final String ADMINS_FILE = USERS_FOLDER + "admins.dat";    

    // General entity files
    public static final String TOURNAMENTS_FILE = ARCHIVES_FOLDER + "tournaments.dat";
    public static final String TEAMS_FILE = ARCHIVES_FOLDER + "teams.dat";      
    public static final String GAMES_FILE = ARCHIVES_FOLDER + "games.dat";   
    public static final String MATCHES_FILE = ARCHIVES_FOLDER + "matches.dat";   
}
