package model.persistence.mapper;

import model.Coach;
import model.Team;
import model.enums.UserRole;
import model.persistence.dto.CoachDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de utilidad para mapear entre objetos Coach y CoachDTO.
 */
public class CoachMapper {

    /**
     * Convierte un objeto CoachDTO a un objeto Coach.
     *
     * @param dto El objeto CoachDTO a convertir.
     * @return El objeto Coach convertido, o null si el DTO es null.
     */
    public static Coach convertCoachDTOToCoach(CoachDTO dto) {
        if (dto == null) return null;

        List<Team> teams = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (dto.getTeamIds() != null) {
            for (Integer id : dto.getTeamIds()) {
                Team team = new Team();
                team.setId(id);
                teams.add(team);
            }
        }

        Coach coach = new Coach();
        coach.setId(dto.getId());
        coach.setFirstName(dto.getFirstName());
        coach.setLastName(dto.getLastName());
        coach.setEmail(dto.getEmail());
        coach.setPassword(dto.getPassword());
        coach.setCountry(dto.getCountry());
        coach.setRole(UserRole.COACH);
        coach.setCity(dto.getCity());
        coach.setTeams(teams);

        if (dto.getBirthDate() != null && !dto.getBirthDate().isEmpty()) {
            coach.setBirthDate(LocalDate.parse(dto.getBirthDate(), formatter));
        }

        return coach;
    }

    /**
     * Convierte un objeto Coach a un objeto CoachDTO.
     *
     * @param coach El objeto Coach a convertir.
     * @return El objeto CoachDTO convertido, o null si el Coach es null.
     */
    public static CoachDTO convertCoachToCoachDTO(Coach coach) {
        if (coach == null) return null;

        CoachDTO dto = new CoachDTO();
        dto.setId(coach.getId());
        dto.setFirstName(coach.getFirstName());
        dto.setLastName(coach.getLastName());
        dto.setEmail(coach.getEmail());
        dto.setPassword(coach.getPassword());
        dto.setCountry(coach.getCountry());
        dto.setCity(coach.getCity());
        dto.setRole(UserRole.COACH.getDisplayName());
        dto.setAge(coach.getAge());

        if (coach.getTeams() != null) {
            List<Integer> teamIds = new ArrayList<>();

            for (Team team : coach.getTeams()) {
                if (team != null) {
                    teamIds.add(team.getId());
                }
            }

            dto.setTeamIds(teamIds);
        }

        if (coach.getBirthDate() != null) {
            dto.setBirthDate(coach.getBirthDate().toString());
        } else {
            dto.setBirthDate(null);
        }

        return dto;
    }

    /**
     * Convierte una lista de objetos Coach a una lista de objetos CoachDTO.
     *
     * @param coaches La lista de objetos Coach a convertir.
     * @return La lista de objetos CoachDTO convertidos.
     */
    public static List<CoachDTO> convertCoachListToCoachDTOList(List<Coach> coaches) {
        List<CoachDTO> dtos = new ArrayList<>();
        if (coaches != null) {
            for (Coach coach : coaches) {
                dtos.add(convertCoachToCoachDTO(coach));
            }
        }
        return dtos;
    }

    /**
     * Convierte una lista de objetos CoachDTO a una lista de objetos Coach.
     *
     * @param dtos La lista de objetos CoachDTO a convertir.
     * @return La lista de objetos Coach convertidos.
     */
    public static List<Coach> convertCoachDTOListToCoachList(List<CoachDTO> dtos) {
        List<Coach> coaches = new ArrayList<>();
        if (dtos != null) {
            for (CoachDTO dto : dtos) {
                coaches.add(convertCoachDTOToCoach(dto));
            }
        }
        return coaches;
    }
}

