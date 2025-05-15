package model;

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

	GameGenre(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
	
}
