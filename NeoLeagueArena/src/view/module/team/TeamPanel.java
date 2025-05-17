package view.module.team;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import utils.ButtonActionCommands;
import utils.Colors;
import utils.WordingMessages;
import view.shared.CardListPanel;
import model.persistence.dto.TeamDTO; // Asegúrate de importar el DTO correctamente

public class TeamPanel extends JPanel {

	private JPanel teamListPanel;
	private List<TeamCardPanel> teamCards;
	private JLabel emptyMessageLabel;

	public TeamPanel() {
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(10, 10, 10, 10)); 
		initializeCompoenents();
	}

	public void initializeCompoenents() {
		teamCards = new ArrayList<>();
		
		emptyMessageLabel = new JLabel(WordingMessages.EMPTY_TEAM_LIST_MESSAGE);
		emptyMessageLabel.setBorder(new EmptyBorder(20, 20, 20, 20));

		if(teamCards.size() == 0) {
			add(emptyMessageLabel, BorderLayout.NORTH);
		}
	}

	public void renderTeamCards(List<TeamDTO> teamDTOs) {
		if (teamCards.size() == 0) {
			emptyMessageLabel.setText("");
			remove(emptyMessageLabel);	
		}

		int rowCount = teamCards.size() > 3 ? 0 : 3;
		teamListPanel = new JPanel();
		teamListPanel.setLayout(new GridLayout(0,2, 10, 10));
		
		teamCards.clear();      
		List<JPanel> panels = new ArrayList<JPanel>();

		for (TeamDTO currentDTO: teamDTOs) {
			String coachName = currentDTO.getCoachName() != null ? currentDTO.getCoachName() : WordingMessages.NOT_ASIGN_TEAM_COACH;
			String buttonActionCommand = ButtonActionCommands.TEAM_DETAIL + "_" + currentDTO.getId();

			TeamCardPanel card = new TeamCardPanel();
			card.getNameLabel().setText(currentDTO.getName());
			card.getMembersLabel().setText("Members: " + currentDTO.getPlayerIds().size());
			card.getCoachLabel().setText("Coach: " + coachName);
			card.getScoreLabel().setText("Score: " + currentDTO.getScore());
			card.getRankingLabel().setText("Ranking: #" + currentDTO.getRanking());
			card.getDetailButton().setActionCommand(buttonActionCommand);			
			teamCards.add(card);
			teamListPanel.add(card);
			panels.add(card);
		}

		//teamListPanel.setCards(panels);

		JScrollPane scrollPane = new JScrollPane(teamListPanel);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		add(scrollPane, BorderLayout.CENTER);

		add(teamListPanel, BorderLayout.CENTER);
		repaintView();
	}

	public void repaintView() {
		revalidate();
		repaint();  
	}

	// Getters y Setters
	public CardListPanel getTeamListPanel() {
		return teamListPanel;
	}

	public void setTeamListPanel(CardListPanel teamListPanel) {
		this.teamListPanel = teamListPanel;
	}

	public List<TeamCardPanel> getTeamCards() {
		return teamCards;
	}

	public void setTeamCards(List<TeamCardPanel> teamCards) {
		this.teamCards = teamCards;
	}
}
