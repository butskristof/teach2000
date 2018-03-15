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
 * @project teach20002
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
                event.consume();
            }
        });

        view.getSaveButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

    }

    private void updateView() {

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
