package teach2000.view.login;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import teach2000.model.Login;
import teach2000.view.mainMenu.MainMenuPresenter;
import teach2000.view.mainMenu.MainMenuView;

/**
 * @author demacryx on 25.02.2018.
 * @project teach20002
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
        view.getLoginButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainMenuView mainMenuView = new MainMenuView();
                MainMenuPresenter mainMenuPresenter =
                        new MainMenuPresenter(model,mainMenuView);
                view.getScene().setRoot(mainMenuView);
                mainMenuView.getScene().getWindow().sizeToScene();
            }
        });
    }

    private void updateView() {

    }

    public void addWindowEventHandlers() {

    }
}
