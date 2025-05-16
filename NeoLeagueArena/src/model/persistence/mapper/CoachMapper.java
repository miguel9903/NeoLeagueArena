package model.persistence.mapper;

import model.Coach;
import model.Team;
import model.persistence.dto.CoachDTO;

import java.util.ArrayList;
import java.util.List;

public class CoachMapper {

    public static Coach convertCoachDTOToCoach(CoachDTO dto) {
        if (dto == null) return null;

        List<Team> teams = new ArrayList<>();
        
        if (dto.getTeamIds() != null) {
            for (Integer id : dto.getTeamIds()) {
                Team team = new Team();
                team.setId(id);
                teams.add(team);
            }
        }

        Coach coach = new Coach(
                dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getPassword(),
                dto.getCountry(),
                dto.getCity(),
                teams
        );

        return coach;
    }

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
        dto.setRole("COACH");

        if (coach.getTeams() != null) {
            List<Integer> teamIds = new ArrayList<>();
            
            for (Team team : coach.getTeams()) {
                if (team != null) {
                    teamIds.add(team.getId());
                }
            }
            
            dto.setTeamIds(teamIds);
        }

        return dto;
    }
    
    public static List<CoachDTO> convertCoachListToCoachDTOList(List<Coach> coaches) {
        List<CoachDTO> dtos = new ArrayList<>();
        if (coaches != null) {
            for (Coach coach : coaches) {
                dtos.add(convertCoachToCoachDTO(coach));
            }
        }
        return dtos;
    }
    
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
