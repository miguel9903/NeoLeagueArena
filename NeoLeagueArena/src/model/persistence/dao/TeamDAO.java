package model.persistence.dao;

import java.util.ArrayList;

import model.Team;
import model.persistence.FileManager;
import utils.PersistencePaths;

public class TeamDAO implements InterfaceDAO<Team> {

	private ArrayList<Team> teams;
	private FileManager<Team> fileManager;

	public TeamDAO() {
		fileManager = new FileManager<>(PersistencePaths.TEAMS_FILE);
		teams = new ArrayList<>();
		loadFromFile();
	}

	public void loadFromFile() {
		ArrayList<Team> loaded = fileManager.readFromFile(Team.class);
		
		if (loaded != null) {
			teams = loaded;
		}
	}

	public void saveToFile() {
		fileManager.writeToFile(teams, Team.class);
	}

	private void loadInitialData() {
		Team team1 = new Team(
				1, 
				"Shadow Strikers", 
				"Equipo agresivo especializado en shooters, con tácticas rápidas y precisión mortal en cada partida."
				);
		Team team2 = new Team(
				2, 
				"Pixel Phantoms", 
				"Maestros en juegos estratégicos y tácticos, con una coordinación impecable y gran adaptabilidad en la escena coreana."
				);
		Team team3 = new Team(
				3, 
				"Quantum Blitz", 
				"Conocidos por su velocidad y trabajo en equipo, destacan en competencias internacionales de eSports con gran éxito."
				);
		Team team4 = new Team(
				4, 
				"Nebula Ninjas", 
				"Equipo innovador y versátil, reconocidos por su creatividad y estrategias sorprendentes en torneos globales."
				);

		teams.add(team1);
		teams.add(team2);
		teams.add(team3);
		teams.add(team4);
	}


	@Override
	public ArrayList<Team> getAll() {
		return new ArrayList<>(teams);
	}

	@Override
	public String getAllAsString() {
		StringBuilder sb = new StringBuilder();
		for (Team t : teams) {
			sb.append(t).append("\n");
		}
		return sb.toString();
	}

	@Override
	public boolean add(Team team) {
		if (find(team) == null) {
			teams.add(team);
			saveToFile();
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Team team) {
		Team found = find(team);
		if (found != null) {
			teams.remove(found);
			saveToFile();
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Team oldTeam, Team newTeam) {
		Team existing = find(oldTeam);
		if (existing != null) {
			teams.remove(existing);
			teams.add(newTeam);
			saveToFile();
			return true;
		}
		return false;
	}

	@Override
	public Team find(Team team) {
		for (Team t : teams) {
			if (t.getId() == team.getId()) {
				return t;
			}
		}
		return null;
	}

}
