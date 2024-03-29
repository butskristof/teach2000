package teach2000.view.writeTest;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 * @author demacryx on 25.02.2018 6:32 PM.
 */
public class WriteView extends GridPane {
    private Label title,taalFrom,taalTo,word;
    private TextField inputField;
    private Button okButton;
    private Label extraText,score,lblResult;


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

    public Label getLblResult() {
        return lblResult;
    }


    public WriteView() {
        this.initializeNodes();
        this.layoutNodes();
    }

    ///////////////////Initializer/////////////////////
    private void initializeNodes() {
        this.title = new Label();
        this.taalFrom = new Label();
        this.taalTo = new Label();
        this.word = new Label();
        this.inputField = new TextField();
        this.okButton = new Button("OK");
        this.extraText = new Label("Extra");
        this.score = new Label("Score");
        this.lblResult = new Label("");
    }

    ///////////////////Layout/////////////////////
    private void layoutNodes() {

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
        GridPane.setConstraints(title, 1, 1, 1, 1,
                HPos.LEFT, VPos.BOTTOM,
                Priority.NEVER, Priority.NEVER);

        //Taal From Label
        this.add(taalFrom, 1, 3);
        this.taalFrom.setStyle("-fx-font-size: 20");
        GridPane.setConstraints(taalFrom, 1, 3, 1, 1,
                HPos.LEFT, VPos.CENTER,
                Priority.NEVER, Priority.NEVER);

        //Word Label
        this.add(word, 1, 4);
        this.word.setStyle("-fx-font-size: 15");
        this.word.setPadding(new Insets(0,0,0,15));
        GridPane.setConstraints(word, 1, 4, 1, 1,
                HPos.LEFT, VPos.CENTER,
                Priority.NEVER, Priority.NEVER);


        //Taal To Label
        this.add(taalTo, 1, 5);
        this.taalTo.setStyle("-fx-font-size: 20");
        GridPane.setConstraints(taalTo, 1, 5, 1, 1,
                HPos.LEFT, VPos.CENTER,
                Priority.NEVER, Priority.NEVER);

        //Input Field
        this.add(inputField, 1, 6);
        this.inputField.setStyle("-fx-font-size: 15");
        GridPane.setConstraints(inputField, 1, 6, 1, 1,
                HPos.LEFT, VPos.CENTER,
                Priority.NEVER, Priority.NEVER);

        // Result label
        this.add(this.lblResult, 2, 4);
        GridPane.setConstraints(this.lblResult, 2, 4, 2, 1,
                HPos.LEFT, VPos.CENTER,
                Priority.NEVER, Priority.NEVER);

        //OK Button
        this.add(okButton, 2, 6);
        this.okButton.setStyle("-fx-font-size: 15");
        GridPane.setConstraints(okButton, 2, 6, 1, 1,
                HPos.LEFT, VPos.CENTER,
                Priority.NEVER, Priority.NEVER);

        //Extra Text Label
        this.add(extraText, 1, 8);
        this.extraText.setStyle("-fx-font-size: 12");
        GridPane.setConstraints(extraText, 1, 8, 1, 1,
                HPos.LEFT, VPos.CENTER,
                Priority.NEVER, Priority.NEVER);

        //Score Label
        this.add(score, 1, 9);
        this.score.setStyle("-fx-font-size: 12");
        GridPane.setConstraints(score, 1, 9, 1, 1,
                HPos.LEFT, VPos.CENTER,
                Priority.NEVER, Priority.NEVER);
    }

}
