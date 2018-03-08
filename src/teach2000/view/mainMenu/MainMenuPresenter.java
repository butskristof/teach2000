package teach2000.view.mainMenu;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import teach2000.model.Login;
import teach2000.model.User;
import teach2000.model.lists.List;

import java.util.Optional;

/**
 * @author demacryx on 25.02.2018 7:12 PM.
 * @project teach20002
 */
public class MainMenuPresenter {
    private User user;
    private MainMenuView view;

    public MainMenuPresenter(User user, MainMenuView view) {
        this.user = user;
        this.view = view;
        addEventHandlers();
        initialiseView();
        updateView();
    }

    private void addEventHandlers() {
        // exit from menu
//		view.getAfsluiten().setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent event) {
//				final Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//				alert.setHeaderText("Are you sure?");
//				alert.setContentText("Are you sure you want to stop Teach2000?");
//				Optional<ButtonType> choice = alert.showAndWait();
//				if (choice.get().getButtonData().isCancelButton()) {
//					event.consume();
//				} else {
//					// stop application
//					// should be extended with closing best practices
//					Platform.exit();
//				}
//			}
//		});
    }

    private void initialiseView() {
    	for (List l: this.user.getLists()) {
    		this.view.addLabel(l.getTitle());
		}
	}

    private void updateView() {
    	this.view.updateLabels();
    }
}
