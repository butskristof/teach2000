package teach2000.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Kristof Buts
 * @version 1.0 22/02/18 01:24
 */
public class Vraag {
	private String question;
	private String answer;
	private String[] alternatives;
	private int score = 0;

	public Vraag(String question, String answer, String[] alternatives) {
		this.question = question;
		this.answer = answer;
		this.alternatives = alternatives;
	}

	public String getQuestion() {
		return question;
	}

	// outsiders shouldn't have access to correct answer, use getPossibilities and processAnswer instead
	public String getAnswer() {
		return answer;
	}

	// outsiders shouldn't have access to correct answer, use getPossibilities and processAnswer instead
	public String[] getAlternatives() {
		return alternatives;
	}

	public ArrayList<String> getPossibilities() {
		// build list starting from alternative answers
		ArrayList<String> possibilities = new ArrayList<String>(Arrays.asList(this.getAlternatives()));
		// add correct answer
		possibilities.add(this.getAnswer());
		// random order
		Collections.shuffle(possibilities);

		return possibilities;
	}

	public int getScore() {
		return this.score;
	}

	// outsiders shouldn't be able to affect score, use processAnswer instead
	private void correctAnswer() {
		// dedicated function for easy alterations
		++this.score;
	}

	// outsiders shouldn't be able to affect score, use processAnswer instead
	private void wrongAnswer() {
		// dedicated function for easy alterations
		--this.score;
	}

	public boolean processAnswer(String a) {
		if (this.getAnswer().equals(a)) {
			this.correctAnswer();
			return true;
		} else {
			this.wrongAnswer();
			return false;
		}
	}

	public boolean questionShouldBeShown() {
		return this.score < 3; // this.score == 3 ? false : true
	}

	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();

		System.out.printf("%s\t%s\t%d\t", this.getQuestion(), this.getAnswer(), this.getAlternatives().length);
		for (String s: this.getAlternatives()) {
			System.out.printf("%s\t", s);
		}
		System.out.printf("%n");

		return ret.toString();
	}
}
