package view.modules.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import utils.Colors;

public class CredentialsPanel extends JPanel {

	private JLabel emailLabel;
	private JLabel passwordLabel;
	private JTextField emailTextField;
	private JPasswordField passwordField;

	public CredentialsPanel() {
		setLayout(new GridLayout(3, 2, 10, 10));
		setBackground(Color.WHITE);
		
		initializeComponents();
	}
	
	private void initializeComponents() {
		emailLabel = new JLabel("Email:");
		emailLabel.setForeground(Color.BLACK);
		emailLabel.setFont(new Font("Arial", Font.BOLD, 14));
		add(emailLabel);

		emailTextField = new JTextField();
		emailTextField.setBorder(new LineBorder(Color.decode(Colors.DARK_SECONDARY), 2));
		add(emailTextField);

		passwordLabel = new JLabel("Password:");
		passwordLabel.setForeground(Color.BLACK);
		passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
		add(passwordLabel);

		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(Color.decode(Colors.DARK_SECONDARY), 2));
		add(passwordField);
	}

	public JLabel getEmailLabel() {
		return emailLabel;
	}

	public void setEmailLabel(JLabel emailLabel) {
		this.emailLabel = emailLabel;
	}

	public JLabel getPasswordLabel() {
		return passwordLabel;
	}

	public void setPasswordLabel(JLabel passwordLabel) {
		this.passwordLabel = passwordLabel;
	}

	public JTextField getEmailTextField() {
		return emailTextField;
	}

	public void setEmailTextField(JTextField emailTextField) {
		this.emailTextField = emailTextField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

}
