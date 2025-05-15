package view.module.tournament;

import javax.swing.*;
import java.awt.*;

import utils.AssetPaths;
import utils.Colors;
import view.shared.BaseCardPanel;

public class TournamentCardPanel extends BaseCardPanel {

	private JLabel iconLabel;
	private JLabel nameLabel;
	private JLabel gameLabel;
	private JLabel stageLabel;
	private JButton detailButton;

	@Override
	protected void buildHeader() {
		ImageIcon icon = loadIcon(AssetPaths.TOURNAMENT_ICON, 20, 20);
		iconLabel = new JLabel(icon);

		nameLabel = new JLabel("Torneo de Rocket League");
		nameLabel.setFont(new Font("Arial", Font.BOLD, 16));

		headerPanel.add(iconLabel);
		headerPanel.add(nameLabel);
	}

	@Override
	protected void buildInfo() {
		gameLabel = new JLabel("Game: Rocket League");
		stageLabel = new JLabel("Current Stage: Fase de Grupos");

		infoPanel.add(gameLabel);
		infoPanel.add(stageLabel);
	}

	@Override
	protected void buildFooter() {
		detailButton = new JButton("View Detail");
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

	public JLabel getGameLabel() {
		return gameLabel;
	}

	public void setGameLabel(JLabel gameLabel) {
		this.gameLabel = gameLabel;
	}

	public JLabel getStageLabel() {
		return stageLabel;
	}

	public void setStageLabel(JLabel stageLabel) {
		this.stageLabel = stageLabel;
	}

	public JButton getDetailButton() {
		return detailButton;
	}

	public void setDetailButton(JButton detailButton) {
		this.detailButton = detailButton;
	}
}
