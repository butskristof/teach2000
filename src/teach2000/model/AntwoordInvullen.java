package teach2000.model;

import teach2000.model.lists.List;

/**
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

	public boolean hasStopword() {
		// if the stopword is empty or isn't set, there isn't one
		if (this.stopword == null || this.stopword.equals("")) {
			return false;
		} else {
			return true;
		}
	}

	// SETTERS
	public void disableStopword() {
		this.stopword = null;
		this.minScoreToStop = 0;
	}

	public void enableStopword(String stopword, int minScoreToStop) {
		this.stopword = stopword;
		this.minScoreToStop = minScoreToStop;
	}

}
