package view.modules.player;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class PlayerPanel extends JPanel {

	JTabbedPane tabs;
	PlayerFormPanel playerFormPanel;
	PlayerTablePanel playerTablePanel;
	
	public PlayerPanel() {
		initializeComponents();
		setBorder(new EmptyBorder(10, 0, 10, 0)); 
	}
	
	public void initializeComponents() {
		tabs = new JTabbedPane();

        playerFormPanel = new PlayerFormPanel();
        playerFormPanel.setPreferredSize(new Dimension(760, 500));
        playerFormPanel.setBorder(new EmptyBorder(0, 40, 0, 40)); 
        tabs.addTab("Manage", playerFormPanel);

        playerTablePanel = new PlayerTablePanel();
        playerTablePanel.setPreferredSize(new Dimension(760, 500));
        tabs.addTab("List", playerTablePanel);

        add(tabs);
	}

	public JTabbedPane getTabs() {
		return tabs;
	}

	public void setTabs(JTabbedPane tabs) {
		this.tabs = tabs;
	}

	public PlayerFormPanel getPlayerFormPanel() {
		return playerFormPanel;
	}

	public void setPlayerFormPanel(PlayerFormPanel playerFormPanel) {
		this.playerFormPanel = playerFormPanel;
	}

	public PlayerTablePanel getPlayerTablePanel() {
		return playerTablePanel;
	}

	public void setPlayerTablePanel(PlayerTablePanel playerTablePanel) {
		this.playerTablePanel = playerTablePanel;
	}
}
