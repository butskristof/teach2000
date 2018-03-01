package teach2000.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Kristof Buts
 * @version 1.0 22/02/18 01:43
 */
public abstract class Overhoring {
	private int score = 0;
	protected Lijst list;
	Scanner keyboard = new Scanner(System.in);

	public Overhoring() {
		// for testing purposes
		Vraag v = new Vraag("tafel", "table", new String[]{"tabel", "taple"});
		Vraag v2 = new Vraag("toetsenbord", "keyboard", new String[]{"typboard", "kyboard"});
		this.list = new Lijst("NL", "EN");
		this.list.addVraag(v);
		this.list.addVraag(v2);
	}

	public Overhoring(Lijst list) {
		this.list = list;
	}

	private void correctAnswer() {
		// dedicated function for easy alterations
		this.score += 5;
	}

	private void wrongAnswer() {
		// dedicated function for easy alterations
		--this.score;
	}

	public void test() {
		// method for functionality testing

		Vraag v = this.list.getQuestion();
		// when all questions have reached their maximum score, Lijst.getQuestion returns null
		// may be rewritten with for loop
		while (v != null) {
			System.out.println(v.getQuestion()); // print word
			// hand off to specific test presentation: enter answer, multiple choice, ...
			if ( this.presentAnswer(v) ) {
				this.correctAnswer();
			} else {
				this.wrongAnswer();
			}

			v = this.list.getQuestion(); // get next
		}

		System.out.printf("Total score: %d", this.score); // print total score at the end

	}

	public abstract boolean presentAnswer(Vraag v);
}
