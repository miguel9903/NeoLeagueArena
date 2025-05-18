package model.persistence.mapper;

import model.Game;
import model.Match;
import model.Team;
import model.Tournament;
import model.enums.GamePlatform;
import model.enums.TournamentPhase;
import model.persistence.dto.GameDTO;
import model.persistence.dto.TournamentDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de utilidad para mapear entre objetos Tournament y TournamentDTO.
 */
public class TournamentMapper {

    /**
     * Convierte un objeto TournamentDTO a un objeto Tournament.
     *
     * @param dto El objeto TournamentDTO a convertir.
     * @return El objeto Tournament convertido, o null si el DTO es null.
     */
    public static Tournament convertTournamentDTOToTournament(TournamentDTO dto) {
        if (dto == null) return null;

        Tournament tournament = new Tournament();
        tournament.setId(dto.getId());

        List<Team> teams = new ArrayList<>();
        if (dto.getTeamIds() != null) {
            for (Integer teamId : dto.getTeamIds()) {
                if (teamId != null) {
                    Team team = new Team();
                    team.setId(teamId);
                    teams.add(team);
                }
            }
        }
        tournament.setTeams(teams);

        List<Match> matches = new ArrayList<>();

        if (dto.getMatchIds() != null) {
            for (Integer matchId : dto.getMatchIds()) {
                if (matchId != null) {
                    Match match = new Match();
                    match.setId(matchId);
                    matches.add(match);
                }
            }
        }
        tournament.setMatches(matches);

        if (dto.getPlatform() != null) {
            tournament.setPlatform(GamePlatform.fromString(dto.getPlatform()));
        }

        Game game = GameMapper.convertGameDTOToGame(dto.getGame());
        tournament.setGame(game);

        if (dto.getPhase() != null) {
            tournament.setPhase(TournamentPhase.fromString(dto.getPhase()));
        }

        return tournament;
    }

    /**
     * Convierte un objeto Tournament a un objeto TournamentDTO.
     *
     * @param tournament El objeto Tournament a convertir.
     * @return El objeto TournamentDTO convertido, o null si el Tournament es null.
     */
    public static TournamentDTO convertTournamentToTournamentDTO(Tournament tournament) {
        if (tournament == null) return null;

        TournamentDTO dto = new TournamentDTO();
        dto.setId(tournament.getId());

        List<Integer> teamIds = new ArrayList<>();
        if (tournament.getTeams() != null) {
            for (Team team : tournament.getTeams()) {
                if (team != null) {
                    teamIds.add(team.getId());
                }
            }
        }
        dto.setTeamIds(teamIds);

        List<Integer> matchIds = new ArrayList<>();
        if (tournament.getMatches() != null) {
            for (Match match : tournament.getMatches()) {
                if (match != null) {
                    matchIds.add(match.getId());
                }
            }
        }
        dto.setMatchIds(matchIds);

        if (tournament.getPlatform() != null) {
            dto.setPlatform(tournament.getPlatform().name());
        }

        GameDTO gameDTO = GameMapper.convertGameToGameDTO(tournament.getGame());
        dto.setGame(gameDTO);

        if (tournament.getPhase() != null) {
            dto.setPhase(tournament.getPhase().name());
        }

        return dto;
    }

    /**
     * Convierte una lista de objetos TournamentDTO a una lista de objetos Tournament.
     *
     * @param dtoList La lista de objetos TournamentDTO a convertir.
     * @return La lista de objetos Tournament convertidos.
     */
    public static List<Tournament> convertTournamentDTOListToTournamentList(List<TournamentDTO> dtoList) {
        List<Tournament> tournaments = new ArrayList<>();

        if (dtoList != null) {
            for (TournamentDTO dto : dtoList) {
                tournaments.add(convertTournamentDTOToTournament(dto));
            }
        }

        return tournaments;
    }

    /**
     * Convierte una lista de objetos Tournament a una lista de objetos TournamentDTO.
     *
     * @param tournamentList La lista de objetos Tournament a convertir.
     * @return La lista de objetos TournamentDTO convertidos.
     */
    public static List<TournamentDTO> convertTournamentListToTournamentDTOList(List<Tournament> tournamentList) {
        List<TournamentDTO> dtoList = new ArrayList<>();

        if (tournamentList != null) {
            for (Tournament tournament : tournamentList) {
                dtoList.add(convertTournamentToTournamentDTO(tournament));
            }
        }

        return dtoList;
    }
}
