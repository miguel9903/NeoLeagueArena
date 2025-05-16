package model.persistence.mapper;


import model.Admin;
import model.Coach;
import model.Player;
import model.Team;
import model.User;
import model.enums.UserRole;
import model.persistence.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

	public static User convertUserDTOToUser(UserDTO dto) {
		if (dto == null) return null;

		UserRole role = UserRole.valueOf(dto.getRole().toUpperCase());

		switch (role) {
		case PLAYER: {
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
			player.setExperienceLevel(dto.getExperienceLevel() != null ? dto.getExperienceLevel() : 0);

			if (dto.getCurrentTeamId() != null) {
				Team team = new Team();
				team.setId(dto.getCurrentTeamId());
				player.setCurrentTeam(team);
			}

			return player;
		}
		case COACH: {
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
		case ADMIN: {
			Admin admin = new Admin(
					dto.getId(),
					dto.getFirstName(),
					dto.getLastName(),
					dto.getEmail(),
					dto.getPassword(),
					dto.getCountry(),
					dto.getCity()
					);
			return admin;
		}
		default: {
			return null;
		}
		}
	}

	public static UserDTO convertUserToUserDTO(User user) {
		if (user == null) return null;

		UserDTO dto = new UserDTO();

		dto.setId(user.getId());
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setEmail(user.getEmail());
		dto.setPassword(user.getPassword());
		dto.setCountry(user.getCountry());
		dto.setCity(user.getCity());

		if (user.getRole() != null) {
			dto.setRole(user.getRole().name());
		} else {
			dto.setRole(null);
		}

		// Specific fields for Player
		if (user instanceof Player) {
			Player player = (Player) user;
			dto.setNickName(player.getNickName());
			dto.setExperienceLevel(player.getExperienceLevel());

			if (player.getCurrentTeam() != null) {
				dto.setCurrentTeamId(player.getCurrentTeam().getId());
			}
		}

		// Specific fields for Coach
		if (user instanceof Coach) {
			Coach coach = (Coach) user;

			if (coach.getTeams() != null) {
				List<Integer> teamIds = new ArrayList<>();

				for (Team team : coach.getTeams()) {
					if (team != null) {
						teamIds.add(team.getId());
					}
				}

				dto.setTeamIds(teamIds);
			}
		}

		return dto;
	}

	public static List<UserDTO> convertUserListToUserDTOList(List<User> users) {
		List<UserDTO> dtos = new ArrayList<>();

		if (users != null) {
			for (User user : users) {
				dtos.add(convertUserToUserDTO(user));
			}
		}

		return dtos;
	}

	public static List<User> convertUserDTOListToUserList(List<UserDTO> dtos) {
		List<User> users = new ArrayList<>();

		if (dtos != null) {
			for (UserDTO dto : dtos) {
				users.add(convertUserDTOToUser(dto));
			}
		}

		return users;
	}
}
