package model.persistence.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Clase DTO (Data Transfer Object) que representa a un torneo.
 */
public class TournamentDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private List<Integer> teamIds;
    private List<Integer> matchIds;
    private String platform;
    private GameDTO game;
    private String phase;

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
     * Obtiene la lista de identificadores de equipos del torneo.
     *
     * @return La lista de identificadores de equipos.
     */
    public List<Integer> getTeamIds() {
        return teamIds;
    }

    /**
     * Establece la lista de identificadores de equipos del torneo.
     *
     * @param teamIds La nueva lista de identificadores de equipos.
     */
    public void setTeamIds(List<Integer> teamIds) {
        this.teamIds = teamIds;
    }

    /**
     * Obtiene la lista de identificadores de partidos del torneo.
     *
     * @return La lista de identificadores de partidos.
     */
    public List<Integer> getMatchIds() {
        return matchIds;
    }

    /**
     * Establece la lista de identificadores de partidos del torneo.
     *
     * @param matchIds La nueva lista de identificadores de partidos.
     */
    public void setMatchIds(List<Integer> matchIds) {
        this.matchIds = matchIds;
    }

    /**
     * Obtiene la plataforma del torneo.
     *
     * @return La plataforma del torneo.
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * Establece la plataforma del torneo.
     *
     * @param platform La nueva plataforma del torneo.
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * Obtiene el juego asociado al torneo.
     *
     * @return El juego asociado al torneo.
     */
    public GameDTO getGame() {
        return game;
    }

    /**
     * Establece el juego asociado al torneo.
     *
     * @param game El nuevo juego asociado al torneo.
     */
    public void setGame(GameDTO game) {
        this.game = game;
    }

    /**
     * Obtiene la fase del torneo.
     *
     * @return La fase del torneo.
     */
    public String getPhase() {
        return phase;
    }

    /**
     * Establece la fase del torneo.
     *
     * @param phase La nueva fase del torneo.
     */
    public void setPhase(String phase) {
        this.phase = phase;
    }
}

