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

/**
 * Clase que actúa como una fachada del modelo (*Model Facade*) en el sistema NeoLeague Arena.
 * Su propósito es centralizar y simplificar las operaciones relacionadas con la gestión de
 * administradores, jugadores, entrenadores y equipos, ocultando la complejidad del acceso a
 * datos y la conversión entre entidades del dominio y sus correspondientes DTOs.
 * 
 */
public class NeoLeagueArena {

    private AdminDAO adminDAO;
    private PlayerDAO playerDAO;
    private CoachDAO coachDAO;
    private TeamDAO teamDAO;

    /**
     * Constructor para inicializar los DAOs necesarios.
     */
    public NeoLeagueArena() {
        adminDAO = new AdminDAO();
        playerDAO = new PlayerDAO();
        coachDAO = new CoachDAO();
        teamDAO = new TeamDAO();
    }

    // ----------------- Admin methods -----------------

    /**
     * Añade un nuevo administrador al sistema.
     *
     * @param adminDTO El DTO del administrador a añadir.
     * @return true si el administrador fue añadido con éxito, false en caso contrario.
     */
    public boolean addAdmin(AdminDTO adminDTO) {
        Admin admin = AdminMapper.convertAdminDTOToAdmin(adminDTO);
        return adminDAO.add(admin);
    }

    /**
     * Elimina un administrador del sistema.
     *
     * @param adminDTO El DTO del administrador a eliminar.
     * @return true si el administrador fue eliminado con éxito, false en caso contrario.
     */
    public boolean deleteAdmin(AdminDTO adminDTO) {
        Admin admin = AdminMapper.convertAdminDTOToAdmin(adminDTO);
        return adminDAO.delete(admin);
    }

    /**
     * Actualiza la información de un administrador en el sistema.
     *
     * @param oldAdminDTO El DTO del administrador con la información antigua.
     * @param newAdminDTO El DTO del administrador con la información nueva.
     * @return true si el administrador fue actualizado con éxito, false en caso contrario.
     */
    public boolean updateAdmin(AdminDTO oldAdminDTO, AdminDTO newAdminDTO) {
        Admin oldAdmin = AdminMapper.convertAdminDTOToAdmin(oldAdminDTO);
        Admin newAdmin = AdminMapper.convertAdminDTOToAdmin(newAdminDTO);
        return adminDAO.update(oldAdmin, newAdmin);
    }

    /**
     * Obtiene una lista de todos los administradores en el sistema.
     *
     * @return Una lista de DTOs de administradores.
     */
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

    /**
     * Carga los administradores desde un archivo.
     */
    public void loadAdmins() {
        adminDAO.loadFromFile();
    }

    /**
     * Guarda los administradores en un archivo.
     */
    public void saveAdmins() {
        adminDAO.saveToFile();
    }

    // ----------------- Player methods -----------------

    /**
     * Añade un nuevo jugador al sistema.
     *
     * @param playerDTO El DTO del jugador a añadir.
     * @return true si el jugador fue añadido con éxito, false en caso contrario.
     */
    public boolean addPlayer(PlayerDTO playerDTO) {
        Player player = PlayerMapper.convertPlayerDTOToPlayer(playerDTO);
        return playerDAO.add(player);
    }

    /**
     * Elimina un jugador del sistema.
     *
     * @param playerDTO El DTO del jugador a eliminar.
     * @return true si el jugador fue eliminado con éxito, false en caso contrario.
     */
    public boolean deletePlayer(PlayerDTO playerDTO) {
        Player player = PlayerMapper.convertPlayerDTOToPlayer(playerDTO);
        return playerDAO.delete(player);
    }

    /**
     * Actualiza la información de un jugador en el sistema.
     *
     * @param oldPlayerDTO El DTO del jugador con la información antigua.
     * @param newPlayerDTO El DTO del jugador con la información nueva.
     * @return true si el jugador fue actualizado con éxito, false en caso contrario.
     */
    public boolean updatePlayer(PlayerDTO oldPlayerDTO, PlayerDTO newPlayerDTO) {
        Player oldPlayer = PlayerMapper.convertPlayerDTOToPlayer(oldPlayerDTO);
        Player newPlayer = PlayerMapper.convertPlayerDTOToPlayer(newPlayerDTO);
        return playerDAO.update(oldPlayer, newPlayer);
    }

    /**
     * Obtiene una lista de todos los jugadores en el sistema.
     *
     * @return Una lista de DTOs de jugadores.
     */
    public ArrayList<PlayerDTO> getAllPlayers() {
        ArrayList<Player> players = playerDAO.getAll();
        ArrayList<PlayerDTO> playerDTOs = new ArrayList<>();

        for (Player player : players) {
            PlayerDTO dto = PlayerMapper.convertPlayerToPlayerDTO(player);
            playerDTOs.add(dto);
        }

        return playerDTOs;
    }

