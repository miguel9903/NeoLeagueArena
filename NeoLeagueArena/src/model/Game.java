package model;

import java.util.List;
import model.enums.GameGenre;
import model.enums.GameMode;
import model.enums.GamePlatform;

/**
 * Representa un videojuego en el sistema de gestión de torneos de e-sports.
 * Contiene información básica del juego como su nombre, descripción, logo,
 * género, plataforma y modos de juego disponibles.
 */
public class Game {

    private int id;
    private String name;
    private String description;
    private String logo;
    private GameGenre genre;
    private GamePlatform platform;
    private List<GameMode> modes;

    /**
     * Constructor para crear una nueva instancia de Game.
     *
     * @param id          El identificador único del juego.
     * @param name        El nombre del juego.
     * @param description La descripción del juego.
     * @param logo        La URL o ruta del logo del juego.
     * @param genre       El género del juego.
     * @param platform    La plataforma en la que está disponible el juego.
     * @param modes       La lista de modos de juego disponibles.
     */
    public Game(int id, String name, String description, String logo, GameGenre genre, GamePlatform platform,
            List<GameMode> modes) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.logo = logo;
        this.genre = genre;
        this.platform = platform;
        this.modes = modes;
    }

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
    public GameGenre getGenre() {
        return genre;
    }

    /**
     * Establece el género del juego.
     *
     * @param genre El nuevo género del juego.
     */
    public void setGenre(GameGenre genre) {
        this.genre = genre;
    }

    /**
     * Obtiene la plataforma en la que está disponible el juego.
     *
     * @return La plataforma del juego.
     */
    public GamePlatform getPlatform() {
        return platform;
    }

    /**
     * Establece la plataforma en la que está disponible el juego.
     *
     * @param platform La nueva plataforma del juego.
     */
    public void setPlatform(GamePlatform platform) {
        this.platform = platform;
    }

    /**
     * Obtiene la lista de modos de juego disponibles.
     *
     * @return La lista de modos de juego disponibles.
     */
    public List<GameMode> getModes() {
        return modes;
    }

    /**
     * Establece la lista de modos de juego disponibles.
     *
     * @param modes La nueva lista de modos de juego disponibles.
     */
    public void setModes(List<GameMode> modes) {
        this.modes = modes;
    }
}
