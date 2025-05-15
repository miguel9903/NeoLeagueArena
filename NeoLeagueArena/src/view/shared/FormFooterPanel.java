package view.shared;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class FormFooterPanel extends JPanel {

	private JButton primaryButton;
	private JButton secondaryButton;
	private JButton tertiaryButton;

	public FormFooterPanel() {
		setLayout(new FlowLayout());
		initializeComponents();
	}

	public void initializeComponents() {
		primaryButton = new JButton("PRIMARY");
		primaryButton.setActionCommand("PRIMARY_BUTTON");
		add(primaryButton);

		secondaryButton = new JButton("SECONDARY");
		secondaryButton.setActionCommand("SECONDARY_BUTTON");
		add(secondaryButton);
		
		tertiaryButton = new JButton("TERTIARY");
		tertiaryButton.setActionCommand("TERTIARY_BUTTON");
		add(tertiaryButton);
	}

	public void setPrimaryButtonActionCommand(String command) {
		primaryButton.setActionCommand(command);
	}

	public void setPrimaryButtonText(String text) {
		primaryButton.setText(text);
	}

	public void setSecondaryButtonActionCommand(String command) {
		secondaryButton.setActionCommand(command);
	}

	public void setSecondaryButtonText(String text) {
		secondaryButton.setText(text);
	}

	public void setTertiaryButtonActionCommand(String command) {
	    tertiaryButton.setActionCommand(command);
	}

	public void setTertiaryButtonText(String text) {
	    tertiaryButton.setText(text);
	}
	
	public JButton getPrimaryButton() {
		return primaryButton;
	}

	public void setPrimaryButton(JButton primaryButton) {
		this.primaryButton = primaryButton;
	}

	public JButton getSecondaryButton() {
		return secondaryButton;
	}

	public void setSecondaryButton(JButton secondaryButton) {
		this.secondaryButton = secondaryButton;
	}
}
