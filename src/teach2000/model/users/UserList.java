package teach2000.model.users;


import java.util.ArrayList;

/**
 * This class functions as a wrapper around an ArrayList to contain and store all User objects in memory.
 * When created, it will automatically import all users from disk.
 *
 * The UserList is kept as a static variable since it will always contain the information stored in the file. There aren't
 * any variations possible.
 *
 * @author demacryx on 25.02.2018 9:28 PM.
 */
public class UserList {
    private static ArrayList<User> users = new ArrayList<>();

    // CONSTRUCTORS

	/**
	 * Upon creation, all users will automatically be read from disk.
	 */
	public UserList() {
		// Ask IO class to read all users in the file
		users = UserIO.readUsers();
	}

	// GETTERS

	/**
	 * Returns an ArrayList containing all User objects.
	 * @return ArrayList containing all User objects
	 */
	public static ArrayList<User> getUsers() {
		// return all users
		return users;
	}

	/**
	 * Returns a User object when given an index from the ArrayList of getUsers()
	 *
	 * @param id index of the User object wanted in the ArrayList
	 * @return User object
	 */
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

	/**
	 * Imports a user that was read in from file by adding it to the users list
	 * @param u User object to be added
	 */
	public void importUser(User u) {
		// Add user to list that is imported from file
        users.add(u);
    }

	/**
	 * Takes a new user, adds it to the users list and writes it to disk.
	 * @param newuser User object to be added and written to disk
	 */
	public void addUser(User newuser) {
		// Create a new user and write it to file
		users.add(newuser);

		UserIO.writeUsersToFile();
	}

	/**
	 * Removes a user from the list and deletes it on disk.
	 * @param user User object to be deleted
	 */
	public void removeUser(User user){
		//remove existing user currently logged in
		users.remove(user);
		UserIO.writeUsersToFile();
	}

}
