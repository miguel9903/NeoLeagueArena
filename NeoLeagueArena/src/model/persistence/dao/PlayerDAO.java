package model.persistence.dao;

import java.util.ArrayList;

import model.Player;
import model.persistence.FileManager;
import utils.PersistencePaths;

/**
 * Clase que implementa el patrón DAO (Data Access Object) para gestionar la persistencia de objetos Player.
 * Proporciona métodos para cargar, guardar, añadir, eliminar, actualizar y buscar jugadores.
 */
public class PlayerDAO implements InterfaceDAO<Player> {

    private ArrayList<Player> players;
    private FileManager<Player> fileManager;

    /**
     * Constructor para inicializar el PlayerDAO.
     * Carga los datos desde el archivo.
     */
    public PlayerDAO() {
        fileManager = new FileManager<>(PersistencePaths.PLAYERS_FILE);
        players = new ArrayList<>();
        loadFromFile();
    }

    /**
     * Carga los jugadores desde el archivo.
     */
    public void loadFromFile() {
        ArrayList<Player> loaded = fileManager.readFromFile(Player.class);

        if (loaded != null) {
            players = loaded;
        }
    }

    /**
     * Guarda los jugadores en el archivo.
     */
    public void saveToFile() {
        fileManager.writeToFile(players, Player.class);
    }

    /**
     * Obtiene una lista de todos los jugadores.
     *
     * @return Una lista de todos los jugadores.
     */
    @Override
    public ArrayList<Player> getAll() {
        return new ArrayList<>(players);
    }

    /**
     * Obtiene una representación en cadena de todos los jugadores.
     *
     * @return Una cadena que representa a todos los jugadores.
     */
    @Override
    public String getAllAsString() {
        StringBuilder sb = new StringBuilder();
        for (Player p : players) {
            sb.append(p).append("\n");
        }
        return sb.toString();
    }

    /**
     * Añade un nuevo jugador.
     *
     * @param player El jugador a añadir.
     * @return true si el jugador fue añadido con éxito, false en caso contrario.
     */
    @Override
    public boolean add(Player player) {
        if (find(player) == null) {
            players.add(player);
            saveToFile();
            return true;
        }
        return false;
    }

    /**
     * Elimina un jugador.
     *
     * @param player El jugador a eliminar.
     * @return true si el jugador fue eliminado con éxito, false en caso contrario.
     */
    @Override
    public boolean delete(Player player) {
        Player found = find(player);
        System.out.print("Finded: " + find(player).toString() + "\n\n");

        for (Player p : players) {
            if (p.getId() == player.getId()) {
                System.out.print(p.toString());
            }
        }

        if (found != null) {
            players.remove(found);
            saveToFile();
            return true;
        }
        return false;
    }

    /**
     * Actualiza un jugador existente con nueva información.
     *
     * @param oldPlayer El jugador con la información antigua.
     * @param newPlayer El jugador con la información nueva.
     * @return true si el jugador fue actualizado con éxito, false en caso contrario.
     */
    @Override
    public boolean update(Player oldPlayer, Player newPlayer) {
        Player existing = find(oldPlayer);
        if (existing != null) {
            players.remove(existing);
            players.add(newPlayer);
            saveToFile();
            return true;
        }
        return false;
    }

    /**
     * Busca un jugador.
     *
     * @param player El jugador a buscar.
     * @return El jugador encontrado, o null si no se encontró.
     */
    @Override
    public Player find(Player player) {
        for (Player p : players) {
            if (p.getId() == player.getId()) {
                return p;
            }
        }
        return null;
    }
}

