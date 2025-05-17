package view.module.tournament;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import utils.Colors;
import view.shared.CardListPanel;

public class TournamentPanel extends JPanel {

    private CardListPanel tournamentListPanel;
    private List<TournamentCardPanel> tournamentCards;

    public TournamentPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.decode(Colors.LIGHT_GRAY));
        initializeComponents();
    }

    public void initializeComponents() {
        tournamentCards = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            TournamentCardPanel card = new TournamentCardPanel();
            card.initializeComponents();
            card.getNameLabel().setText("Torneo #" + (i + 1));
            card.getGameLabel().setText("Game: Rocket League");
            card.getStageLabel().setText("Stage: Grupos");
            tournamentCards.add(card);
        }

        tournamentListPanel = new CardListPanel(3, 3);
        tournamentListPanel.setBackground(Color.decode(Colors.LIGHT_GRAY));

        JScrollPane scrollPane = new JScrollPane(tournamentListPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        add(scrollPane, BorderLayout.CENTER);
    }

	public CardListPanel getTournamentListPanel() {
		return tournamentListPanel;
	}

	public void setTournamentListPanel(CardListPanel tournamentListPanel) {
		this.tournamentListPanel = tournamentListPanel;
	}

	public List<TournamentCardPanel> getTournamentCards() {
		return tournamentCards;
	}

	public void setTournamentCards(List<TournamentCardPanel> tournamentCards) {
		this.tournamentCards = tournamentCards;
	}	
}
