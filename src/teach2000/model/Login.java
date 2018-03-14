package teach2000.model;

import teach2000.model.users.User;
import teach2000.model.users.UserList;
import teach2000.view.login.LoginView;

/**
 * This class administrates the Login. Upon creation, it will create a UserList (that will read in existing users)
 * and offer everything in an accessible format to the presenter.
 *
 * @author demacryx on 25.02.2018 5:41 PM.
 */
public class Login {

    private Login model;
    private LoginView view;

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
