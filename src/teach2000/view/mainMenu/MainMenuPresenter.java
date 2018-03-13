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
import sun.rmi.runtime.Log;
import teach2000.model.AntwoordInvullen;
import teach2000.model.Login;
import teach2000.model.User;
import teach2000.model.UserList;
import teach2000.model.lists.List;
import teach2000.model.lists.ListIO;
import teach2000.view.add.AddPresenter;
import teach2000.view.add.AddView;
import teach2000.view.login.LoginPresenter;
import teach2000.view.login.LoginView;
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
	private Login loginmodel;
    private User user;
    private MainMenuView view;
    private ObservableList<List> lists = FXCollections.observableArrayList();

    public MainMenuPresenter(Login loginmodel, User user, MainMenuView view) {
    	this.loginmodel = loginmodel;
        this.user = user;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {
    	view.getAdd().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//open new window to create new wordlist
				// make selector view and presenter
				AddView addView = new AddView();
				AddPresenter addPresenter = new AddPresenter(user, addView);

				// create new window for adding lists
				Stage stage = new Stage();
				stage.initOwner(view.getScene().getWindow());
				stage.setScene(new Scene(addView));
				stage.setHeight(600);
				stage.setWidth(800);

				// show new window and pause current window
				stage.showAndWait();

				// refresh list after returning from add window
				updateView();
			}
		});

    	view.getDeleteUser().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//delete user account
				loginmodel.getUsers().removeUser(user);
				// go back to login view
				Login model = new Login();
				LoginView loginview = new LoginView();
				LoginPresenter presenter = new LoginPresenter(model, loginview);

				view.getScene().setRoot(loginview);
			}
		});

    	view.getLogoutUser().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// go back to login view
				Login model = new Login();
				LoginView loginview = new LoginView();
				LoginPresenter presenter = new LoginPresenter(model, loginview);

				view.getScene().setRoot(loginview);
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
                	// TODO ignore if no item is selected
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
//					selectorView.getScene().getWindow().setWidth(400);
//					selectorView.getScene().getWindow().setHeight(200);
					stage.setWidth(400);
					stage.setHeight(200);
					stage.setResizable(false);

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
