package view.module.tournament;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.shared.FormFooterPanel;
import view.shared.FormHeaderPanel;

import java.awt.BorderLayout;

public class CoachFormPanel extends JPanel {

	FormHeaderPanel formHeaderPanel;
	TournamentFormFieldsPanel coachFormFieldsPanel;
	FormFooterPanel formFooterPanel;

	public CoachFormPanel() {
		setLayout(new BorderLayout()); 
		initializeComponents(); 
		setupFormControls();
	}

	private void initializeComponents() { 
		formHeaderPanel = new FormHeaderPanel();
		formHeaderPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

		coachFormFieldsPanel = new TournamentFormFieldsPanel();
		coachFormFieldsPanel.setBorder(new EmptyBorder(0, 20, 0, 20)); 

		formFooterPanel = new FormFooterPanel();
		formFooterPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

		add(formHeaderPanel, BorderLayout.NORTH); 
		add(coachFormFieldsPanel, BorderLayout.CENTER);
		add(formFooterPanel, BorderLayout.SOUTH); 
	}

	public void setupFormControls() {
		formHeaderPanel.getFormTitleLabel().setText("Manage Coaches");
		formFooterPanel.setPrimaryButtonText("CREATE");
		formFooterPanel.setPrimaryButtonActionCommand("CREATE_COACH");
		
		formFooterPanel.setSecondaryButtonText("UPDATE");
		formFooterPanel.setSecondaryButtonActionCommand("UPDATE_COACH");
		
		formFooterPanel.setTertiaryButtonText("CANCEL");
		formFooterPanel.setTertiaryButtonActionCommand("CANCEL_CREATE_CCACH");
	}

	public FormHeaderPanel getFormHeaderPanel() {
		return formHeaderPanel;
	}

	public void setFormHeaderPanel(FormHeaderPanel formHeaderPanel) {
		this.formHeaderPanel = formHeaderPanel;
	}

	public TournamentFormFieldsPanel getCoachFormFieldsPanel() {
		return coachFormFieldsPanel;
	}

	public void setCoachFormFieldsPanel(TournamentFormFieldsPanel coachFormFieldsPanel) {
		this.coachFormFieldsPanel = coachFormFieldsPanel;
	}

	public FormFooterPanel getFormFooterPanel() {
		return formFooterPanel;
	}

	public void setFormFooterPanel(FormFooterPanel formFooterPanel) {
		this.formFooterPanel = formFooterPanel;
	}
}
