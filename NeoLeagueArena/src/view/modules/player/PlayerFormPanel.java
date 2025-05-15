package view.modules.player;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.shared.FormFooterPanel;
import view.shared.FormHeaderPanel;

import java.awt.BorderLayout;

public class PlayerFormPanel extends JPanel {

	FormHeaderPanel formHeaderPanel;
	PlayerFormFieldsPanel playerFormFieldsPanel;
	FormFooterPanel formFooterPanel;

	public PlayerFormPanel() {
		setLayout(new BorderLayout()); 
		initializeComponents(); 
		setupFormControls();
	}

	private void initializeComponents() { 
		formHeaderPanel = new FormHeaderPanel();
		formHeaderPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

		playerFormFieldsPanel = new PlayerFormFieldsPanel();
		playerFormFieldsPanel.setBorder(new EmptyBorder(20, 20, 20, 20)); 

		formFooterPanel = new FormFooterPanel();
		formFooterPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

		add(formHeaderPanel, BorderLayout.NORTH); 
		add(playerFormFieldsPanel, BorderLayout.CENTER);
		add(formFooterPanel, BorderLayout.SOUTH); 
	}

	public void setupFormControls() {
		formHeaderPanel.getFormTitleLabel().setText("Manage Players");
		formFooterPanel.setPrimaryButtonText("CREATE");
		formFooterPanel.setPrimaryButtonActionCommand("CREATE_PLAYER");
		
		formFooterPanel.setSecondaryButtonText("UPDATE");
		formFooterPanel.setSecondaryButtonActionCommand("UPDATE_PLAYER");
		
		formFooterPanel.setTertiaryButtonText("CANCEL");
		formFooterPanel.setTertiaryButtonActionCommand("CANCEL_CREATE_PLAYER");
	}
	
	public FormHeaderPanel getFormHeaderPanel() {
		return formHeaderPanel;
	}

	public void setFormHeaderPanel(FormHeaderPanel formHeaderPanel) {
		this.formHeaderPanel = formHeaderPanel;
	}

	public PlayerFormFieldsPanel getPlayerFormFieldsPanel() {
		return playerFormFieldsPanel;
	}

	public void setPlayerFormFieldsPanel(PlayerFormFieldsPanel playerFormFieldsPanel) {
		this.playerFormFieldsPanel = playerFormFieldsPanel;
	}

	public FormFooterPanel getFormFooterPanel() {
		return formFooterPanel;
	}

	public void setFormFooterPanel(FormFooterPanel formFooterPanel) {
		this.formFooterPanel = formFooterPanel;
	}

}
