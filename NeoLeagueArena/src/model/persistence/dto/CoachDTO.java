package model.persistence.dto;

import java.io.Serializable;
import java.util.List;

public class CoachDTO extends UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Integer> teamIds;

	public CoachDTO() {
		super();
		setRole("COACH");
	}

	public CoachDTO(int id, String firstName, String lastName, String email, String password,
			String country, String city, List<Integer> teamIds) {
		super(id, firstName, lastName, email, password, country, city, "COACH");
		this.teamIds = teamIds;
	}

	public List<Integer> getTeamIds() {
		return teamIds;
	}

	public void setTeamIds(List<Integer> teamIds) {
		this.teamIds = teamIds;
	}

	@Override
	public String toString() {
		return super.toString() + ", CoachDTO [teamIds=" + teamIds + "]";
	}

}
