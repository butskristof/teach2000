package teach2000.view.mcTest;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.WindowEvent;
import teach2000.model.MultipleChoice;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author demacryx on 25.02.2018 6:33 PM.
 */

public class McPresenter {
    private MultipleChoice model;
    private McView view;

    public McPresenter(MultipleChoice model, McView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.initialiseView();
        this.updateView();
    }

    private void addEventHandlers() {
        // handle answer

        // okay button is clicked
        this.view.getOkButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // check if there's a toggle selected
                if (view.getToggleGroup().getSelectedToggle() != null) {
                    handleAnswer();
                }
            }
        });
    }

    public void addWindowEventHandlers() {
        // when a close request is sent from window button or menu item
        // closeDialog function is called which displays a dialog to the user
        // and stops the test if necessary
        // close request
        view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                // show close dialog
                final Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Are you sure?");
                alert.setContentText("Are you sure you want to stop this test?");
                alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE); // Make sure height is resized to fit text on Linux
                Optional<ButtonType> choice = alert.showAndWait();
                if (!choice.get().getButtonData().isCancelButton()) {
                    // stop test
                    stopTest();
                } else {
                    event.consume();
                }
            }
        });
    }

    private void stopTest() {
        // handle end of test
        final Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Done!");
        alert.setContentText(String.format("Score: %d", this.model.getScore()));
        alert.showAndWait();

        // return to main menu
        // close this window after the alert so we return to the main menu
        this.view.getScene().getWindow().hide();
    }

    private void handleAnswer() {
        // we take the user's input and pass it down to the model
        // afterwards, the view is updated
        // get toggle group and pass value
        String correctAnswer = this.model.getCurrentQuestion().getAnswer();

        RadioButton r = (RadioButton) this.view.getToggleGroup().getSelectedToggle();
        boolean result = this.model.handleAnswer(r.getText());

        if (result) {
            this.view.getLblResult().setText("Correct!");
            this.view.getLblResult().setTextFill(Color.GREEN);
        } else {
            this.view.getLblResult().setText("Wrong... The correct answer was " + correctAnswer);
            this.view.getLblResult().setTextFill(Color.RED);
        }

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
            // close this window after the alert so we return to the main menu
            this.view.getScene().getWindow().hide();
        } else {
            this.model.setNewQuestion();

            // set word, current score and clear input field
            this.view.getWord().setText(this.model.getCurrentQuestion().getQuestion());
            this.view.getExtraText().setText(String.format("Score for this test: %d", this.model.getScore()));
            this.view.getScore().setText(String.format("Score for this question: %d", this.model.getCurrentQuestion().getScore()));
            ArrayList<String> possibilities = this.model.getCurrentQuestion().getPossibilities();
            this.view.setRadioButtons(possibilities);
        }

    }

}
