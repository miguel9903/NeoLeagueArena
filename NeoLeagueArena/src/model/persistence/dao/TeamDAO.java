package model.persistence.dao;

import java.util.ArrayList;

import model.Team;
import model.persistence.FileManager;
import utils.PersistencePaths;

/**
 * Clase que implementa el patrón DAO (Data Access Object) para gestionar la persistencia de objetos Team.
 * Proporciona métodos para cargar, guardar, añadir, eliminar, actualizar y buscar equipos.
 */
public class TeamDAO implements InterfaceDAO<Team> {

    private ArrayList<Team> teams;
    private FileManager<Team> fileManager;

    /**
     * Constructor para inicializar el TeamDAO.
     * Carga los datos desde el archivo.
     */
    public TeamDAO() {
        fileManager = new FileManager<>(PersistencePaths.TEAMS_FILE);
        teams = new ArrayList<>();
        loadFromFile();
    }

    /**
     * Carga los equipos desde el archivo.
     */
    public void loadFromFile() {
        ArrayList<Team> loaded = fileManager.readFromFile(Team.class);

        if (loaded != null) {
            teams = loaded;
        }
    }

    /**
     * Guarda los equipos en el archivo.
     */
    public void saveToFile() {
        fileManager.writeToFile(teams, Team.class);
    }

    /**
     * Obtiene una lista de todos los equipos.
     *
     * @return Una lista de todos los equipos.
     */
    @Override
    public ArrayList<Team> getAll() {
        return new ArrayList<>(teams);
    }

    /**
     * Obtiene una representación en cadena de todos los equipos.
     *
     * @return Una cadena que representa a todos los equipos.
     */
    @Override
    public String getAllAsString() {
        StringBuilder sb = new StringBuilder();
        for (Team t : teams) {
            sb.append(t).append("\n");
        }
        return sb.toString();
    }

    /**
     * Añade un nuevo equipo.
     *
     * @param team El equipo a añadir.
     * @return true si el equipo fue añadido con éxito, false en caso contrario.
     */
    @Override
    public boolean add(Team team) {
        if (find(team) == null) {
            teams.add(team);
            saveToFile();
            return true;
        }
        return false;
    }

    /**
     * Elimina un equipo.
     *
     * @param team El equipo a eliminar.
     * @return true si el equipo fue eliminado con éxito, false en caso contrario.
     */
    @Override
    public boolean delete(Team team) {
        Team found = find(team);
        if (found != null) {
            teams.remove(found);
            saveToFile();
            return true;
        }
        return false;
    }

    /**
     * Actualiza un equipo existente con nueva información.
     *
     * @param oldTeam El equipo con la información antigua.
     * @param newTeam El equipo con la información nueva.
     * @return true si el equipo fue actualizado con éxito, false en caso contrario.
     */
    @Override
    public boolean update(Team oldTeam, Team newTeam) {
        Team existing = find(oldTeam);
        if (existing != null) {
            teams.remove(existing);
            teams.add(newTeam);
            saveToFile();
            return true;
        }
        return false;
    }

    /**
     * Busca un equipo.
     *
     * @param team El equipo a buscar.
     * @return El equipo encontrado, o null si no se encontró.
     */
    @Override
    public Team find(Team team) {
        for (Team t : teams) {
            if (t.getId() == team.getId()) {
                return t;
            }
        }
        return null;
    }
}
