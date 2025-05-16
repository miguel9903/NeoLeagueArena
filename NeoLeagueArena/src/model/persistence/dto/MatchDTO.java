package model.persistence.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

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
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public int getTeamAId() {
        return teamAId;
    }
    
    public void setTeamAId(int teamAId) {
        this.teamAId = teamAId;
    }

    public int getTeamBId() {
        return teamBId;
    }
    
    public void setTeamBId(int teamBId) {
        this.teamBId = teamBId;
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

    public Integer getWinnerId() {
        return winnerId;
    }
    
    public void setWinnerId(Integer winnerId) {
        this.winnerId = winnerId;
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

    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}
