package model.persistence.dto;

import java.io.Serializable;

public class PlayerDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nickName;
    private int experienceLevel;
    private int currentTeamId;

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

    public int getCurrentTeamId() {
        return currentTeamId;
    }

    public void setCurrentTeamId(int currentTeamId) {
        this.currentTeamId = currentTeamId;
    }
    
}
