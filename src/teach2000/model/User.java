package teach2000.model;

import java.util.ArrayList;

/**
 * @author Kristof Buts
 */
public class User {
	private String id;
	private ArrayList<Lijst> lijsten = new ArrayList<>();

	public User(String id) {
		this.id = id;
	}

	public void addLijst(Lijst l) {
		this.lijsten.add(l);
	}

	public ArrayList<Lijst> getLijsten() {
		return lijsten;
	}

	public Lijst getLijst(int index) {
		return lijsten.get(index);
	}
}