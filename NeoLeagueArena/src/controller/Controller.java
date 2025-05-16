package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import utils.ButtonActionCommands;
import utils.MessageDisplayer;
import utils.ViewNames;
import view.View;
import view.module.team.TeamCardPanel;
import view.module.tournament.TournamentCardPanel;
import view.modules.admin.AdminNavBarPanel;
import view.modules.navigation.SideBarPanel;
import view.modules.player.PlayerCardPanel;

public class Controller implements ActionListener {

	private View view;

	public Controller() {
		view = new View();
		assignListeners();
	}

	public void run() {
		view.getLoginWindow().setVisible(true);
	}

	public void assignListeners() {
		// Login
		assigLoginListeners();

		// Register
		assignRegisterListeners();

		// Sidebar Panel
		assignSideBarListeners();

		// Admin Panel
		assignAdminNavBarListeners();


		// Tournaments Panel
		assignTournamentListListeners();

		// Teams Panel
		assignTeamsListListeners();
		assignTeamDetailListeners();
	}

	public void assigLoginListeners() {
		view.getLoginWindow().getLoginButton().addActionListener(this);
		view.getLoginWindow().getRegisterButton().addActionListener(this);
	}

	public void assignRegisterListeners() {
		view.getRegisterWindow().getRegisterButton().addActionListener(this);
		view.getRegisterWindow().getCancelButton().addActionListener(this);
	}

	public void assignSideBarListeners() {
		view.getMainWindow().getSideBarPanel().getHomeButton().addActionListener(this);
		view.getMainWindow().getSideBarPanel().getTournamentsButton().addActionListener(this);
		view.getMainWindow().getSideBarPanel().getTeamsButton().addActionListener(this);
		view.getMainWindow().getSideBarPanel().getPlayersButton().addActionListener(this);
		view.getMainWindow().getSideBarPanel().getCoachesButton().addActionListener(this);
		view.getMainWindow().getSideBarPanel().getAdminsButton().addActionListener(this);
		view.getMainWindow().getSideBarPanel().getMatchesButton().addActionListener(this);
		view.getMainWindow().getSideBarPanel().getGamesButton().addActionListener(this);
		view.getMainWindow().getSideBarPanel().getReportsButton().addActionListener(this);
		view.getMainWindow().getSideBarPanel().getSettingsButton().addActionListener(this);
	}

	public void assignAdminNavBarListeners() {
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminNavBarPanel().getTournamentsButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminNavBarPanel().getTeamsButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminNavBarPanel().getPlayersButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminNavBarPanel().getCoachesButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminNavBarPanel().getAdministratorsButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminNavBarPanel().getMatchesButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminNavBarPanel().getGamesButton().addActionListener(this);
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


	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		handleLoginCommand(command);
		handleSignUpCommand(command);
		handleSidebarCommand(command);
		handleTournamentCommand(command);
		handleTeamCommand(command);
		handlePlayerCommand(command);
		handleAdminCommand(command);	
	}

	public void handleLoginCommand(String command) {
		if (command.equals(ButtonActionCommands.LOGIN_ACTION_COMMAND)) {
			String email = view.getLoginWindow().getCredentialsPanel().getEmailTextField().getText().trim();
			String password = new String(view.getLoginWindow().getCredentialsPanel().getPasswordTextField().getPassword()).trim();
			
			// Setear nombre user
			view.getLoginWindow().dispose();
			view.getMainWindow().setVisible(true);
			
		} else if(command.equals(ButtonActionCommands.LOGIN_REGISTER_ACTION_COMMAND)) {
			view.getLoginWindow().dispose();
			view.getRegisterWindow().setVisible(true);
		}
	}

	public void handleSignUpCommand(String command) {
		if (command.equals(ButtonActionCommands.REGISTER_ACTION_COMMAND)) {
			String id = view.getRegisterWindow().getRegisterFieldsPanel().getIdTextField().getText().trim();
			String firstName = view.getRegisterWindow().getRegisterFieldsPanel().getFirstNameTextField().getText().trim();
			String lastName = view.getRegisterWindow().getRegisterFieldsPanel().getLastNameTextField().getText().trim();
			String email = view.getRegisterWindow().getRegisterFieldsPanel().getEmailTextField().getText().trim();
			String password = new String(view.getRegisterWindow().getRegisterFieldsPanel().getPasswordTextField().getPassword());
			String country = view.getRegisterWindow().getRegisterFieldsPanel().getCountryTextField().getText().trim();
			String city = view.getRegisterWindow().getRegisterFieldsPanel().getCityTextField().getText().trim();
			String role = (String) view.getRegisterWindow().getRegisterFieldsPanel().getRoleComboBox().getSelectedItem();

		} else if(command.equals(ButtonActionCommands.REGISTER_CANCEL_ACTION_COMMAND)) {
			view.getRegisterWindow().dispose();
			view.getLoginWindow().setVisible(true);
		}
	}

