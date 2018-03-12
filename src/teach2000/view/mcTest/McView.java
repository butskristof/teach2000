package teach2000.view.mcTest;

import javafx.geometry.HPos;
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
        this.afsluiten = new MenuItem("Exit");

        this.okButton = new Button("OK");
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

		//OK Button
		this.add(okButton, 2, 5);
		this.okButton.setStyle("-fx-font-size: 15");
		GridPane.setConstraints(okButton, 2, 5, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        //Extra Text Label
        this.add(extraText, 3, 3);
        this.extraText.setStyle("-fx-font-size: 12");
        GridPane.setConstraints(extraText, 3, 3, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        //Score Label
        this.add(score, 3, 4);
        this.score.setStyle("-fx-font-size: 12");
        GridPane.setConstraints(score, 3, 4, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);
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
