package teach2000.view.writeTest;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 * @author demacryx on 25.02.2018 6:32 PM.
 * @project teach20002
 */
public class WriteView extends GridPane {
    ///////////////////Attributes/////////////////////
    private Label title;
    private Label taalFrom;
    private Label taalTo;
    private Label word;
    private TextField inputField;
    private Button okButton;
    private Label extraText;
    private Label score;
    private Label lblResult;

    private MenuItem afsluiten;


    ///////////////////Getters/////////////////////
    public Label getTitle() {
        return title;
    }

    public Label getTaalFrom() {
        return taalFrom;
    }

    public Label getTaalTo() {
        return taalTo;
    }

    public Label getWord() {
        return word;
    }

    public TextField getInputField() {
        return inputField;
    }

    public Button getOkButton() {
        return okButton;
    }

    public Label getExtraText() {
        return extraText;
    }

    public Label getScore() {
        return score;
    }

    public MenuItem getAfsluiten() {
        return afsluiten;
    }

    public Label getLblResult() {
        return lblResult;
    }

    ///////////////////Constructor/////////////////////
    public WriteView() {
        this.initializeNodes();
        this.layoutNodes();
    }

    ///////////////////Initializer/////////////////////
    private void initializeNodes() {
        title = new Label();
        taalFrom = new Label();
        taalTo = new Label();
        word = new Label();
        inputField = new TextField();
        okButton = new Button("OK");
        extraText = new Label("Extra");
        score = new Label("Score");
        this.lblResult = new Label("");

        this.afsluiten = new MenuItem("Close");
    }

    ///////////////////Layout/////////////////////
    private void layoutNodes() {
        //Menu
        final Menu bestandMenu = new
                Menu("File");
//        final Menu editMenu = new
//                Menu("Edit");
//        final Menu helpMenu = new
//                Menu("Help");
//        final Menu aboutMenu = new
//                Menu("About");
        bestandMenu.getItems().add(this.afsluiten);

        //MenuBar
        final MenuBar menuBar = new
//                MenuBar(bestandMenu, editMenu, helpMenu, aboutMenu);
                MenuBar(bestandMenu);
        this.add(menuBar, 0, 0, 5, 1);


        ///////////////////Grid Settings/////////////////////
        this.setGridLinesVisible(false);
        this.setAlignment(Pos.TOP_LEFT);

        //Vertical Gap
        this.setVgap(0);

        //Horizontal Gap
        this.setHgap(0);

        //Column Constraints
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(5);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(42);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(8);
        ColumnConstraints column4 = new ColumnConstraints();
        column4.setPercentWidth(45);
        /*ColumnConstraints column5 = new ColumnConstraints();
        column5.setPercentWidth(1);*/

        this.getColumnConstraints().addAll(column1, column2, column3, column4);

        //Row Constraints
        //Menu
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(8);
        row1.setValignment(VPos.TOP);
        //Title
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(15);
        //Empty
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(7);
        //Taal From
        RowConstraints row4 = new RowConstraints();
        row4.setPercentHeight(8);
        //Word
        RowConstraints row5 = new RowConstraints();
        row5.setPercentHeight(7);
        //Taal To
        RowConstraints row6 = new RowConstraints();
        row6.setPercentHeight(8);
        //Text Field
        RowConstraints row7 = new RowConstraints();
        row7.setPercentHeight(10);
        //Empty
        RowConstraints row8 = new RowConstraints();
        row8.setPercentHeight(8);
        //Extra Text
        RowConstraints row9 = new RowConstraints();
        row9.setPercentHeight(7);
        //Score
        RowConstraints row10 = new RowConstraints();
        row10.setPercentHeight(7);

        this.getRowConstraints().addAll(row1, row2, row3, row4, row5, row6, row7, row8, row9, row10);


        ///////////////////Elements Layout/////////////////////

        //title
        this.add(title, 1, 1);
        this.title.setStyle("-fx-font-size: 30");
        GridPane.setConstraints(title, 1, 1, 1, 1, HPos.LEFT, VPos.BOTTOM, Priority.NEVER, Priority.NEVER);

        //Taal From Label
        this.add(taalFrom, 1, 3);
        this.taalFrom.setStyle("-fx-font-size: 20");
        GridPane.setConstraints(taalFrom, 1, 3, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        //Word Label
        this.add(word, 1, 4);
        this.word.setStyle("-fx-font-size: 15");
        GridPane.setConstraints(word, 1, 4, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);
        word.setPadding(new Insets(0,0,0,15));

        //Taal To Label
        this.add(taalTo, 1, 5);
        this.taalTo.setStyle("-fx-font-size: 20");
        GridPane.setConstraints(taalTo, 1, 5, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        //Input Field
        this.add(inputField, 1, 6);
        this.inputField.setStyle("-fx-font-size: 15");
        GridPane.setConstraints(inputField, 1, 6, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        // Result label
        this.add(this.lblResult, 2, 4);
        GridPane.setConstraints(this.lblResult, 2, 4, 2, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        //OK Button
        this.add(okButton, 2, 6);
        this.okButton.setStyle("-fx-font-size: 15");
        GridPane.setConstraints(okButton, 2, 6, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        //Extra Text Label
        this.add(extraText, 1, 8);
        this.extraText.setStyle("-fx-font-size: 12");
        GridPane.setConstraints(extraText, 1, 8, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        //Score Label
        this.add(score, 1, 9);
        this.score.setStyle("-fx-font-size: 12");
        GridPane.setConstraints(score, 1, 9, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);
    }

}
