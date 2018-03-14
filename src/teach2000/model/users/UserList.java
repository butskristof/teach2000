package teach2000.model.users;


import teach2000.model.users.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * @author demacryx on 25.02.2018 9:28 PM.
 * @project teach20002
 */
public class UserList {
	// this class will initialise a list for the users and read the already existing ones from the users file

    private ArrayList<User> users = new ArrayList<>();

    // CONSTRUCTORS

	public UserList() {
		// Ask IO class to read all users in the file
		this.users = UserIO.readUsers();
	}

	// GETTERS

	public ArrayList<User> getUsers() {
		// return all users
		return this.users;
	}

	public User getUser(String id) {
		// return a specific user
		// passed in value is the user's ID
		User ret = null;

		// loop over users
		for (User u: users) {
			if (u.getId().equals(id)) {
				// set return value to user if found and stop loop
				ret = u;
				break;
			}
		}

		return ret;
	}

	// BUSINESS LOGIC

	public void importUser(User u) {
		// Add user to list that is imported from file
        this.users.add(u);
    }

    public void addUser(User newuser) {
		// Create a new user and write it to file
		this.users.add(newuser);

		UserIO.writeUsersToFile(this.users);
	}

	public void removeUser(User user){
		//remove existing user currently logged in
		this.users.remove(user);
		UserIO.writeUsersToFile(this.users);
	}

}
