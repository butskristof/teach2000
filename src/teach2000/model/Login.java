package teach2000.model;

import teach2000.model.users.User;
import teach2000.model.users.UserList;
import teach2000.view.login.LoginView;

/**
 * @author demacryx on 25.02.2018 5:41 PM.
 * @project teach20002
 */
public class Login {

    private Login model;
    private LoginView view;

	// the login model will read the users from the correct files and store them in memory
	// offering them in an accessible format for the presenter
	private UserList users = new UserList();

	public UserList getUsers() {
		return users;
	}

	public void addUser(String name) {
		// create new user and add to user list
		User newUser = new User( name);
		users.addUser(newUser);
	}
}
