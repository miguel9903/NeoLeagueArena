package view.module.team;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.ButtonActionCommands;
import utils.Colors;
import view.shared.FormFooterPanel;
import view.shared.FormHeaderPanel;

import java.awt.BorderLayout;
import java.awt.Color;

public class TeamFormPanel extends JPanel {

	private FormHeaderPanel formHeaderPanel;
	private TeamFormFieldsPanel teamFormFieldsPanel;
	private FormFooterPanel formFooterPanel;

	public TeamFormPanel() {
		setLayout(new BorderLayout()); 
		initializeComponents(); 
		setupFormControls();
	}

	private void initializeComponents() { 
		formHeaderPanel = new FormHeaderPanel();
		formHeaderPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

		teamFormFieldsPanel = new TeamFormFieldsPanel();
		teamFormFieldsPanel.setBorder(new EmptyBorder(0, 20, 0, 20)); 

		formFooterPanel = new FormFooterPanel();
		formFooterPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
		formFooterPanel.setBackground(Color.decode(Colors.MEDIUM_GRAY));

		add(formHeaderPanel, BorderLayout.NORTH); 
		add(teamFormFieldsPanel, BorderLayout.CENTER);
		add(formFooterPanel, BorderLayout.SOUTH); 
	}

	public void setupFormControls() {
		formHeaderPanel.getFormTitleLabel().setText("Manage Teams");
		formFooterPanel.setPrimaryButtonText("CREATE");
		formFooterPanel.setPrimaryButtonActionCommand(ButtonActionCommands.ADMIN_CREATE_TEAM);
		
		formFooterPanel.setSecondaryButtonText("UPDATE");
		formFooterPanel.setSecondaryButtonActionCommand(ButtonActionCommands.ADMIN_UPDATE_TEAM);
		
		formFooterPanel.setTertiaryButtonText("CANCEL");
		formFooterPanel.setTertiaryButtonActionCommand(ButtonActionCommands.ADMIN_DELETE_TEAM);
	}

	public FormHeaderPanel getFormHeaderPanel() {
		return formHeaderPanel;
	}

	public void setFormHeaderPanel(FormHeaderPanel formHeaderPanel) {
		this.formHeaderPanel = formHeaderPanel;
	}

	public TeamFormFieldsPanel getTeamFormFieldsPanel() {
		return teamFormFieldsPanel;
	}

	public void setTeamFormFieldsPanel(TeamFormFieldsPanel teamFormFieldsPanel) {
		this.teamFormFieldsPanel = teamFormFieldsPanel;
	}

	public FormFooterPanel getFormFooterPanel() {
		return formFooterPanel;
	}

	public void setFormFooterPanel(FormFooterPanel formFooterPanel) {
		this.formFooterPanel = formFooterPanel;
	}

	
}
