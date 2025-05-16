package model.persistence.dto;

import java.io.Serializable;

public class PlayerDTO extends UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nickName;
	private int experienceLevel;
	private Integer currentTeamId;

	public PlayerDTO() {
		super();
		setRole("PLAYER");
	}

	public PlayerDTO(int id, String firstName, String lastName, String email, String password,
			String country, String city, String nickName, int experienceLevel, Integer currentTeamId) {
		super(id, firstName, lastName, email, password, country, city, "PLAYER");
		this.nickName = nickName;
		this.experienceLevel = experienceLevel;
		this.currentTeamId = currentTeamId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getExperienceLevel() {
		return experienceLevel;
	}

	public void setExperienceLevel(int experienceLevel) {
		this.experienceLevel = experienceLevel;
	}

	public Integer getCurrentTeamId() {
		return currentTeamId;
	}

	public void setCurrentTeamId(Integer currentTeamId) {
		this.currentTeamId = currentTeamId;
	}

	@Override
	public String toString() {
		return super.toString() + ", PlayerDTO [nickName=" + nickName +
				", experienceLevel=" + experienceLevel +
				", currentTeamId=" + currentTeamId + "]";
	}
}
