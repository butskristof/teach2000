package teach2000.view.mcTest;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

/**
 * @author demacryx on 25.02.2018 6:33 PM.
 * @project teach20002
 */
public class McView extends GridPane {
    ///////////////////Attributes/////////////////////
    private Label title, taalFrom, taalTo, word, extraText, score;
    private RadioButton alternative, alternative2, alternative3, antwoord;
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

    public Label getExtraText() {
        return extraText;
    }

    public Label getScore() {
        return score;
    }

    public MenuItem getAfsluiten() {
        return afsluiten;
    }

    public RadioButton getAlternative() {
        return alternative;
    }

    public RadioButton getAlternative2() {
        return alternative2;
    }

    public RadioButton getAlternative3() {
        return alternative3;
    }

    public RadioButton getAntwoord() {
        return antwoord;
    }

    ///////////////////Constructor/////////////////////
    public McView() {
        this.initializeNodes();
        this.layoutNodes();
    }

    ///////////////////Initializer/////////////////////
    private void initializeNodes() {
        ToggleGroup group = new ToggleGroup();

        title = new Label();
        taalFrom = new Label();
        taalTo = new Label();
        word = new Label();
        extraText = new Label("Extra");
        score = new Label("Score");
        alternative = new RadioButton("Alternative");
        alternative.setToggleGroup(group);
        alternative2 = new RadioButton("Alternative2");
        alternative2.setToggleGroup(group);
        alternative3 = new RadioButton("Alternative3");
        alternative3.setToggleGroup(group);
        antwoord = new RadioButton("Juist Antwoord");
        antwoord.setToggleGroup(group);

        this.afsluiten = new MenuItem("Exit");
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
        column2.setPercentWidth(43);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(6);
        ColumnConstraints column4 = new ColumnConstraints();
        column4.setPercentWidth(46);
        /*ColumnConstraints column5 = new ColumnConstraints();
        column5.setPercentWidth(1);*/

        this.getColumnConstraints().addAll(column1, column2, column3, column4);

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

        //multiple Choice
        this.add(alternative, 1, 6);
        GridPane.setConstraints(alternative,1,6,1,1,HPos.LEFT,VPos.CENTER,Priority.NEVER,Priority.NEVER);

        this.add(alternative2, 1, 7);
        GridPane.setConstraints(alternative2,1,7,1,1,HPos.LEFT,VPos.CENTER,Priority.NEVER,Priority.NEVER);

        this.add(alternative3, 1, 8);
        GridPane.setConstraints(alternative3,1,8,1,1,HPos.LEFT,VPos.CENTER,Priority.NEVER,Priority.NEVER);

        this.add(antwoord, 1, 9);
        GridPane.setConstraints(antwoord,1,9,1,1,HPos.LEFT,VPos.CENTER,Priority.NEVER,Priority.NEVER);

        //Extra Text Label
        this.add(extraText, 1, 10);
        this.extraText.setStyle("-fx-font-size: 12");
        GridPane.setConstraints(extraText, 1, 10, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        //Score Label
        this.add(score, 1, 11);
        this.score.setStyle("-fx-font-size: 12");
        GridPane.setConstraints(score, 1, 11, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);
    }

}
