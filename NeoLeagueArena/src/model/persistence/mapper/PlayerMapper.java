package model.persistence.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.Player;
import model.Team;
import model.enums.UserRole;
import model.persistence.dto.PlayerDTO;

/**
 * Clase de utilidad para mapear entre objetos Player y PlayerDTO.
 */
public class PlayerMapper {

    /**
     * Convierte un objeto PlayerDTO a un objeto Player.
     *
     * @param dto El objeto PlayerDTO a convertir.
     * @return El objeto Player convertido, o null si el DTO es null.
     */
    public static Player convertPlayerDTOToPlayer(PlayerDTO dto) {
        if (dto == null) return null;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Player player = new Player();
        player.setId(dto.getId());
        player.setFirstName(dto.getFirstName());
        player.setLastName(dto.getLastName());
        player.setEmail(dto.getEmail());
        player.setPassword(dto.getPassword());
        player.setCountry(dto.getCountry());
        player.setCity(dto.getCity());
        player.setNickName(dto.getNickName());
        player.setExperienceLevel(dto.getExperienceLevel());
        player.setRole(UserRole.PLAYER);

        if (dto.getCurrentTeamId() != null) {
            Team team = new Team();
            team.setId(dto.getCurrentTeamId());
            team.setName(dto.getCurrentTeamName());
            player.setCurrentTeam(team);
        }

        if (dto.getBirthDate() != null && !dto.getBirthDate().isEmpty()) {
            player.setBirthDate(LocalDate.parse(dto.getBirthDate(), formatter));
        }

        return player;
    }

    /**
     * Convierte un objeto Player a un objeto PlayerDTO.
     *
     * @param player El objeto Player a convertir.
     * @return El objeto PlayerDTO convertido, o null si el Player es null.
     */
    public static PlayerDTO convertPlayerToPlayerDTO(Player player) {
        if (player == null) return null;

        PlayerDTO dto = new PlayerDTO();
        dto.setId(player.getId());
        dto.setFirstName(player.getFirstName());
        dto.setLastName(player.getLastName());
        dto.setEmail(player.getEmail());
        dto.setPassword(player.getPassword());
        dto.setCountry(player.getCountry());
        dto.setCity(player.getCity());

        if (player.getCurrentTeam() != null) {
            dto.setCurrentTeamId(player.getCurrentTeam().getId());
            dto.setCurrentTeamName(player.getCurrentTeam().getName());
        } else {
            dto.setCurrentTeamId(null);
            dto.setCurrentTeamName(null);
        }

        dto.setRole(UserRole.PLAYER.getDisplayName());
        dto.setNickName(player.getNickName());
        dto.setExperienceLevel(player.getExperienceLevel());
        dto.setAge(player.getAge());

        if (player.getBirthDate() != null) {
            dto.setBirthDate(player.getBirthDate().toString());
        } else {
            dto.setBirthDate(null);
        }

        return dto;
    }

    /**
     * Convierte una lista de objetos Player a una lista de objetos PlayerDTO.
     *
     * @param players La lista de objetos Player a convertir.
     * @return La lista de objetos PlayerDTO convertidos.
     */
    public static List<PlayerDTO> convertPlayerListToPlayerDTOList(List<Player> players) {
        List<PlayerDTO> dtos = new ArrayList<>();
        if (players != null) {
            for (Player player : players) {
                dtos.add(convertPlayerToPlayerDTO(player));
            }
        }
        return dtos;
    }

    /**
     * Convierte una lista de objetos PlayerDTO a una lista de objetos Player.
     *
     * @param dtos La lista de objetos PlayerDTO a convertir.
     * @return La lista de objetos Player convertidos.
     */
    public static List<Player> convertPlayerDTOListToPlayerList(List<PlayerDTO> dtos) {
        List<Player> players = new ArrayList<>();
        if (dtos != null) {
            for (PlayerDTO dto : dtos) {
                players.add(convertPlayerDTOToPlayer(dto));
            }
        }
        return players;
    }
}

