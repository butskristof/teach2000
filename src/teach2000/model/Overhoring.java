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
	private int score;
	protected Lijst list;
	Scanner keyboard = new Scanner(System.in);

	public Overhoring() {
		Vraag v = new Vraag("tafel", "table", new String[]{"tabel", "taple"});
		Vraag v2 = new Vraag("toetsenbord", "keyboard", new String[]{"typboard", "kyboard"});
		this.list = new Lijst("NL", "EN");
		this.list.addVraag(v);
		this.list.addVraag(v2);
	}

	public Overhoring(Lijst list) {
		this.list = list;
	}

	public void test() {
		Vraag v = this.list.getQuestion();
		while (v != null) {
			System.out.println(v.getQuestion());
			if ( this.presentAnswer(v) ) {
				this.score += 5;
			} else {
				--this.score;
			}

			v = this.list.getQuestion();
		}

		System.out.printf("Total score: %d", this.score);

	}

	public abstract boolean presentAnswer(Vraag v);
}
