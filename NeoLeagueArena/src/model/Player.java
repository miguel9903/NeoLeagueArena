package model;

import java.time.LocalDate;
import model.enums.UserRole;

/**
 * La clase Player representa un jugador en el sistema.
 * Extiende la clase User, heredando sus propiedades y métodos.
 */
public class Player extends User {

    private String nickName;
    private Team currentTeam;
    private int experienceLevel;

    /**
     * Constructor por defecto para Player.
     * Inicializa un objeto Player con valores por defecto.
     */
    public Player() {
        super();
    }

    /**
     * Constructor para Player con detalles específicos.
     *
     * @param id        El identificador único para el jugador.
     * @param firstName El nombre del jugador.
     * @param lastName  El apellido del jugador.
     * @param email     La dirección de correo electrónico del jugador.
     * @param password  La contraseña para la cuenta del jugador.
     * @param country   El país de residencia del jugador.
     * @param city      La ciudad de residencia del jugador.
     * @param birthDate La fecha de nacimiento del jugador.
     * @param role      El rol del jugador en el sistema.
     */
    public Player(int id, String firstName, String lastName, String email, String password, String country, String city,
            LocalDate birthDate, UserRole role) {
        super(id, firstName, lastName, email, password, country, city, birthDate, role);
    }

    /**
     * Constructor para Player con detalles específicos y rol por defecto como PLAYER.
     *
     * @param id        El identificador único para el jugador.
     * @param firstName El nombre del jugador.
     * @param lastName  El apellido del jugador.
     * @param email     La dirección de correo electrónico del jugador.
     * @param password  La contraseña para la cuenta del jugador.
     * @param country   El país de residencia del jugador.
     * @param city      La ciudad de residencia del jugador.
     * @param birthDate La fecha de nacimiento del jugador.
     */
    public Player(int id, String firstName, String lastName, String email, String password, String country, String city,
            LocalDate birthDate) {
        super(id, firstName, lastName, email, password, country, city, birthDate, UserRole.PLAYER);
    }

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
     * @param nickName El apodo a establecer.
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
     * @param experienceLevel El nivel de experiencia a establecer.
     */
    public void setExperienceLevel(int experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    /**
     * Obtiene el equipo actual del jugador.
     *
     * @return El equipo actual del jugador.
     */
    public Team getCurrentTeam() {
        return currentTeam;
    }

    /**
     * Establece el equipo actual del jugador.
     *
     * @param currentTeam El equipo actual a establecer.
     */
    public void setCurrentTeam(Team currentTeam) {
        this.currentTeam = currentTeam;
    }
}

