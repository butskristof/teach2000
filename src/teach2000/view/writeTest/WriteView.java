package teach2000.view.writeTest;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

/**
 * @author demacryx on 25.02.2018 6:32 PM.
 * @project teach20002
 */
public class WriteView extends GridPane{
    ///////////////////Attributes/////////////////////
    private Label title, taal1, woord, taal2,empty;
    private TextField textField;
    private Button button;

    ///////////////////Getters/////////////////////
    public Label getTitle() {
        return title;
    }

    public Label getTaal1() {
        return taal1;
    }

    public Label getWoord() {
        return woord;
    }

    public Label getTaal2() {
        return taal2;
    }

    public TextField getTextField() {
        return textField;
    }

    public Button getButton() {
        return button;
    }

    ///////////////////Constructor/////////////////////
    public WriteView() {
        this.initializeNodes();
        this.layoutNodes();
    }

    ///////////////////Initializer/////////////////////
    private void initializeNodes() {
        this.button = new Button("OK");
        this.taal1 = new Label("Nederlands");
        this.taal2=new Label("Engels");
        this.textField = new TextField();
        this.woord = new Label("\"TestWoord\"");
        this.title = new Label("Nederlands - Engels");
        this.empty = new Label();
    }

    ///////////////////Layout/////////////////////
    private void layoutNodes() {
        ///////////////////Grid Settings/////////////////////
        this.setGridLinesVisible(true);
        this.setAlignment(Pos.TOP_LEFT);

        //Vertical Gap
        this.setVgap(10);

        //Horizontal Gap
        this.setHgap(10);

        //Column Constraints
        ColumnConstraints column1 = new ColumnConstraints();column1.setPercentWidth(5.0);
        ColumnConstraints column2 = new ColumnConstraints();column2.setPercentWidth(65.0);
        ColumnConstraints column3 = new ColumnConstraints();column3.setPercentWidth(30.0);
        this.getColumnConstraints().addAll(column1, column2,column3);

        //Row Constraints
        RowConstraints rowConstraints1 = new RowConstraints();rowConstraints1.setPercentHeight(5.0);
        this.getRowConstraints().addAll(rowConstraints1);

        ///////////////////Elements Layout/////////////////////

        //Title
        this.add(title, 1, 1);
        GridPane.setConstraints(title, 1, 1, 1, 1,
                HPos.LEFT, VPos.TOP,
                Priority.NEVER, Priority.NEVER);
        title.setFont(new Font("Arial",50));

        /*this.add(empty, 0, 2);
        GridPane.setConstraints(empty, 0, 2, 1, 1,
                HPos.LEFT, VPos.TOP,
                Priority.NEVER, Priority.NEVER);
        empty.setFont(new Font("Arial",30));
*/
        this.add(taal1,1,3);
        GridPane.setConstraints(taal1,1,3,1,1,
                HPos.LEFT,VPos.TOP,
                Priority.NEVER, Priority.NEVER);
        taal1.setFont(new Font("Arial",20));

        this.add(woord,1,4);
        GridPane.setConstraints(woord,1,4,1,1,
                HPos.LEFT,VPos.TOP,
                Priority.NEVER, Priority.NEVER);
        woord.setFont(new Font("Arial",30));

        this.add(taal2,1,5);
        GridPane.setConstraints(taal2,1,5,1,1,
                HPos.LEFT,VPos.TOP,
                Priority.NEVER, Priority.NEVER);
        taal2.setFont(new Font("Arial",20));

        this.add(textField,1,6);
        GridPane.setConstraints(textField,1,6,1,1,
                HPos.LEFT,VPos.TOP,
                Priority.NEVER, Priority.NEVER);

        this.add(button,2,6);
        GridPane.setConstraints(button,2,6,1,1,
                HPos.LEFT,VPos.TOP,
                Priority.NEVER, Priority.NEVER);
    }
}
