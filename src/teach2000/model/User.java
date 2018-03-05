package teach2000.model;

import java.util.ArrayList;

/**
 * @author Kristof Buts
 */
public class User {
    private String id;
    private String name;
    private ArrayList<Lijst> lijsten = new ArrayList<>();

    public User(String id, String name) {
        this.id = id;
        this.name = name;
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
}