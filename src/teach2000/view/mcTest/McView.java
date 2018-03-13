package teach2000.view.mcTest;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;

/**
 * @author demacryx on 25.02.2018 6:33 PM.
 * @project teach20002
 */
public class McView extends GridPane {
    ///////////////////Attributes/////////////////////
    private Label title, taalFrom, taalTo, word, extraText, score;
    ArrayList<RadioButton> radioButtons = new ArrayList<>();
    private Button okButton;
    private MenuItem afsluiten;

    private Label lblResult;

    private ToggleGroup toggleGroup;

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

    public Button getOkButton() {
        return okButton;
    }

    public ToggleGroup getToggleGroup() {
        return toggleGroup;
    }

	public Label getLblResult() {
		return lblResult;
	}

	///////////////////Constructor/////////////////////
    public McView() {
        this.initializeNodes();
        this.layoutNodes();
    }

    ///////////////////Initializer/////////////////////
    private void initializeNodes() {
        title = new Label();
        taalFrom = new Label();
        taalTo = new Label();
        word = new Label();
        extraText = new Label("Extra");
        score = new Label("Score");

        this.lblResult = new Label("");

        this.afsluiten = new MenuItem("Exit");

        this.okButton = new Button("SUMBIT");
    }

    ///////////////////Layout/////////////////////
    private void layoutNodes() {
        //Menu
        final Menu bestandMenu = new
                Menu("File");
        final Menu aboutMenu = new
                Menu("About");
        bestandMenu.getItems().add(this.afsluiten);

        //MenuBar
        final MenuBar menuBar = new MenuBar(bestandMenu, aboutMenu);
        this.add(menuBar, 0, 0, 5, 1);

        ///////////////////Grid Settings/////////////////////
        this.setGridLinesVisible(false);
        this.setAlignment(Pos.TOP_LEFT);

        //Vertical Gap
        this.setVgap(5);

        //Horizontal Gap
        this.setHgap(5);

        //Column Constraints
        ColumnConstraints column0 = new ColumnConstraints();
        column0.setPercentWidth(10);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(40);
       /* ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(5);*/
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(40);
        ColumnConstraints column4 = new ColumnConstraints();
        column4.setPercentWidth(10);

        this.getColumnConstraints().addAll(column0, column1, column3, column4);

        //Row Constraints
        //Menu
        RowConstraints row0 = new RowConstraints();
        row0.setPercentHeight(8);
        row0.setValignment(VPos.TOP);
        //Title
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(15);
        //Empty
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(7);
        //Taal From
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(8);
        //Word
        RowConstraints row4 = new RowConstraints();
        row4.setPercentHeight(7);
        //Taal To
        RowConstraints row5 = new RowConstraints();
        row5.setPercentHeight(8);
        //Text Field
        RowConstraints row6 = new RowConstraints();
        row6.setPercentHeight(10);
        //Empty
        RowConstraints row7 = new RowConstraints();
        row7.setPercentHeight(8);
        //Extra Text
        RowConstraints row8 = new RowConstraints();
        row8.setPercentHeight(7);
        //Score
        RowConstraints row9 = new RowConstraints();
        row9.setPercentHeight(7);

        this.getRowConstraints().addAll(row0, row1, row2, row3, row4, row5, row6, row7, row8, row9);


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
        title.setPadding(new Insets(20,0,0,0));

        //Taal From Label
        this.add(taalFrom, 1, 3);
        this.taalFrom.setStyle("-fx-font-size: 20");
        GridPane.setConstraints(taalFrom, 1, 3, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        //Word Label
        this.add(word, 1, 4);
        this.word.setStyle("-fx-font-size: 15");
        this.word.setStyle("-fx-font-weight: bold");
        GridPane.setConstraints(word, 1, 4, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);
        word.setPadding(new Insets(0,0,0,15));

        //Taal To Label
        this.add(taalTo, 1, 5);
        this.taalTo.setStyle("-fx-font-size: 20");
        GridPane.setConstraints(taalTo, 1, 5, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        // Result label
		this.add(this.lblResult, 2, 4);
		GridPane.setConstraints(this.lblResult, 2, 4, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        //OK Button
        this.add(okButton, 1, 10);
        this.okButton.setStyle("-fx-font-size: 15");
        GridPane.setConstraints(okButton, 1, 10, 2, 1, HPos.CENTER, VPos.CENTER, Priority.NEVER, Priority.NEVER);
        okButton.setMinWidth(200);

        //Extra Text Label
        this.add(extraText, 2, 1);
        this.extraText.setStyle("-fx-font-size: 12");
        GridPane.setConstraints(extraText, 2, 1, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        //Score Label
        this.add(score, 2, 2);
        this.score.setStyle("-fx-font-size: 12");
        GridPane.setConstraints(score, 2, 2, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);
    }

    public void setRadioButtons(ArrayList<String> possibilities) {
        // clear existing radio button from pane
        this.getChildren().removeAll(this.radioButtons);
        this.toggleGroup = new ToggleGroup();
        // clear container for radio buttons
        this.radioButtons.clear();

        // create a new radio button for each possibility and add it to the pane
        for (int i = 0; i < possibilities.size(); ++i) {
            // create radio button
            RadioButton r = new RadioButton(possibilities.get(i));
            // add to container for easy removal
            this.radioButtons.add(r);
            // set toggle group
            r.setToggleGroup(this.toggleGroup);
            // add to pane
            this.add(r, 1, i + 6);
            GridPane.setConstraints(r, 1, i + 6, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);
        }
    }

}
