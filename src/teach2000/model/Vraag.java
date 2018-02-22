package teach2000.model;

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

	public String getAnswer() {
		return answer;
	}

	public String[] getAlternatives() {
		return alternatives;
	}

	public int getScore() {
		return this.score;
	}

	public void correctAnswer() {
		++this.score;
	}

	public void wrongAnswer() {
		--this.score;
	}

	public boolean processAnswer(String a) {
		return false;
	}

	public boolean questionShouldBeShown() {
		return this.score != 3; // this.score == 3 ? false : true
	}

	@Override
	public String toString() {
		return "Vraag{" +
				"question='" + question + '\'' +
				'}';
	}
}
