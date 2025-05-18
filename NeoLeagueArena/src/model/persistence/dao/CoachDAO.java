package model.persistence.dao;

import java.util.ArrayList;

import model.Coach;
import model.persistence.FileManager;
import utils.PersistencePaths;

/**
 * Clase que implementa el patrón DAO (Data Access Object) para gestionar la persistencia de objetos Coach.
 * Proporciona métodos para cargar, guardar, añadir, eliminar, actualizar y buscar entrenadores.
 */
public class CoachDAO implements InterfaceDAO<Coach> {

    private ArrayList<Coach> coaches;
    private FileManager<Coach> fileManager;

    /**
     * Constructor para inicializar el CoachDAO.
     * Carga los datos desde el archivo.
     */
    public CoachDAO() {
        fileManager = new FileManager<>(PersistencePaths.COACHES_FILE);
        coaches = new ArrayList<>();
        loadFromFile();
    }

    /**
     * Carga los entrenadores desde el archivo.
     */
    public void loadFromFile() {
        ArrayList<Coach> loaded = fileManager.readFromFile(Coach.class);
        if (loaded != null) {
            coaches = loaded;
        }
    }

    /**
     * Guarda los entrenadores en el archivo.
     */
    public void saveToFile() {
        fileManager.writeToFile(coaches, Coach.class);
    }

    /**
     * Obtiene una lista de todos los entrenadores.
     *
     * @return Una lista de todos los entrenadores.
     */
    @Override
    public ArrayList<Coach> getAll() {
        return new ArrayList<>(coaches);
    }

    /**
     * Obtiene una representación en cadena de todos los entrenadores.
     *
     * @return Una cadena que representa a todos los entrenadores.
     */
    @Override
    public String getAllAsString() {
        StringBuilder sb = new StringBuilder();
        for (Coach c : coaches) {
            sb.append(c).append("\n");
        }
        return sb.toString();
    }

    /**
     * Añade un nuevo entrenador.
     *
     * @param coach El entrenador a añadir.
     * @return true si el entrenador fue añadido con éxito, false en caso contrario.
     */
    @Override
    public boolean add(Coach coach) {
        if (find(coach) == null) {
            coaches.add(coach);
            saveToFile();
            return true;
        }
        return false;
    }

    /**
     * Elimina un entrenador.
     *
     * @param coach El entrenador a eliminar.
     * @return true si el entrenador fue eliminado con éxito, false en caso contrario.
     */
    @Override
    public boolean delete(Coach coach) {
        Coach found = find(coach);
        if (found != null) {
            coaches.remove(found);
            saveToFile();
            return true;
        }
        return false;
    }

    /**
     * Actualiza un entrenador existente con nueva información.
     *
     * @param oldCoach El entrenador con la información antigua.
     * @param newCoach El entrenador con la información nueva.
     * @return true si el entrenador fue actualizado con éxito, false en caso contrario.
     */
    @Override
    public boolean update(Coach oldCoach, Coach newCoach) {
        Coach existing = find(oldCoach);
        if (existing != null) {
            coaches.remove(existing);
            coaches.add(newCoach);
            saveToFile();
            return true;
        }
        return false;
    }

    /**
     * Busca un entrenador.
     *
     * @param coach El entrenador a buscar.
     * @return El entrenador encontrado, o null si no se encontró.
     */
    @Override
    public Coach find(Coach coach) {
        for (Coach c : coaches) {
            if (c.getId() == coach.getId()) {
                return c;
            }
        }
        return null;
    }
}

