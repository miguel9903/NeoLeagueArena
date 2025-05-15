package model;

public enum GamePlatform {

    PC("Personal Computer"),
    PLAYSTATION("PlayStation"),
    XBOX("Xbox"),
    NINTENDO_SWITCH("Nintendo Switch");

    private final String displayName;

    GamePlatform(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
	
}
