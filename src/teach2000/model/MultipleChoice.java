package teach2000.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Kristof Buts
 * @version 1.0 22/02/18 01:44
 */
public class MultipleChoice extends Overhoring {

	public MultipleChoice(Lijst list) {
		super(list);
	}

	@Override
	public boolean presentAnswer(Vraag v) {
			ArrayList<String> possibilities = new ArrayList<String>(Arrays.asList(v.getAlternatives()));
			possibilities.add(v.getAnswer());
			Collections.shuffle(possibilities);
			for (int i = 0; i < possibilities.size(); ++i) {
				System.out.printf("\t%d: %s", i, possibilities.get(i));
			}
			System.out.printf("%n");
			System.out.printf("Enter your choice: ");
			int choice = keyboard.nextInt();

			if (v.getAnswer().equals(possibilities.get(choice))) {
				v.correctAnswer();
				System.out.printf("Correct! Score: %d%n", v.getScore());
				return true;
			} else {
				v.wrongAnswer();
				System.out.printf("Nope, dumbass. Score: %d%n", v.getScore());
				return false;
			}
	}
}
