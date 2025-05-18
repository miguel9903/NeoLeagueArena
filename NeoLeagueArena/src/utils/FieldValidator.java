package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Clase de utilidad para validar campos de entrada.
 */
public class FieldValidator {

    /**
     * Verifica si una cadena es un número decimal.
     *
     * @param value La cadena a verificar.
     * @return true si la cadena es un número decimal, false en caso contrario.
     */
    public static boolean isDecimal(String value) {
        return value != null && value.matches("\\d+(\\.\\d+)?");
    }

    /**
     * Verifica si una cadena es un número entero.
     *
     * @param value La cadena a verificar.
     * @return true si la cadena es un número entero, false en caso contrario.
     */
    public static boolean isInteger(String value) {
        return value != null && value.matches("\\d+");
    }

    /**
     * Verifica si una cadena está vacía.
     *
     * @param value La cadena a verificar.
     * @return true si la cadena está vacía, false en caso contrario.
     */
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    /**
     * Verifica si una cadena no está vacía.
     *
     * @param value La cadena a verificar.
     * @return true si la cadena no está vacía, false en caso contrario.
     */
    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    /**
     * Verifica si un valor decimal está dentro de un rango.
     *
     * @param value El valor a verificar.
     * @param min   El valor mínimo del rango.
     * @param max   El valor máximo del rango.
     * @return true si el valor está dentro del rango, false en caso contrario.
     */
    public static boolean isInDecimalRange(double value, double min, double max) {
        return value >= min && value <= max;
    }

    /**
     * Verifica si una cadena es alfanumérica.
     *
     * @param input La cadena a verificar.
     * @return true si la cadena es alfanumérica, false en caso contrario.
     */
    public static boolean isAlphanumeric(String input) {
        return input != null && input.matches("^[a-zA-Z0-9 ]+$");
    }

    /**
     * Verifica si un valor entero está dentro de un rango.
     *
     * @param value El valor a verificar.
     * @param min   El valor mínimo del rango.
     * @param max   El valor máximo del rango.
     * @return true si el valor está dentro del rango, false en caso contrario.
     */
    public static boolean isInIntegerRange(int value, int min, int max) {
        return value >= min && value <= max;
    }

    /**
     * Verifica si una cadena tiene un formato de fecha válido.
     *
     * @param date La cadena de fecha a verificar.
     * @return true si la cadena tiene un formato de fecha válido, false en caso contrario.
     */
    public static boolean isValidDateFormat(String date) {
        return isValidDate(date, "yyyy-MM-dd");
    }

    /**
     * Verifica si una cadena tiene un formato de fecha válido según un patrón específico.
     *
     * @param date    La cadena de fecha a verificar.
     * @param pattern El patrón de fecha a utilizar.
     * @return true si la cadena tiene un formato de fecha válido, false en caso contrario.
     */
    public static boolean isValidDate(String date, String pattern) {
        if (date == null || pattern == null) return false;

        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        dateFormat.setLenient(false);

        try {
            dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * Verifica si alguno de los campos está vacío.
     *
     * @param fields Los campos a verificar.
     * @return true si alguno de los campos está vacío, false en caso contrario.
     */
    public static boolean isAnyEmpty(String... fields) {
        for (String field : fields) {
            if (field == null || field.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica si todos los campos están vacíos.
     *
     * @param fields Los campos a verificar.
     * @return true si todos los campos están vacíos, false en caso contrario.
     */
    public static boolean areAllEmpty(String... fields) {
        for (String field : fields) {
            if (field != null && !field.trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}

