package teach2000.model.lijsten;

import teach2000.model.vragen.Vraag;
import teach2000.model.utilities.RandomGenerator;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Kristof Buts
 * @version 1.0 22/02/18 01:30
 */
public class Lijst {
	private ArrayList<Vraag> vragen = new ArrayList<>();
	private String id;
	private String lang_from;
	private String lang_to;

	// CONSTRUCTORS

	public Lijst(String lang_from, String lang_to) {
		// used when creating a new list that hasn't got an ID yet
		this(RandomGenerator.getRandomId(), lang_from, lang_to);
	}

	public Lijst(String id, String lang_from, String lang_to) {
		// used when importing a list from file
		this.id = id;
		this.lang_from = lang_from;
		this.lang_to = lang_to;
	}

	// GETTERS

	public String getId() {
		return id;
	}

	public String getLang_from() {
		return lang_from;
	}

	public String getLang_to() {
		return lang_to;
	}

	public ArrayList<Vraag> getVragen() {
		return vragen;
	}

	// Formatted title for uniform presentation
	public String getTitle() {
		return String.format("%s - %s", this.lang_from, this.lang_to);
	}

	public void addVraag(Vraag v) {
		this.vragen.add(v);
	}

	// BUSINESS LOGIC

	// Get a question from the list
	// When all questions in the list have reached their maximum score, null will be returned
	public Vraag getQuestion() {
		// Shuffle questions to make sure they're in random order
		Collections.shuffle(vragen);

		// Iterate through questions until we have one that hasn't reached it's maximum score
		for (Vraag v : vragen) {
			if (v.questionShouldBeShown()) {
				return v;
			}
		}

		// Only reached when all questions have reached their maximum score
		return null;
	}


	// PRESENTATION

	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();
		ret.append(String.format("%s - %s%n", this.getLang_from(), this.getLang_to()));
		ret.append(String.format("Questions: %d%n", this.getVragen().size()));

		for (Vraag v: this.getVragen()) {
			ret.append(v.toString());
		}

		return ret.toString();
	}
}
