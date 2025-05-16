package model.persistence.dto;

import java.io.Serializable;
import java.util.List;

public class TournamentDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private List<Integer> teamIds;
    private List<Integer> matchIds;
    private String platform;
    private GameDTO game;
    private String phase;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getTeamIds() {
        return teamIds;
    }

    public void setTeamIds(List<Integer> teamIds) {
        this.teamIds = teamIds;
    }

    public List<Integer> getMatchIds() {
        return matchIds;
    }

    public void setMatchIds(List<Integer> matchIds) {
        this.matchIds = matchIds;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public GameDTO getGame() {
        return game;
    }

    public void setGame(GameDTO game) {
        this.game = game;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }
}
