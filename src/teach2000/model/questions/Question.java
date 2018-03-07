package teach2000.model.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Kristof Buts
 * @version 1.0 22/02/18 01:24
 */
public class Question {

	/*
	This class is self-administrating: outsiders only get access to the word that has to be found
	or all possibilities (in case of multiple choice)
	outsiders can never access or manipulate the score and correct answer
	to evaluate a question, the user's guess must be passed in through processAnswer
	*/

	private String question;
	private String answer;
	private String[] alternatives;
	private int score = 0;
	private final static int MAX_SCORE = 3; // score after which the question won't be shown is the same for all questions

	// CONSTRUCTORS

	public Question(String question, String answer, String[] alternatives) {
		this.question = question;
		this.answer = answer;
		this.alternatives = alternatives;
	}

	// GETTERS

	// get the word that has to be translated
	public String getQuestion() {
		return question;
	}

	public int getScore() {
		return this.score;
	}

	/*
	we only offer access to all possibilities at once, in random order
	so there is no way to extract the correct answer
	 */
	public ArrayList<String> getPossibilities() {
		// build list starting from alternative answers
		ArrayList<String> possibilities = new ArrayList<String>(Arrays.asList(this.getAlternatives()));
		// add correct answer
		possibilities.add(this.getAnswer());
		// shuffle to make sure answer can't be guessed
		Collections.shuffle(possibilities);

		return possibilities;
	}

	// outsiders shouldn't have access to correct answer, use getPossibilities and processAnswer instead
	// access is package-private so QuestionIO works
	String getAnswer() {
		return answer;
	}

	// outsiders shouldn't have access to correct answer, use getPossibilities and processAnswer instead
	// access is package-private so QuestionIO works
	String[] getAlternatives() {
		return alternatives;
	}

	// BUSINESS LOGIC

	/*
	The user's guess can be passed in to this function, which will take care of all the administration regarding scores etc.
	The return value tells the calling function whether the answer was correct or not.
	 */
	public boolean processAnswer(String a) {
		// compare user's guess to correct answer
		if (this.getAnswer().equals(a)) {
			// call function to handle correct answer
			this.correctAnswer();
			return true;
		} else {
			// call function to handle wrong answer
			this.wrongAnswer();
			return false;
		}
	}

	public boolean questionShouldBeShown() {
		return this.score < MAX_SCORE; // this.score == 3 ? false : true
	}

	// outsiders shouldn't be able to affect score, use processAnswer instead
	private void correctAnswer() {
		// dedicated function for easy alterations in case scoring changes
		// for now, it's just + 1
		++this.score;
	}

	// outsiders shouldn't be able to affect score, use processAnswer instead
	private void wrongAnswer() {
		// dedicated function for easy alterations in case scoring changes
		// for now, it's just - 1
		--this.score;
	}

	// PRESENTATION

	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();

		System.out.printf("%s\t%s\t%d\t", this.getQuestion(), this.getAnswer(), this.getAlternatives().length);
		for (String s: this.getAlternatives()) {
			System.out.printf("%s\t", s);
		}
		System.out.printf("%n");

		return ret.toString();
	}
}
