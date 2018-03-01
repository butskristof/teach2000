package teach2000.view;

import teach2000.model.Teach2000Model;

/**
 * @author Kristof Buts
 * @version 1.0 22/02/18 01:12
 */
public class Teach2000Presenter {
	private Teach2000View view;
	private Teach2000Model model;

	public Teach2000Presenter(Teach2000Model model, Teach2000View view) {
		this.view = view;
		this.model = model;

		this.addEventHandlers();
		this.addwindowEventHandlers();
	}

	private void addEventHandlers() {

	}

	private void addwindowEventHandlers() {

	}
}