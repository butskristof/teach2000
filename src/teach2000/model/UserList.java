package teach2000.model;


import java.io.*;
import java.util.ArrayList;

/**
 * @author demacryx on 25.02.2018 9:28 PM.
 * @project teach20002
 */
public class UserList {
	// this class will initialise a list for the users and read the already existing ones from the users file
	private static final String FILE = "resources/users.bin";
    private ArrayList<User> users = new ArrayList<>();

	public UserList() {
		this.readUsers();
	}

	public void importUser(User u) {
		// import old user from file
        this.users.add(u);
    }

    public void addUser(User newuser) {
		// add new user and write to file
		this.users.add(newuser);

		// write users to file
		try (DataOutputStream os = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(FILE)))) {
			for (User u: users) {
				os.writeUTF(u.getId());
				os.writeUTF(u.getName());
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public ArrayList<User> getUsers() {
		return this.users;
	}

	public User getUser(String id) {
    	// get specific user
		// by index of ArrayList
		User ret = null;

		for (User u: users) {
			if (u.getId().equals(id)) {
				ret = u;
				break;
			}
		}

		return ret;
	}

	private void readUsers() {
		// read users from binary file
		try (DataInputStream is = new DataInputStream(new BufferedInputStream(new FileInputStream(FILE)))) {
			while (is.available() > 0) {
				this.importUser(new User(is.readUTF(), is.readUTF()));
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		// print imported users for testing purposes
//		System.out.println("Added users");
//		for (User u: this.getUsers()) {
//			System.out.printf("%s\t%s%n", u.getId(), u.getName());
//		}
	}
}
