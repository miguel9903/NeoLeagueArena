package model;

import java.util.List;

import model.enums.UserRole;

public class Coach extends User {

	private List<Team> teams;

	public Coach() {
		super();
	}
	
	public Coach(int id, String firstName, String lastName, String email, String password, String country, String city,
			UserRole role, List<Team> teams) {
		super(id, firstName, lastName, email, password, country, city, role);
		this.teams = teams;
	}

	public Coach(int id, String firstName, String lastName, String email, String password, String country, String city, List<Team> teams) {
		super(id, firstName, lastName, email, password, country, city, UserRole.COACH);
		this.teams = teams;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
}
//Intento1212sjhsjsh
