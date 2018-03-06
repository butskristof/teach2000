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
    private static final String userlistfile_prefix = "resources/lists/";

    public User(String name) {
        this(RandomGenerator.getRandomId(), name);
    }

    public User(String id, String name) {
    	this.id = id;
    	this.name = name;

    	this.importLijsten();
	}

    public void addLijst(Lijst l) {
        this.lijsten.add(l);
    }

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

    public void importLijsten() {
		LijstIO.readAllLists(this.getId());
	}
}