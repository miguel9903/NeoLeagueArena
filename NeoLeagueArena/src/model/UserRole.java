package model;

public enum UserRole {

	ADMIN("Administrator"),
	PLAYER("Player"),
	COACH("Coach");

	private final String displayName;

	UserRole(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
