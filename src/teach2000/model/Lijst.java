package teach2000.model;

import teach2000.model.utilities.RandomGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author Kristof Buts
 * @version 1.0 22/02/18 01:30
 */
public class Lijst {
	private ArrayList<Vraag> vragen = new ArrayList<>();
	private String id;
	private String lang_from;
	private String lang_to;

	public Lijst(String lang_from, String lang_to) {
		this(RandomGenerator.getRandomId(), lang_from, lang_to);
	}

	public Lijst(String id, String lang_from, String lang_to) {
		this.id = id;
		this.lang_from = lang_from;
		this.lang_to = lang_to;
	}

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

	public String getTitle() {
		return String.format("%s - %s", this.lang_from, this.lang_to);
	}

	public void addVraag(Vraag v) {
		this.vragen.add(v);
	}

	public Vraag getQuestion() {
		// returns null if all questions have a score of 3

		// make sure the questions are returned at random
		Collections.shuffle(vragen);

		// iterate through questions until we have one that hasn't reached it's maximum score
		for (Vraag v : vragen) {
			System.out.println(v.questionShouldBeShown());
			if (v.questionShouldBeShown()) {
				return v;
			}
		}

		return null;
	}

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
