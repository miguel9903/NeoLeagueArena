package model.persistence.dao;

import java.util.ArrayList;

/**
 * Interfaz genérica para el patrón DAO (Data Access Object).
 * Define los métodos básicos para gestionar la persistencia de objetos de tipo T.
 *
 * @param <T> El tipo de objeto que se gestionará.
 */
public interface InterfaceDAO<T> {

    /**
     * Obtiene una lista de todos los objetos de tipo T.
     *
     * @return Una lista de todos los objetos de tipo T.
     */
    ArrayList<T> getAll();

    /**
     * Obtiene una representación en cadena de todos los objetos de tipo T.
     *
     * @return Una cadena que representa a todos los objetos de tipo T.
     */
    String getAllAsString();

    /**
     * Añade un nuevo objeto de tipo T.
     *
     * @param x El objeto de tipo T a añadir.
     * @return true si el objeto fue añadido con éxito, false en caso contrario.
     */
    boolean add(T x);

    /**
     * Elimina un objeto de tipo T.
     *
     * @param x El objeto de tipo T a eliminar.
     * @return true si el objeto fue eliminado con éxito, false en caso contrario.
     */
    boolean delete(T x);

    /**
     * Actualiza un objeto de tipo T existente con nueva información.
     *
     * @param x El objeto de tipo T con la información antigua.
     * @param y El objeto de tipo T con la información nueva.
     * @return true si el objeto fue actualizado con éxito, false en caso contrario.
     */
    boolean update(T x, T y);

    /**
     * Busca un objeto de tipo T.
     *
     * @param x El objeto de tipo T a buscar.
     * @return El objeto de tipo T encontrado, o null si no se encontró.
     */
    T find(T x);
}
