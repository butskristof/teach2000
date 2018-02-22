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

	private String getAnswer() {
		return answer;
	}

	private String[] getAlternatives() {
		return alternatives;
	}

	public ArrayList<String> getPossibilities() {
		// build list starting from alternative answers
		ArrayList<String> possibilities = new ArrayList<String>(Arrays.asList(this.getAlternatives()));
		possibilities.add(this.getAnswer());
		Collections.shuffle(possibilities);

		return possibilities;
	}

	public int getScore() {
		return this.score;
	}

	private void correctAnswer() {
		++this.score;
	}

	private void wrongAnswer() {
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
		return this.score <= 3; // this.score == 3 ? false : true
	}

	@Override
	public String toString() {
		return "Vraag{" +
				"question='" + question + '\'' +
				'}';
	}
}
