package model;

import java.time.LocalDate;
import java.time.Period;
import model.enums.UserRole;

/**
 * La clase abstracta User representa un usuario en el sistema.
 * Proporciona propiedades y métodos comunes para todos los tipos de usuarios.
 */
public abstract class User {

    protected int id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;
    protected String country;
    protected String city;
    private LocalDate birthDate;
    protected UserRole role;

    /**
     * Constructor por defecto para User.
     * Inicializa un objeto User con valores por defecto.
     */
    public User() { }

    /**
     * Constructor para User con detalles específicos.
     *
     * @param id        El identificador único para el usuario.
     * @param firstName El nombre del usuario.
     * @param lastName  El apellido del usuario.
     * @param email     La dirección de correo electrónico del usuario.
     * @param password  La contraseña para la cuenta del usuario.
     * @param country   El país de residencia del usuario.
     * @param city      La ciudad de residencia del usuario.
     * @param birthDate La fecha de nacimiento del usuario.
     * @param role      El rol del usuario en el sistema.
     */
    public User(int id, String firstName, String lastName, String email, String password, String country, String city,
            LocalDate birthDate, UserRole role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.country = country;
        this.city = city;
        this.birthDate = birthDate;
        this.role = role;
    }

    /**
     * Inicia sesión en el sistema.
     *
     * @param email    La dirección de correo electrónico del usuario.
     * @param password La contraseña para la cuenta del usuario.
     * @return true si el inicio de sesión es exitoso, false en caso contrario.
     */
    public boolean login(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    /**
     * Obtiene la edad del usuario.
     *
     * @return La edad del usuario en años, o -1 si la fecha de nacimiento no está establecida.
     */
    public int getAge() {
        if (birthDate == null)  return -1;
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    // Getters y Setters

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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}


