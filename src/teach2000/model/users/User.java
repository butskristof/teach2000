package teach2000.model.users;

import teach2000.model.lists.List;
import teach2000.model.lists.ListIO;
import teach2000.model.utilities.RandomGenerator;

import java.util.ArrayList;

/**
 *
 * This class represents a user. Users have a unique ID which is generated randomly and stays with them throughout runs
 * of the programme. It will be written to disk.
 *
 * There is a possibility to add a stopword: this also requires a minimum score at which it can be applied.
 *
 * @author Kristof Buts
 */

public class User {
    private String id;
    private String name;
    private String stopword;
    private int minimumRequiredScoreToStop = 0;
    private ArrayList<List> lists = new ArrayList<>();

    // CONSTRUCTORS

	/**
	 * Use this when creating a *new* user that hasn't got an ID yet.
	 * @param name username
	 */
    public User(String name) {
    	// used for creating new users that do not yet have an ID
        this(RandomGenerator.getRandomId(), name);
    }

	/**
	 * Use this when importing a user that already has an ID.
	 * The user's lists are also read from file automatically.
	 *
	 * @param id ID of the user to be created, imported
	 * @param name username
	 */
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

	public String getStopword() {
		return stopword;
	}

	public int getMinimumRequiredScoreToStop() {
		return minimumRequiredScoreToStop;
	}

	public boolean getHasStopword() {
    	// if the stopword is empty or isn't set, there isn't one
    	if (this.stopword == null || this.stopword.equals("")) {
    		return false;
		} else {
    		return true;
		}
	}

	// SETTERS

	/**
	 * Method to remove the ability to use a stopword.
	 */
	public void disableStopword() {
    	this.stopword = null;
    	this.minimumRequiredScoreToStop = 0;
	}

	/**
	 * Method to enable a stopword. A minimum score to be reached before it can be used must also be set.
	 * @param stopword Stopword to be used
	 * @param minimumRequiredScoreToStop Minimum required score to be able to use the stopword
	 */
	public void enableStopword(String stopword, int minimumRequiredScoreToStop) {
    	this.stopword = stopword;
    	this.minimumRequiredScoreToStop = minimumRequiredScoreToStop;
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

	public void removeList(List l) {
		// find index and call overloaded method if exists
		int listindex = this.lists.indexOf(l);
		if (listindex != -1) {
			this.removeList(listindex);
		}
	}

	/**
	 * Import all lists in the user's default folder.
	 */
    public void importLists() {
    	// import user's lists from files
		this.lists = ListIO.readAllLists(this.getId());
	}
}