    /**
     * Carga los jugadores desde un archivo.
     */
    public void loadPlayers() {
        playerDAO.loadFromFile();
    }

    /**
     * Guarda los jugadores en un archivo.
     */
    public void savePlayers() {
        playerDAO.saveToFile();
    }

    /**
     * Busca un jugador en el sistema.
     *
     * @param playerDTO El DTO del jugador a buscar.
     * @return El DTO del jugador encontrado, o null si no se encontró.
     */
    public PlayerDTO findPlayer(PlayerDTO playerDTO) {
        Player player = PlayerMapper.convertPlayerDTOToPlayer(playerDTO);
        Player foundPlayer = playerDAO.find(player);
        PlayerDTO foundPlayerDTO = PlayerMapper.convertPlayerToPlayerDTO(foundPlayer);

        return foundPlayerDTO;
    }

    // ----------------- Coach methods -----------------

    /**
     * Añade un nuevo entrenador al sistema.
     *
     * @param coachDTO El DTO del entrenador a añadir.
     * @return true si el entrenador fue añadido con éxito, false en caso contrario.
     */
    public boolean addCoach(CoachDTO coachDTO) {
        Coach coach = CoachMapper.convertCoachDTOToCoach(coachDTO);
        return coachDAO.add(coach);
    }

    /**
     * Elimina un entrenador del sistema.
     *
     * @param coachDTO El DTO del entrenador a eliminar.
     * @return true si el entrenador fue eliminado con éxito, false en caso contrario.
     */
    public boolean deleteCoach(CoachDTO coachDTO) {
        Coach coach = CoachMapper.convertCoachDTOToCoach(coachDTO);
        return coachDAO.delete(coach);
    }

    /**
     * Actualiza la información de un entrenador en el sistema.
     *
     * @param oldCoachDTO El DTO del entrenador con la información antigua.
     * @param newCoachDTO El DTO del entrenador con la información nueva.
     * @return true si el entrenador fue actualizado con éxito, false en caso contrario.
     */
    public boolean updateCoach(CoachDTO oldCoachDTO, CoachDTO newCoachDTO) {
        Coach oldCoach = CoachMapper.convertCoachDTOToCoach(oldCoachDTO);
        Coach newCoach = CoachMapper.convertCoachDTOToCoach(newCoachDTO);
        return coachDAO.update(oldCoach, newCoach);
    }

    /**
     * Obtiene una lista de todos los entrenadores en el sistema.
     *
     * @return Una lista de DTOs de entrenadores.
     */
    public ArrayList<CoachDTO> getAllCoaches() {
        ArrayList<Coach> coaches = coachDAO.getAll();
        ArrayList<CoachDTO> coachDTOs = new ArrayList<>();

        for (Coach coach : coaches) {
            CoachDTO dto = CoachMapper.convertCoachToCoachDTO(coach);
            coachDTOs.add(dto);
        }

        return coachDTOs;
    }

    /**
     * Busca un entrenador en el sistema.
     *
     * @param coachDTO El DTO del entrenador a buscar.
     * @return El DTO del entrenador encontrado, o null si no se encontró.
     */
    public CoachDTO findCoach(CoachDTO coachDTO) {
        Coach coach = CoachMapper.convertCoachDTOToCoach(coachDTO);
        Coach foundCoach = coachDAO.find(coach);
        CoachDTO foundTeamDTO = CoachMapper.convertCoachToCoachDTO(foundCoach);

        return foundTeamDTO;
    }

    /**
     * Carga los entrenadores desde un archivo.
     */
    public void loadCoaches() {
        coachDAO.loadFromFile();
    }

    /**
     * Guarda los entrenadores en un archivo.
     */
    public void saveCoaches() {
        coachDAO.saveToFile();
    }

    // ----------------- Team methods -----------------

    /**
     * Añade un nuevo equipo al sistema.
     *
     * @param teamDTO El DTO del equipo a añadir.
     * @return true si el equipo fue añadido con éxito, false en caso contrario.
     */
    public boolean addTeam(TeamDTO teamDTO) {
        Team team = TeamMapper.convertTeamDTOToTeam(teamDTO);
        return teamDAO.add(team);
    }

    /**
     * Elimina un equipo del sistema.
     *
     * @param teamDTO El DTO del equipo a eliminar.
     * @return true si el equipo fue eliminado con éxito, false en caso contrario.
     */
    public boolean deleteTeam(TeamDTO teamDTO) {
        Team team = TeamMapper.convertTeamDTOToTeam(teamDTO);
        return teamDAO.delete(team);
    }

    /**
     * Actualiza la información de un equipo en el sistema.
     *
     * @param oldTeamDTO El DTO del equipo con la información antigua.
     * @param newTeamDTO El DTO del equipo con la información nueva.
     * @return true si el equipo fue actualizado con éxito, false en caso contrario.
     */
    public boolean updateTeam(TeamDTO oldTeamDTO, TeamDTO newTeamDTO) {
        Team oldTeam = TeamMapper.convertTeamDTOToTeam(oldTeamDTO);
        Team newTeam = TeamMapper.convertTeamDTOToTeam(newTeamDTO);
        return teamDAO.update(oldTeam, newTeam);
    }

