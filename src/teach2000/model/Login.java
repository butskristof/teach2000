package teach2000.model;

import java.io.*;
import java.util.ArrayList;

/**
 * @author demacryx on 25.02.2018 5:41 PM.
 * @project teach20002
 */
public class Login {
	// the login model will read the users from the correct files and store them in memory
	// offering them in an accessible format for the presenter
	private UserList users = new UserList();

	public UserList getUsers() {
		return users;
	}

	public void addUser(String name) {
		User newUser = new User( name);
		users.addUser(newUser);
	}
}
