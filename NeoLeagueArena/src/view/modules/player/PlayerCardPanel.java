package view.modules.player;

import javax.swing.*;
import java.awt.*;

import utils.AssetPaths;
import utils.Colors;
import view.shared.BaseCardPanel;

public class PlayerCardPanel extends BaseCardPanel {

	private JLabel iconLabel;
	private JLabel nameLabel;
	private JLabel teamLabel;
	private JButton detailButton;

	@Override
	protected void buildHeader() {
		ImageIcon icon = loadIcon(AssetPaths.USER_ICON, 20, 20);
		iconLabel = new JLabel(icon);

		nameLabel = new JLabel("Player");
		nameLabel.setFont(new Font("Arial", Font.BOLD, 16));

		headerPanel.add(iconLabel);
		headerPanel.add(nameLabel);
	}

	@Override
	protected void buildInfo() {
		teamLabel = new JLabel("Team");
		infoPanel.add(teamLabel);
	}

	@Override
	protected void buildFooter() {
		detailButton = new JButton("View Player");
		detailButton.setForeground(Color.decode(Colors.BLUE_NEON));
		detailButton.setOpaque(false);
		detailButton.setContentAreaFilled(false);
		detailButton.setBorderPainted(false);
		detailButton.setFocusPainted(false);
		detailButton.setFont(new Font("Arial", Font.PLAIN, 12));
		detailButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		footerPanel.add(detailButton);
	}

	public JLabel getIconLabel() {
		return iconLabel;
	}

	public void setIconLabel(JLabel iconLabel) {
		this.iconLabel = iconLabel;
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(JLabel nameLabel) {
		this.nameLabel = nameLabel;
	}

	public JLabel getTeamLabel() {
		return teamLabel;
	}

	public void setTeamLabel(JLabel teamLabel) {
		this.teamLabel = teamLabel;
	}

	public JButton getDetailButton() {
		return detailButton;
	}

	public void setDetailButton(JButton detailButton) {
		this.detailButton = detailButton;
	}
}