	public void handleSidebarCommand(String command) {
		if (command.equals(ViewNames.HOME_VIEW)) {
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.HOME_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.HOME_VIEW);
			view.getMainWindow().getSideBarPanel().resetAllButtonStyles();
			view.getMainWindow().getSideBarPanel().applyHighlightStyle(view.getMainWindow().getSideBarPanel().getHomeButton());
		} else if (command.equals(ViewNames.TOURNAMENT_VIEW)) {
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.TOURNAMENT_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.TOURNAMENT_VIEW);
			view.getMainWindow().getSideBarPanel().resetAllButtonStyles();
			view.getMainWindow().getSideBarPanel().applyHighlightStyle(view.getMainWindow().getSideBarPanel().getTournamentsButton());
		} else if (command.equals(ViewNames.TEAM_VIEW)) {
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.TEAM_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.TEAM_VIEW);
			view.getMainWindow().getSideBarPanel().resetAllButtonStyles();
			view.getMainWindow().getSideBarPanel().applyHighlightStyle(view.getMainWindow().getSideBarPanel().getTeamsButton());
		} else if (command.equals(ViewNames.PLAYER_VIEW)) {
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.PLAYER_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.PLAYER_VIEW);
			view.getMainWindow().getSideBarPanel().resetAllButtonStyles();
			view.getMainWindow().getSideBarPanel().applyHighlightStyle(view.getMainWindow().getSideBarPanel().getPlayersButton());
		} else if (command.equals(ViewNames.COACH_VIEW)) {
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.COACH_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.COACH_VIEW);
			view.getMainWindow().getSideBarPanel().resetAllButtonStyles();
			view.getMainWindow().getSideBarPanel().applyHighlightStyle(view.getMainWindow().getSideBarPanel().getCoachesButton());
		} else if (command.equals(ViewNames.ADMIN_VIEW)) {
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.ADMIN_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.ADMIN_VIEW);
			view.getMainWindow().getSideBarPanel().resetAllButtonStyles();
			view.getMainWindow().getSideBarPanel().applyHighlightStyle(view.getMainWindow().getSideBarPanel().getAdminsButton());
		} else if (command.equals(ViewNames.MATCH_VIEW)) {
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.MATCH_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.MATCH_VIEW);
			view.getMainWindow().getSideBarPanel().resetAllButtonStyles();
			view.getMainWindow().getSideBarPanel().applyHighlightStyle(view.getMainWindow().getSideBarPanel().getMatchesButton());
		} else if (command.equals(ViewNames.GAME_VIEW)) {
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.GAME_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.GAME_VIEW);
			view.getMainWindow().getSideBarPanel().resetAllButtonStyles();
			view.getMainWindow().getSideBarPanel().applyHighlightStyle(view.getMainWindow().getSideBarPanel().getGamesButton());
		} else if (command.equals(ViewNames.REPORT_VIEW)) {
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.REPORT_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.REPORT_VIEW);
			view.getMainWindow().getSideBarPanel().resetAllButtonStyles();
			view.getMainWindow().getSideBarPanel().applyHighlightStyle(view.getMainWindow().getSideBarPanel().getReportsButton());
		} else if (command.equals(ViewNames.SETTINGS_VIEW)) {
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.SETTINGS_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.SETTINGS_VIEW);
			view.getMainWindow().getSideBarPanel().resetAllButtonStyles();
			view.getMainWindow().getSideBarPanel().applyHighlightStyle(view.getMainWindow().getSideBarPanel().getSettingsButton());
		}
	}

	public void handleTournamentCommand(String command) {
		if (command.startsWith("TOURNAMENT_")) {
			int tournamentId = Integer.parseInt(command.split("_")[1]) + 1;
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.TOURNAMENT_DETAIL_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.TOURNAMENT_DETAIL_VIEW);
			System.out.print("DETAIL TOURNAMENT " + tournamentId);
		}
	}

	public void handleTeamCommand(String command) {
		if (command.startsWith("TEAM_")) {
			int teamId = Integer.parseInt(command.split("_")[1]) + 1;  
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.TEAM_DETAIL_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.TEAM_DETAIL_VIEW);
			System.out.println("DETAIL TEAM " + teamId); 
		}
	}

	public void handlePlayerCommand(String command) {
		if (command.startsWith("PLAYER_")) {
			int playerId = Integer.parseInt(command.split("_")[1]) + 1;  
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.PLAYER_DETAIL_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.PLAYER_DETAIL_VIEW);
			System.out.println("DETAIL TEAM " + playerId); 
		}
	}

	public void handleAdminCommand(String command) {
		if (command.startsWith(ButtonActionCommands.ADMIN_TOURNAMENT_ACTION_COMMAND)) {
			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.showView(ViewNames.ADMIN_TOURNAMENT_VIEW);

		} else if (command.startsWith(ButtonActionCommands.ADMIN_TEAM_ACTION_COMMAND)) {
			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.showView(ViewNames.ADMIN_TEAM_VIEW);

		} else if (command.startsWith(ButtonActionCommands.ADMIN_PLAYER_ACTION_COMMAND)) {
			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.showView(ViewNames.ADMIN_PLAYER_VIEW);

		} else if (command.startsWith(ButtonActionCommands.ADMIN_COACH_ACTION_COMMAND)) {
			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.showView(ViewNames.ADMIN_COACH_VIEW);

		} else if (command.startsWith(ButtonActionCommands.ADMIN_ADMINISTRATOR_ACTION_COMMAND)) {
			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.showView(ViewNames.ADMIN_ADMIN_VIEW);

		} else if (command.startsWith(ButtonActionCommands.ADMIN_MATCH_ACTION_COMMAND)) {
			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.showView(ViewNames.ADMIN_MATCH_VIEW);

		} else if (command.startsWith(ButtonActionCommands.ADMIN_GAME_ACTION_COMMAND)) {
			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.showView(ViewNames.ADMIN_GAME_VIEW);
		}
	}


}
