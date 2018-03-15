package teach2000.view.login;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;
import teach2000.model.Login;
import teach2000.model.users.User;
import teach2000.model.users.UserList;
import teach2000.view.mainMenu.MainMenuPresenter;
import teach2000.view.mainMenu.MainMenuView;
import teach2000.view.register.RegisterPresenter;
import teach2000.view.register.RegisterView;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author demacryx on 25.02.2018.
 */
public class LoginPresenter {
    private Login model;
    private LoginView view;

    public LoginPresenter(Login model, LoginView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {
    	// login handler
        view.getLoginButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	// get index of user selected
				int userChosen = view.getUsers().getSelectionModel().getSelectedIndex();
				User u = UserList.getUsers().get(userChosen);

				try {
					MainMenuView mainMenuView = new MainMenuView();
					MainMenuPresenter presenter = new MainMenuPresenter(model, u, mainMenuView);
					view.getScene().setRoot(mainMenuView);
					mainMenuView.getScene().getWindow().setHeight(400);
					mainMenuView.getScene().getWindow().setWidth(800);
				} catch (IndexOutOfBoundsException ex) {
					System.out.println("No lists found.");
				}

            }
        });

        // register handler
		view.getRegisterButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				RegisterView registerView = new RegisterView();
				RegisterPresenter registerPresenter = new RegisterPresenter(model, registerView);
				view.getScene().setRoot(registerView);
				registerView.getScene().getWindow().setWidth(400);
				registerView.getScene().getWindow().setHeight(200);
			}
		});
    }

    private void updateView() {
    	// fill list in login view with users in model
		ArrayList<User> users = UserList.getUsers();
		// build list to display
		ObservableList<String> choices = FXCollections.observableArrayList();
		for (User u: users) {
			choices.add(u.getName());
		}

		this.view.getUsers().setItems(choices);
		this.view.getUsers().getSelectionModel().select(0);
    }

    public void addWindowEventHandlers() {
    	// window event handler for closing
		view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				final Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setHeaderText("Are you sure?");
				alert.setContentText("Are you sure you want to stop Teach2000?");
				Optional<ButtonType> choice = alert.showAndWait();
				if (choice.get().getButtonData().isCancelButton()) {
					event.consume();
				}
			}
		});
    }
}
