package model.persistence.dto;

import java.io.Serializable;

/**
 * Clase DTO (Data Transfer Object) que representa a un jugador.
 * Extiende de UserDTO para incluir propiedades específicas de un jugador.
 */
public class PlayerDTO extends UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nickName;
    private int experienceLevel;
    private Integer currentTeamId;
    private String currentTeamName;

    /**
     * Obtiene el apodo del jugador.
     *
     * @return El apodo del jugador.
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * Establece el apodo del jugador.
     *
     * @param nickName El nuevo apodo del jugador.
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * Obtiene el nivel de experiencia del jugador.
     *
     * @return El nivel de experiencia del jugador.
     */
    public int getExperienceLevel() {
        return experienceLevel;
    }

    /**
     * Establece el nivel de experiencia del jugador.
     *
     * @param experienceLevel El nuevo nivel de experiencia del jugador.
     */
    public void setExperienceLevel(int experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    /**
     * Obtiene el identificador del equipo actual del jugador.
     *
     * @return El identificador del equipo actual del jugador.
     */
    public Integer getCurrentTeamId() {
        return currentTeamId;
    }

    /**
     * Establece el identificador del equipo actual del jugador.
     *
     * @param currentTeamId El nuevo identificador del equipo actual del jugador.
     */
    public void setCurrentTeamId(Integer currentTeamId) {
        this.currentTeamId = currentTeamId;
    }

    /**
     * Obtiene el nombre del equipo actual del jugador.
     *
     * @return El nombre del equipo actual del jugador.
     */
    public String getCurrentTeamName() {
        return currentTeamName;
    }

    /**
     * Establece el nombre del equipo actual del jugador.
     *
     * @param currentTeamName El nuevo nombre del equipo actual del jugador.
     */
    public void setCurrentTeamName(String currentTeamName) {
        this.currentTeamName = currentTeamName;
    }

    /**
     * Obtiene el serialVersionUID.
     *
     * @return El serialVersionUID.
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * Devuelve una representación en cadena del objeto PlayerDTO.
     *
     * @return Una cadena que representa al objeto PlayerDTO.
     */
    @Override
    public String toString() {
        return super.toString() + ", PlayerDTO [nickName=" + nickName +
                ", experienceLevel=" + experienceLevel +
                ", currentTeamId=" + currentTeamId + "]";
    }
}

