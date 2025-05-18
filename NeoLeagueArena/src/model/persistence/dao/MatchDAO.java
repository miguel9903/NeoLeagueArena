package model.persistence.dao;

import java.util.ArrayList;

import model.Match;
import model.persistence.FileManager;
import utils.PersistencePaths;

/**
 * Clase que implementa el patrón DAO (Data Access Object) para gestionar la persistencia de objetos Match.
 * Proporciona métodos para cargar, guardar, añadir, eliminar, actualizar y buscar partidos.
 */
public class MatchDAO implements InterfaceDAO<Match> {

    private ArrayList<Match> matches;
    private FileManager<Match> fileManager;

    /**
     * Constructor para inicializar el MatchDAO.
     * Carga los datos desde el archivo.
     */
    public MatchDAO() {
        fileManager = new FileManager<>(PersistencePaths.MATCHES_FILE);
        matches = new ArrayList<>();
        loadFromFile();
    }

    /**
     * Carga los partidos desde el archivo.
     */
    private void loadFromFile() {
        ArrayList<Match> loaded = fileManager.readFromFile(Match.class);
        if (loaded != null) {
            matches = loaded;
        }
    }

    /**
     * Guarda los partidos en el archivo.
     */
    private void saveToFile() {
        fileManager.writeToFile(matches, Match.class);
    }

    /**
     * Obtiene una lista de todos los partidos.
     *
     * @return Una lista de todos los partidos.
     */
    @Override
    public ArrayList<Match> getAll() {
        return new ArrayList<>(matches);
    }

    /**
     * Obtiene una representación en cadena de todos los partidos.
     *
     * @return Una cadena que representa a todos los partidos.
     */
    @Override
    public String getAllAsString() {
        StringBuilder sb = new StringBuilder();
        for (Match m : matches) {
            sb.append(m).append("\n");
        }
        return sb.toString();
    }

    /**
     * Añade un nuevo partido.
     *
     * @param match El partido a añadir.
     * @return true si el partido fue añadido con éxito, false en caso contrario.
     */
    @Override
    public boolean add(Match match) {
        if (find(match) == null) {
            matches.add(match);
            saveToFile();
            return true;
        }
        return false;
    }

    /**
     * Elimina un partido.
     *
     * @param match El partido a eliminar.
     * @return true si el partido fue eliminado con éxito, false en caso contrario.
     */
    @Override
    public boolean delete(Match match) {
        Match found = find(match);
        if (found != null) {
            matches.remove(found);
            saveToFile();
            return true;
        }
        return false;
    }

    /**
     * Actualiza un partido existente con nueva información.
     *
     * @param oldMatch El partido con la información antigua.
     * @param newMatch El partido con la información nueva.
     * @return true si el partido fue actualizado con éxito, false en caso contrario.
     */
    @Override
    public boolean update(Match oldMatch, Match newMatch) {
        Match existing = find(oldMatch);
        if (existing != null) {
            matches.remove(existing);
            matches.add(newMatch);
            saveToFile();
            return true;
        }
        return false;
    }

    /**
     * Busca un partido.
     *
     * @param match El partido a buscar.
     * @return El partido encontrado, o null si no se encontró.
     */
    @Override
    public Match find(Match match) {
        for (Match m : matches) {
            if (m.equals(match)) {
                return m;
            }
        }
        return null;
    }
}
