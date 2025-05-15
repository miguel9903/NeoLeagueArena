package view.modules.coach;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import view.modules.player.PlayerTablePanel;

public class CoachPanel extends JPanel {
	
	JTabbedPane tabs;
	CoachFormPanel coachFormPanel;
	CoachTablePanel coachTablePanel;

	public CoachPanel() {
		initializeComponents();
		setBorder(new EmptyBorder(10, 0, 10, 0)); 
	}

	public void initializeComponents() {
		tabs = new JTabbedPane();

		coachFormPanel = new CoachFormPanel();
		coachFormPanel.setPreferredSize(new Dimension(760, 500));
		coachFormPanel.setBorder(new EmptyBorder(0, 40, 0, 40)); 
		tabs.addTab("Manage", coachFormPanel);

		coachTablePanel = new CoachTablePanel();
		coachTablePanel.setPreferredSize(new Dimension(760, 500));
		tabs.addTab("List", coachTablePanel);

		add(tabs);
	}


	
}
