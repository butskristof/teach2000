package teach2000.model;

import teach2000.model.lists.List;
import teach2000.model.questions.Question;

/**
 * Super class for tests. Contains all functionality to administrate a test. It closes off the access to the model members,
 * but provides the necessary information to classes using it.
 *
 * A test is based around a List object.
 * Questions will be provided in random order until their maximum score is reached. If all questions have reached their
 * maximum score, null will be returned and the test_done variable will be set to true.
 *
 * A score is kept throughout the test, but isn't saved or written to disk.
 *
 * This is an abstract class and should be extended with test-specific functionality by using inheritance.
 *
 * @author Kristof Buts
 * @version 1.0 22/02/18 01:43
 */
public abstract class Overhoring {
	private int score = 0;
	protected List list;
	private Question currentQuestion;
	private boolean test_done = false;

	// CONSTRUCTORS

	/**
	 * Tests must be created with an accompanying List object to be used.
	 * @param list List object used for the test.
	 */
	public Overhoring(List list) {
		// pass in a list which will be used during the test
		this.list = list;
		this.initialise();
	}

	// GETTERS

	public Question getCurrentQuestion() {
		return this.currentQuestion;
	}

	/**
	 * Access to the list itself isn't provided, so this acts as an intermediary.
	 * @return Language of the questions.
	 */
	public String getLangFrom() {
		// we don't open up access to the list, so an intermediate method is necessary
		return this.list.getLang_from();
	}

	/**
	 * Access to the list itself isn't provided, so this acts as an intermediary.
	 * @return Language of the answers that have to be provided.
	 */
	public String getLangTo() {
		// we don't open up access to the list, so an intermediate method is necessary
		return this.list.getLang_to();
	}

	public String getTitle() {
		// we don't open up access to the list, so an intermediate method is necessary
		return this.list.getTitle();
	}

	public String getListName() {
		// we don't open up access to the list, so an intermediate method is necessary
		return this.list.getName();
	}

	public int getScore() {
		return score;
	}

	/**
	 * Will return true if all questions have reached their maximum score.
	 * @return Boolean indicating the end of the test.
	 */
	public boolean isTest_done() {
		return test_done;
	}

	// BUSINESS LOGIC

	/**
	 * Loads a new question from the list.
	 * Returns the new Question, or null if they have all reached their maximum score.
	 *
	 * @return new Question object set, or null if they have all reached their maximum score
	 */
	public Question setNewQuestion() {
		// a new question is set by retrieving it from the list
		this.currentQuestion = this.list.getQuestion();
		if (this.currentQuestion == null) {
			this.test_done = true;
			this.list.resetQuestionScores();
		}

		return this.getCurrentQuestion();
	}

	/**
	 * Initialises the test by loading the first Question from the list
	 */
	private void initialise() {
		// to initialise the test, we set the currentQuestion property to actually contain a question
		this.setNewQuestion();
	}

	/**
	 * The user's guess is passed in and passed on to the Question. The user will only know if it was right or wrong.
	 *
	 * @param answer String with the user's guess
	 * @return Boolean indicating correctness of the guess
	 */
	public boolean handleAnswer(String answer) {
		// an answer is passed in and processed by the model
		// the question is self-administrating: we pass the answer to the question
		// it'll take care of it's score and provide us with the result
		boolean ret = false; // assume worst case
		ret = this.currentQuestion.processAnswer(answer); // pass user's answer to question
		// set test score
		if (ret) {
			this.correctAnswer();
		} else {
			this.wrongAnswer();
		}
		this.setNewQuestion(); // move on from this question

		return ret;
	}

	/**
	 * Private method for adjusting the test score. Score goes up by 5 if correct.
	 */
	private void correctAnswer() {
		// dedicated function for easy alterations
		this.score += 5;
	}

	/**
	 * Private method for adjusting the test score. Score goes down by 1 if incorrect.
	 */
	private void wrongAnswer() {
		// dedicated function for easy alterations
		--this.score;
	}

}
