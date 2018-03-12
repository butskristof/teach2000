package teach2000.view.add;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

/**
 * @author demacryx on 12.03.2018 11:09 PM.
 * @project teach20002
 */
public class AddView extends GridPane {
    private TextField left1, left2, left3, left4, left5, left6, left7, left8, left9, left10;
    private TextField right1, right2, right3, right4, right5, right6, right7, right8, right9, right10;
    private TextField title;
    private TextField taalFrom, taalTo;
    private MenuItem afsluiten;

    AddView() {
        initialiserNodes();
        layoutNodes();
    }

    private void initialiserNodes() {
        left1 = new TextField();
        left2 = new TextField();
        left3 = new TextField();
        left4 = new TextField();
        left5 = new TextField();
        left6 = new TextField();
        left7 = new TextField();
        left8 = new TextField();
        left9 = new TextField();
        left10 = new TextField();
        right1 = new TextField();
        right2 = new TextField();
        right3 = new TextField();
        right4 = new TextField();
        right5 = new TextField();
        right6 = new TextField();
        right7 = new TextField();
        right8 = new TextField();
        right9 = new TextField();
        right10 = new TextField();
        title = new TextField();
        title.setPromptText("Title");
        taalFrom = new TextField();
        taalFrom.setPromptText("From");
        taalTo = new TextField();
        taalTo.setPromptText("To");
        this.afsluiten = new MenuItem("Exit");
    }

    private void layoutNodes() {
        //Menu
        final Menu bestandMenu = new
                Menu("File");
//        final Menu editMenu = new
//                Menu("Edit");
//        final Menu helpMenu = new
//                Menu("Help");
        final Menu aboutMenu = new
                Menu("About");
        bestandMenu.getItems().add(this.afsluiten);

        //MenuBar
        final MenuBar menuBar = new
//                MenuBar(bestandMenu, editMenu, helpMenu, aboutMenu);
                MenuBar(bestandMenu, aboutMenu);
        this.add(menuBar, 0, 0, 5, 1);


        ///////////////////Grid Settings/////////////////////
        this.setGridLinesVisible(true);
        this.setAlignment(Pos.TOP_LEFT);

        //Vertical Gap
        this.setVgap(0);

        //Horizontal Gap
        this.setHgap(0);

        //Column Constraints
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(5);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(45);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(45);
        ColumnConstraints column4 = new ColumnConstraints();
        column4.setPercentWidth(5);

        this.getColumnConstraints().addAll(column1, column2, column3,column4);

        //Row Constraints
        //Menu
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(8);
        //Title
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(10);
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
        //Background Image
        /*setBackground(new Background(new BackgroundImage(new Image("images/writeview.jpg"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));*/

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

        //Taal To Label
        this.add(taalTo, 1, 5);
        this.taalTo.setStyle("-fx-font-size: 20");
        GridPane.setConstraints(taalTo, 1, 5, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        //Input Field
        this.add(inputField, 1, 6);
        this.inputField.setStyle("-fx-font-size: 15");
        GridPane.setConstraints(inputField, 1, 6, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

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
