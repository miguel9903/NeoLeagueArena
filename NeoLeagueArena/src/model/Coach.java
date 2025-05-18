package model;

import java.time.LocalDate;
import java.util.List;
import model.enums.UserRole;

/**
 * La clase Coach representa un entrenador en el sistema.
 * Extiende la clase User, heredando sus propiedades y métodos.
 */
public class Coach extends User {

    private List<Team> teams;

    /**
     * Constructor por defecto para Coach.
     * Inicializa un objeto Coach con valores por defecto.
     */
    public Coach() {
        super();
    }

    /**
     * Constructor para Coach con detalles específicos.
     *
     * @param id        El identificador único para el entrenador.
     * @param firstName El nombre del entrenador.
     * @param lastName  El apellido del entrenador.
     * @param email     La dirección de correo electrónico del entrenador.
     * @param password  La contraseña para la cuenta del entrenador.
     * @param country   El país de residencia del entrenador.
     * @param city      La ciudad de residencia del entrenador.
     * @param birthDate La fecha de nacimiento del entrenador.
     * @param role      El rol del entrenador en el sistema.
     */
    public Coach(int id, String firstName, String lastName, String email, String password, String country, String city,
            LocalDate birthDate, UserRole role) {
        super(id, firstName, lastName, email, password, country, city, birthDate, role);
    }

    /**
     * Constructor para Coach con detalles específicos y rol por defecto como COACH.
     *
     * @param id        El identificador único para el entrenador.
     * @param firstName El nombre del entrenador.
     * @param lastName  El apellido del entrenador.
     * @param email     La dirección de correo electrónico del entrenador.
     * @param password  La contraseña para la cuenta del entrenador.
     * @param country   El país de residencia del entrenador.
     * @param city      La ciudad de residencia del entrenador.
     * @param birthDate La fecha de nacimiento del entrenador.
     */
    public Coach(int id, String firstName, String lastName, String email, String password, String country, String city,
            LocalDate birthDate) {
        super(id, firstName, lastName, email, password, country, city, birthDate, UserRole.COACH);
    }

    /**
     * Obtiene la lista de equipos asociados al entrenador.
     *
     * @return La lista de equipos asociados al entrenador.
     */
    public List<Team> getTeams() {
        return teams;
    }

    /**
     * Establece la lista de equipos asociados al entrenador.
     *
     * @param teams La lista de equipos a asociar al entrenador.
     */
    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}


