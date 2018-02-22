package teach2000.model;

/**
 * @author Kristof Buts
 */
public class AntwoordInvullen extends Overhoring {

	public AntwoordInvullen(Lijst list) {
		super(list);
	}

	@Override
	public void presentAnswer(Vraag v) {
		System.out.printf("Enter your choice: ");
		String input = keyboard.nextLine();

		if (v.getAnswer().equals(input)) {
			v.correctAnswer();
			System.out.printf("Correct! Score: %d%n", v.getScore());
		} else {
			v.wrongAnswer();
			System.out.printf("Nope, dumbass. Score: %d%n", v.getScore());
		}

	}
}
