package teach2000.model;

/**
 * @author Kristof Buts
 */
public class AntwoordInvullen extends Overhoring {

	public AntwoordInvullen(Lijst list) {
		super(list);
	}

	@Override
	public boolean presentAnswer(Vraag v) {
		System.out.printf("Enter your choice: ");
		String input = keyboard.nextLine();

		// forward choice to question which will handle score updates etc

		if ( v.processAnswer(input) ) {
			System.out.printf("Correct! Score: %d%n", v.getScore());
			return true;
		} else {
			System.out.printf("Nope, dumbass. Score: %d%n", v.getScore());
			return false;
		}
	}
}
