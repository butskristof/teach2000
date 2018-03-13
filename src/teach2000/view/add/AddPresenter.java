package teach2000.view.add;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import teach2000.model.User;
import teach2000.model.lists.List;
import teach2000.model.questions.Question;

import java.util.ArrayList;

/**
 * @author demacryx on 12.03.2018 11:10 PM.
 * @project teach20002
 */
public class AddPresenter {
    private User model;
    private AddView view;

    public AddPresenter(User model, AddView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {
    	this.view.getSumbitButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// get information and make new list
				String name = view.getTitle().getText();
				String langfrom = view.getTaalFrom().getText();
				String langto = view.getTaalTo().getText();
				List newlist = new List(langfrom, langto, name);

				// loop over fields and create new questions
				ArrayList<Question> questions = new ArrayList<>();
				if (!view.getLeft1().getText().equals("") && !view.getRight1().getText().equals("")) {
					questions.add(new Question(view.getLeft1().getText(), view.getRight1().getText(), new String[0]));
				}
				if (!view.getLeft2().getText().equals("") && !view.getRight2().getText().equals("")) {
					questions.add(new Question(view.getLeft2().getText(), view.getRight2().getText(), new String[0]));
				}
				if (!view.getLeft3().getText().equals("") && !view.getRight3().getText().equals("")) {
					questions.add(new Question(view.getLeft3().getText(), view.getRight3().getText(), new String[0]));
				}
				if (!view.getLeft4().getText().equals("") && !view.getRight4().getText().equals("")) {
					questions.add(new Question(view.getLeft4().getText(), view.getRight4().getText(), new String[0]));
				}
				if (!view.getLeft5().getText().equals("") && !view.getRight5().getText().equals("")) {
					questions.add(new Question(view.getLeft5().getText(), view.getRight5().getText(), new String[0]));
				}
				if (!view.getLeft6().getText().equals("") && !view.getRight6().getText().equals("")) {
					questions.add(new Question(view.getLeft6().getText(), view.getRight6().getText(), new String[0]));
				}
				if (!view.getLeft7().getText().equals("") && !view.getRight7().getText().equals("")) {
					questions.add(new Question(view.getLeft7().getText(), view.getRight7().getText(), new String[0]));
				}
				if (!view.getLeft8().getText().equals("") && !view.getRight8().getText().equals("")) {
					questions.add(new Question(view.getLeft8().getText(), view.getRight8().getText(), new String[0]));
				}
				if (!view.getLeft9().getText().equals("") && !view.getRight9().getText().equals("")) {
					questions.add(new Question(view.getLeft9().getText(), view.getRight9().getText(), new String[0]));
				}
				if (!view.getLeft10().getText().equals("") && !view.getRight10().getText().equals("")) {
					questions.add(new Question(view.getLeft10().getText(), view.getRight10().getText(), new String[0]));
				}

				// add questions to list
				for (Question q: questions) {
					newlist.addQuestion(q);
				}

				// add list to user
				model.addList(newlist);

				// close window and return to main menu
				view.getScene().getWindow().hide();
			}
		});
	}

	private void updateView() {

	}
}
