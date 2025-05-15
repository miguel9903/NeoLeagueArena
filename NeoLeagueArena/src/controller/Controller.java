package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import utils.MessageDisplayer;
import utils.ViewNames;
import view.View;
import view.module.team.TeamCardPanel;
import view.module.tournament.TournamentCardPanel;
import view.modules.player.PlayerCardPanel;

public class Controller implements ActionListener {

	private View view;

	public Controller() {
		view = new View();
		assignListeners();
	}

	public void assignListeners() {
		// Sidebar Panel
		view.getMainWindow().getSidebarPanel().getHomeButton().addActionListener(this);
		view.getMainWindow().getSidebarPanel().getTournamentsButton().addActionListener(this);
		view.getMainWindow().getSidebarPanel().getTeamsButton().addActionListener(this);
		view.getMainWindow().getSidebarPanel().getPlayersButton().addActionListener(this);
		view.getMainWindow().getSidebarPanel().getCoachesButton().addActionListener(this);
		view.getMainWindow().getSidebarPanel().getAdminsButton().addActionListener(this);
		view.getMainWindow().getSidebarPanel().getMatchesButton().addActionListener(this);
		view.getMainWindow().getSidebarPanel().getGamesButton().addActionListener(this);
		view.getMainWindow().getSidebarPanel().getReportsButton().addActionListener(this);
		view.getMainWindow().getSidebarPanel().getSettingsButton().addActionListener(this);

		// Tournaments Panel
		assignTournamentListListeners();
		
		// Teams Panel
		assignTeamsListListeners();
		assignTeamDetailListeners();
	}

	public void assignTournamentListListeners() {
		List<TournamentCardPanel> tournamentCards = view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getTournamentPanel().getTournamentCards();

		for (int i = 0; i < tournamentCards.size(); i++) {
			TournamentCardPanel card = tournamentCards.get(i);
			String actionCommand = "TOURNAMENT_" + i;
			card.getDetailButton().setActionCommand(actionCommand);
			card.getDetailButton().addActionListener(this);
		}
	}
	
	
	
	public void assignTeamsListListeners() {
	    List<TeamCardPanel> teamCards = view.getMainWindow().getMainContentPanel()
	            .getLayoutContentPanel().getTeamsPanel().getTeamCards(); 

	    for (int i = 0; i < teamCards.size(); i++) {
	        TeamCardPanel card = teamCards.get(i);
	        String actionCommand = "TEAM_" + i;
	        card.getDetailButton().setActionCommand(actionCommand);
	        card.getDetailButton().addActionListener(this);
	    }
	}
	
	public void assignTeamDetailListeners() {
	    List<PlayerCardPanel> playerCards = view.getMainWindow().getMainContentPanel()
	            .getLayoutContentPanel().getTeamDetailPanel().getPlayerCards();

	    for (int i = 0; i < playerCards.size(); i++) {
	    	PlayerCardPanel card = playerCards.get(i);
	        String actionCommand = "PLAYER_" + i;
	        card.getDetailButton().setActionCommand(actionCommand);
	        card.getDetailButton().addActionListener(this);
	    }
	}
	
	public void run() {
		view.getMainWindow().setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		handleSidebarEvents(command);
		handleTournamentsEvents(command);
		handleTeamsEvents(command);
		handlePlayersEvents(command);
	}

