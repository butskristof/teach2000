package teach2000.view.selector;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.input.MouseEvent;
import teach2000.model.*;
import teach2000.view.mainMenu.MainMenuView;
import teach2000.view.mcTest.McPresenter;
import teach2000.view.mcTest.McView;
import teach2000.view.writeTest.WritePresenter;
import teach2000.view.writeTest.WriteView;


/**
 * @author demacryx on 12.03.2018 12:14 AM.
 * @project teach20002
 */
public class SelectorPresenter {
    private SelectorView view;
    private User selectedUser;
    private int selectedList;

    public SelectorPresenter(SelectorView view, User u, int listindex) {
        this.view = view;
        this.selectedUser = u;
        this.selectedList = listindex;
        this.addEventHandlers();
        this.updateView();
    }



    private void addEventHandlers() {
        this.view.getMultiplechoice().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// start mutliple choice test
				// create model with passed in user and list index
				MultipleChoice mc = new MultipleChoice(selectedUser.getList(selectedList));

				// create view and presenter
				McView mcView = new McView();
				McPresenter presenter = new McPresenter(mc, mcView);
				// replace current view with test window
				view.getScene().setRoot(mcView);
				mcView.getScene().getWindow().sizeToScene();
			}
		});

        this.view.getWrite().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// start write
				// create model with passed in user and list index
				AntwoordInvullen ai = new AntwoordInvullen(selectedUser.getList(selectedList));

				// create view and presenter
				WriteView writeView = new WriteView();
				WritePresenter presenter = new WritePresenter(ai, writeView);
				// replace the current view with the test window
				view.getScene().setRoot(writeView);
				writeView.getScene().getWindow().sizeToScene();
			}
		});
    }

    private void updateView() {
        // not applicable here
    }
}
