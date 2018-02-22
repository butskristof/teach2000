package teach2000.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author Kristof Buts
 * @version 1.0 22/02/18 01:30
 */
public class Lijst {
	private ArrayList<Vraag> vragen = new ArrayList<>();
//	private int score;
	private String lang_from;
	private String lang_to;

	public Lijst(String lang_from, String lang_to) {
		this.lang_from = lang_from;
		this.lang_to = lang_to;
	}

	public String getTitle() {
		return String.format("%s - %s", this.lang_from, this.lang_to);
	}

	public void addVraag(Vraag v) {
		this.vragen.add(v);
	}

	public Vraag getQuestion() {
		// returns null if all questions have a score of 3

		Collections.shuffle(vragen);

		for (Vraag v : vragen) {
			if (v.questionShouldBeShown()) {
				return v;
			}
		}

		return null;
	}
}
