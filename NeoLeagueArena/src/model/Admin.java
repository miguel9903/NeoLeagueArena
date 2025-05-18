package model;

import java.time.LocalDate;
import model.enums.UserRole;

/**
 * La clase Admin representa un usuario administrativo en el sistema.
 * Extiende la clase User, heredando sus propiedades y métodos.
 */
public class Admin extends User {

    /**
     * Constructor por defecto para Admin.
     * Inicializa un objeto Admin con valores por defecto.
     */
    public Admin() {
        super();
    }

    /**
     * Constructor para Admin con detalles específicos.
     *
     * @param id        El identificador único para el administrador.
     * @param firstName El nombre del administrador.
     * @param lastName  El apellido del administrador.
     * @param email     La dirección de correo electrónico del administrador.
     * @param password  La contraseña para la cuenta del administrador.
     * @param country   El país de residencia del administrador.
     * @param city      La ciudad de residencia del administrador.
     * @param birthDate La fecha de nacimiento del administrador.
     * @param role      El rol del administrador en el sistema.
     */
    public Admin(int id, String firstName, String lastName, String email, String password, String country, String city,
            LocalDate birthDate, UserRole role) {
        super(id, firstName, lastName, email, password, country, city, birthDate, role);
    }

    /**
     * Constructor para Admin con detalles específicos y rol por defecto como ADMIN.
     *
     * @param id        El identificador único para el administrador.
     * @param firstName El nombre del administrador.
     * @param lastName  El apellido del administrador.
     * @param email     La dirección de correo electrónico del administrador.
     * @param password  La contraseña para la cuenta del administrador.
     * @param country   El país de residencia del administrador.
     * @param city      La ciudad de residencia del administrador.
     * @param birthDate La fecha de nacimiento del administrador.
     */
    public Admin(int id, String firstName, String lastName, String email, String password, String country, String city,
            LocalDate birthDate) {
        super(id, firstName, lastName, email, password, country, city, birthDate, UserRole.ADMIN);
    }
}

