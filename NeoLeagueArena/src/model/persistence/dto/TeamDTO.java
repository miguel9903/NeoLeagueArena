package model.persistence.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Clase DTO (Data Transfer Object) que representa a un equipo.
 */
public class TeamDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String description;
    private String logo;
    private double score;
    private int ranking;
    private List<Integer> playerIds;
    private List<Integer> tournamentIds;
    private Integer coachId;
    private String coachName;
    private List<PlayerDTO> players;

    /**
     * Obtiene el identificador único del equipo.
     *
     * @return El identificador único del equipo.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el identificador único del equipo.
     *
     * @param id El nuevo identificador único del equipo.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del equipo.
     *
     * @return El nombre del equipo.
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del equipo.
     *
     * @param name El nuevo nombre del equipo.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene la descripción del equipo.
     *
     * @return La descripción del equipo.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Establece la descripción del equipo.
     *
     * @param description La nueva descripción del equipo.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtiene la URL o ruta del logo del equipo.
     *
     * @return La URL o ruta del logo del equipo.
     */
    public String getLogo() {
        return logo;
    }

    /**
     * Establece la URL o ruta del logo del equipo.
     *
     * @param logo La nueva URL o ruta del logo del equipo.
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * Obtiene la puntuación del equipo.
     *
     * @return La puntuación del equipo.
     */
    public double getScore() {
        return score;
    }

    /**
     * Establece la puntuación del equipo.
     *
     * @param score La nueva puntuación del equipo.
     */
    public void setScore(double score) {
        this.score = score;
    }

    /**
     * Obtiene el ranking del equipo.
     *
     * @return El ranking del equipo.
     */
    public int getRanking() {
        return ranking;
    }

    /**
     * Establece el ranking del equipo.
     *
     * @param ranking El nuevo ranking del equipo.
     */
    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    /**
     * Obtiene la lista de identificadores de jugadores del equipo.
     *
     * @return La lista de identificadores de jugadores.
     */
    public List<Integer> getPlayerIds() {
        return playerIds;
    }

    /**
     * Establece la lista de identificadores de jugadores del equipo.
     *
     * @param playerIds La nueva lista de identificadores de jugadores.
     */
    public void setPlayerIds(List<Integer> playerIds) {
        this.playerIds = playerIds;
    }

    /**
     * Obtiene la lista de identificadores de torneos del equipo.
     *
     * @return La lista de identificadores de torneos.
     */
    public List<Integer> getTournamentIds() {
        return tournamentIds;
    }

    /**
     * Establece la lista de identificadores de torneos del equipo.
     *
     * @param tournamentIds La nueva lista de identificadores de torneos.
     */
    public void setTournamentIds(List<Integer> tournamentIds) {
        this.tournamentIds = tournamentIds;
    }

    /**
     * Obtiene el identificador del entrenador del equipo.
     *
     * @return El identificador del entrenador.
     */
    public Integer getCoachId() {
        return coachId;
    }

    /**
     * Establece el identificador del entrenador del equipo.
     *
     * @param coachId El nuevo identificador del entrenador.
     */
    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    /**
     * Obtiene el nombre del entrenador del equipo.
     *
     * @return El nombre del entrenador.
     */
    public String getCoachName() {
        return coachName;
    }

    /**
     * Establece el nombre del entrenador del equipo.
     *
     * @param coachName El nuevo nombre del entrenador.
     */
    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    /**
     * Obtiene el serialVersionUID.
     *
     * @return El serialVersionUID.
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * Obtiene la lista de jugadores del equipo.
     *
     * @return La lista de jugadores.
     */
    public List<PlayerDTO> getPlayers() {
        return players;
    }

    /**
     * Establece la lista de jugadores del equipo.
     *
     * @param players La nueva lista de jugadores.
     */
    public void setPlayers(List<PlayerDTO> players) {
        this.players = players;
    }

    /**
     * Devuelve una representación en cadena del objeto TeamDTO.
     *
     * @return Una cadena que representa al objeto TeamDTO.
     */
    @Override
    public String toString() {
        return "TeamDTO [id=" + id + ", name=" + name + ", description=" + description + ", logo=" + logo + ", score="
                + score + ", ranking=" + ranking + ", playerIds=" + playerIds + ", tournamentIds=" + tournamentIds
                + ", coachId=" + coachId + ", coachName=" + coachName + ", players=" + players + "]";
    }
}

