package model.enums;

/**
 * El enum GameMode representa los diferentes modos de juego en un videojuego.
 * Cada modo de juego tiene un nombre para mostrar asociado.
 */
public enum GameMode {

    ONE_VS_ONE("1v1"),
    TEAM_VS_TEAM("Team vs Team"),
    TOURNAMENT("Tournament"),
    BATTLE_ROYALE("Battle Royale"),
    CO_OP("Cooperative"),
    KING_OF_THE_HILL("King of the Hill"),
    CAPTURE_THE_FLAG("Capture the Flag"),
    TIME_TRIALS("Time Trials"),
    SURVIVAL("Survival"),
    FREE_FOR_ALL("Free-for-All"),
    DRAFT_MODE("Draft Mode");

    private final String displayName;

    /**
     * Constructor para GameMode.
     *
     * @param displayName El nombre para mostrar del modo de juego.
     */
    GameMode(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Obtiene el nombre para mostrar del modo de juego.
     *
     * @return El nombre para mostrar del modo de juego.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Obtiene el modo de juego a partir de una cadena de texto.
     *
     * @param mode La cadena de texto que representa el modo de juego.
     * @return El modo de juego correspondiente, o null si no se encuentra.
     */
    public static GameMode fromString(String mode) {
        if (mode == null) return null;

        for (GameMode gm : GameMode.values()) {
            if (gm.name().equalsIgnoreCase(mode) || gm.getDisplayName().equalsIgnoreCase(mode)) {
                return gm;
            }
        }

        return null;
    }
}
