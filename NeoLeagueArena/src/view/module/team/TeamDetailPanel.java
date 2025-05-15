package view.module.team;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import utils.AssetPaths;
import utils.Colors;
import view.modules.player.PlayerCardPanel;
import view.shared.CardListPanel;
 
public class TeamDetailPanel extends JPanel {
	
	private JPanel logoPanel;
	private JPanel infoPanel;
    private JLabel logoLabel;
    private JLabel nameLabel;
    private JTextArea descriptionTextArea;
    private JLabel coachLabel;
    private JLabel membersLabel;
    private JLabel playersLabel;
    private CardListPanel playerListPanel;
    private List<PlayerCardPanel> playerCards;
 
    public TeamDetailPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.decode(Colors.LIGHT_GRAY));  
        setBorder(new EmptyBorder(20, 20, 20, 20));
        
        initializeComponents();
    }

    private void initializeComponents() {
    	logoPanel = new JPanel();
    	
        ImageIcon teamIcon = loadIcon(AssetPaths.TEAM_ICON, 80, 80);
        logoLabel = new JLabel(teamIcon);
        logoPanel.add(logoLabel);
        
        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        JPanel nameLabelPanel = new JPanel();
        nameLabelPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        nameLabelPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        nameLabel = new JLabel("Team Name");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        nameLabelPanel.add(nameLabel);
        infoPanel.add(nameLabelPanel);
       
        JPanel coachLabelPanel = new JPanel();
        coachLabelPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        coachLabel = new JLabel("Coach: Ned Flanders");
        coachLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        coachLabelPanel.add(coachLabel);
        infoPanel.add(coachLabelPanel); 
        
        JPanel membersLabelPanel = new JPanel();
        membersLabelPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        membersLabel = new JLabel("Members: 5");
        membersLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        membersLabelPanel.add(membersLabel);
        infoPanel.add(membersLabelPanel); 
                
        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        descriptionPanel.setBorder(new EmptyBorder(10, 0, 5, 0));
        playersLabel = new JLabel("Description");
        playersLabel.setFont(new Font("Arial", Font.BOLD, 16));
        descriptionPanel.add(playersLabel);
        infoPanel.add(descriptionPanel);
        
        descriptionTextArea = new JTextArea();
        descriptionTextArea.setText("Phoenix Esports es un equipo profesional de eSports fundado en 2020, especializado en competiciones de Rocket League. El equipo ha crecido rápidamente en la escena, destacándose por su jugabilidad estratégica y habilidades excepcionales en el campo. Han logrado numerosas victorias en campeonatos nacionales e internacionales y están comprometidos con el crecimiento de sus jugadores a través de entrenamientos rigurosos y trabajo en equipo. Phoenix Esports es conocido por su ética de trabajo, resiliencia, y pasión por el juego.");
        descriptionTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        descriptionTextArea.setWrapStyleWord(true); 
        descriptionTextArea.setLineWrap(true); 
        descriptionTextArea.setOpaque(false);  
        descriptionTextArea.setEditable(false);  
        
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionTextArea);
        descriptionScrollPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        infoPanel.add(descriptionScrollPane);
        
        JPanel playerLabelPanel = new JPanel();
        playerLabelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        playerLabelPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
        playersLabel = new JLabel("Players");
        playersLabel.setFont(new Font("Arial", Font.BOLD, 16));
        playerLabelPanel.add(playersLabel);
        infoPanel.add(playerLabelPanel);
        
        playerCards = new ArrayList<>();
        
        for (int i = 0; i < 5; i++) {
            PlayerCardPanel card = new PlayerCardPanel();
            card.initializeComponents();
            card.getNameLabel().setText("Player #" + (i + 1)); 
            card.getTeamLabel().setText("Team: Rocket"); 
            playerCards.add(card);
        }

        playerListPanel = new CardListPanel(playerCards.toArray(new JPanel[0]));

        JScrollPane scrollPane = new JScrollPane(playerListPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        infoPanel.add(scrollPane);

        add(logoPanel, BorderLayout.NORTH);
        add(infoPanel, BorderLayout.CENTER);
    }
    
	public ImageIcon loadIcon(String imagePath, int width, int height) {
		ImageIcon icon = new ImageIcon(imagePath);
		Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(scaledImage);
	}

    public void displayTeamDetails() {
    	// TODO: Display team details
    }
	
	public JPanel getLogoPanel() {
		return logoPanel;
	}

	public void setLogoPanel(JPanel logoPanel) {
		this.logoPanel = logoPanel;
	}

	public JPanel getInfoPanel() {
		return infoPanel;
	}

	public void setInfoPanel(JPanel infoPanel) {
		this.infoPanel = infoPanel;
	}

	public JLabel getLogoLabel() {
		return logoLabel;
	}

	public void setLogoLabel(JLabel logoLabel) {
		this.logoLabel = logoLabel;
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(JLabel nameLabel) {
		this.nameLabel = nameLabel;
	}

	public JTextArea getDescriptionTextArea() {
		return descriptionTextArea;
	}

	public void setDescriptionTextArea(JTextArea descriptionTextArea) {
		this.descriptionTextArea = descriptionTextArea;
	}

	public JLabel getCoachLabel() {
		return coachLabel;
	}

	public void setCoachLabel(JLabel coachLabel) {
		this.coachLabel = coachLabel;
	}

	public JLabel getMembersLabel() {
		return membersLabel;
	}

	public void setMembersLabel(JLabel membersLabel) {
		this.membersLabel = membersLabel;
	}

	public JLabel getPlayersLabel() {
		return playersLabel;
	}

	public void setPlayersLabel(JLabel playersLabel) {
		this.playersLabel = playersLabel;
	}

	public CardListPanel getPlayerListPanel() {
		return playerListPanel;
	}

	public void setPlayerListPanel(CardListPanel playerListPanel) {
		this.playerListPanel = playerListPanel;
	}

	public List<PlayerCardPanel> getPlayerCards() {
		return playerCards;
	}

	public void setPlayerCards(List<PlayerCardPanel> playerCards) {
		this.playerCards = playerCards;
	}
}
