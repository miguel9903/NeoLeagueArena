package model;

import java.util.ArrayList;
import java.util.List;

import model.persistence.dao.AdminDAO;
import model.persistence.dao.PlayerDAO;
import model.persistence.dao.TeamDAO;
import model.persistence.dao.CoachDAO;

import model.persistence.dto.AdminDTO;
import model.persistence.dto.PlayerDTO;
import model.persistence.dto.TeamDTO;
import model.persistence.dto.CoachDTO;
import model.persistence.dto.UserDTO;  // Assuming a common interface or base class for users

import model.persistence.mapper.AdminMapper;
import model.persistence.mapper.CoachMapper;
import model.persistence.mapper.PlayerMapper;
import model.persistence.mapper.TeamMapper;

public class NeoLeagueArena {

	private AdminDAO adminDAO;
	private PlayerDAO playerDAO;
	private CoachDAO coachDAO;
	private TeamDAO teamDAO;


	public NeoLeagueArena() {
		adminDAO = new AdminDAO();
		playerDAO = new PlayerDAO();
		coachDAO = new CoachDAO();
		teamDAO = new TeamDAO();
	}

	// ----------------- Admin methods -----------------

	public boolean addAdmin(AdminDTO adminDTO) {
		Admin admin = AdminMapper.convertAdminDTOToAdmin(adminDTO);
		return adminDAO.add(admin);
	}

	public boolean deleteAdmin(AdminDTO adminDTO) {
		Admin admin = AdminMapper.convertAdminDTOToAdmin(adminDTO);
		return adminDAO.delete(admin);
	}

	public boolean updateAdmin(AdminDTO oldAdminDTO, AdminDTO newAdminDTO) {
		Admin oldAdmin = AdminMapper.convertAdminDTOToAdmin(oldAdminDTO);
		Admin newAdmin = AdminMapper.convertAdminDTOToAdmin(newAdminDTO);
		return adminDAO.update(oldAdmin, newAdmin);
	}

	public ArrayList<AdminDTO> getAllAdmins() {
		ArrayList<Admin> admins = adminDAO.getAll();
		ArrayList<AdminDTO> adminDTOs = new ArrayList<>();

		for (Admin admin : admins) {
			System.out.print(admin.toString());
		}


		for (Admin admin : admins) {
			AdminDTO dto = AdminMapper.convertAdminToAdminDTO(admin);
			adminDTOs.add(dto);
		}

		return adminDTOs;
	}

	public void loadAdmins() {
		adminDAO.loadFromFile();
	}

	public void saveAdmins() {
		adminDAO.saveToFile();
	}

	// ----------------- Player methods -----------------

	public boolean addPlayer(PlayerDTO playerDTO) {
		Player player = PlayerMapper.convertPlayerDTOToPlayer(playerDTO);
		return playerDAO.add(player);
	}

	public boolean deletePlayer(PlayerDTO playerDTO) {
		Player player = PlayerMapper.convertPlayerDTOToPlayer(playerDTO);
		return playerDAO.delete(player);
	}

	public boolean updatePlayer(PlayerDTO oldPlayerDTO, PlayerDTO newPlayerDTO) {
		Player oldPlayer = PlayerMapper.convertPlayerDTOToPlayer(oldPlayerDTO);
		Player newPlayer = PlayerMapper.convertPlayerDTOToPlayer(newPlayerDTO);
		return playerDAO.update(oldPlayer, newPlayer);
	}

	public ArrayList<PlayerDTO> getAllPlayers() {
		ArrayList<Player> players = playerDAO.getAll();
		ArrayList<PlayerDTO> playerDTOs = new ArrayList<>();
		
		for (Player player : players) {
			PlayerDTO dto = PlayerMapper.convertPlayerToPlayerDTO(player);
			playerDTOs.add(dto);
		}
		
		return playerDTOs;
	}

	public void loadPlayers() {
		playerDAO.loadFromFile();
	}

	public void savePlayers() {
		playerDAO.saveToFile();
	}

	public PlayerDTO findPlayer(PlayerDTO playerDTO) {
		Player player = PlayerMapper.convertPlayerDTOToPlayer(playerDTO);
		Player foundPlayer = playerDAO.find(player);
		PlayerDTO foundPlayerDTO = PlayerMapper.convertPlayerToPlayerDTO(foundPlayer);

		return foundPlayerDTO;
	}

	// ----------------- Coach methods -----------------

	public boolean addCoach(CoachDTO coachDTO) {
		Coach coach = CoachMapper.convertCoachDTOToCoach(coachDTO);
		return coachDAO.add(coach);
	}

