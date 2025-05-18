package model.persistence.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Clase DTO (Data Transfer Object) que representa a un juego.
 */
public class GameDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String description;
    private String logo;
    private String genre;
    private String platform;
    private List<String> modes;

    /**
     * Obtiene el identificador único del juego.
     *
     * @return El identificador único del juego.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del juego.
     *
     * @param id El nuevo identificador único del juego.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del juego.
     *
     * @return El nombre del juego.
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del juego.
     *
     * @param name El nuevo nombre del juego.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene la descripción del juego.
     *
     * @return La descripción del juego.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Establece la descripción del juego.
     *
     * @param description La nueva descripción del juego.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtiene la URL o ruta del logo del juego.
     *
     * @return La URL o ruta del logo del juego.
     */
    public String getLogo() {
        return logo;
    }

    /**
     * Establece la URL o ruta del logo del juego.
     *
     * @param logo La nueva URL o ruta del logo del juego.
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * Obtiene el género del juego.
     *
     * @return El género del juego.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Establece el género del juego.
     *
     * @param genre El nuevo género del juego.
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Obtiene la plataforma del juego.
     *
     * @return La plataforma del juego.
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * Establece la plataforma del juego.
     *
     * @param platform La nueva plataforma del juego.
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * Obtiene la lista de modos de juego disponibles.
     *
     * @return La lista de modos de juego disponibles.
     */
    public List<String> getModes() {
        return modes;
    }

    /**
     * Establece la lista de modos de juego disponibles.
     *
     * @param modes La nueva lista de modos de juego disponibles.
     */
    public void setModes(List<String> modes) {
        this.modes = modes;
    }
}
