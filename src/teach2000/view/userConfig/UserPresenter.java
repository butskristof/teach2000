package teach2000.view.userConfig;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;
import teach2000.model.users.User;
import teach2000.model.users.UserIO;

import java.util.Optional;

/**
 * @author demacryx on 15.03.2018 8:35 PM.
 */
public class UserPresenter {
    private User user;
    private UserView view;

    public UserPresenter(User user, UserView view) {
        this.user = user;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {
        view.getCancelButtton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                event.consume();
				// send close request
				view.getScene().getWindow().fireEvent(new WindowEvent(view.getScene().getWindow(), WindowEvent.WINDOW_CLOSE_REQUEST));
            }
        });

        view.getSaveButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	// change username if necessary
				String newusername = view.getNameText().getText();
				if (!newusername.equals("") && !newusername.equals(user.getName())) {
					user.setName(newusername);
				}

				// check if stopword should be used and that the input field isn't empty
				if (view.getCheckbox().isSelected() && !view.getStopWordField().getText().equals("")) {
					// enable stopword
					String stopword = view.getStopWordField().getText();
					user.enableStopword(stopword, (int)Math.round(view.getSlider().getValue()));
				} else {
					// disable stopword
					user.disableStopword();
				}

				updateView();
				UserIO.writeUsersToFile();

				// close window and return to main menu
				view.getScene().getWindow().hide();
            }
        });

        // checkbox toggled, disable textfield and slider
        view.getCheckbox().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// see if it's currently active and flip it
				view.getStopWordField().setDisable(
						!(view.getStopWordField().isDisabled())
				);
				view.getSlider().setDisable(
						!(view.getSlider().isDisabled())
				);
			}
		});

    }

    private void updateView() {
    	// fill in username
		view.getNameText().setText(user.getName());

		if (user.getHasStopword()) {
			// check if the user has a stopword currently enabled
			view.getCheckbox().setSelected(true);

			view.getStopWordField().setText(user.getStopword());
			view.getSlider().setValue(user.getMinimumRequiredScoreToStop());
		} else {
			view.getStopWordField().setDisable(true);
			view.getSlider().setDisable(true);
		}
    }

    public void addWindowEventHandlers() {
        // window event handler for closing
        view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                final Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Are you sure?");
                alert.setContentText("All unsaved progress will be lost.");
                Optional<ButtonType> choice = alert.showAndWait();
                if (choice.get().getButtonData().isCancelButton()) {
                    event.consume();
                }
            }
        });
    }
}
