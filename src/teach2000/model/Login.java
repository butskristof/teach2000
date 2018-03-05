package teach2000.model;

import java.util.ArrayList;

/**
 * @author demacryx on 25.02.2018 5:41 PM.
 * @project teach20002
 */
public class Login {
	private UserList users = new UserList();

	public Login() {
		this.initialiseLoginModel();
	}

	public UserList getUsers() {
		return users;
	}

	private void initialiseLoginModel() {
		// test code, should be replaced with reading users from file
		User jos = new User("0", "Jos");
		User buts = new User("1", "Buts");
		users.addUser(jos);
		users.addUser(buts);
	}
}
