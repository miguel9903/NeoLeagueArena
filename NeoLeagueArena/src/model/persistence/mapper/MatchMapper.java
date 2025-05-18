package model.persistence.mapper;

import model.Match;
import model.Team;
import model.enums.MatchStatus;
import model.enums.UserRole;
import model.persistence.dto.MatchDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de utilidad para mapear entre objetos Match y MatchDTO.
 */
public class MatchMapper {

    /**
     * Convierte un objeto MatchDTO a un objeto Match.
     *
     * @param dto El objeto MatchDTO a convertir.
     * @return El objeto Match convertido, o null si el DTO es null.
     */
    public static Match convertMatchDTOToMatch(MatchDTO dto) {
        if (dto == null) return null;

        Team teamA = new Team();
        teamA.setId(dto.getTeamAId());

        Team teamB = new Team();
        teamB.setId(dto.getTeamBId());

        Team winner = null;
        if (dto.getWinnerId() != null) {
            winner = new Team();
            winner.setId(dto.getWinnerId());
        }

        MatchStatus status = MatchStatus.fromString(dto.getStatus());

        return new Match(
                dto.getId(),
                teamA,
                teamB,
                dto.getDate(),
                dto.getStartTime(),
                dto.getEndTime(),
                winner,
                dto.getTeamAScore(),
                dto.getTeamBScore(),
                dto.getSummary(),
                status
        );
    }

    /**
     * Convierte un objeto Match a un objeto MatchDTO.
     *
     * @param match El objeto Match a convertir.
     * @return El objeto MatchDTO convertido, o null si el Match es null.
     */
    public static MatchDTO convertMatchToMatchDTO(Match match) {
        if (match == null) return null;

        MatchDTO dto = new MatchDTO();

        dto.setId(match.getId());

        if (match.getTeamA() != null) {
            dto.setTeamAId(match.getTeamA().getId());
        }

        if (match.getTeamB() != null) {
            dto.setTeamBId(match.getTeamB().getId());
        }

        dto.setDate(match.getDate());
        dto.setStartTime(match.getStartTime());
        dto.setEndTime(match.getEndTime());

        if (match.getWinner() != null) {
            dto.setWinnerId(match.getWinner().getId());
        }

        dto.setTeamAScore(match.getTeamAScore());
        dto.setTeamBScore(match.getTeamBScore());
        dto.setSummary(match.getSummary());

        if (match.getStatus() != null) {
            dto.setStatus(match.getStatus().name());
        } else {
            dto.setStatus(null);
        }

        return dto;
    }

    /**
     * Convierte una lista de objetos Match a una lista de objetos MatchDTO.
     *
     * @param matches La lista de objetos Match a convertir.
     * @return La lista de objetos MatchDTO convertidos.
     */
    public static List<MatchDTO> convertMatchListToMatchDTOList(List<Match> matches) {
        List<MatchDTO> dtos = new ArrayList<>();

        if (matches != null) {
            for (Match match : matches) {
                dtos.add(convertMatchToMatchDTO(match));
            }
        }

        return dtos;
    }

    /**
     * Convierte una lista de objetos MatchDTO a una lista de objetos Match.
     *
     * @param dtos La lista de objetos MatchDTO a convertir.
     * @return La lista de objetos Match convertidos.
     */
    public static List<Match> convertMatchDTOListToMatchList(List<MatchDTO> dtos) {
        List<Match> matches = new ArrayList<>();

        if (dtos != null) {
            for (MatchDTO dto : dtos) {
                matches.add(convertMatchDTOToMatch(dto));
            }
        }

        return matches;
    }
}
