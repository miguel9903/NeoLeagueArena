package model;

import model.enums.GamePlatform;
import model.enums.TournamentPhase;

import java.util.ArrayList;
import java.util.List;

public class Tournament {

    private int id;
    private List<Team> teams;
    private List<Match> matches;
    private GamePlatform platform;
    private Game game;
    private TournamentPhase phase;

    public Tournament() {
        this.id = 0;
        this.teams = new ArrayList<>();
        this.matches = new ArrayList<>();
        this.platform = GamePlatform.UNKNOWN;
        this.game = null;                      
        this.phase = TournamentPhase.REGISTRATION; 
    }
    
    public Tournament(int id, List<Team> teams, List<Match> matches, GamePlatform platform, Game game, TournamentPhase phase) {
        this.id = id;
        this.teams = teams;
        this.matches = matches;
        this.platform = platform;
        this.game = game;
        this.phase = phase;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public GamePlatform getPlatform() {
        return platform;
    }

    public void setPlatform(GamePlatform platform) {
        this.platform = platform;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public TournamentPhase getPhase() {
        return phase;
    }

    public void setPhase(TournamentPhase phase) {
        this.phase = phase;
    }
    
}
