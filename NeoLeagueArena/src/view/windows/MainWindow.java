package view.windows;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import view.modules.layout.MainContentPanel;
import view.modules.navigation.SidebarPanel;

public class MainWindow extends JFrame {

	private SidebarPanel sidebarPanel;
	private MainContentPanel mainContentPanel;

	public MainWindow() {
		setTitle("NeoLeague Arena");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 660);
		setResizable(false);
		setLocationRelativeTo(null);

		initializeComponents();
		setVisible(false);
	}

	private void initializeComponents() {
		sidebarPanel = new SidebarPanel();
		mainContentPanel = new MainContentPanel();

		add(sidebarPanel, BorderLayout.WEST);
		add(mainContentPanel, BorderLayout.CENTER);
	}

	public SidebarPanel getSidebarPanel() {
		return sidebarPanel;
	}

	public MainContentPanel getMainContentPanel() {
		return mainContentPanel;
	}
}
