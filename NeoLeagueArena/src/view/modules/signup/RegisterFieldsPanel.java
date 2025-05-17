package view.modules.signup;

import javax.swing.DefaultComboBoxModel;

import model.enums.UserRole;
import view.shared.BaseUserFormFieldsPanel;

public class RegisterFieldsPanel extends BaseUserFormFieldsPanel {
	
	public RegisterFieldsPanel() { }
	
    @Override
    public void initializeComponents() {
        super.initializeComponents();
        // loadUserRolesComboBox();
    }
    
    public void loadUserRolesComboBox() {
        String[] filteredRoles = new String[] {
            "Role 1",
            "Role 2",
            "Role 3"
        };
        
        getRoleComboBox().setModel(new DefaultComboBoxModel<>(filteredRoles));
    }
}
