package view.modules.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import utils.AssetPaths;
import utils.Colors;

public class LoginWindow extends JFrame {

	private CredentialsPanel credentialsPanel;
	private JLabel logoLabel;
	private JPanel buttonsPanel;
	private JPanel logoPanel;
	private JButton loginButton;
	private JButton cancelButton;

	public LoginWindow() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		initializeComponents();
		setVisible(true);
	}


	public void initializeComponents() {
		ImageIcon logo = loadIcon(AssetPaths.DARK_LOGO, 180, 40);
		logoLabel = new JLabel(logo);
		logoLabel.setHorizontalAlignment(SwingConstants.CENTER);

		logoPanel = new JPanel(new GridBagLayout());
		logoPanel.setPreferredSize(new Dimension(600, 200));
		logoPanel.setBackground(Color.decode(Colors.DARK_SECONDARY));
		logoPanel.add(logoLabel);

		credentialsPanel = new CredentialsPanel();
		credentialsPanel.setPreferredSize(new Dimension(600, 300));
		credentialsPanel.setBorder(new EmptyBorder(20, 100, 0, 100)); 

		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); 
		buttonsPanel.setBorder(new EmptyBorder(20, 40, 20, 40)); 

		loginButton = new JButton("Login");
		loginButton.setActionCommand("BOTON_LOGIN_INGRESAR");
		buttonsPanel.add(loginButton);

		cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("BOTON_LOGIN_CANCELAR");
		buttonsPanel.add(cancelButton);

		add(logoPanel, BorderLayout.NORTH);
		add(credentialsPanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);
	}

	private ImageIcon loadIcon(String imagePath, int width, int height) {
		ImageIcon icon = new ImageIcon(imagePath);
		Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(scaledImage);
	}

	public CredentialsPanel getCredentialsPanel() {
		return credentialsPanel;
	}

	public void setCredentialsPanel(CredentialsPanel credentialsPanel) {
		this.credentialsPanel = credentialsPanel;
	}

	public JLabel getLogoLabel() {
		return logoLabel;
	}

	public void setLogoLabel(JLabel logoLabel) {
		this.logoLabel = logoLabel;
	}

	public JPanel getButtonsPanel() {
		return buttonsPanel;
	}

	public void setButtonsPanel(JPanel buttonsPanel) {
		this.buttonsPanel = buttonsPanel;
	}

	public JPanel getLogoPanel() {
		return logoPanel;
	}

	public void setLogoPanel(JPanel logoPanel) {
		this.logoPanel = logoPanel;
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(JButton loginButton) {
		this.loginButton = loginButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

}
