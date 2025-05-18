package utils;

/**
 * Clase que contiene constantes para las rutas de persistencia de la aplicación.
 */
public class PersistencePaths {

    // Base folder
    /** Ruta de la carpeta base de archivos. */
    public static final String ARCHIVES_FOLDER = "archives/";

    // Folder for user data
    /** Ruta de la carpeta de datos de usuarios. */
    public static final String USERS_FOLDER = ARCHIVES_FOLDER + "users/";
    /** Ruta de la carpeta de administradores. */
    public static final String ADMINS_FOLDER = USERS_FOLDER + "admins/";
    /** Ruta de la carpeta de entrenadores. */
    public static final String COACHES_FOLDER = USERS_FOLDER + "coaches/";
    /** Ruta de la carpeta de jugadores. */
    public static final String PLAYERS_FOLDER = USERS_FOLDER + "players/";

    // Folder for general entities (same level as USERS_FOLDER)
    /** Ruta de la carpeta de torneos. */
    public static final String TOURNAMENTS_FOLDER = ARCHIVES_FOLDER + "tournaments/";
    /** Ruta de la carpeta de equipos. */
    public static final String TEAMS_FOLDER = ARCHIVES_FOLDER + "teams/";
    /** Ruta de la carpeta de juegos. */
    public static final String GAMES_FOLDER = ARCHIVES_FOLDER + "games/";
    /** Ruta de la carpeta de partidos. */
    public static final String MATCHES_FOLDER = ARCHIVES_FOLDER + "matches/";

    // Files inside user folders
    /** Ruta del archivo de administradores. */
    public static final String ADMINS_FILE = ADMINS_FOLDER + "admins.dat";
    /** Ruta del archivo de entrenadores. */
    public static final String COACHES_FILE = COACHES_FOLDER + "coaches.dat";
    /** Ruta del archivo de jugadores. */
    public static final String PLAYERS_FILE = PLAYERS_FOLDER + "players.dat";

    // Files inside general entity folders
    /** Ruta del archivo de torneos. */
    public static final String TOURNAMENTS_FILE = TOURNAMENTS_FOLDER + "tournaments.dat";
    /** Ruta del archivo de equipos. */
    public static final String TEAMS_FILE = TEAMS_FOLDER + "teams.dat";
    /** Ruta del archivo de juegos. */
    public static final String GAMES_FILE = GAMES_FOLDER + "games.dat";
    /** Ruta del archivo de partidos. */
    public static final String MATCHES_FILE = MATCHES_FOLDER + "matches.dat";
}
