package model;

import java.time.LocalDate;
import java.time.LocalTime;

import model.enums.MatchStatus;

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

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Team getTeamA() {
        return teamA;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }

    public double getTeamAScore() {
        return teamAScore;
    }

    public void setTeamAScore(double teamAScore) {
        this.teamAScore = teamAScore;
    }

    public double getTeamBScore() {
        return teamBScore;
    }

    public void setTeamBScore(double teamBScore) {
        this.teamBScore = teamBScore;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public MatchStatus getStatus() {
        return status;
    }

    public void setStatus(MatchStatus status) {
        this.status = status;
    }
    
}
