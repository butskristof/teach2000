package teach2000;

/**
 * @author Kristof Buts
 * @version 1.0 09/03/18 00:09
 */
public class Teach2000Exception extends RuntimeException {
	// unchecked exception class to streamline errors flowing from model to presentation

	public Teach2000Exception(String message) {
		super(message);
	}

	public Teach2000Exception(Throwable cause) {
		super(cause);
	}
}
