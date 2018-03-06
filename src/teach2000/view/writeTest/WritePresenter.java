package teach2000.view.writeTest;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import teach2000.model.AntwoordInvullen;
import teach2000.model.Login;

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
	}

	private void updateView() {
		this.view.getTitle().setText(model.getList().getTitle());
	}
}
