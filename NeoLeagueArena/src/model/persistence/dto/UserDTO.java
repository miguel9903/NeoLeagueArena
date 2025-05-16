package model.persistence.dto;

import java.util.List;

public class UserDTO {
    
    // Common fields for all user types
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String country;
    private String city;
    private String role;

    // Fields specific to Player
    private String nickName;
    private Integer experienceLevel;
    private Integer currentTeamId;
    
    //Fields specific to Coach
    private List<Integer> teamIds;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getExperienceLevel() {
		return experienceLevel;
	}

	public void setExperienceLevel(Integer experienceLevel) {
		this.experienceLevel = experienceLevel;
	}

	public Integer getCurrentTeamId() {
		return currentTeamId;
	}

	public void setCurrentTeamId(Integer currentTeamId) {
		this.currentTeamId = currentTeamId;
	}

	public List<Integer> getTeamIds() {
		return teamIds;
	}

	public void setTeamIds(List<Integer> teamIds) {
		this.teamIds = teamIds;
	} 
    
}
