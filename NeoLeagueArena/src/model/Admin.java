package model;

import java.util.List;

public class Admin extends User {

	private List<String> permissions;

	public Admin(String firstName, String lastName, String email, String password, UserRole role,
			List<String> permissions) {
		super(firstName, lastName, email, password, role);
		this.permissions = permissions;
	}
	


	
	
}
