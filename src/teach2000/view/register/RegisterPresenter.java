package teach2000.view.register;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import teach2000.model.Login;
import teach2000.view.login.LoginPresenter;
import teach2000.view.login.LoginView;

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
				model.addUser(view.getAddName().getText());

				callbackLogin();
			}
		});
	}

	private void callbackLogin() {
		LoginView loginview = new LoginView();
		LoginPresenter presenter = new LoginPresenter(model, loginview);
		view.getScene().setRoot(loginview);
//		loginview.getScene().getWindow().sizeToScene();
	}

	private void updateView() {
		// not applicable here
	}
}
