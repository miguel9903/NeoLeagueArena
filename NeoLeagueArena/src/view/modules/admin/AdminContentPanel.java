package view.modules.admin;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import utils.ViewNames;
import view.module.team.TeamManagementPanel;

public class AdminContentPanel extends JPanel {

	private CardLayout cardLayout;
	private TeamManagementPanel teamManagementPanel;

	public AdminContentPanel() {
		cardLayout = new CardLayout();
		setLayout(cardLayout);
		initializeComponents(); 
	}
	
	public void initializeComponents() {
		teamManagementPanel = new TeamManagementPanel();		
		add(teamManagementPanel, ViewNames.ADMIN_TEAM_VIEW);
	}

	public void showView(String viewName) {
		cardLayout.show(this, viewName);
	}
}
