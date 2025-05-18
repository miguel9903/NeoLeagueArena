package model.enums;

/**
 * El enum GameGenre representa los diferentes géneros de videojuegos.
 * Cada género tiene un nombre para mostrar asociado.
 */
public enum GameGenre {

    ACTION("Action"),
    ADVENTURE("Adventure"),
    RPG("Role Playing Game"),
    FPS("First Person Shooter"),
    SPORTS("Sports"),
    SIMULATION("Simulation"),
    STRATEGY("Strategy"),
    MOBA("Multiplayer Online Battle Arena"),
    FIGHTING("Fighting"),
    PUZZLE("Puzzle"),
    HORROR("Horror"),
    RACING("Racing"),
    MMO("Massively Multiplayer Online");

    private final String displayName;

    /**
     * Constructor para GameGenre.
     *
     * @param displayName El nombre para mostrar del género.
     */
    GameGenre(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Obtiene el nombre para mostrar del género.
     *
     * @return El nombre para mostrar del género.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Obtiene el género de juego a partir de una cadena de texto.
     *
     * @param genre La cadena de texto que representa el género.
     * @return El género de juego correspondiente, o null si no se encuentra.
     */
    public static GameGenre fromString(String genre) {
        if (genre == null) return null;

        for (GameGenre gg : GameGenre.values()) {
            if (gg.name().equalsIgnoreCase(genre) || gg.getDisplayName().equalsIgnoreCase(genre)) {
                return gg;
            }
        }

        return null;
    }
}

