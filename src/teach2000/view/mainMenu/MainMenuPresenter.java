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
import javafx.stage.Stage;
import teach2000.model.AntwoordInvullen;
import teach2000.model.Login;
import teach2000.model.User;
import teach2000.model.lists.List;
import teach2000.view.selector.SelectorPresenter;
import teach2000.view.selector.SelectorView;
import teach2000.view.writeTest.WritePresenter;
import teach2000.view.writeTest.WriteView;


import java.util.ArrayList;
import java.util.Optional;

/**
 * @author demacryx on 25.02.2018 7:12 PM.
 * @project teach20002
 */
public class MainMenuPresenter {

    private User user;
    private MainMenuView view;
	private SelectorView selectorView;
    private ObservableList<List> lists = FXCollections.observableArrayList();

    public MainMenuPresenter(User user, MainMenuView view) {
        this.user = user;
        this.view = view;
        addEventHandlers();
        initialiseView();
        updateView();
    }

    private void addEventHandlers() {
        // exit from menu
        view.getAfsluiten().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Are you sure??");
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
        private void initialiseView(){
    	/*for (List l: this.user.getLists()) {
    		this.view.addLabel(l.getTitle());
		}*/

            ArrayList<List> userlists = this.user.getLists();
            for (List l : userlists) {
                this.lists.add(l);
            }

            this.view.getTable().setItems(this.lists);
        }

        private void updateView () {
    /*	this.view.updateLabels();
    }*/
        }
    }
