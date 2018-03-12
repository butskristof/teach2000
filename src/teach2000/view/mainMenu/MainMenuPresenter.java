package teach2000.view.mainMenu;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import teach2000.model.AntwoordInvullen;
import teach2000.model.Login;
import teach2000.model.User;
import teach2000.model.UserList;
import teach2000.model.lists.List;
import teach2000.model.lists.ListIO;
import teach2000.view.selector.SelectorPresenter;
import teach2000.view.selector.SelectorView;
import teach2000.view.writeTest.WritePresenter;
import teach2000.view.writeTest.WriteView;


import java.io.File;
import java.util.ArrayList;
import java.util.Optional;

/**
 * @author demacryx on 25.02.2018 7:12 PM.
 * @project teach20002
 */
public class MainMenuPresenter {
	private UserList userList;
    private User user;
    private MainMenuView view;
    private ObservableList<List> lists = FXCollections.observableArrayList();

    public MainMenuPresenter(User user, MainMenuView view) {
        this.user = user;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {
    	view.getDeleteUser().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//delete user account
				userList.removeUser(user);
			}
		});


        // exit from menu
        view.getAfsluiten().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	// we send a close request so the same code can be re-used
            	view.getScene().getWindow().fireEvent(new WindowEvent(view.getScene().getWindow(), WindowEvent.WINDOW_CLOSE_REQUEST));
            }
        });

        // import list
		this.view.getImportList().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				FileChooser fc = new FileChooser();
				fc.setTitle("Select list file to import");
				File listToImport = fc.showOpenDialog(view.getScene().getWindow());

				if ((listToImport != null) && (!listToImport.getName().equals("")) && (listToImport.isFile())) {
					List importedList = ListIO.readList(listToImport);
					user.addList(importedList);
				}

				updateView();
			}
		});

		// remove list
		this.view.getRemove().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// get index of selected row which is the same as the list index
				Object object =  view.getTable().getSelectionModel().selectedItemProperty().get();
				int index = view.getTable().getSelectionModel().selectedIndexProperty().get();

				user.removeList(index);

				updateView();
			}
		});

        // handle click on table
		// get selected row, make new window for tests
        view.getTable().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2){
                	// get index of selected row which is the same as the list index
					Object object =  view.getTable().getSelectionModel().selectedItemProperty().get();
					int index = view.getTable().getSelectionModel().selectedIndexProperty().get();

					// make selector view and presenter
                    SelectorView selectorView = new SelectorView();
					SelectorPresenter selectorPresenter = new SelectorPresenter(selectorView, user, index);

					// create new windows for selection of type and the test itself
					Stage stage = new Stage();
					stage.initOwner(view.getScene().getWindow());
					stage.setScene(new Scene(selectorView));

					// show new window and pause current window
					stage.showAndWait();
                }
            }
        });

    }

	private void updateView () {
		this.view.getTable().getItems().clear();
		this.lists.clear();

		ArrayList<List> userlists = this.user.getLists();
		for (List l : userlists) {
			this.lists.add(l);
		}

		this.view.getTable().setItems(this.lists);
	}
}