	public boolean deleteCoach(CoachDTO coachDTO) {
		Coach coach = CoachMapper.convertCoachDTOToCoach(coachDTO);
		return coachDAO.delete(coach);
	}

	public boolean updateCoach(CoachDTO oldCoachDTO, CoachDTO newCoachDTO) {
		Coach oldCoach = CoachMapper.convertCoachDTOToCoach(oldCoachDTO);
		Coach newCoach = CoachMapper.convertCoachDTOToCoach(newCoachDTO);
		return coachDAO.update(oldCoach, newCoach);
	}

	public ArrayList<CoachDTO> getAllCoaches() {
		ArrayList<Coach> coaches = coachDAO.getAll();
		ArrayList<CoachDTO> coachDTOs = new ArrayList<>();
		
		for (Coach coach : coaches) {
			CoachDTO dto = CoachMapper.convertCoachToCoachDTO(coach);
			coachDTOs.add(dto);
		}
		
		return coachDTOs;
	}
	
	public CoachDTO findCoach(CoachDTO coachDTO) {
		if (coachDTO.getId() == -1) return null;
		
		Coach coach = CoachMapper.convertCoachDTOToCoach(coachDTO);
		Coach foundCoach = coachDAO.find(coach);
		CoachDTO foundTeamDTO = CoachMapper.convertCoachToCoachDTO(foundCoach);

		return foundTeamDTO;
	}

	public void loadCoaches() {
		coachDAO.loadFromFile();
	}

	public void saveCoaches() {
		coachDAO.saveToFile();
	}

	// ----------------- Team methods -----------------

	public boolean addTeam(TeamDTO teamDTO) {
		Team team = TeamMapper.convertTeamDTOToTeam(teamDTO);
		return teamDAO.add(team);
	}

	public boolean deleteTeam(TeamDTO teamDTO) {
		Team team = TeamMapper.convertTeamDTOToTeam(teamDTO);
		return teamDAO.delete(team);
	}

	public boolean updateTeam(TeamDTO oldTeamDTO, TeamDTO newTeamDTO) {
		Team oldTeam = TeamMapper.convertTeamDTOToTeam(oldTeamDTO);
		Team newTeam = TeamMapper.convertTeamDTOToTeam(newTeamDTO);
		return teamDAO.update(oldTeam, newTeam);
	}

	public ArrayList<TeamDTO> getAllTeams() {
		ArrayList<Team> teams = teamDAO.getAll();
		ArrayList<TeamDTO> teamDTOs = new ArrayList<>();

		for (Team team : teams) {
			TeamDTO dto = TeamMapper.convertTeamToTeamDTO(team);
			teamDTOs.add(dto);
		}

		return teamDTOs;
	}
	
	public TeamDTO getTeamWithPlayers(int teamId) {
	    TeamDTO teamDTO = new TeamDTO();
	    teamDTO.setId(teamId);
	    
	    TeamDTO foundTeam = findTeam(teamDTO);
	    
	    if (foundTeam != null && foundTeam.getPlayerIds() != null && !foundTeam.getPlayerIds().isEmpty()) {
	        List<PlayerDTO> teamPlayers = new ArrayList<>();
	        
	        for (Integer id : foundTeam.getPlayerIds()) {
	            PlayerDTO playerDTO = new PlayerDTO();
	            playerDTO.setId(id);
	            
	            PlayerDTO foundPlayer = findPlayer(playerDTO);
	            
	            if (foundPlayer != null) {
	                teamPlayers.add(foundPlayer);
	            }
	        }
	        
	        foundTeam.setPlayers(teamPlayers);
	    }
	    
	    return foundTeam;
	}

	public void loadTeams() {
		teamDAO.loadFromFile();
	}

	public void saveTeams() {
		teamDAO.saveToFile();
	}

	public Integer getLastTeamId() {
		return teamDAO.getAll().size() + 1;
	}
	
	public TeamDTO findTeam(TeamDTO teamDTO) {
		Team team = TeamMapper.convertTeamDTOToTeam(teamDTO);
		Team foundTeam = teamDAO.find(team);
		TeamDTO foundTeamDTO = TeamMapper.convertTeamToTeamDTO(foundTeam);

		return foundTeamDTO;
	}

	public UserDTO authenticateUser(String email, String password) {
		// Check in admins
		for (AdminDTO admin : getAllAdmins()) {
			if (admin.login(email, password)) {
				return admin;
			}
		}

		// Check in coaches
		for (CoachDTO coach : getAllCoaches()) {
			if (coach.login(email, password)) {
				return coach;
			}
		}

		// Check in players
		for (PlayerDTO player : getAllPlayers()) {
			if (player.login(email, password)) {
				return player;
			}
		}

		// No user found with matching credentials
		return null;
	}

}
