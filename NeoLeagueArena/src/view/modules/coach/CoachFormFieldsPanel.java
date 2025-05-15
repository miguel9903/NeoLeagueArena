package view.modules.coach;

import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import view.shared.BaseUserFormFieldsPanel;

public class CoachFormFieldsPanel extends BaseUserFormFieldsPanel {

    private JLabel teamLabel;
    private JComboBox<String> teamComboBox; 

    @Override
    public void initializeComponents() {
        super.initializeComponents();

        teamLabel = new JLabel("Teams:");

        String[] teamNames = {"Team A", "Team B", "Team C", "Team D", "Team E"};        
        teamComboBox = new JComboBox<>(teamNames);
        teamComboBox.setPreferredSize(new Dimension(200, 30));  // Ajuste de tamaño

        add(teamLabel);
        add(teamComboBox);
    }

    public JLabel getTeamLabel() {
        return teamLabel;
    }

    public void setTeamLabel(JLabel teamLabel) {
        this.teamLabel = teamLabel;
    }

    public JComboBox<String> getTeamComboBox() {
        return teamComboBox;
    }

    public void setTeamComboBox(JComboBox<String> teamComboBox) {
        this.teamComboBox = teamComboBox;
    }
}
