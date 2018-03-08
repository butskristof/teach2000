package teach2000.view.writeTest;

import com.sun.javafx.binding.StringFormatter;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import teach2000.model.AntwoordInvullen;

import java.util.Optional;

/**
 * @author demacryx on 25.02.2018 6:32 PM.
 * @project teach20002
 */
public class WritePresenter {
//	private Login model;
	private AntwoordInvullen model;
	private WriteView view;

	public WritePresenter(AntwoordInvullen model, WriteView view) {
		this.model = model;
		this.view = view;
		this.addEventHandlers();
		this.initialiseView();
		this.updateView();
	}

	private void addEventHandlers() {
		// exit from menu
		view.getAfsluiten().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				final Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setHeaderText("Are you sure?");
				alert.setContentText("Are you sure you want to stop Teach2000?");
				Optional<ButtonType> choice = alert.showAndWait();
				if (choice.get().getButtonData().isCancelButton()) {
					event.consume();
				} else {
					// stop application
					// should be extended with closing best practices
					Platform.exit();
				}
			}
		});

		// okay button is clicked
		this.view.getOkButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				handleAnswer();
			}
		});

		// entered in input field
		this.view.getInputField().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				handleAnswer();
			}
		});
	}

	private void handleAnswer() {
		// we take the user's input and pass it down to the model
		// afterwards, the view is updated
		boolean result = model.handleAnswer(view.getInputField().getText());

		updateView();
	}

	private void initialiseView() {
		// when the view is created, we set the meta information such as
		// languages, titles, ...
		// these won't change during the course of the test so shouldn't be
		// updated constantly
		this.view.getTaalFrom().setText(this.model.getLangFrom());
		this.view.getTaalTo().setText(this.model.getLangTo());
		this.view.getTitle().setText(this.model.getListName());
	}

	private void updateView() {
		// depending on whether we get a new question
		// we either update the view with a new question
		// or go into completing procedures

		if (this.model.isTest_done()) {
			// handle end of test
			final Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText("Done!");
			alert.setContentText(String.format("Score: %d", this.model.getScore()));
			alert.showAndWait();

			// return to main menu
			Platform.exit();
		} else {
			this.model.setNewQuestion();

			// set word, current score and clear input field
			this.view.getWord().setText(this.model.getCurrentQuestion().getQuestion());
			this.view.getExtraText().setText(String.format("Score voor deze test: %d", this.model.getScore()));
			this.view.getScore().setText(String.format("Score voor deze vraag: %d", this.model.getCurrentQuestion().getScore()));
			this.view.getInputField().clear();
		}

	}

}
