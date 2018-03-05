package teach2000.model;


import java.io.*;
import java.util.ArrayList;

/**
 * @author demacryx on 25.02.2018 9:28 PM.
 * @project teach20002
 */
public class UserList {
//    private String user;
    private ArrayList<User> users = new ArrayList<>();

    public void addUser(User u) {
        this.users.add(u);
    }

	public ArrayList<User> getUsers() {
		return this.users;
	}

	public User getUser(String id) {
    	// get user
		return null;
	}

}
