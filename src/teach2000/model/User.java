package teach2000.model;

import teach2000.model.utilities.LijstIO;
import teach2000.model.utilities.RandomGenerator;

import java.util.ArrayList;

/**
 * @author Kristof Buts
 */
public class User {
    private String id;
    private String name;
    private ArrayList<Lijst> lijsten = new ArrayList<>();

    public User(String name) {
    	// used for creating new users that do not yet have an ID
        this(RandomGenerator.getRandomId(), name);
    }

    public User(String id, String name) {
    	// used for importing users that already have an ID
    	this.id = id;
    	this.name = name;

    	this.importLijsten();
	}

	// getters

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Lijst> getLijsten() {
        return lijsten;
    }

    public Lijst getLijst(int index) {
        return lijsten.get(index);
    }

    // business logic

	public void addLijst(Lijst l) {
    	// add new list to user
		// TODO should be extended with functionality to write to file
		this.lijsten.add(l);
	}

    public void importLijsten() {
    	// import user's lists from files
		this.lijsten = LijstIO.readAllLists(this.getId());
	}
}