    /**
     * Obtiene una lista de todos los equipos en el sistema.
     *
     * @return Una lista de DTOs de equipos.
     */
    public ArrayList<TeamDTO> getAllTeams() {
        ArrayList<Team> teams = teamDAO.getAll();
        ArrayList<TeamDTO> teamDTOs = new ArrayList<>();

        for (Team team : teams) {
            TeamDTO dto = TeamMapper.convertTeamToTeamDTO(team);
            teamDTOs.add(dto);
        }

        return teamDTOs;
    }

    /**
     * Obtiene un equipo con sus jugadores asociados.
     *
     * @param teamId El ID del equipo.
     * @return El DTO del equipo con sus jugadores, o null si no se encontró.
     */
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

    /**
     * Verifica si un nombre de equipo ya existe en el sistema.
     *
     * @param teamName El nombre del equipo a verificar.
     * @return true si el nombre del equipo ya existe, false en caso contrario.
     */
    public boolean teamNameExists(String teamName) {
        for (TeamDTO team : getAllTeams()) {
            if (team.getName().equalsIgnoreCase(teamName.trim())) {
                return true;
            }
        }

        return false;
    }

    /**
     * Verifica si un nombre de equipo ya existe en el sistema, excluyendo un equipo específico.
     *
     * @param teamName El nombre del equipo a verificar.
     * @param currentTeamId El ID del equipo a excluir de la verificación.
     * @return true si el nombre del equipo ya existe, false en caso contrario.
     */
    public boolean teamNameExists(String teamName, Integer currentTeamId) {
        for (TeamDTO team : getAllTeams()) {
            if (!team.getId().equals(currentTeamId) &&
                team.getName().trim().equalsIgnoreCase(teamName.trim())) {
                return true;
            }
        }

        return false;
    }

    /**
     * Verifica si un jugador está asignado a algún equipo en el sistema.
     *
     * @param playerId El ID del jugador a verificar.
     * @return true si el jugador está asignado a algún equipo, false en caso contrario.
     */
    public boolean isPlayerAssignedToAnyTeam(Integer playerId) {
        System.out.print("\nPLAYER ID: " + playerId + "\n");

        for (TeamDTO teamDTO : getAllTeams()) {
            List<Integer> playerIds = teamDTO.getPlayerIds();
            System.out.print("PLAYER IDS: " + teamDTO.getPlayerIds().toString() + "\n");

            if (playerIds != null && playerIds.contains(playerId)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Verifica si un jugador está en un equipo específico en el sistema.
     *
     * @param playerId El ID del jugador a verificar.
     * @param teamId El ID del equipo a verificar.
     * @return true si el jugador está en el equipo, false en caso contrario.
     */
    public boolean isPlayerInTeam(Integer playerId, Integer teamId) {
        System.out.print("\nPLAYER ID: " + playerId + "\n");
        System.out.print("\nTEAM  ID: " + playerId + "\n");

        TeamDTO teamDTO =  new TeamDTO();
        teamDTO.setId(teamId);

        TeamDTO foundTeamDTO = findTeam(teamDTO);

        if (foundTeamDTO != null && foundTeamDTO.getPlayerIds() != null) {
            System.out.print("\nTEAM IDS : " + foundTeamDTO.getPlayerIds().toString()  + "\n");
            return foundTeamDTO.getPlayerIds().contains(playerId);
        }

        return false;
    }

    /**
     * Carga los equipos desde un archivo.
     */
    public void loadTeams() {
        teamDAO.loadFromFile();
    }

    /**
     * Guarda los equipos en un archivo.
     */
    public void saveTeams() {
        teamDAO.saveToFile();
    }

    /**
     * Obtiene el último ID de equipo utilizado en el sistema.
     *
     * @return El último ID de equipo utilizado.
     */
    public Integer getLastTeamId() {
        return teamDAO.getAll().size() + 1;
    }

    /**
     * Busca un equipo en el sistema.
     *
     * @param teamDTO El DTO del equipo a buscar.
     * @return El DTO del equipo encontrado, o null si no se encontró.
     */
    public TeamDTO findTeam(TeamDTO teamDTO) {
        Team team = TeamMapper.convertTeamDTOToTeam(teamDTO);
        Team foundTeam = teamDAO.find(team);
        TeamDTO foundTeamDTO = TeamMapper.convertTeamToTeamDTO(foundTeam);

        return foundTeamDTO;
    }

    /**
     * Autentica a un usuario en el sistema.
     *
     * @param email El correo electrónico del usuario.
     * @param password La contraseña del usuario.
     * @return El DTO del usuario autenticado, o null si no se encontró.
     */
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

