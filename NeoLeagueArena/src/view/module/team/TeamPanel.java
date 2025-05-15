package view.module.team;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import utils.Colors;
import view.shared.CardListPanel;

public class TeamPanel extends JPanel {

    private CardListPanel teamListPanel;
    private List<TeamCardPanel> teamCards;

    public TeamPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.decode(Colors.LIGHT_GRAY));
        initializeComponents();
    }

    public void initializeComponents() {
        teamCards = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            TeamCardPanel card = new TeamCardPanel();
            card.initializeComponents();
            card.getNameLabel().setText("Team #" + (i + 1)); 
            card.getMembersLabel().setText("Members: " + (i + 1) * 5); 
            card.getCoachLabel().setText("Coach: Coach #" + (i + 1));
            teamCards.add(card);
        }

        teamListPanel = new CardListPanel(teamCards.toArray(new JPanel[0]));
        teamListPanel.setBackground(Color.decode(Colors.LIGHT_GRAY));

        JScrollPane scrollPane = new JScrollPane(teamListPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);
    }

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
