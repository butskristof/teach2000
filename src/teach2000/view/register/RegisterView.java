package teach2000.view.register;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

/**
 * @author demacryx on 25.02.2018 6:09 PM.
 */
public class RegisterView extends GridPane {
    private Button confirm, cancel;
    private TextField addName;


    public RegisterView() {
        this.initializeNodes();
        this.layoutNodes();
    }

    Button getConfirm() {
        return confirm;
    }

    Button getCancel() {
        return cancel;
    }

    TextField getAddName() {
        return addName;
    }

    private void initializeNodes() {
        this.confirm = new Button("OK");
        this.cancel = new Button("Cancel");
        this.addName = new TextField();
        this.addName.setPromptText("Enter name");
    }

    private void layoutNodes() {
        ///////////////////Grid Settings/////////////////////
        this.setGridLinesVisible(false);
        this.setAlignment(Pos.CENTER);

        //Horizontal Gap
        this.setHgap(10);

        //Vertical Gap
        this.setVgap(10);

        //Column Constraints
        ColumnConstraints column1 = new ColumnConstraints(150);
        ColumnConstraints column2 = new ColumnConstraints(150);
        this.getColumnConstraints().addAll(column1,column2);

        //Row Constraints
        RowConstraints rowConstraints = new RowConstraints(150);

        ///////////////////Elements Layout/////////////////////

        //TextField
        this.add(addName, 0, 0);
        //addName.setPrefWidth(50);
        GridPane.setConstraints(addName, 0, 0, 2, 1,
                HPos.CENTER, VPos.CENTER,
                Priority.NEVER, Priority.NEVER);

        //OK Button
        this.add(confirm, 0, 1);
        this.confirm.setPrefWidth(120);
        GridPane.setConstraints(confirm, 0, 1, 1, 1,
                HPos.RIGHT, VPos.CENTER,
                Priority.NEVER, Priority.NEVER);

        //Cancel Button
        this.add(cancel, 1, 1);
        this.cancel.setPrefWidth(120);
        GridPane.setConstraints(cancel, 1, 1, 1, 1,
                HPos.LEFT, VPos.CENTER,
                Priority.NEVER, Priority.NEVER);
    }
}