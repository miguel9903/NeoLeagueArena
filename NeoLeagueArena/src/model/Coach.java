package model;

import java.util.List;

public class Coach extends User {

	private List<Team> teams;

	public Coach(String firstName, String lastName, String email, String password, UserRole role, List<Team> teams) {
		super(firstName, lastName, email, password, role);
		this.teams = teams;
	}
	
	public Coach(String firstName, String lastName, String email, String password, List<Team> teams) {
		super(firstName, lastName, email, password, UserRole.COACH);
		this.teams = teams;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
}
