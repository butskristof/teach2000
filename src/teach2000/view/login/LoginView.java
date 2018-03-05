package teach2000.view.login;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import teach2000.model.UserList;

/**
 * @author demacryx on 25.02.2018.
 * @project teach2000
 */
public class LoginView extends GridPane {
    ///////////////////Attributes/////////////////////
    private ComboBox<String> users;
    private Button loginButton, registerButton;
    private Label explanationLabel;

    ///////////////////Getters/////////////////////
	Button getLoginButton() {
        return loginButton;
    }

    Button getRegisterButton() {
        return registerButton;
    }
    ///////////////////Constructor/////////////////////
    public LoginView() {
        this.initializeNodes();
        this.layoutNodes();
    }

	ComboBox<String> getUsers() {
		return users;
	}

	///////////////////Initializer/////////////////////
    private void initializeNodes() {
        this.users = new ComboBox<>();
//        ObservableList<String> names = FXCollections.observableArrayList("Default");
//        this.users.setItems(names);
//        this.users.getSelectionModel().select(0);
        this.loginButton = new Button("Login");
        this.registerButton = new Button("Register");
        this.explanationLabel = new Label("To add a new user press the Register button");
    }

    ///////////////////Layout/////////////////////
    private void layoutNodes() {
        ///////////////////Grid Settings/////////////////////
        this.setGridLinesVisible(false);
        this.setAlignment(Pos.CENTER);

        //Vertical Gap
        this.setVgap(10);

        //Horizontal Gap
        this.setHgap(10);

        //Column Constraints
        ColumnConstraints column1 = new ColumnConstraints(200);
        ColumnConstraints column2 = new ColumnConstraints(200);
        this.getColumnConstraints().addAll(column1, column2);

        //Row Constraints
        RowConstraints rowConstraints = new RowConstraints(200);

        ///////////////////Elements Layout/////////////////////

        //Label at Top
        this.add(explanationLabel, 0, 0);
        GridPane.setConstraints(explanationLabel, 0, 0, 2, 1,
                HPos.CENTER, VPos.CENTER,
                Priority.NEVER, Priority.NEVER);

        //BoxList
        this.add(users, 0, 1);
        users.setPrefWidth(250);
        GridPane.setConstraints(users, 0, 1, 2, 1,
                HPos.CENTER, VPos.CENTER,
                Priority.ALWAYS, Priority.NEVER);

        //Login Button
        this.add(loginButton, 0, 2);
        loginButton.setPrefWidth(120);
        GridPane.setConstraints(loginButton, 0, 2, 1, 1,
                HPos.RIGHT, VPos.CENTER,
                Priority.NEVER, Priority.NEVER);

        //Register Button
        this.add(registerButton, 1, 2);
        registerButton.setPrefWidth(120);
        GridPane.setConstraints(registerButton, 1, 2, 1, 1,
                HPos.LEFT, VPos.CENTER,
                Priority.NEVER, Priority.NEVER);
    }
}
