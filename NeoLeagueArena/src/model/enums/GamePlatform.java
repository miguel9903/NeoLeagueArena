package model.enums;

/**
 * El enum GamePlatform representa las diferentes plataformas de videojuegos.
 * Cada plataforma tiene un nombre para mostrar asociado.
 */
public enum GamePlatform {

    PC("Personal Computer"),
    PLAYSTATION("PlayStation"),
    XBOX("Xbox"),
    NINTENDO_SWITCH("Nintendo Switch"),
    UNKNOWN("Unknown");

    private final String displayName;

    /**
     * Constructor para GamePlatform.
     *
     * @param displayName El nombre para mostrar de la plataforma.
     */
    GamePlatform(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Obtiene el nombre para mostrar de la plataforma.
     *
     * @return El nombre para mostrar de la plataforma.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Obtiene la plataforma de juego a partir de una cadena de texto.
     *
     * @param platform La cadena de texto que representa la plataforma.
     * @return La plataforma de juego correspondiente, o null si no se encuentra.
     */
    public static GamePlatform fromString(String platform) {
        if (platform == null) return null;

        for (GamePlatform gp : GamePlatform.values()) {
            if (gp.name().equalsIgnoreCase(platform) || gp.getDisplayName().equalsIgnoreCase(platform)) {
                return gp;
            }
        }

        return null;
    }
}

