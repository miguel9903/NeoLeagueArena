package model;

import model.enums.GamePlatform;
import model.enums.TournamentPhase;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un torneo en el sistema de gestión de torneos de e-sports.
 * Contiene información sobre los equipos participantes, partidos, plataforma,
 * juego asociado y fase actual del torneo.
 */
public class Tournament {

    private int id;
    private List<Team> teams;
    private List<Match> matches;
    private GamePlatform platform;
    private Game game;
    private TournamentPhase phase;

    /**
     * Constructor por defecto para crear una instancia de Tournament con valores predeterminados.
     */
    public Tournament() {
        this.id = 0;
        this.teams = new ArrayList<>();
        this.matches = new ArrayList<>();
        this.platform = GamePlatform.UNKNOWN;
        this.game = null;
        this.phase = TournamentPhase.REGISTRATION;
    }

    /**
     * Constructor para crear una nueva instancia de Tournament con parámetros específicos.
     *
     * @param id       El identificador único del torneo.
     * @param teams    La lista de equipos participantes en el torneo.
     * @param matches  La lista de partidos programados en el torneo.
     * @param platform La plataforma del juego del torneo.
     * @param game     El juego asociado al torneo.
     * @param phase    La fase actual del torneo.
     */
    public Tournament(int id, List<Team> teams, List<Match> matches, GamePlatform platform, Game game, TournamentPhase phase) {
        this.id = id;
        this.teams = teams;
        this.matches = matches;
        this.platform = platform;
        this.game = game;
        this.phase = phase;
    }

    /**
     * Obtiene el identificador único del torneo.
     *
     * @return El identificador único del torneo.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del torneo.
     *
     * @param id El nuevo identificador único del torneo.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene la lista de equipos participantes en el torneo.
     *
     * @return La lista de equipos del torneo.
     */
    public List<Team> getTeams() {
        return teams;
    }

    /**
     * Establece la lista de equipos participantes en el torneo.
     *
     * @param teams La nueva lista de equipos del torneo.
     */
    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    /**
     * Obtiene la lista de partidos programados en el torneo.
     *
     * @return La lista de partidos del torneo.
     */
    public List<Match> getMatches() {
        return matches;
    }

    /**
     * Establece la lista de partidos programados en el torneo.
     *
     * @param matches La nueva lista de partidos del torneo.
     */
    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    /**
     * Obtiene la plataforma del juego del torneo.
     *
     * @return La plataforma del juego del torneo.
     */
    public GamePlatform getPlatform() {
        return platform;
    }

    /**
     * Establece la plataforma del juego del torneo.
     *
     * @param platform La nueva plataforma del juego del torneo.
     */
    public void setPlatform(GamePlatform platform) {
        this.platform = platform;
    }

    /**
     * Obtiene el juego asociado al torneo.
     *
     * @return El juego asociado al torneo.
     */
    public Game getGame() {
        return game;
    }

    /**
     * Establece el juego asociado al torneo.
     *
     * @param game El nuevo juego asociado al torneo.
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Obtiene la fase actual del torneo.
     *
     * @return La fase actual del torneo.
     */
    public TournamentPhase getPhase() {
        return phase;
    }

    /**
     * Establece la fase actual del torneo.
     *
     * @param phase La nueva fase del torneo.
     */
    public void setPhase(TournamentPhase phase) {
        this.phase = phase;
    }
}

