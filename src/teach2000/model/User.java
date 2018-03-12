package teach2000.model;

import teach2000.model.lists.List;
import teach2000.model.lists.ListIO;
import teach2000.model.utilities.RandomGenerator;

import java.util.ArrayList;

/**
 * @author Kristof Buts
 */

public class User {
    private String id;
    private String name;
    private ArrayList<List> lists = new ArrayList<>();

    // CONSTRUCTORS

    public User(String name) {
    	// used for creating new users that do not yet have an ID
        this(RandomGenerator.getRandomId(), name);
    }

    public User(String id, String name) {
    	// used for importing users that already have an ID
    	this.id = id;
    	this.name = name;

    	this.importLists();
	}

	// GETTERS

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ArrayList<List> getLists() {
        return this.lists;
    }

    public List getList(int index) {
        return this.lists.get(index);
    }

    // BUSINESS LOGIC

	public void addList(List l) {
    	// add new list to user and write it to a file in the user's folder
		this.lists.add(l);
		ListIO.writeList(this.getId(), l);
	}

	public void removeList(int listindex) {
    	// remove file
		ListIO.removeList(this.getId(), this.lists.get(listindex).getId());
		// remove from user list
    	this.lists.remove(listindex);
	}

    public void importLists() {
    	// import user's lists from files
		this.lists = ListIO.readAllLists(this.getId());
	}
}