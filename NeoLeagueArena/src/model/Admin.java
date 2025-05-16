package model;

import model.enums.UserRole;

public class Admin extends User {

	public Admin(int id, String firstName, String lastName, String email, String password, String country, String city,
			UserRole role) {
		super(id, firstName, lastName, email, password, country, city, role);
	}

	public Admin(int id, String firstName, String lastName, String email, String password, String country, String city) {
		super(id, firstName, lastName, email, password, country, city, UserRole.ADMIN);
	}
}
