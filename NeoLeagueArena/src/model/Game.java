package model;

public class Game {

	private int id;
	private String name;
	private String description;
	private String coverImage;
	private GameGenre game;
	private GamePlatform platform;
	private GameMode mode;
	
	public Game(int id, String name, String description, String coverImage, GameGenre game, GamePlatform platform,
			GameMode mode) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.coverImage = coverImage;
		this.game = game;
		this.platform = platform;
		this.mode = mode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public GameGenre getGame() {
		return game;
	}

	public void setGame(GameGenre game) {
		this.game = game;
	}

	public GamePlatform getPlatform() {
		return platform;
	}

	public void setPlatform(GamePlatform platform) {
		this.platform = platform;
	}

	public GameMode getMode() {
		return mode;
	}

	public void setMode(GameMode mode) {
		this.mode = mode;
	}
	
}
