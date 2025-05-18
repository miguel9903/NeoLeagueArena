package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import model.NeoLeagueArena;
import model.persistence.dto.AdminDTO;
import model.persistence.dto.CoachDTO;
import model.persistence.dto.PlayerDTO;
import model.persistence.dto.TeamDTO;
import model.persistence.dto.UserDTO;
import utils.AssetPaths;
import utils.ButtonActionCommands;
import utils.FieldValidator;
import utils.ViewNames;
import view.View;
import view.module.team.TeamCardPanel;
import view.module.tournament.TournamentCardPanel;
import view.modules.player.PlayerCardPanel;

public class Controller implements ActionListener {

	private View view;
	private NeoLeagueArena neoLeagueArena;

	public Controller() {
		view = new View();
		neoLeagueArena = new NeoLeagueArena();

		neoLeagueArena.loadAdmins();
		assignListeners();
	}

	public void run() {
		view.getLoginWindow().setVisible(true);
	}

	public void assignListeners() {
		// Login
		assigLoginListeners();

		// Logout
		assignLogoutListeners();

		// Register
		assignRegisterListeners();

		// Sidebar Panel
		assignSideBarListeners();

		// Admin Panel
		assignAdminNavBarListeners();

		// Tournaments Panel
		assignTournamentListeners();

		// Teams Panel
		assignAdminTeamListeners();
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

	public void assignLogoutListeners() {
		view.getMainWindow().getMainContentPanel().getTopBarPanel().getLogoutButton().addActionListener(this);
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

	public void assignTournamentListeners() {
		List<TournamentCardPanel> tournamentCards = view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getTournamentPanel().getTournamentCards();

		for (int i = 0; i < tournamentCards.size(); i++) {
			TournamentCardPanel card = tournamentCards.get(i);
			String actionCommand = "TOURNAMENT_" + i;
			card.getDetailButton().setActionCommand(actionCommand);
			card.getDetailButton().addActionListener(this);
		}
	}

	public void assignTeamtListeners() {
		List<TeamCardPanel> teamtCards = view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getTeamsPanel().getTeamCards();

		for (int i = 0; i < teamtCards.size(); i++) {
			TeamCardPanel card = teamtCards.get(i);
			card.getDetailButton().addActionListener(this);
		}
	}

	public void assignTeamListeners () {
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

	public void assignAdminTeamListeners() {
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getTeamManagementPanel().getTeamFormPanel().getFormHeaderPanel().getSearchButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getTeamManagementPanel().getTeamFormPanel().getFormFooterPanel().getPrimaryButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getTeamManagementPanel().getTeamFormPanel().getFormFooterPanel().getSecondaryButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getTeamManagementPanel().getTeamFormPanel().getFormFooterPanel().getTertiaryButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getTeamManagementPanel().getTeamFormPanel().getFormFooterPanel().getQuaternaryButton().addActionListener(this);
		view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getAdminPanel().getAdminContentPanel().getTeamManagementPanel().getTeamPlayerAssignmentPanel().getAddPlayerButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.print("\n COMMAND: " + command + "\n");

		handleLoginCommand(command);
		handleSignUpCommand(command);
		handleSidebarCommand(command);
		handleTournamentCommand(command);
		handleTeamCommand(command);
		handlePlayerCommand(command);
		handleAdminCommand(command);
		handleAdminTeamCommand(command);
	}

	public void handleLoginCommand(String command) {
		if (command.equals(ButtonActionCommands.LOGIN_ACTION_COMMAND)) {
			String email = view.getLoginWindow().getCredentialsPanel().getEmailTextField().getText().trim();
			String password = new String(view.getLoginWindow().getCredentialsPanel().getPasswordTextField().getPassword()).trim();

			if (FieldValidator.isAnyEmpty(email, password)) {
				view.showErrorMessage(view.getLoginWindow(), "Please enter both email and password.");
				return;
			}

			UserDTO loggedUser = neoLeagueArena.authenticateUser(email, password);

			if (loggedUser != null) {
				String loggedUserName = loggedUser.getFirstName() + " " + loggedUser.getLastName();

				view.getLoginWindow().getCredentialsPanel().resetFields();
				view.getMainWindow().getMainContentPanel().getTopBarPanel().getUserNameLabel().setText(loggedUserName);

				if (!"ADMIN".equalsIgnoreCase(loggedUser.getRole())) {
					view.getMainWindow().getSideBarPanel().showAdminsButton(false);
				}

				view.getLoginWindow().dispose();
				view.getMainWindow().setVisible(true);
			} else {
				view.showErrorMessage(view.getLoginWindow(), "Incorrect email or password. Please try again.");
			}

		} else if (command.equals(ButtonActionCommands.LOGIN_REGISTER_ACTION_COMMAND)) {
			view.getLoginWindow().dispose();
			view.getRegisterWindow().setVisible(true);
		} else if (command.equals(ButtonActionCommands.LOGOUT_ACTION_COMMAND)) {
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getUserNameLabel().setText("");
			view.getMainWindow().dispose();
			view.getLoginWindow().setVisible(true);
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

			if (FieldValidator.isAnyEmpty(id, firstName, lastName, email, password, country, city, role)) {
				view.showErrorMessage(view.getRegisterWindow(), "Please fill in all fields.");
				return;
			}

			if (role.equalsIgnoreCase("Player")) {
				PlayerDTO newPlayer = new PlayerDTO();

				newPlayer.setId(Integer.parseInt(id));
				newPlayer.setFirstName(firstName);
				newPlayer.setLastName(lastName);
				newPlayer.setEmail(email);
				newPlayer.setPassword(password);
				newPlayer.setCountry(country);
				newPlayer.setCity(city);
				newPlayer.setRole(role);

				boolean successRegistry = neoLeagueArena.addPlayer(newPlayer);

				if (successRegistry) {
					view.showInfoMessage(view.getRegisterWindow(), "Player registered successfully!");
					view.getRegisterWindow().getRegisterFieldsPanel().resetFields();
					view.getRegisterWindow().dispose();
					view.getLoginWindow().setVisible(true);
				} else {
					view.showErrorMessage(view.getRegisterWindow(), "Player with that email or ID already exists.");
				}

			} else if (role.equalsIgnoreCase("Coach")) {
				CoachDTO newCoach = new CoachDTO();

				newCoach.setId(Integer.parseInt(id));
				newCoach.setFirstName(firstName);
				newCoach.setLastName(lastName);
				newCoach.setEmail(email);
				newCoach.setPassword(password);
				newCoach.setCountry(country);
				newCoach.setCity(city);
				newCoach.setRole(role);

				boolean successRegistry = neoLeagueArena.addCoach(newCoach);

				if (successRegistry) {
					view.showInfoMessage(view.getRegisterWindow(), "Coach registered successfully!");
					view.getRegisterWindow().getRegisterFieldsPanel().resetFields();
					view.getRegisterWindow().dispose();
					view.getLoginWindow().setVisible(true);
				} else {
					view.showErrorMessage(view.getRegisterWindow(), "Coach with that email or ID already exists.");
				}
			}


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

			neoLeagueArena.loadTeams();
			List<TeamDTO> teamsDTO = neoLeagueArena.getAllTeams();

			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.TEAM_VIEW);
			view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.TEAM_VIEW);
			view.getMainWindow().getSideBarPanel().resetAllButtonStyles();
			view.getMainWindow().getSideBarPanel().applyHighlightStyle(view.getMainWindow().getSideBarPanel().getTeamsButton());
			view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getTeamsPanel().renderTeamCards(teamsDTO);

			assignTeamtListeners();

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
		if (command.startsWith(ButtonActionCommands.TEAM_DETAIL_ACTION_COMMAND + "_")) {
			int teamId = Integer.parseInt(command.substring(command.lastIndexOf("_") + 1));

			TeamDTO foundTeam = neoLeagueArena.getTeamWithPlayers(teamId);

			if (foundTeam != null) {
				view.getMainWindow().getMainContentPanel().getLayoutContentPanel().showView(ViewNames.TEAM_DETAIL_VIEW);
				view.getMainWindow().getMainContentPanel().getTopBarPanel().getTitleLabel().setText(ViewNames.TEAM_DETAIL_VIEW);
				view.getMainWindow().getMainContentPanel().getLayoutContentPanel().getTeamDetailPanel().renderTeamDetail(foundTeam);
			}
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
			
			neoLeagueArena.loadCoaches();
			neoLeagueArena.loadPlayers();
			neoLeagueArena.loadTeams();

			List<CoachDTO> coachesDTO = neoLeagueArena.getAllCoaches();
			List<PlayerDTO> playersDTO = neoLeagueArena.getAllPlayers();
			List<TeamDTO> teamsDTO = neoLeagueArena.getAllTeams();

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTeamManagementPanel()
			.getTeamFormPanel()
			.getTeamFormFieldsPanel()
			.setCoachesComboBox(coachesDTO);

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTeamManagementPanel()
			.getTeamPlayerAssignmentPanel()
			.loadPlayersComboBox(playersDTO);

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTeamManagementPanel()
			.getTeamPlayerAssignmentPanel()
			.loadTeamsComboBox(teamsDTO);
			
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

	
	// ==========================================
	// ====  ADMIN COMMANDS: TEAM MANAGEMENT ====
	// ==========================================
	public void handleAdminTeamCommand(String command) {
	    if (command.equals(ButtonActionCommands.ADMIN_CREATE_TEAM_ACTION_COMMAND)) {
	        handleCreateTeam();
	    } else if (command.equals(ButtonActionCommands.ADMIN_ADD_PLAYERS_TO_TEAM_ACTION_COMMAND)) {
	    	handleAddPlayersToTeam();
	    } else if (command.equals(ButtonActionCommands.ADMIN_SEARCH_TEAM_ACTION_COMMAND)) {
	        handleSearchTeam();
	    } else if (command.equals(ButtonActionCommands.ADMIN_UPDATE_TEAM_ACTION_COMMAND)) {
	        handleUpdateTeam();
	    } else if (command.equals(ButtonActionCommands.ADMIN_DELETE_TEAM_ACTION_COMMAND)) {
	        handleDeleteTeam();
	    } else if (command.equals(ButtonActionCommands.ADMIN_RESET_TEAM_ACTION_COMMAND)) {
	        handleResetTeamFields();
	    }
	}

	private void handleCreateTeam() {
		String name = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.getNameTextField()
				.getText()
				.trim();

		String description = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.getDescriptionTextArea()
				.getText()
				.trim();

		String logoText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.getLogoTextField()
				.getText()
				.trim();

		String scoreText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.getScoreTextField()
				.getText()
				.trim();

		String rankingText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.getRankingTextField()
				.getText()
				.trim();

		Integer coachId = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.getCoachComboBoxValue();

		if (FieldValidator.isAnyEmpty(name, description)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Please fill in all required fields.");
			return;
		}

		if (!FieldValidator.isAlphanumeric(name)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"The name cannot contain special characters.");
			return;
		}

		if (neoLeagueArena.teamNameExists(name)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"A team with the name \"" + name + "\" already exists. Please choose another name.");
			return;
		}

		if (description.length() < 10) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Description must be at least 10 characters long.");
			return;
		}

		if (!FieldValidator.isAlphanumeric(description)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"The description cannot contain special characters.");
			return;
		}

		if (!scoreText.isEmpty() && !FieldValidator.isDecimal(scoreText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Score must be a valid decimal number.");
			return;
		}

		if (!rankingText.isEmpty() && !FieldValidator.isInteger(rankingText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Ranking must be a valid integer.");
			return;
		}

		String logo = logoText.isEmpty() ? AssetPaths.TEAM_ICON : logoText;
		double score = (scoreText != null && !scoreText.isEmpty()) ? Double.parseDouble(scoreText) : 0.0;
		int ranking = (rankingText != null && !rankingText.isEmpty()) ? Integer.parseInt(rankingText) : 0;

		Integer lastTeamId = neoLeagueArena.getLastTeamId();
		CoachDTO coachDTO = new CoachDTO();
		coachDTO.setId(coachId != null ? coachId : -1);
		CoachDTO foundCoachDTO = neoLeagueArena.findCoach(coachDTO);

		TeamDTO teamDTO = new TeamDTO();
		teamDTO.setId(lastTeamId);
		teamDTO.setName(name);
		teamDTO.setDescription(description);
		teamDTO.setLogo(logo);
		teamDTO.setScore(score);
		teamDTO.setRanking(ranking);	
		teamDTO.setPlayerIds(null); 
		teamDTO.setTournamentIds(null);

		if (foundCoachDTO != null) {
			String teamCoachName = foundCoachDTO.getFirstName() + " " + foundCoachDTO.getLastName();
			teamDTO.setCoachId(foundCoachDTO.getId());
			teamDTO.setCoachName(teamCoachName);
		} else {
			teamDTO.setCoachId(null);
			teamDTO.setCoachName(null);		
		}

		boolean teamAddedSuccessfully = neoLeagueArena.addTeam(teamDTO);

		if (teamAddedSuccessfully) {
			view.showInfoMessage("Team added succesfully.");
			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTeamManagementPanel()
			.getTeamFormPanel()
			.getTeamFormFieldsPanel()
			.resetFields();
		} else {
			view.showErrorMessage(view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Error creating team");
		}
	}

	private void handleAddPlayersToTeam() {
		String teamText = (String) view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamPlayerAssignmentPanel()
				.getTeamComboBox()
				.getSelectedItem();

		String playerText = (String) view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamPlayerAssignmentPanel()
				.getPlayerComboBox()
				.getSelectedItem();
	}

	private void handleSearchTeam() {
		String searchText = (String) view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getFormHeaderPanel()
				.getSearchTextField()
				.getText();

		if (FieldValidator.isEmpty(searchText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Please enter a search term.");
			return;
		}

		if (!FieldValidator.isInteger(searchText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Please enter a valid ID.");
			return;
		}

		TeamDTO teamDTO = new TeamDTO();
		teamDTO.setId(Integer.parseInt(searchText));
		TeamDTO foundTeamDTO = neoLeagueArena.findTeam(teamDTO);

		if (foundTeamDTO != null) {
			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTeamManagementPanel()
			.getTeamFormPanel()
			.getTeamFormFieldsPanel()
			.getIdTextField()
			.setText(foundTeamDTO.getId().toString());

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTeamManagementPanel()
			.getTeamFormPanel()
			.getTeamFormFieldsPanel()
			.getNameTextField()
			.setText(foundTeamDTO.getName());

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTeamManagementPanel()
			.getTeamFormPanel()
			.getTeamFormFieldsPanel()
			.getDescriptionTextArea()
			.setText(foundTeamDTO.getDescription());

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTeamManagementPanel()
			.getTeamFormPanel()
			.getTeamFormFieldsPanel()
			.getLogoTextField()
			.setText(foundTeamDTO.getLogo());

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTeamManagementPanel()
			.getTeamFormPanel()
			.getTeamFormFieldsPanel()
			.getScoreTextField()
			.setText(String.valueOf(foundTeamDTO.getScore()));

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTeamManagementPanel()
			.getTeamFormPanel()
			.getTeamFormFieldsPanel()
			.getRankingTextField()
			.setText(String.valueOf(foundTeamDTO.getRanking()));

			CoachDTO coachDTO = new CoachDTO();
			coachDTO.setId(foundTeamDTO.getCoachId());
			List<CoachDTO> coachesDTO = neoLeagueArena.getAllCoaches();
			CoachDTO foundCoachDTO = neoLeagueArena.findCoach(coachDTO);

			if (foundCoachDTO != null) {
				String coachName = foundCoachDTO.getId() + " - " + foundCoachDTO.getFirstName() + " " + foundCoachDTO.getLastName();

				view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.setCoachesComboBox(coachesDTO);

				view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.getCoachComboBox()
				.setSelectedItem(coachName);
			}

		} else {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"No team found with ID: " + searchText
					);
		}
	}
	
	private void handleUpdateTeam() {
		String id = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.getIdTextField()
				.getText()
				.trim();

		String name = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.getNameTextField()
				.getText()
				.trim();

		String description = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.getDescriptionTextArea()
				.getText()
				.trim();

		String logoText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.getLogoTextField()
				.getText()
				.trim();

		String scoreText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.getScoreTextField()
				.getText()
				.trim();

		String rankingText = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.getRankingTextField()
				.getText()
				.trim();

		Integer coachId = view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.getCoachComboBoxValue();

		String searchText = (String) view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getFormHeaderPanel()
				.getSearchTextField()
				.getText();

		if (FieldValidator.isEmpty(searchText) || FieldValidator.isEmpty(id)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"You must search for a team before updating.");
			return;
		}

		if (FieldValidator.isAnyEmpty(name, description)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Please fill in all required fields.");
			return;
		}

		if (!FieldValidator.isAlphanumeric(name)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"The name cannot contain special characters.");
			return;
		}

		TeamDTO teamDTO2 = new TeamDTO();
		teamDTO2.setId(Integer.parseInt(searchText));
		TeamDTO oldTeamDTO2 = neoLeagueArena.findTeam(teamDTO2);

		if (neoLeagueArena.teamNameExists(name, oldTeamDTO2.getId())) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"A team with the name \"" + name + "\" already exists. Please choose another name.");
			return;
		}

		if (description.length() < 10) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Description must be at least 10 characters long.");
			return;
		}

