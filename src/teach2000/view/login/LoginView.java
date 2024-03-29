package teach2000.view.login;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 * @author demacryx on 25.02.2018.
 */
public class LoginView extends GridPane {
    private ComboBox<String> users;
    private Button loginButton, registerButton;
    private Label explanationLabel, titleLabel;
	public LoginView() {
		this.initializeNodes();
		this.layoutNodes();
	}

    ///////////////////Getters/////////////////////
	Button getLoginButton() {
        return loginButton;
    }

    Button getRegisterButton() {
        return registerButton;
    }

	ComboBox<String> getUsers() {
		return users;
	}

	///////////////////Initializer/////////////////////
    private void initializeNodes() {
        this.users = new ComboBox<>(); // will be filled by presenter
        this.loginButton = new Button("Login");
        this.registerButton = new Button("Register");
        this.explanationLabel = new Label("To add a new user press the Register button");
        this.titleLabel = new Label("Teach2000");
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

        ///////////////////Elements Layout/////////////////////

		// TITLE
		this.add(this.titleLabel, 0, 0);
		this.titleLabel.setStyle("-fx-font-size: 50");
		GridPane.setConstraints(this.titleLabel, 0, 0, 2, 1,
                HPos.CENTER, VPos.CENTER,
                Priority.NEVER, Priority.NEVER);

        //Label at Top
        this.add(explanationLabel, 0, 1);
        GridPane.setConstraints(explanationLabel, 0, 1, 2, 1,
                HPos.CENTER, VPos.CENTER,
                Priority.NEVER, Priority.NEVER);

        //BoxList
        this.add(users, 0, 2);
        this.users.setPrefWidth(250);
        GridPane.setConstraints(users, 0, 2, 2, 1,
                HPos.CENTER, VPos.CENTER,
                Priority.ALWAYS, Priority.NEVER);

        //Login Button
        this.add(loginButton, 0, 3);
        this.loginButton.setPrefWidth(120);
        GridPane.setConstraints(loginButton, 0, 3, 1, 1,
                HPos.RIGHT, VPos.CENTER,
                Priority.NEVER, Priority.NEVER);

        //Register Button
        this.add(registerButton, 1, 3);
        this.registerButton.setPrefWidth(120);
        GridPane.setConstraints(registerButton, 1, 3, 1, 1,
                HPos.LEFT, VPos.CENTER,
                Priority.NEVER, Priority.NEVER);

    }
}