	public void handleSidebarEvents(String command) {
		if (command.equals(ViewNames.HOME_VIEW)) {
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.HOME_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.HOME_VIEW);
			view.getMainWindow().getSidebarPanel().resetAllButtonStyles();
			view.getMainWindow().getSidebarPanel().applyHighlightStyle(view.getMainWindow().getSidebarPanel().getHomeButton());
		} else if (command.equals(ViewNames.TOURNAMENT_VIEW)) {
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.TOURNAMENT_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.TOURNAMENT_VIEW);
			view.getMainWindow().getSidebarPanel().resetAllButtonStyles();
			view.getMainWindow().getSidebarPanel().applyHighlightStyle(view.getMainWindow().getSidebarPanel().getTournamentsButton());
		} else if (command.equals(ViewNames.TEAM_VIEW)) {
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.TEAM_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.TEAM_VIEW);
			view.getMainWindow().getSidebarPanel().resetAllButtonStyles();
			view.getMainWindow().getSidebarPanel().applyHighlightStyle(view.getMainWindow().getSidebarPanel().getTeamsButton());
		} else if (command.equals(ViewNames.PLAYER_VIEW)) {
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.PLAYER_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.PLAYER_VIEW);
			view.getMainWindow().getSidebarPanel().resetAllButtonStyles();
			view.getMainWindow().getSidebarPanel().applyHighlightStyle(view.getMainWindow().getSidebarPanel().getPlayersButton());
		} else if (command.equals(ViewNames.COACH_VIEW)) {
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.COACH_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.COACH_VIEW);
			view.getMainWindow().getSidebarPanel().resetAllButtonStyles();
			view.getMainWindow().getSidebarPanel().applyHighlightStyle(view.getMainWindow().getSidebarPanel().getCoachesButton());
		} else if (command.equals(ViewNames.ADMIN_VIEW)) {
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.ADMIN_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.ADMIN_VIEW);
			view.getMainWindow().getSidebarPanel().resetAllButtonStyles();
			view.getMainWindow().getSidebarPanel().applyHighlightStyle(view.getMainWindow().getSidebarPanel().getAdminsButton());
		} else if (command.equals(ViewNames.MATCH_VIEW)) {
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.MATCH_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.MATCH_VIEW);
			view.getMainWindow().getSidebarPanel().resetAllButtonStyles();
			view.getMainWindow().getSidebarPanel().applyHighlightStyle(view.getMainWindow().getSidebarPanel().getMatchesButton());
		} else if (command.equals(ViewNames.GAME_VIEW)) {
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.GAME_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.GAME_VIEW);
			view.getMainWindow().getSidebarPanel().resetAllButtonStyles();
			view.getMainWindow().getSidebarPanel().applyHighlightStyle(view.getMainWindow().getSidebarPanel().getGamesButton());
		} else if (command.equals(ViewNames.REPORT_VIEW)) {
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.REPORT_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.REPORT_VIEW);
			view.getMainWindow().getSidebarPanel().resetAllButtonStyles();
			view.getMainWindow().getSidebarPanel().applyHighlightStyle(view.getMainWindow().getSidebarPanel().getReportsButton());
		} else if (command.equals(ViewNames.SETTINGS_VIEW)) {
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.SETTINGS_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.SETTINGS_VIEW);
			view.getMainWindow().getSidebarPanel().resetAllButtonStyles();
			view.getMainWindow().getSidebarPanel().applyHighlightStyle(view.getMainWindow().getSidebarPanel().getSettingsButton());
		}
	}

	public void handleTournamentsEvents(String command) {
		if (command.startsWith("TOURNAMENT_")) {
			int tournamentId = Integer.parseInt(command.split("_")[1]) + 1;
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.TOURNAMENT_DETAIL_VIEW);
	        view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.TOURNAMENT_DETAIL_VIEW);
			System.out.print("DETAIL TOURNAMENT " + tournamentId);
		}
	}
	
	public void handleTeamsEvents(String command) {
	    if (command.startsWith("TEAM_")) {
	        int teamId = Integer.parseInt(command.split("_")[1]) + 1;  
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.TEAM_DETAIL_VIEW);
	        view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.TEAM_DETAIL_VIEW);
	        System.out.println("DETAIL TEAM " + teamId); 
	    }
	}
	
	public void handlePlayersEvents(String command) {
	    if (command.startsWith("PLAYER_")) {
	        int playerId = Integer.parseInt(command.split("_")[1]) + 1;  
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.PLAYER_DETAIL_VIEW);
	        view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.PLAYER_DETAIL_VIEW);
	        System.out.println("DETAIL TEAM " + playerId); 
	    }
	}

}
