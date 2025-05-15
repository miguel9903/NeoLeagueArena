package view.shared;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class CardListPanel extends JPanel {

	public CardListPanel(JPanel... cards) {
		setLayout(new GridLayout(0, 3, 20, 20));
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		initializeComponents(cards);
	}

	public void initializeComponents(JPanel... cards) {
		for (JPanel card : cards) {
			add(card);
		}
	}

}
