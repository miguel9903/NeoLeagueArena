package model.enums;

/**
 * El enum UserRole representa los diferentes roles de usuario en el sistema.
 * Cada rol tiene un nombre para mostrar asociado.
 */
public enum UserRole {

    ADMIN("Administrator"),
    PLAYER("Player"),
    COACH("Coach");

    private final String displayName;

    /**
     * Constructor para UserRole.
     *
     * @param displayName El nombre para mostrar del rol.
     */
    UserRole(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Obtiene el nombre para mostrar del rol.
     *
     * @return El nombre para mostrar del rol.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Obtiene el rol de usuario a partir de una cadena de texto.
     *
     * @param role La cadena de texto que representa el rol.
     * @return El rol de usuario correspondiente, o null si no se encuentra.
     */
    public static UserRole fromString(String role) {
        if (role == null) return null;

        for (UserRole ur : UserRole.values()) {
            if (ur.name().equalsIgnoreCase(role) || ur.getDisplayName().equalsIgnoreCase(role)) {
                return ur;
            }
        }

        return null;
    }
}

