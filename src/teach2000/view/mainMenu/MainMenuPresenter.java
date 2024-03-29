package teach2000.view.mainMenu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import teach2000.Teach2000Exception;
import teach2000.model.Login;
import teach2000.model.users.User;
import teach2000.model.lists.List;
import teach2000.model.lists.ListIO;
import teach2000.view.add.AddPresenter;
import teach2000.view.add.AddView;
import teach2000.view.add.EditPresenter;
import teach2000.view.login.LoginPresenter;
import teach2000.view.login.LoginView;
import teach2000.view.selector.SelectorPresenter;
import teach2000.view.selector.SelectorView;
import teach2000.view.userConfig.UserPresenter;
import teach2000.view.userConfig.UserView;

import java.io.File;
import java.util.ArrayList;

/**
 * @author demacryx on 25.02.2018 7:12 PM.
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

		// FILE MENU

		// import list
		this.view.getImportList().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				FileChooser fc = new FileChooser();
				fc.setTitle("Select list file to import");
				File listToImport = fc.showOpenDialog(view.getScene().getWindow());

				if ((listToImport != null) && (!listToImport.getName().equals("")) && (listToImport.isFile())) {
					try {
						List importedList = ListIO.readList(listToImport);
						user.addList(importedList);
					} catch (Teach2000Exception ex) {
						final Alert alert = new Alert(Alert.AlertType.ERROR);
						alert.setTitle("Import failed");
						alert.setHeaderText("Unable to import list");
						alert.setContentText(ex.getMessage());
						alert.showAndWait();
					}
				}

				updateView();
			}
		});

		// export list
		this.view.getExportList().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// get selected table entry
				Object object =  view.getTable().getSelectionModel().selectedItemProperty().get();
				int index = view.getTable().getSelectionModel().selectedIndexProperty().get();
				if (index == -1) {
					// ignore if nothing selected in table
					final Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText("Geen lijst geselecteerd");
					alert.showAndWait();
					event.consume();
				} else {
					// open file chooser
					FileChooser fileChooser = new FileChooser();
					File toSave = fileChooser.showSaveDialog(view.getScene().getWindow());
					if ((toSave == null) || (toSave.getName().equals(""))) {
						// break if canceled
						event.consume();
					} else {
						// get list from user
						List listToSave = user.getList(index);

						// call ListIO and let it write to file
						try {
							ListIO.writeList(toSave, listToSave);
						} catch (Teach2000Exception ex) {
							final Alert alert = new Alert(Alert.AlertType.ERROR);
							alert.setTitle("Import failed");
							alert.setHeaderText("Unable to import list");
							alert.setContentText(ex.getMessage());
							alert.showAndWait();
						}
					}
				}

			}
		});

		// exit from menu item
		this.view.getAfsluiten().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// we send a close request so the same code can be re-used
				view.getScene().getWindow().fireEvent(new WindowEvent(view.getScene().getWindow(), WindowEvent.WINDOW_CLOSE_REQUEST));
			}
		});

		// EDIT MENU

		// edit currently selected list
		this.view.getEdit().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// get selected list
				Object object =  view.getTable().getSelectionModel().selectedItemProperty().get();
				int index = view.getTable().getSelectionModel().selectedIndexProperty().get();
				if (index == -1) {
					// ignore if nothing selected in table
					final Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText("Geen lijst geselecteerd");
					alert.showAndWait();
					event.consume();
					event.consume();
				} else {
					List listToEdit = user.getList(index);

					//open new window to create new wordlist
					// make selector view and presenter
					AddView addView = new AddView();
					EditPresenter presenter = new EditPresenter(user, listToEdit, addView);

					// create new window for adding lists
					Stage stage = new Stage();
					stage.initOwner(view.getScene().getWindow());
					stage.setScene(new Scene(addView));
					stage.setHeight(600);
					stage.setWidth(800);
					presenter.addWindowEventHandlers();

					// show new window and pause current window
					stage.showAndWait();

					// refresh list after returning from add window
					updateView();
				}

			}
		});

		// add new list
		this.view.getAdd().setOnAction(new EventHandler<ActionEvent>() {
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

				addPresenter.addWindowEventHandlers();

				// show new window and pause current window
				stage.showAndWait();

				// refresh list after returning from add window
				updateView();
			}
		});

		// remove selected list
		this.view.getRemove().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// get index of selected row which is the same as the list index
				Object object =  view.getTable().getSelectionModel().selectedItemProperty().get();
				int index = view.getTable().getSelectionModel().selectedIndexProperty().get();

				if (index == -1) {
					// ignore if nothing selected in table
					final Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText("Geen lijst geselecteerd");
					alert.showAndWait();
					event.consume();
					event.consume();
				} else {
					try {
						user.removeList(index);
					} catch (Teach2000Exception ex) {
						final Alert alert = new Alert(Alert.AlertType.ERROR);
						alert.setTitle("Import failed");
						alert.setHeaderText("Unable to import list");
						alert.setContentText(ex.getMessage());
						alert.showAndWait();
					}

					updateView();
				}

			}
		});

		// USER MENU

		// delete current logged in user
		this.view.getDeleteUser().setOnAction(new EventHandler<ActionEvent>() {
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

		// log out current user and go back to login view
		this.view.getLogoutUser().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// go back to login view
				Login model = new Login();
				LoginView loginview = new LoginView();
				LoginPresenter presenter = new LoginPresenter(model, loginview);

				view.getScene().setRoot(loginview);
			}
		});

		// configuration
		this.view.getUserConfiguration().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				UserView userView = new UserView();
				UserPresenter userPresenter = new UserPresenter(user, userView);

				// create new window for adding lists

				Stage stage = new Stage();
				stage.initOwner(view.getScene().getWindow());
				stage.setScene(new Scene(userView));
				stage.setHeight(300);
				stage.setWidth(500);

				userPresenter.addWindowEventHandlers();

				// show new window and pause current window
				stage.showAndWait();
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

					if (index == -1) {
						// ignore if nothing selected
						final Alert alert = new Alert(Alert.AlertType.ERROR);
						alert.setHeaderText("Geen lijst geselecteerd");
						alert.showAndWait();
						event.consume();
						event.consume();
					} else {
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
			}
		});

	}

	private void updateView () {
		this.view.getTable().getItems().clear();
		this.lists.clear();

		ArrayList<List> userlists = this.user.getLists();
		for (List l : userlists) {
			// convert to Observable ArrayList for View
			this.lists.add(l);
		}

		this.view.getTable().setItems(this.lists);
	}
}