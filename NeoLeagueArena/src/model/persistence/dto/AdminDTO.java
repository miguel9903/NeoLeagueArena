package model.persistence.dto;

/**
 * Clase DTO (Data Transfer Object) que representa a un administrador.
 * Extiende de UserDTO para incluir propiedades específicas de un administrador.
 */
public class AdminDTO extends UserDTO {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor por defecto para crear una instancia de AdminDTO.
     * Establece el rol como "ADMIN".
     */
    public AdminDTO() {
        super();
        setRole("ADMIN");
    }

    /**
     * Constructor para crear una nueva instancia de AdminDTO con parámetros específicos.
     *
     * @param id        El identificador único del administrador.
     * @param firstName El nombre del administrador.
     * @param lastName  El apellido del administrador.
     * @param email     El correo electrónico del administrador.
     * @param password  La contraseña del administrador.
     * @param country   El país del administrador.
     * @param city      La ciudad del administrador.
     */
    public AdminDTO(int id, String firstName, String lastName, String email, String password,
            String country, String city) {
        super();
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
        setCountry(country);
        setCity(city);
        setRole("ADMIN");
    }

    /**
     * Devuelve una representación en cadena del objeto AdminDTO.
     *
     * @return Una cadena que representa al objeto AdminDTO.
     */
    @Override
    public String toString() {
        return "AdminDTO [id=" + getId() + ", firstName=" + getFirstName() + ", lastName=" + getLastName()
        + ", email=" + getEmail() + ", password=" + getPassword() + ", country=" + getCountry()
        + ", city=" + getCity() + ", role=" + getRole() + "]";
    }
}

