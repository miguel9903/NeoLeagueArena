package model.persistence.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Clase DTO (Data Transfer Object) que representa a un entrenador.
 * Extiende de UserDTO para incluir propiedades específicas de un entrenador.
 */
public class CoachDTO extends UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Integer> teamIds;

    /**
     * Obtiene la lista de identificadores de equipos asociados al entrenador.
     *
     * @return La lista de identificadores de equipos.
     */
    public List<Integer> getTeamIds() {
        return teamIds;
    }

    /**
     * Establece la lista de identificadores de equipos asociados al entrenador.
     *
     * @param teamIds La nueva lista de identificadores de equipos.
     */
    public void setTeamIds(List<Integer> teamIds) {
        this.teamIds = teamIds;
    }

    /**
     * Devuelve una representación en cadena del objeto CoachDTO.
     *
     * @return Una cadena que representa al objeto CoachDTO.
     */
    @Override
    public String toString() {
        return super.toString() + ", CoachDTO [teamIds=" + teamIds + "]";
    }
}
