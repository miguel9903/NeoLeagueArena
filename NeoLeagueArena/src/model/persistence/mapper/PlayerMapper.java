package model.persistence.mapper;

import java.util.ArrayList;
import java.util.List;

import model.Player;
import model.Team;
import model.persistence.dto.PlayerDTO;

public class PlayerMapper {

    public static Player convertPlayerDTOToPlayer(PlayerDTO dto) {
        if (dto == null) return null;

        Player player = new Player(
                dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getPassword(),
                dto.getCountry(),
                dto.getCity()
        );
        player.setNickName(dto.getNickName());
        player.setExperienceLevel(dto.getExperienceLevel());

        if (dto.getCurrentTeamId() != null) {
            Team team = new Team();
            team.setId(dto.getCurrentTeamId());
            player.setCurrentTeam(team);
        }

        return player;
    }

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
        dto.setRole("PLAYER");

        dto.setNickName(player.getNickName());
        dto.setExperienceLevel(player.getExperienceLevel());

        if (player.getCurrentTeam() != null) {
            dto.setCurrentTeamId(player.getCurrentTeam().getId());
        }

        return dto;
    }
    
    public static List<PlayerDTO> convertPlayerListToPlayerDTOList(List<Player> players) {
        List<PlayerDTO> dtos = new ArrayList<>();
        if (players != null) {
            for (Player player : players) {
                dtos.add(convertPlayerToPlayerDTO(player));
            }
        }
        return dtos;
    }

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
