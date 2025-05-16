package view.module.team;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Colors;
import view.shared.FormFooterPanel;
import view.shared.FormHeaderPanel;

import java.awt.BorderLayout;
import java.awt.Color;

public class TeamFormPanel extends JPanel {

	private FormHeaderPanel formHeaderPanel;
	private CoachFormFieldsPanel coachFormFieldsPanel;
	private FormFooterPanel formFooterPanel;

	public TeamFormPanel() {
		setLayout(new BorderLayout()); 
		initializeComponents(); 
		setupFormControls();
	}

	private void initializeComponents() { 
		formHeaderPanel = new FormHeaderPanel();
		formHeaderPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

		coachFormFieldsPanel = new CoachFormFieldsPanel();
		coachFormFieldsPanel.setBorder(new EmptyBorder(0, 20, 0, 20)); 

		formFooterPanel = new FormFooterPanel();
		formFooterPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
		formFooterPanel.setBackground(Color.decode(Colors.MEDIUM_GRAY));

		add(formHeaderPanel, BorderLayout.NORTH); 
		add(coachFormFieldsPanel, BorderLayout.CENTER);
		add(formFooterPanel, BorderLayout.SOUTH); 
	}

	public void setupFormControls() {
		formHeaderPanel.getFormTitleLabel().setText("Manage Teams");
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

	public CoachFormFieldsPanel getCoachFormFieldsPanel() {
		return coachFormFieldsPanel;
	}

	public void setCoachFormFieldsPanel(CoachFormFieldsPanel coachFormFieldsPanel) {
		this.coachFormFieldsPanel = coachFormFieldsPanel;
	}

	public FormFooterPanel getFormFooterPanel() {
		return formFooterPanel;
	}

	public void setFormFooterPanel(FormFooterPanel formFooterPanel) {
		this.formFooterPanel = formFooterPanel;
	}
}
