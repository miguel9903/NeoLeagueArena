package model.enums;

/**
 * El enum TournamentPhase representa las diferentes fases de un torneo.
 * Cada fase tiene un nombre para mostrar asociado.
 */
public enum TournamentPhase {

    REGISTRATION("Registration"),
    GROUP_STAGE("Group Stage"),
    KNOCKOUT("Knockout"),
    QUARTERFINALS("Quarterfinals"),
    SEMIFINALS("Semifinals"),
    FINALS("Finals"),
    THIRD_PLACE("Third Place"),
    EXHIBITION("Exhibition");

    private final String displayName;

    /**
     * Constructor para TournamentPhase.
     *
     * @param displayName El nombre para mostrar de la fase del torneo.
     */
    TournamentPhase(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Obtiene el nombre para mostrar de la fase del torneo.
     *
     * @return El nombre para mostrar de la fase del torneo.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Obtiene la fase del torneo a partir de una cadena de texto.
     *
     * @param phase La cadena de texto que representa la fase del torneo.
     * @return La fase del torneo correspondiente, o null si no se encuentra.
     */
    public static TournamentPhase fromString(String phase) {
        if (phase == null) return null;

        for (TournamentPhase tp : TournamentPhase.values()) {
            if (tp.name().equalsIgnoreCase(phase) || tp.getDisplayName().equalsIgnoreCase(phase)) {
                return tp;
            }
        }

        return null;
    }
}
