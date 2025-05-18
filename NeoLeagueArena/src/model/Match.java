package model;

import java.time.LocalDate;
import java.time.LocalTime;

import model.enums.MatchStatus;

/**
 * Representa un partido en el sistema de gestión de torneos de e-sports.
 * Contiene información sobre los equipos participantes, fechas, horarios,
 * resultados y estado del partido.
 */
public class Match {

    private int id;
    private Team teamA;
    private Team teamB;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Team winner;
    private double teamAScore;
    private double teamBScore;
    private String summary;
    private MatchStatus status;

    /**
     * Constructor por defecto para crear una instancia de Match con valores predeterminados.
     */
    public Match() {
        this.id = 0;
        this.teamA = null;
        this.teamB = null;
        this.date = LocalDate.now();
        this.startTime = LocalTime.of(0, 0);
        this.endTime = LocalTime.of(0, 0);
        this.winner = null;
        this.teamAScore = 0.0;
        this.teamBScore = 0.0;
        this.summary = "";
        this.status = MatchStatus.SCHEDULED;
    }

    /**
     * Constructor para crear una nueva instancia de Match con parámetros específicos.
     *
     * @param id          El identificador único del partido.
     * @param teamA       El primer equipo participante.
     * @param teamB       El segundo equipo participante.
     * @param date        La fecha del partido.
     * @param startTime   La hora de inicio del partido.
     * @param endTime     La hora de finalización del partido.
     * @param winner      El equipo ganador del partido.
     * @param teamAScore  La puntuación del equipo A.
     * @param teamBScore  La puntuación del equipo B.
     * @param summary     Un resumen del partido.
     * @param status      El estado actual del partido.
     */
    public Match(int id, Team teamA, Team teamB, LocalDate date, LocalTime startTime, LocalTime endTime, Team winner,
            double teamAScore, double teamBScore, String summary, MatchStatus status) {
        super();
        this.id = id;
        this.teamA = teamA;
        this.teamB = teamB;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.winner = winner;
        this.teamAScore = teamAScore;
        this.teamBScore = teamBScore;
        this.summary = summary;
        this.status = status;
    }

    /**
     * Obtiene el identificador único del partido.
     *
     * @return El identificador único del partido.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del partido.
     *
     * @param id El nuevo identificador único del partido.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el primer equipo participante.
     *
     * @return El primer equipo participante.
     */
    public Team getTeamA() {
        return teamA;
    }

    /**
     * Establece el primer equipo participante.
     *
     * @param teamA El nuevo primer equipo participante.
     */
    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    /**
     * Obtiene el segundo equipo participante.
     *
     * @return El segundo equipo participante.
     */
    public Team getTeamB() {
        return teamB;
    }

    /**
     * Establece el segundo equipo participante.
     *
     * @param teamB El nuevo segundo equipo participante.
     */
    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    /**
     * Obtiene la fecha del partido.
     *
     * @return La fecha del partido.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Establece la fecha del partido.
     *
     * @param date La nueva fecha del partido.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Obtiene la hora de inicio del partido.
     *
     * @return La hora de inicio del partido.
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /**
     * Establece la hora de inicio del partido.
     *
     * @param startTime La nueva hora de inicio del partido.
     */
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    /**
     * Obtiene la hora de finalización del partido.
     *
     * @return La hora de finalización del partido.
     */
    public LocalTime getEndTime() {
        return endTime;
    }

    /**
     * Establece la hora de finalización del partido.
     *
     * @param endTime La nueva hora de finalización del partido.
     */
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    /**
     * Obtiene el equipo ganador del partido.
     *
     * @return El equipo ganador del partido.
     */
    public Team getWinner() {
        return winner;
    }

    /**
     * Establece el equipo ganador del partido.
     *
     * @param winner El nuevo equipo ganador del partido.
     */
    public void setWinner(Team winner) {
        this.winner = winner;
    }

    /**
     * Obtiene la puntuación del equipo A.
     *
     * @return La puntuación del equipo A.
     */
    public double getTeamAScore() {
        return teamAScore;
    }

    /**
     * Establece la puntuación del equipo A.
     *
     * @param teamAScore La nueva puntuación del equipo A.
     */
    public void setTeamAScore(double teamAScore) {
        this.teamAScore = teamAScore;
    }

    /**
     * Obtiene la puntuación del equipo B.
     *
     * @return La puntuación del equipo B.
     */
    public double getTeamBScore() {
        return teamBScore;
    }

    /**
     * Establece la puntuación del equipo B.
     *
     * @param teamBScore La nueva puntuación del equipo B.
     */
    public void setTeamBScore(double teamBScore) {
        this.teamBScore = teamBScore;
    }

    /**
     * Obtiene un resumen del partido.
     *
     * @return Un resumen del partido.
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Establece un resumen del partido.
     *
     * @param summary El nuevo resumen del partido.
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * Obtiene el estado actual del partido.
     *
     * @return El estado actual del partido.
     */
    public MatchStatus getStatus() {
        return status;
    }

    /**
     * Establece el estado actual del partido.
     *
     * @param status El nuevo estado del partido.
     */
    public void setStatus(MatchStatus status) {
        this.status = status;
    }
}
