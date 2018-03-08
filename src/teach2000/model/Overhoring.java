package teach2000.model;

import teach2000.model.lists.List;
import teach2000.model.questions.Question;

/**
 * @author Kristof Buts
 * @version 1.0 22/02/18 01:43
 */
public abstract class Overhoring {
	private int score = 0;
	protected List list;
	private Question currentQuestion;
	private boolean test_done = false;

	// CONSTRUCTORS

	public Overhoring(List list) {
		// pass in a list which will be used during the test
		this.list = list;
		this.initialise();
	}

	// GETTERS

	public Question getCurrentQuestion() {
		return this.currentQuestion;
	}

	public String getLangFrom() {
		// we don't open up access to the list, so an intermediate method is necessary
		return this.list.getLang_from();
	}

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

	public boolean isTest_done() {
		return test_done;
	}

	// BUSINESS LOGIC

	public Question setNewQuestion() {
		// a new question is set by retrieving it from the list
		this.currentQuestion = this.list.getQuestion();
		if (this.currentQuestion == null) {
			this.test_done = true;
		}

		return this.getCurrentQuestion();
	}

	private void initialise() {
		// to initialise the test, we set the currentQuestion property to actually contain a question
		this.setNewQuestion();
	}

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

	private void correctAnswer() {
		// dedicated function for easy alterations
		this.score += 5;
	}

	private void wrongAnswer() {
		// dedicated function for easy alterations
		--this.score;
	}

}
