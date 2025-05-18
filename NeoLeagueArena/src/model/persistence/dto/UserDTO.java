package model.persistence.dto;

import java.io.Serializable;

/**
 * Clase DTO (Data Transfer Object) que representa a un usuario.
 */
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String country;
    private String city;
    private String role;
    private String birthDate;
    private int age;

    /**
     * Constructor por defecto para crear una instancia de UserDTO.
     */
    public UserDTO() { }

    /**
     * Autentica al usuario con el correo electrónico y la contraseña.
     *
     * @param email    El correo electrónico del usuario.
     * @param password La contraseña del usuario.
     * @return true si las credenciales son correctas, false en caso contrario.
     */
    public boolean login(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    /**
     * Obtiene el identificador único del usuario.
     *
     * @return El identificador único del usuario.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el identificador único del usuario.
     *
     * @param id El nuevo identificador único del usuario.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param firstName El nuevo nombre del usuario.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Obtiene el apellido del usuario.
     *
     * @return El apellido del usuario.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Establece el apellido del usuario.
     *
     * @param lastName El nuevo apellido del usuario.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return El correo electrónico del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param email El nuevo correo electrónico del usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param password La nueva contraseña del usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtiene el país del usuario.
     *
     * @return El país del usuario.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Establece el país del usuario.
     *
     * @param country El nuevo país del usuario.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Obtiene la ciudad del usuario.
     *
     * @return La ciudad del usuario.
     */
    public String getCity() {
        return city;
    }

    /**
     * Establece la ciudad del usuario.
     *
     * @param city La nueva ciudad del usuario.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Obtiene el rol del usuario.
     *
     * @return El rol del usuario.
     */
    public String getRole() {
        return role;
    }

    /**
     * Establece el rol del usuario.
     *
     * @param role El nuevo rol del usuario.
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Obtiene la fecha de nacimiento del usuario.
     *
     * @return La fecha de nacimiento del usuario.
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Establece la fecha de nacimiento del usuario.
     *
     * @param birthDate La nueva fecha de nacimiento del usuario.
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
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
     * Obtiene la edad del usuario.
     *
     * @return La edad del usuario.
     */
    public int getAge() {
        return age;
    }

    /**
     * Establece la edad del usuario.
     *
     * @param age La nueva edad del usuario.
     */
    public void setAge(int age) {
        this.age = age;
    }
}

