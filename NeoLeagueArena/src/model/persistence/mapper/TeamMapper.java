package model.persistence.mapper;

import java.util.ArrayList;
import java.util.List;

import model.Team;
import model.Player;
import model.Coach;
import model.persistence.dto.TeamDTO;

/**
 * Clase de utilidad para mapear entre objetos Team y TeamDTO.
 */
public class TeamMapper {

    /**
     * Convierte un objeto TeamDTO a un objeto Team.
     *
     * @param dto El objeto TeamDTO a convertir.
     * @return El objeto Team convertido, o null si el DTO es null.
     */
    public static Team convertTeamDTOToTeam(TeamDTO dto) {
        if (dto == null) return null;

        Team team = new Team();
        team.setId(dto.getId());
        team.setName(dto.getName());
        team.setDescription(dto.getDescription());
        team.setLogo(dto.getLogo());
        team.setScore(dto.getScore());
        team.setRanking(dto.getRanking());

        if (dto.getCoachId() != null) {
            Coach coach = new Coach();
            coach.setId(dto.getCoachId());
            coach.setFirstName(dto.getCoachName());
            team.setCoach(coach);
        }

        List<Player> players = new ArrayList<>();

        if (dto.getPlayerIds() != null) {
            for (Integer playerId : dto.getPlayerIds()) {
                if (playerId != null) {
                    Player player = new Player();
                    player.setId(playerId);
                    players.add(player);
                }
            }
        }
        team.setPlayers(players);

        return team;
    }

    /**
     * Convierte un objeto Team a un objeto TeamDTO.
     *
     * @param team El objeto Team a convertir.
     * @return El objeto TeamDTO convertido, o null si el Team es null.
     */
    public static TeamDTO convertTeamToTeamDTO(Team team) {
        if (team == null) return null;

        TeamDTO dto = new TeamDTO();
        dto.setId(team.getId());
        dto.setName(team.getName());
        dto.setDescription(team.getDescription());
        dto.setLogo(team.getLogo());
        dto.setScore(team.getScore());
        dto.setRanking(team.getRanking());

        if (team.getCoach() != null) {
            dto.setCoachId(team.getCoach().getId());
            dto.setCoachName(team.getCoach().getFirstName());
        }

        List<Integer> playerIds = new ArrayList<>();

        if (team.getPlayers() != null) {
            for (Player player : team.getPlayers()) {
                if (player != null) {
                    playerIds.add(player.getId());
                }
            }
        }
        dto.setPlayerIds(playerIds);

        return dto;
    }

    /**
     * Convierte una lista de objetos TeamDTO a una lista de objetos Team.
     *
     * @param dtoList La lista de objetos TeamDTO a convertir.
     * @return La lista de objetos Team convertidos.
     */
    public static List<Team> convertTeamDTOListToTeamList(List<TeamDTO> dtoList) {
        List<Team> teams = new ArrayList<>();
        if (dtoList != null) {
            for (TeamDTO dto : dtoList) {
                teams.add(convertTeamDTOToTeam(dto));
            }
        }
        return teams;
    }

    /**
     * Convierte una lista de objetos Team a una lista de objetos TeamDTO.
     *
     * @param teamList La lista de objetos Team a convertir.
     * @return La lista de objetos TeamDTO convertidos.
     */
    public static List<TeamDTO> convertTeamListToTeamDTOList(List<Team> teamList) {
        List<TeamDTO> dtoList = new ArrayList<>();
        if (teamList != null) {
            for (Team team : teamList) {
                dtoList.add(convertTeamToTeamDTO(team));
            }
        }
        return dtoList;
    }
}