		if (!FieldValidator.isAlphanumeric(description)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"The description cannot contain special characters.");
			return;
		}

		if (!scoreText.isEmpty() && !FieldValidator.isDecimal(scoreText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Score must be a valid decimal number.");
			return;
		}

		if (!rankingText.isEmpty() && !FieldValidator.isInteger(rankingText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Ranking must be a valid integer.");
			return;
		}

		String logo = logoText.isEmpty() ? AssetPaths.TEAM_ICON : logoText;
		double score = (scoreText != null && !scoreText.isEmpty()) ? Double.parseDouble(scoreText) : 0.0;
		int ranking = (rankingText != null && !rankingText.isEmpty()) ? Integer.parseInt(rankingText) : 0;

		CoachDTO coachDTO = new CoachDTO();
		coachDTO.setId(coachId != null ? coachId : -1);
		CoachDTO foundCoachDTO = neoLeagueArena.findCoach(coachDTO);

		TeamDTO teamDTO = new TeamDTO();
		teamDTO.setId(Integer.parseInt(searchText));
		TeamDTO oldTeamDTO = neoLeagueArena.findTeam(teamDTO);

		TeamDTO newTeamDTO = new TeamDTO();
		newTeamDTO.setId(oldTeamDTO.getId());
		newTeamDTO.setName(name);
		newTeamDTO.setDescription(description);
		newTeamDTO.setLogo(logo);
		newTeamDTO.setScore(score);
		newTeamDTO.setRanking(ranking);	
		newTeamDTO.setPlayerIds(oldTeamDTO.getPlayerIds()); 
		newTeamDTO.setTournamentIds(oldTeamDTO.getTournamentIds());

		if (foundCoachDTO != null) {
			String teamCoachName = foundCoachDTO.getFirstName() + " " + foundCoachDTO.getLastName();
			newTeamDTO.setCoachId(foundCoachDTO.getId());
			newTeamDTO.setCoachName(teamCoachName);
		} else {
			newTeamDTO.setCoachId(oldTeamDTO.getCoachId());
			newTeamDTO.setCoachName(oldTeamDTO.getCoachName());		
		}

		boolean teamUpdatedSuccessfully = neoLeagueArena.updateTeam(oldTeamDTO, newTeamDTO);

		if (teamUpdatedSuccessfully) {
			view.showInfoMessage("Team updated succesfully.");
			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTeamManagementPanel()
			.getTeamFormPanel()
			.getTeamFormFieldsPanel()
			.resetFields();
		} else {
			view.showErrorMessage(view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Error updating team");

			view.getMainWindow()
			.getMainContentPanel()
			.getLayoutContentPanel()
			.getAdminPanel()
			.getAdminContentPanel()
			.getTeamManagementPanel()
			.getTeamFormPanel()
			.getFormHeaderPanel()
			.resetFields();
		}
	}

	private void handleDeleteTeam() {
		String searchText = (String) view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getFormHeaderPanel()
				.getSearchTextField()
				.getText();

		if (FieldValidator.isEmpty(searchText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Please enter a search term.");
			return;
		}

		if (!FieldValidator.isInteger(searchText)) {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"Please enter a valid ID.");
			return;
		}

		TeamDTO teamDTO = new TeamDTO();
		teamDTO.setId(Integer.parseInt(searchText));
		TeamDTO foundTeamDTO = neoLeagueArena.findTeam(teamDTO);

		if (foundTeamDTO != null) {
			boolean teamDeletedSuccessfully = neoLeagueArena.deleteTeam(foundTeamDTO);

			if (teamDeletedSuccessfully) {
				view.showInfoMessage("Team deleted succesfully.");
				view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getTeamFormFieldsPanel()
				.resetFields();

				view.showInfoMessage("Team deleted succesfully.");
				view.getMainWindow()
				.getMainContentPanel()
				.getLayoutContentPanel()
				.getAdminPanel()
				.getAdminContentPanel()
				.getTeamManagementPanel()
				.getTeamFormPanel()
				.getFormHeaderPanel()
				.resetFields();

			} else {
				view.showErrorMessage(view.getMainWindow()
						.getMainContentPanel()
						.getLayoutContentPanel()
						.getAdminPanel()
						.getAdminContentPanel()
						.getTeamManagementPanel(),
						"Error deleting team");
			}

		} else {
			view.showErrorMessage(
					view.getMainWindow()
					.getMainContentPanel()
					.getLayoutContentPanel()
					.getAdminPanel()
					.getAdminContentPanel()
					.getTeamManagementPanel(),
					"No team found with ID: " + searchText
					);
		}
	}

	private void handleResetTeamFields() {
		view.getMainWindow()
		.getMainContentPanel()
		.getLayoutContentPanel()
		.getAdminPanel()
		.getAdminContentPanel()
		.getTeamManagementPanel()
		.getTeamFormPanel()
		.getTeamFormFieldsPanel()
		.resetFields();

	}
}
