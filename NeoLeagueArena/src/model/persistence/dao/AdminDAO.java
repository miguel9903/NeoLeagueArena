package model.persistence.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

import model.Admin;
import model.persistence.FileManager;
import utils.PersistencePaths;

/**
 * Clase que implementa el patrón DAO (Data Access Object) para gestionar la persistencia de objetos Admin.
 * Proporciona métodos para cargar, guardar, añadir, eliminar, actualizar y buscar administradores.
 */
public class AdminDAO implements InterfaceDAO<Admin> {

    private ArrayList<Admin> admins;
    private FileManager<Admin> fileManager;

    /**
     * Constructor para inicializar el AdminDAO.
     * Carga los datos desde el archivo y, si no hay datos, carga datos iniciales.
     */
    public AdminDAO() {
        fileManager = new FileManager<>(PersistencePaths.ADMINS_FILE);
        admins = new ArrayList<>();
        loadFromFile();

        if (admins.isEmpty()) {
            loadInitialData();
            saveToFile();
        }
    }

    /**
     * Carga los administradores desde el archivo.
     */
    public void loadFromFile() {
        ArrayList<Admin> loaded = fileManager.readFromFile(Admin.class);
        if (loaded != null) {
            admins = loaded;
        }
    }

    /**
     * Guarda los administradores en el archivo.
     */
    public void saveToFile() {
        fileManager.writeToFile(admins, Admin.class);
    }

    /**
     * Carga datos iniciales de administradores.
     * Se utiliza cuando no hay datos cargados desde el archivo.
     */
    private void loadInitialData() {
        Admin defaultAdmin = new Admin(
            1,
            "ADMIN",
            "ADMIN",
            "admin",
            "123",
            "Colombia",
            "Bogotá D.C.",
            LocalDate.of(1990, 1, 1)
        );

        admins.add(defaultAdmin);
    }

    /**
     * Obtiene una lista de todos los administradores.
     *
     * @return Una lista de todos los administradores.
     */
    @Override
    public ArrayList<Admin> getAll() {
        return new ArrayList<>(admins);
    }

    /**
     * Obtiene una representación en cadena de todos los administradores.
     *
     * @return Una cadena que representa a todos los administradores.
     */
    @Override
    public String getAllAsString() {
        return admins.stream()
                .map(Admin::toString)
                .collect(Collectors.joining("\n"));
    }

    /**
     * Añade un nuevo administrador.
     *
     * @param admin El administrador a añadir.
     * @return true si el administrador fue añadido con éxito, false en caso contrario.
     */
    @Override
    public boolean add(Admin admin) {
        if (find(admin) == null) {
            admins.add(admin);
            saveToFile();
            return true;
        }
        return false;
    }

    /**
     * Elimina un administrador.
     *
     * @param admin El administrador a eliminar.
     * @return true si el administrador fue eliminado con éxito, false en caso contrario.
     */
    @Override
    public boolean delete(Admin admin) {
        Admin found = find(admin);
        if (found != null) {
            admins.remove(found);
            saveToFile();
            return true;
        }
        return false;
    }

    /**
     * Actualiza un administrador existente con nueva información.
     *
     * @param oldAdmin El administrador con la información antigua.
     * @param newAdmin El administrador con la información nueva.
     * @return true si el administrador fue actualizado con éxito, false en caso contrario.
     */
    @Override
    public boolean update(Admin oldAdmin, Admin newAdmin) {
        Admin existing = find(oldAdmin);
        if (existing != null) {
            admins.remove(existing);
            admins.add(newAdmin);
            saveToFile();
            return true;
        }
        return false;
    }

    /**
     * Busca un administrador.
     *
     * @param admin El administrador a buscar.
     * @return El administrador encontrado, o null si no se encontró.
     */
    @Override
    public Admin find(Admin admin) {
        for (Admin a : admins) {
            if (a.getId() == admin.getId()) {
                return a;
            }
        }
        return null;
    }
}

