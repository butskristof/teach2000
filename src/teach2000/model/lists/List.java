package teach2000.model.lists;

import teach2000.model.questions.Question;
import teach2000.model.utilities.RandomGenerator;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * The List class embodies one list. It holds a list of Question elements
 * and provides the necessary functions for the management.
 *
 * @author Kristof Buts
 * @version 1.0 22/02/18 01:30
 */
public class List {
	private ArrayList<Question> vragen = new ArrayList<>();
	private String id;
	private String lang_from;
	private String lang_to;
	private String name;

	// CONSTRUCTORS

	/**
	 * Used when creating a new list that hasn't got an ID yet.
	 * @param lang_from Source language
	 * @param lang_to Target language
	 * @param name Name of the test
	 */
	public List(String lang_from, String lang_to, String name) {
		// used when creating a new list that hasn't got an ID yet
		this(RandomGenerator.getRandomId(), lang_from, lang_to, name);
	}

	/**
	 * Used when importing a list that already has an ID.
	 * @param id Existing ID of the list
	 * @param lang_from Source language
	 * @param lang_to Target language
	 * @param name Name of the test
	 */
	public List(String id, String lang_from, String lang_to, String name) {
		// used when importing a list from file
		this.id = id;
		this.lang_from = lang_from;
		this.lang_to = lang_to;
		this.name = name;
	}

	// GETTERS

	public String getId() {
		return id;
	}

	public String getLang_from() {
		return lang_from;
	}

	public String getLang_to() {
		return lang_to;
	}

	public ArrayList<Question> getVragen() {
		return vragen;
	}

	// Formatted title for uniform presentation
	/**
	 * The title consists of the two languages (to and from), separated by a hyphen.
	 * @return String containing the title of the List
	 */
	public String getTitle() {
		return String.format("%s - %s", this.lang_from, this.lang_to);
	}

	/**
	 * Name of the List, e.g. the chapter.
	 * @return String containing the name of the List
	 */
	public String getName() {
		return name;
	}

	public void addQuestion(Question v) {
		this.vragen.add(v);
	}

	public void removeQuestion(int index) {
		// check if provided index is in range
		if ( index >= 0 && (index < (this.vragen.size() - 1)) ) {
			this.vragen.remove(index);
		} else {
			throw new IllegalArgumentException("Provided index out of bounds");
		}
	}

	// BUSINESS LOGIC

	/**
	 * This method is used to get a new question from the list. The questions will come in random order, until all
	 * questions have reached their maximum score. When that happens, null is returned
	 *
	 * @return next random question, null if all questions have reached their maximum score
	 */
	public Question getQuestion() {
		// Shuffle questions to make sure they're in random order
		Collections.shuffle(vragen);

		// Iterate through questions until we have one that hasn't reached it's maximum score
		for (Question v : vragen) {
			if (v.questionShouldBeShown()) {
				return v;
			}
		}

		// Only reached when all questions have reached their maximum score
		return null;
	}

	/**
	 * Resets the score of all questions in the list. To do when a test is fully completed.
	 */
	public void resetQuestionScores() {
		// loop over all questions in List
		for (Question q: this.vragen) {
			// reset
			q.resetScore();
		}
	}

	// PRESENTATION

	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();
		ret.append(String.format("%s - %s%n", this.getLang_from(), this.getLang_to()));
		ret.append(String.format("Questions: %d%n", this.getVragen().size()));

		for (Question v: this.getVragen()) {
			ret.append(v.toString());
		}

		return ret.toString();
	}
}
