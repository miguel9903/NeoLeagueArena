package view.module.tournament;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import utils.Colors;
import view.module.team.TeamFormPanel;
import view.module.team.TeamPlayerAssignmentPanel;

public class TournamentManagementPanel extends JPanel {

    private JTabbedPane tabs;
    private TeamFormPanel teamFormPanel;
    private TeamPlayerAssignmentPanel teamPlayerAssignmentPanel;
    private TournamentTablePanel tournamentTablePanel;
    
    public TournamentManagementPanel() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setBackground(Color.decode(Colors.LIGHT_GRAY));
        initializeComponents();
    }

    private void initializeComponents() {
        tabs = new JTabbedPane();

        teamFormPanel = new TeamFormPanel();
        teamFormPanel.setPreferredSize(new Dimension(550, 500));
        tabs.addTab("Manage Teams", teamFormPanel);

        teamPlayerAssignmentPanel = new TeamPlayerAssignmentPanel();
        teamPlayerAssignmentPanel.setPreferredSize(new Dimension(500, 500));
        tabs.addTab("Assign Players", teamPlayerAssignmentPanel);
        
        tournamentTablePanel = new TournamentTablePanel();
        tournamentTablePanel.setPreferredSize(new Dimension(500, 500));
        tabs.addTab("List Tournaments", tournamentTablePanel);
        
        add(tabs);
    }

	public JTabbedPane getTabs() {
		return tabs;
	}

	public void setTabs(JTabbedPane tabs) {
		this.tabs = tabs;
	}

	public TeamFormPanel getTeamFormPanel() {
		return teamFormPanel;
	}

	public void setTeamFormPanel(TeamFormPanel teamFormPanel) {
		this.teamFormPanel = teamFormPanel;
	}

	public TeamPlayerAssignmentPanel getTeamPlayerAssignmentPanel() {
		return teamPlayerAssignmentPanel;
	}

	public void setTeamPlayerAssignmentPanel(TeamPlayerAssignmentPanel teamPlayerAssignmentPanel) {
		this.teamPlayerAssignmentPanel = teamPlayerAssignmentPanel;
	}

	public TournamentTablePanel getTournamentTablePanel() {
		return tournamentTablePanel;
	}

	public void setTournamentTablePanel(TournamentTablePanel tournamentTablePanel) {
		this.tournamentTablePanel = tournamentTablePanel;
	}
	
}
