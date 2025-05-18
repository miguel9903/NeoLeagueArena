package model.persistence.dao;

import java.util.ArrayList;

import model.Tournament;
import model.persistence.FileManager;
import utils.PersistencePaths;

/**
 * Clase que implementa el patrón DAO (Data Access Object) para gestionar la persistencia de objetos Tournament.
 * Proporciona métodos para cargar, guardar, añadir, eliminar, actualizar y buscar torneos.
 */
public class TournamentDAO implements InterfaceDAO<Tournament> {

    private ArrayList<Tournament> tournaments;
    private FileManager<Tournament> fileManager;

    /**
     * Constructor para inicializar el TournamentDAO.
     * Carga los datos desde el archivo.
     */
    public TournamentDAO() {
        fileManager = new FileManager<>(PersistencePaths.TOURNAMENTS_FILE);
        tournaments = new ArrayList<>();
        loadFromFile();
    }

    /**
     * Carga los torneos desde el archivo.
     */
    private void loadFromFile() {
        ArrayList<Tournament> loaded = fileManager.readFromFile(Tournament.class);
        if (loaded != null) {
            tournaments = loaded;
        }
    }

    /**
     * Guarda los torneos en el archivo.
     */
    private void saveToFile() {
        fileManager.writeToFile(tournaments, Tournament.class);
    }

    /**
     * Obtiene una lista de todos los torneos.
     *
     * @return Una lista de todos los torneos.
     */
    @Override
    public ArrayList<Tournament> getAll() {
        return new ArrayList<>(tournaments);
    }

    /**
     * Obtiene una representación en cadena de todos los torneos.
     *
     * @return Una cadena que representa a todos los torneos.
     */
    @Override
    public String getAllAsString() {
        StringBuilder sb = new StringBuilder();
        for (Tournament t : tournaments) {
            sb.append(t).append("\n");
        }
        return sb.toString();
    }

    /**
     * Añade un nuevo torneo.
     *
     * @param tournament El torneo a añadir.
     * @return true si el torneo fue añadido con éxito, false en caso contrario.
     */
    @Override
    public boolean add(Tournament tournament) {
        if (find(tournament) == null) {
            tournaments.add(tournament);
            saveToFile();
            return true;
        }
        return false;
    }

    /**
     * Elimina un torneo.
     *
     * @param tournament El torneo a eliminar.
     * @return true si el torneo fue eliminado con éxito, false en caso contrario.
     */
    @Override
    public boolean delete(Tournament tournament) {
        Tournament found = find(tournament);
        if (found != null) {
            tournaments.remove(found);
            saveToFile();
            return true;
        }
        return false;
    }

    /**
     * Actualiza un torneo existente con nueva información.
     *
     * @param oldTournament El torneo con la información antigua.
     * @param newTournament El torneo con la información nueva.
     * @return true si el torneo fue actualizado con éxito, false en caso contrario.
     */
    @Override
    public boolean update(Tournament oldTournament, Tournament newTournament) {
        Tournament existing = find(oldTournament);
        if (existing != null) {
            tournaments.remove(existing);
            tournaments.add(newTournament);
            saveToFile();
            return true;
        }
        return false;
    }

    /**
     * Busca un torneo.
     *
     * @param tournament El torneo a buscar.
     * @return El torneo encontrado, o null si no se encontró.
     */
    @Override
    public Tournament find(Tournament tournament) {
        for (Tournament t : tournaments) {
            if (t.equals(tournament)) {
                return t;
            }
        }
        return null;
    }
}

