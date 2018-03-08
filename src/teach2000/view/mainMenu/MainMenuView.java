package teach2000.view.mainMenu;


import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import teach2000.model.User;
import teach2000.model.lists.List;

import java.util.ArrayList;

/**
 * @author demacryx on 25.02.2018 7:11 PM.
 * @project teach20002
 */
public class MainMenuView extends GridPane {
    ///////////////////Attributes/////////////////////
    private Label lijsten;
    private Button toevoegen, verweideren, bewerken;
//    private final TableView;
	private ArrayList<Label> labels;

    ///////////////////Constructor/////////////////////
    public MainMenuView() {
        this.initializeNodes();
        this.layoutNodes();
    }

    ///////////////////Getters/////////////////////

	public void addLabel(String lblText) {
    	this.labels.add(new Label(lblText));
	}

	///////////////////Initializer/////////////////////
    private void initializeNodes() {
		this.labels = new ArrayList<>();
    }

    ///////////////////Layout/////////////////////

	public void updateLabels() {
    	this.getChildren().addAll(this.labels);
	}

    private void layoutNodes() {
        ///////////////////Grid Settings/////////////////////
        this.setGridLinesVisible(true);
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

//        //Label at Top
//        this.add(explanationLabel, 0, 0);
//        GridPane.setConstraints(explanationLabel, 0, 0, 2, 1,
//                HPos.CENTER, VPos.CENTER,
//                Priority.NEVER, Priority.NEVER);
//
//        //BoxList
//        this.add(users, 0, 1);
//        users.setPrefWidth(250);
//        GridPane.setConstraints(users, 0, 1, 2, 1,
//                HPos.CENTER, VPos.CENTER,
//                Priority.ALWAYS, Priority.NEVER);
//
//        //Login Button
//        this.add(loginButton, 0, 2);
//        loginButton.setPrefWidth(120);
//        GridPane.setConstraints(loginButton, 0, 2, 1, 1,
//                HPos.RIGHT, VPos.CENTER,
//                Priority.NEVER, Priority.NEVER);
//
//        //Register Button
//        this.add(registerButton, 1, 2);
//        registerButton.setPrefWidth(120);
//        GridPane.setConstraints(registerButton, 1, 2, 1, 1,
//                HPos.LEFT, VPos.CENTER,
//                Priority.NEVER, Priority.NEVER);
    }
}
