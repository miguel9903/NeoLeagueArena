package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un equipo en el sistema de gestión de torneos de e-sports.
 * Contiene información sobre el equipo, como su nombre, descripción, logo,
 * puntuación, ranking, jugadores, torneos y entrenador.
 */
public class Team {

    private int id;
    private String name;
    private String description;
    private String logo;
    private double score;
    private int ranking;
    private List<Player> players;
    private List<Tournament> tournaments;
    private Coach coach;

    /**
     * Constructor por defecto para crear una instancia de Team con valores predeterminados.
     */
    public Team() {
        this.id = 0;
        this.name = "";
        this.description = "";
        this.logo = "";
        this.score = 0.0;
        this.ranking = 0;
        this.players = new ArrayList<>();
        this.tournaments = new ArrayList<>();
        this.coach = null;
    }

    /**
     * Constructor para crear una nueva instancia de Team con parámetros específicos.
     *
     * @param id          El identificador único del equipo.
     * @param name        El nombre del equipo.
     * @param description La descripción del equipo.
     */
    public Team(int id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.logo = "";
        this.score = 0.0;
        this.ranking = 0;
        this.players = new ArrayList<>();
        this.tournaments = new ArrayList<>();
        this.coach = null;
    }

    /**
     * Constructor para crear una nueva instancia de Team con todos los parámetros.
     *
     * @param id           El identificador único del equipo.
     * @param name         El nombre del equipo.
     * @param description  La descripción del equipo.
     * @param logo         La URL o ruta del logo del equipo.
     * @param score        La puntuación del equipo.
     * @param ranking      El ranking del equipo.
     * @param players      La lista de jugadores del equipo.
     * @param tournaments  La lista de torneos en los que participa el equipo.
     * @param coach        El entrenador del equipo.
     */
    public Team(int id, String name, String description, String logo, double score, int ranking, List<Player> players,
            List<Tournament> tournaments, Coach coach) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.logo = logo;
        this.score = score;
        this.ranking = ranking;
        this.players = players;
        this.tournaments = tournaments;
        this.coach = coach;
    }

    /**
     * Obtiene el identificador único del equipo.
     *
     * @return El identificador único del equipo.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del equipo.
     *
     * @param id El nuevo identificador único del equipo.
     */
    public void setId(int id) {
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
     * Obtiene la lista de jugadores del equipo.
     *
     * @return La lista de jugadores del equipo.
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Establece la lista de jugadores del equipo.
     *
     * @param players La nueva lista de jugadores del equipo.
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    /**
     * Obtiene la lista de torneos en los que participa el equipo.
     *
     * @return La lista de torneos del equipo.
     */
    public List<Tournament> getTournaments() {
        return tournaments;
    }

    /**
     * Establece la lista de torneos en los que participa el equipo.
     *
     * @param tournaments La nueva lista de torneos del equipo.
     */
    public void setTournaments(List<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    /**
     * Obtiene el entrenador del equipo.
     *
     * @return El entrenador del equipo.
     */
    public Coach getCoach() {
        return coach;
    }

    /**
     * Establece el entrenador del equipo.
     *
     * @param coach El nuevo entrenador del equipo.
     */
    public void setCoach(Coach coach) {
        this.coach = coach;
    }
}

