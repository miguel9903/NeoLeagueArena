package view.module.team;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Colors;
import view.shared.FormFooterPanel;
import view.shared.FormHeaderPanel;

public class TeamPlayerAssignmentPanel extends JPanel {

	private FormHeaderPanel formHeaderPanel;
	private FormFooterPanel formFooterPanel;

	private JPanel playersPanel;
	private JLabel teamLabel;
	private JComboBox<String> teamComboBox;
	private JLabel playerLabel;
	private JComboBox<String> playerComboBox;
	private JButton addPlayerButton;

	public TeamPlayerAssignmentPanel() {
		setLayout(new BorderLayout());
		initializeComponents();
		setupFormControls();	
	}

	private void initializeComponents() {
		formHeaderPanel = new FormHeaderPanel();
		formHeaderPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
		
		formFooterPanel = new FormFooterPanel();
		formFooterPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
		formFooterPanel.setBackground(Color.decode(Colors.MEDIUM_GRAY));

		playersPanel = new JPanel();
		playersPanel.setLayout(new GridLayout(6, 2, 10, 10)); 
		playersPanel.setBorder(new EmptyBorder(20, 20, 120, 20));

		teamLabel = new JLabel("Team:");
		teamComboBox = new JComboBox<>();
		teamComboBox.addItem("Team Alpha");
		teamComboBox.addItem("Team Beta");

		playerLabel = new JLabel("Player:");
		playerComboBox = new JComboBox<>();
		playerComboBox.addItem("Juan Pérez");
		playerComboBox.addItem("María Gómez");
		playerComboBox.addItem("Carlos López");
		playerComboBox.addItem("Ana Torres");

		addPlayerButton = new JButton("ADD PLAYER");
		addPlayerButton.setActionCommand("ADD_PLAYER");

		JLabel EMPTY_LABEL = new JLabel("");
		playersPanel.add(teamLabel);
		playersPanel.add(teamComboBox);
		playersPanel.add(playerLabel);
		playersPanel.add(playerComboBox);
		playersPanel.add(EMPTY_LABEL);
		playersPanel.add(EMPTY_LABEL);
		playersPanel.add(EMPTY_LABEL);
		playersPanel.add(EMPTY_LABEL);
		playersPanel.add(EMPTY_LABEL);
		playersPanel.add(EMPTY_LABEL);
		playersPanel.add(EMPTY_LABEL);
		playersPanel.add(EMPTY_LABEL);

		add(formHeaderPanel, BorderLayout.NORTH);
		add(playersPanel, BorderLayout.CENTER);
		add(formFooterPanel, BorderLayout.SOUTH);
	}

	public void setupFormControls() {
		formHeaderPanel.getFormTitleLabel().setText("Add Players");
		formFooterPanel.setPrimaryButtonText("ADD PLAYER");
		formFooterPanel.setPrimaryButtonActionCommand("ADD_PLAYER");
		formFooterPanel.removeSecondaryButton();
		formFooterPanel.removeTertiaryButton();
	}
}
