package utils;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 * Clase de utilidad para mostrar mensajes al usuario.
 */
public class MessageDisplayer {

    // INFO messages
    /**
     * Muestra un mensaje de información.
     *
     * @param message El mensaje a mostrar.
     */
    public static void showInfoMessage(String message) {
        showInfoMessage(null, message, "Information");
    }

    /**
     * Muestra un mensaje de información con un título específico.
     *
     * @param message El mensaje a mostrar.
     * @param title   El título del mensaje.
     */
    public static void showInfoMessage(String message, String title) {
        showInfoMessage(null, message, title);
    }

    /**
     * Muestra un mensaje de información con un componente padre.
     *
     * @param parent  El componente padre.
     * @param message El mensaje a mostrar.
     */
    public static void showInfoMessage(Component parent, String message) {
        showInfoMessage(parent, message, "Information");
    }

    /**
     * Muestra un mensaje de información con un componente padre y un título específico.
     *
     * @param parent  El componente padre.
     * @param message El mensaje a mostrar.
     * @param title   El título del mensaje.
     */
    public static void showInfoMessage(Component parent, String message, String title) {
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    // SUCCESS messages
    /**
     * Muestra un mensaje de éxito.
     *
     * @param message El mensaje a mostrar.
     */
    public static void showSuccessMessage(String message) {
        showSuccessMessage(null, message, "Success");
    }

    /**
     * Muestra un mensaje de éxito con un título específico.
     *
     * @param message El mensaje a mostrar.
     * @param title   El título del mensaje.
     */
    public static void showSuccessMessage(String message, String title) {
        showSuccessMessage(null, message, title);
    }

    /**
     * Muestra un mensaje de éxito con un componente padre.
     *
     * @param parent  El componente padre.
     * @param message El mensaje a mostrar.
     */
    public static void showSuccessMessage(Component parent, String message) {
        showSuccessMessage(parent, message, "Success");
    }

    /**
     * Muestra un mensaje de éxito con un componente padre y un título específico.
     *
     * @param parent  El componente padre.
     * @param message El mensaje a mostrar.
     * @param title   El título del mensaje.
     */
    public static void showSuccessMessage(Component parent, String message, String title) {
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    // ERROR messages
    /**
     * Muestra un mensaje de error.
     *
     * @param message El mensaje a mostrar.
     */
    public static void showErrorMessage(String message) {
        showErrorMessage(null, message, "Error");
    }

    /**
     * Muestra un mensaje de error con un título específico.
     *
     * @param message El mensaje a mostrar.
     * @param title   El título del mensaje.
     */
    public static void showErrorMessage(String message, String title) {
        showErrorMessage(null, message, title);
    }

    /**
     * Muestra un mensaje de error con un componente padre.
     *
     * @param parent  El componente padre.
     * @param message El mensaje a mostrar.
     */
    public static void showErrorMessage(Component parent, String message) {
        showErrorMessage(parent, message, "Error");
    }

    /**
     * Muestra un mensaje de error con un componente padre y un título específico.
     *
     * @param parent  El componente padre.
     * @param message El mensaje a mostrar.
     * @param title   El título del mensaje.
     */
    public static void showErrorMessage(Component parent, String message, String title) {
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.ERROR_MESSAGE);
    }

    // WARNING messages
    /**
     * Muestra un mensaje de advertencia.
     *
     * @param message El mensaje a mostrar.
     */
    public static void showWarningMessage(String message) {
        showWarningMessage(null, message, "Warning");
    }

    /**
     * Muestra un mensaje de advertencia con un título específico.
     *
     * @param message El mensaje a mostrar.
     * @param title   El título del mensaje.
     */
    public static void showWarningMessage(String message, String title) {
        showWarningMessage(null, message, title);
    }

    /**
     * Muestra un mensaje de advertencia con un componente padre.
     *
     * @param parent  El componente padre.
     * @param message El mensaje a mostrar.
     */
    public static void showWarningMessage(Component parent, String message) {
        showWarningMessage(parent, message, "Warning");
    }

    /**
     * Muestra un mensaje de advertencia con un componente padre y un título específico.
     *
     * @param parent  El componente padre.
     * @param message El mensaje a mostrar.
     * @param title   El título del mensaje.
     */
    public static void showWarningMessage(Component parent, String message, String title) {
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.WARNING_MESSAGE);
    }

    // CONFIRMATION messages
    /**
     * Muestra un mensaje de confirmación.
     *
     * @param message El mensaje a mostrar.
     * @return true si el usuario confirma, false en caso contrario.
     */
    public static boolean showConfirmationMessage(String message) {
        return showConfirmationMessage(null, message, "Confirmation");
    }

    /**
     * Muestra un mensaje de confirmación con un título específico.
     *
     * @param message El mensaje a mostrar.
     * @param title   El título del mensaje.
     * @return true si el usuario confirma, false en caso contrario.
     */
    public static boolean showConfirmationMessage(String message, String title) {
        return showConfirmationMessage(null, message, title);
    }

    /**
     * Muestra un mensaje de confirmación con un componente padre.
     *
     * @param parent  El componente padre.
     * @param message El mensaje a mostrar.
     * @return true si el usuario confirma, false en caso contrario.
     */
    public static boolean showConfirmationMessage(Component parent, String message) {
        return showConfirmationMessage(parent, message, "Confirmation");
    }

    /**
     * Muestra un mensaje de confirmación con un componente padre y un título específico.
     *
     * @param parent  El componente padre.
     * @param message El mensaje a mostrar.
     * @param title   El título del mensaje.
     * @return true si el usuario confirma, false en caso contrario.
     */
    public static boolean showConfirmationMessage(Component parent, String message, String title) {
        int option = JOptionPane.showConfirmDialog(parent, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return option == JOptionPane.YES_OPTION;
    }
}

