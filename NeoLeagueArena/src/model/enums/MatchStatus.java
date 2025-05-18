package model.enums;

/**
 * El enum MatchStatus representa los diferentes estados de un partido.
 * Cada estado tiene un nombre para mostrar asociado.
 */
public enum MatchStatus {

    SCHEDULED("Scheduled"),
    ONGOING("Ongoing"),
    PAUSED("Paused"),
    COMPLETED("Completed"),
    CANCELLED("Cancelled"),
    POSTPONED("Postponed");

    private final String displayName;

    /**
     * Constructor para MatchStatus.
     *
     * @param displayName El nombre para mostrar del estado del partido.
     */
    MatchStatus(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Obtiene el nombre para mostrar del estado del partido.
     *
     * @return El nombre para mostrar del estado del partido.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Obtiene el estado del partido a partir de una cadena de texto.
     *
     * @param status La cadena de texto que representa el estado del partido.
     * @return El estado del partido correspondiente, o null si no se encuentra.
     */
    public static MatchStatus fromString(String status) {
        if (status == null) return null;

        for (MatchStatus ms : MatchStatus.values()) {
            if (ms.name().equalsIgnoreCase(status) || ms.getDisplayName().equalsIgnoreCase(status)) {
                return ms;
            }
        }

        return null;
    }
}
