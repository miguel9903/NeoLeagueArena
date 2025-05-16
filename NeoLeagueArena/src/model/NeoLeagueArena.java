package model;

import java.util.ArrayList;

import model.persistence.dao.AdminDAO;
import model.persistence.dao.PlayerDAO;
import model.persistence.dao.CoachDAO;

import model.persistence.dto.AdminDTO;
import model.persistence.dto.PlayerDTO;
import model.persistence.dto.CoachDTO;
import model.persistence.dto.UserDTO;  // Assuming a common interface or base class for users

import model.persistence.mapper.AdminMapper;
import model.persistence.mapper.CoachMapper;
import model.persistence.mapper.PlayerMapper;

public class NeoLeagueArena {

	private AdminDAO adminDAO;
	private PlayerDAO playerDAO;
	private CoachDAO coachDAO;

	public NeoLeagueArena() {
		adminDAO = new AdminDAO();
		playerDAO = new PlayerDAO();
		coachDAO = new CoachDAO();
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

	public void loadCoaches() {
		coachDAO.loadFromFile();
	}

	public void saveCoaches() {
		coachDAO.saveToFile();
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
