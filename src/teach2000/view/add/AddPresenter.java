package teach2000.view.add;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.WindowEvent;
import teach2000.model.users.User;
import teach2000.model.lists.List;
import teach2000.model.questions.Question;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author demacryx on 12.03.2018 11:10 PM.
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
    	// tell view to add a new row of inputs
    	this.view.getBtnAddRow().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				view.addInputRow();
			}
		});

    	// submit
    	this.view.getSumbitButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// get meta information and make new list
				String name = view.getTitle().getText();
				String langfrom = view.getLangFrom().getText();
				String langto = view.getLangTo().getText();
				List newlist = new List(langfrom, langto, name);

				// loop over fields and create new questions
				ArrayList<ArrayList<TextField>> questioninputs = view.getQuestioninputs();

				// loop over each row
				for (ArrayList<TextField> inputRow: questioninputs) {
					// question and answer are the first input fields in the row
					String question = inputRow.get(0).getText();
					String answer = inputRow.get(1).getText();
					// do nothing if one of both is empty
					if (!question.equals("") && !answer.equals("")) {
						ArrayList<String> alternatives = new ArrayList<>();

						// if the alternative field isn't empty, it's added to the question
						for (int i = 2; i < 6; ++i) {
							String alternative = inputRow.get(i).getText();
							if (!alternative.equals("")) {
								alternatives.add(alternative);
							}
						}

						// new question is created
						Question q = new Question(question, answer, alternatives.toArray(new String[alternatives.size()]));

						// and added to the new list
						newlist.addQuestion(q);
					}
				}

				// add list to user
				// will take care of writing to file
				model.addList(newlist);

				// close window and return to main menu
				view.getScene().getWindow().hide();
			}
		});

    	// close from menu item
		this.view.getAfsluiten().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// fire close request for uniformity
				view.getScene().getWindow().fireEvent(new WindowEvent(view.getScene().getWindow(), WindowEvent.WINDOW_CLOSE_REQUEST));
			}
		});
	}

	public void addWindowEventHandlers() {
    	this.view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				// show close dialog
				final Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setHeaderText("Are you sure?");
				alert.setContentText("Are you sure you want to close this window? All progress will be lost.");
				alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE); // Make sure height is resized to fit text on Linux
				Optional<ButtonType> choice = alert.showAndWait();
				if (!choice.get().getButtonData().isCancelButton()) {
					// stop test
					view.getScene().getWindow().hide();
				} else {
					event.consume();
				}
			}
		});
	}

	private void updateView() {

	}
}
