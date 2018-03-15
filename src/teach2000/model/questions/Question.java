package teach2000.model.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * This is the object-oriented representation of a Question.
 * The class is as self-administrating as possible: outsiders only get access the word that has to be guessed,
 * or all the possibilities at once for a multiple choice.
 *
 * For evalution, a method is provided which checks the provided guess with the correct answer and modifies
 * the question's score accordingly.
 *
 * A maximum score to be reached is set to 3 for all Question objects.
 *
 * Note: it is possible to extract the correct answer because it must be displayed to the user if he has it wrong.
 *
 * @author Kristof Buts
 * @version 1.0 22/02/18 01:24
 */
public class Question {
	private String question;
	private String answer;
	private String[] alternatives;
	private int score = 0;
	private final static int MAX_SCORE = 3; // score after which the question won't be shown is the same for all questions

	// CONSTRUCTORS

	public Question(String question, String answer, String[] alternatives) {

		if (question != null && !question.equals("")) {
			this.question = question;
		} else {
			throw new IllegalArgumentException("Question shouldn't be empty.");
		}

		if (answer != null && !answer.equals("")) {
			this.answer = answer;
		} else {
			throw new IllegalArgumentException("Answer shouldn't be empty.");
		}

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

	/**
	 * This returns all possibilities at once, with the correct answer and alternatives mixed up.
	 *
	 * @return ArrayList of possible answers for multiple choice
	 */
	public ArrayList<String> getPossibilities() {
		// build list starting from alternative answers
		ArrayList<String> possibilities = new ArrayList<>(Arrays.asList(this.getAlternatives()));
		// add correct answer
		possibilities.add(this.getAnswer());
		// shuffle to make sure answer can't be guessed
		Collections.shuffle(possibilities);

		return possibilities;
	}

	// outsiders shouldn't have access to correct answer, use getPossibilities and processAnswer instead
	// access is package-private so QuestionIO works
	/**
	 * Returns the correct answer.
	 * This has been made public because the correct answer must be shown when the user guesses wrong.
	 *
	 * @return Correct answer to this question.
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * Method to get the alternative answers. Outsiders shouldn't have access and should use
	 * getPossibilities and processAnswer instead.
	 *
	 *
	 * @return String array containing all alternative answers.
	 */
	public String[] getAlternatives() {
		return alternatives;
	}

	// BUSINESS LOGIC

	/*
	The user's guess can be passed in to this function, which will take care of all the administration regarding scores etc.
	The return value tells the calling function whether the answer was correct or not.
	 */

	/**
	 *
	 * This method processes a user's guess. The guess is passed in, and will then be evaluated towards the correct answers.
	 * The score for this question will then be adjusted accordingly.
	 *
	 * @param a The user's guess
	 * @return Boolean to indicate if the user's guess was correct or wrong
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

	/**
	 * Use this method to poll if a question should be shown. It indicates if it has reached it's maximum score yet,
	 * in which case it shouldn't be shown in the test anymore.
	 *
	 * @return Boolean to indiciate if it should be shown in a test.
	 */
	public boolean questionShouldBeShown() {
		return this.score < MAX_SCORE; // this.score == 3 ? false : true
	}

	// outsiders shouldn't be able to affect score, use processAnswer instead

	/**
	 * Private method to adjust the score. Outsiders do not have access and should use processAnswer instead.
	 */
	private void correctAnswer() {
		// dedicated function for easy alterations in case scoring changes
		// for now, it's just + 1
		++this.score;
	}

	// outsiders shouldn't be able to affect score, use processAnswer instead
	/**
	 * Private method to adjust the score. Outsiders do not have access and should use processAnswer instead.
	 */
	private void wrongAnswer() {
		// dedicated function for easy alterations in case scoring changes
		// for now, it's just - 1
		--this.score;
	}

	/**
	 * Method to reset the score of a question when a test is finished.
	 */
	public void resetScore() {
		this.score = 0;
	}

	// PRESENTATION

	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();

		ret.append(String.format("%s\t%s\t%d\t", this.getQuestion(), this.getAnswer(), this.getAlternatives().length));
		for (String s: this.getAlternatives()) {
			ret.append(String.format("%s\t", s));
		}
		ret.append("\n");

		return ret.toString();
	}
}
