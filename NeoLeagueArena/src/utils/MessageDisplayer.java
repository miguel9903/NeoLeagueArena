package utils;

import javax.swing.JOptionPane;

public class MessageDisplayer {
	
	public static void showInfoMessage(String message) {
		showInfoMessage(message, "Information");
	}

	public static void showInfoMessage(String message, String title) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}

	public static void showSuccessMessage(String message) {
		showSuccessMessage(message, "Success");
	}

	public static void showSuccessMessage(String message, String title) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}

	public static void showErrorMessage(String message) {
		showErrorMessage(message, "Error");
	}

	public static void showErrorMessage(String message, String title) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
	}

	public static void showWarningMessage(String message) {
		showWarningMessage(message, "Warning");
	}

	public static void showWarningMessage(String message, String title) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
	}

	public static boolean showConfirmationMessage(String message) {
		return showConfirmationMessage(message, "Confirmation");
	}

	public static boolean showConfirmationMessage(String message, String title) {
		int option = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		return option == JOptionPane.YES_OPTION;
	}
	
}
