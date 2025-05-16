package model.persistence.dto;

import java.io.Serializable;
import java.util.List;

public class TeamDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String description;
    private String logo;
    private double score;
    private int ranking;
    private List<Integer> playerIds;
    private List<Integer> tournamentIds;
    private Integer coachId;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getLogo() {
        return logo;
    }
    
    public void setLogo(String logo) {
        this.logo = logo;
    }
    
    public double getScore() {
        return score;
    }
    
    public void setScore(double score) {
        this.score = score;
    }
    
    public int getRanking() {
        return ranking;
    }
    
    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
    
    public List<Integer> getPlayerIds() {
        return playerIds;
    }
    
    public void setPlayerIds(List<Integer> playerIds) {
        this.playerIds = playerIds;
    }
    
    public List<Integer> getTournamentIds() {
        return tournamentIds;
    }
    
    public void setTournamentIds(List<Integer> tournamentIds) {
        this.tournamentIds = tournamentIds;
    }
    
    public Integer getCoachId() {
        return coachId;
    }
    
    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }
    
}
