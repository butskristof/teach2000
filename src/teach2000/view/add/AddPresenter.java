package teach2000.view.add;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import teach2000.model.User;
import teach2000.model.lists.List;
import teach2000.model.questions.Question;

import java.util.ArrayList;
import java.util.Collections;

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
    	this.view.getBtnAddRow().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				view.addInputRow();
			}
		});

    	this.view.getSumbitButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// get information and make new list
				String name = view.getTitle().getText();
				String langfrom = view.getLangFrom().getText();
				String langto = view.getLangTo().getText();
				List newlist = new List(langfrom, langto, name);

				// loop over fields and create new questions
				ArrayList<ArrayList<TextField>> questioninputs = view.getQuestioninputs();

				for (ArrayList<TextField> inputRow: questioninputs) {
					String question = inputRow.get(0).getText();
					String answer = inputRow.get(1).getText();
					if (!question.equals("") && !answer.equals("")) {
						ArrayList<String> alternatives = new ArrayList<>();
						for (int i = 2; i < 6; ++i) {
							String alternative = inputRow.get(i).getText();
							if (!alternative.equals("")) {
								alternatives.add(alternative);
							}
						}
						Question q = new Question(question, answer, alternatives.toArray(new String[alternatives.size()]));

						newlist.addQuestion(q);
					}
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
