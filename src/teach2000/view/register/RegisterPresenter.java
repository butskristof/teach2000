package teach2000.view.register;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import teach2000.model.Login;
import teach2000.view.login.LoginPresenter;
import teach2000.view.login.LoginView;

import java.util.Optional;

/**
 * @author demacryx on 25.02.2018 6:08 PM.
 * @project teach20002
 */
public class RegisterPresenter {
	private Login model;
	private RegisterView view;

	public RegisterPresenter(Login model, RegisterView view) {
		this.model = model;
		this.view = view;
		this.addEventHandlers();
		this.updateView();
	}

	private void addEventHandlers() {
		// cancel
		view.getCancel().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// go back to login view
				callbackLogin();
			}
		});

		// add user
		view.getConfirm().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// add user
				//User cannot be added if name field is empty.
				if (view.getAddName().getText().isEmpty()) {
					final Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
					alert.setHeaderText("No Name");
					alert.setContentText("Please fill in a name!");
					Optional<ButtonType> choice = alert.showAndWait();
					if (choice.get().getButtonData().isCancelButton()) {
						event.consume();
					}
				}else {
					model.addUser(view.getAddName().getText());
					callbackLogin();
				}
			}
		});
	}

	private void callbackLogin() {
		LoginView loginview = new LoginView();
		LoginPresenter presenter = new LoginPresenter(model, loginview);
		view.getScene().setRoot(loginview);
		loginview.getScene().getWindow().setHeight(300);
		loginview.getScene().getWindow().setWidth(500);
	}

	private void updateView() {
		// not applicable here
	}
}
