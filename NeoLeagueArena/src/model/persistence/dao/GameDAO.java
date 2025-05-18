package model.persistence.dao;

import java.util.ArrayList;

import model.Game;
import model.persistence.FileManager;
import utils.PersistencePaths;

/**
 * Clase que implementa el patrón DAO (Data Access Object) para gestionar la persistencia de objetos Game.
 * Proporciona métodos para cargar, guardar, añadir, eliminar, actualizar y buscar juegos.
 */
public class GameDAO implements InterfaceDAO<Game> {

    private ArrayList<Game> games;
    private FileManager<Game> fileManager;

    /**
     * Constructor para inicializar el GameDAO.
     * Carga los datos desde el archivo.
     */
    public GameDAO() {
        fileManager = new FileManager<>(PersistencePaths.GAMES_FILE);
        games = new ArrayList<>();
        loadFromFile();
    }

    /**
     * Carga los juegos desde el archivo.
     */
    public void loadFromFile() {
        ArrayList<Game> loadedGames = fileManager.readFromFile(Game.class);
        if (loadedGames != null) {
            games = loadedGames;
        }
    }

    /**
     * Guarda los juegos en el archivo.
     */
    public void saveToFile() {
        fileManager.writeToFile(games, Game.class);
    }

    /**
     * Obtiene una lista de todos los juegos.
     *
     * @return Una lista de todos los juegos.
     */
    @Override
    public ArrayList<Game> getAll() {
        return new ArrayList<>(games);
    }

    /**
     * Obtiene una representación en cadena de todos los juegos.
     *
     * @return Una cadena que representa a todos los juegos.
     */
    @Override
    public String getAllAsString() {
        StringBuilder sb = new StringBuilder();
        for (Game g : games) {
            sb.append(g.getId()).append(" - ").append(g.getName()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Añade un nuevo juego.
     *
     * @param game El juego a añadir.
     * @return true si el juego fue añadido con éxito, false en caso contrario.
     */
    @Override
    public boolean add(Game game) {
        if (find(game) == null) {
            games.add(game);
            saveToFile();
            return true;
        }
        return false;
    }

    /**
     * Elimina un juego.
     *
     * @param game El juego a eliminar.
     * @return true si el juego fue eliminado con éxito, false en caso contrario.
     */
    @Override
    public boolean delete(Game game) {
        Game found = find(game);
        if (found != null) {
            games.remove(found);
            saveToFile();
            return true;
        }
        return false;
    }

    /**
     * Actualiza un juego existente con nueva información.
     *
     * @param oldGame El juego con la información antigua.
     * @param newGame El juego con la información nueva.
     * @return true si el juego fue actualizado con éxito, false en caso contrario.
     */
    @Override
    public boolean update(Game oldGame, Game newGame) {
        Game existing = find(oldGame);
        if (existing != null) {
            games.remove(existing);
            games.add(newGame);
            saveToFile();
            return true;
        }
        return false;
    }

    /**
     * Busca un juego.
     *
     * @param game El juego a buscar.
     * @return El juego encontrado, o null si no se encontró.
     */
    @Override
    public Game find(Game game) {
        for (Game g : games) {
            if (g.getId() == game.getId()) {
                return g;
            }
        }
        return null;
    }
}

