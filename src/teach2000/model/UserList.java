package teach2000.model;


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

	private static final String FILE = "resources/users.bin";
    private ArrayList<User> users = new ArrayList<>();

    // CONSTRUCTORS

	public UserList() {
		this.readUsers();
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

		// Write user information to file
		// UserIO should be extracted to separate utility class
		try (DataOutputStream os = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(FILE)))) {
			for (User u: users) {
				os.writeUTF(u.getId());
				os.writeUTF(u.getName());
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void removeUser(User user){
		//remove existing user currently logged in
		this.users.remove(user);
	}

	private void readUsers() {
		// Users are imported from binary file
		// try to open users file

		// if users file doesn't exist, stop
		if (!Files.exists(Paths.get(FILE))) {
			return;
		}

		try (DataInputStream is = new DataInputStream(new BufferedInputStream(new FileInputStream(FILE)))) {
			// loop over all entries
			while (is.available() > 0) {
				this.importUser(new User(is.readUTF(), is.readUTF())); // user ID and name are read in
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}
