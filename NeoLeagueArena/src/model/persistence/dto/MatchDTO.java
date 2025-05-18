package model.persistence.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Clase DTO (Data Transfer Object) que representa a un partido.
 */
public class MatchDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private int teamAId;
    private int teamBId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer winnerId;
    private double teamAScore;
    private double teamBScore;
    private String summary;
    private String status;

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
     * Obtiene el identificador del primer equipo participante.
     *
     * @return El identificador del primer equipo participante.
     */
    public int getTeamAId() {
        return teamAId;
    }

    /**
     * Establece el identificador del primer equipo participante.
     *
     * @param teamAId El nuevo identificador del primer equipo participante.
     */
    public void setTeamAId(int teamAId) {
        this.teamAId = teamAId;
    }

    /**
     * Obtiene el identificador del segundo equipo participante.
     *
     * @return El identificador del segundo equipo participante.
     */
    public int getTeamBId() {
        return teamBId;
    }

    /**
     * Establece el identificador del segundo equipo participante.
     *
     * @param teamBId El nuevo identificador del segundo equipo participante.
     */
    public void setTeamBId(int teamBId) {
        this.teamBId = teamBId;
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
     * Obtiene el identificador del equipo ganador.
     *
     * @return El identificador del equipo ganador.
     */
    public Integer getWinnerId() {
        return winnerId;
    }

    /**
     * Establece el identificador del equipo ganador.
     *
     * @param winnerId El nuevo identificador del equipo ganador.
     */
    public void setWinnerId(Integer winnerId) {
        this.winnerId = winnerId;
    }

    /**
     * Obtiene la puntuación del primer equipo.
     *
     * @return La puntuación del primer equipo.
     */
    public double getTeamAScore() {
        return teamAScore;
    }

    /**
     * Establece la puntuación del primer equipo.
     *
     * @param teamAScore La nueva puntuación del primer equipo.
     */
    public void setTeamAScore(double teamAScore) {
        this.teamAScore = teamAScore;
    }

    /**
     * Obtiene la puntuación del segundo equipo.
     *
     * @return La puntuación del segundo equipo.
     */
    public double getTeamBScore() {
        return teamBScore;
    }

    /**
     * Establece la puntuación del segundo equipo.
     *
     * @param teamBScore La nueva puntuación del segundo equipo.
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
     * Obtiene el estado del partido.
     *
     * @return El estado del partido.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Establece el estado del partido.
     *
     * @param status El nuevo estado del partido.
     */
    public void setStatus(String status) {
        this.status = status;
    }
}

