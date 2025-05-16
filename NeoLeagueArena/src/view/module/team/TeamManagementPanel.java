package view.module.team;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import utils.Colors;

public class TeamManagementPanel extends JPanel {

    private JTabbedPane tabs;
    private TeamFormPanel teamFormPanel;
    private TeamPlayerAssignmentPanel teamPlayerAssignmentPanel;
    
    public TeamManagementPanel() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setBackground(Color.decode(Colors.LIGHT_GRAY));
        initializeComponents();
    }

    private void initializeComponents() {
        tabs = new JTabbedPane();

        teamFormPanel = new TeamFormPanel();
        teamFormPanel.setPreferredSize(new Dimension(550, 500));
        teamFormPanel.setBackground(Color.red);
        tabs.addTab("Manage Teams", teamFormPanel);

        teamPlayerAssignmentPanel = new TeamPlayerAssignmentPanel();
        teamPlayerAssignmentPanel.setPreferredSize(new Dimension(500, 500));
        teamPlayerAssignmentPanel.setBackground(Color.red);
        tabs.addTab("Assign Players", teamPlayerAssignmentPanel);
        
        add(tabs);
    }
	
}
