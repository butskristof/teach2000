package teach2000.model;

import teach2000.model.lists.List;

/**
 *
 * Class for use with a test where the user has to fill in an answer.
 * This allows the use of a stopword that the user can apply when he has reached the necessary minimum score.
 * The test is created as usual by passing in a List object, the stopword functionality can later be enabled with specific
 * methods.
 *
 * @author Kristof Buts
 */
public class AntwoordInvullen extends Overhoring {
	private String stopword;
	private int minScoreToStop = 0;

	public AntwoordInvullen(List list) {
		super(list);
	}

	public String getStopword() {
		return stopword;
	}

	public int getMinScoreToStop() {
		return minScoreToStop;
	}

	/**
	 * Indicates if this test uses a stop word.
	 * @return Boolean that indicates if stopword functionality is enabled
	 */
	public boolean hasStopword() {
		// if the stopword is empty or isn't set, there isn't one
		if (this.stopword == null || this.stopword.equals("")) {
			return false;
		} else {
			return true;
		}
	}

	// SETTERS

	/**
	 * Disables stopword functionality
	 */
	public void disableStopword() {
		this.stopword = null;
		this.minScoreToStop = 0;
	}

	/**
	 * Enables stopword functionality, both stopword and minimum required score must be passed in.
	 * @param stopword Word to be used to stop
	 * @param minScoreToStop Integer representing the minimum required score
	 */
	public void enableStopword(String stopword, int minScoreToStop) {
		this.stopword = stopword;
		this.minScoreToStop = minScoreToStop;
	}

}
