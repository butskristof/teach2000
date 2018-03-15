package teach2000.view.add;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.util.ArrayList;

/**
 * @author demacryx on 12.03.2018 11:09 PM.
 */
public class AddView extends GridPane {
	private Label lblTitle;
    private TextField txtTitle;
    private Label lblLangFrom, lblLangTo;
    private TextField txtLangFrom, txtLangTo;

    private Label lblQuestion, lblAnswer, lblAlternatives;

    // the input field are stored in an ArrayList per row, with the question and answer being first and second
	// from the third item on the alternatives are given
	// all rows are stored in an ArrayList so we get a 2D matrix
    private int numberOfInputs = 5; // default five input fields
	private int firstFreeRow = 5; // row where new input fields can be added
	private ArrayList<ArrayList<TextField>> questioninputs = new ArrayList<>();

    private MenuItem afsluiten;
    private Button sumbitButton, btnAddRow;
    
    // CONSTRUCTOR

    public AddView() {
        initialiseNodes();
        layoutNodes();
    }

    //GETTERS

    public TextField getTitle() {
        return txtTitle;
    }

    public TextField getLangFrom() {
        return txtLangFrom;
    }

    public TextField getLangTo() {
        return txtLangTo;
    }

    public MenuItem getAfsluiten() {
        return afsluiten;
    }

    public Button getSumbitButton() {
        return sumbitButton;
    }

	public Button getBtnAddRow() {
		return btnAddRow;
	}

	public ArrayList<ArrayList<TextField>> getQuestioninputs() {
		return questioninputs;
	}

	//LAYOUT

    private void initialiseNodes() {
    	// Title section
    	this.lblTitle = new Label("Title");
        this.txtTitle = new TextField();

        // Languages section
		this.lblLangFrom = new Label("From");
		this.txtLangFrom = new TextField();
		this.lblLangTo = new Label("To");
		this.txtLangTo = new TextField();

		// labels above inputs
		this.lblQuestion = new Label("Question");
		this.lblAnswer = new Label("Answer");
		this.lblAlternatives = new Label("Alternatives");

		// input fields
		// are generated dynamically depending on the number set as an attribute
		for (int i = 0; i < this.numberOfInputs; ++i) {
			// create arraylist to store the row
			ArrayList<TextField> inputRow = new ArrayList<>();
			// six input field are generated for question, answer and max 4 alternatives
			for (int j = 0; j < 6; ++j) {
				TextField textField = new TextField();
				inputRow.add(textField);
			}

			// add row to arraylist of input rows
			this.questioninputs.add(inputRow);
		}

        this.afsluiten = new MenuItem("Close");
		this.btnAddRow = new Button("+");
        sumbitButton = new Button("SUMBIT");

        Separator separator1 = new Separator();
    }

    private void layoutNodes() {

//    	for testing
//    	this.setGridLinesVisible(true);

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
        menuBar.setPadding(new Insets(0));

        ///////////////////Grid Settings/////////////////////
//        this.setGridLinesVisible(false);
        this.setAlignment(Pos.TOP_LEFT);

        //Vertical Gap
        this.setVgap(5);

        //Horizontal Gap
        this.setHgap(5);

//        //Column Constraints
//        ColumnConstraints column1 = new ColumnConstraints();
//        column1.setPercentWidth(5);
//        ColumnConstraints column2 = new ColumnConstraints();
//        column2.setPercentWidth(45);
//        ColumnConstraints column3 = new ColumnConstraints();
//        column3.setPercentWidth(45);
//        ColumnConstraints column4 = new ColumnConstraints();
////        column4.setPercentWidth(5);
//
//        this.getColumnConstraints().addAll(column1, column2, column3,column4);

        //Row Constraints
        //Menu
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(10);
        row1.setValignment(VPos.TOP);
        //Title
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(5);
        //Empty
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(5);
        //Taal From
        RowConstraints row4 = new RowConstraints();
        row4.setPercentHeight(5);
        //Word
        RowConstraints row5 = new RowConstraints();
        row5.setPercentHeight(2.5);
        //Taal To
        RowConstraints row6 = new RowConstraints();
        row6.setPercentHeight(2.5);

        RowConstraints row16 = new RowConstraints();
        row16.setPercentHeight(5);

        this.getRowConstraints().addAll(row1, row2, row3, row4, row5, row6,row16);


        ///////////////////Elements Layout/////////////////////
        //Background Image
        /*setBackground(new Background(new BackgroundImage(new Image("images/writeview.jpg"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));*/
        Separator separator1 = new Separator();
        this.add(separator1,0,5);
        GridPane.setConstraints(separator1,0,5,5,1,HPos.LEFT, VPos.TOP,Priority.NEVER,Priority.NEVER);

        //title
		this.add(lblTitle, 1, 0);
		GridPane.setConstraints(lblTitle, 1, 0, 1, 1, HPos.LEFT, VPos.BOTTOM, Priority.NEVER, Priority.NEVER);
        this.add(txtTitle, 1, 1);
        this.txtTitle.setStyle("-fx-font-size: 20");
        GridPane.setConstraints(txtTitle, 1, 1, 1, 1, HPos.LEFT, VPos.BOTTOM, Priority.NEVER, Priority.NEVER);

        //Taal From Label
		this.add(lblLangFrom, 1, 2);
		GridPane.setConstraints(txtLangFrom, 1, 2, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);
        this.add(txtLangFrom, 1, 3);
        this.txtLangFrom.setStyle("-fx-font-size: 15");
        GridPane.setConstraints(txtLangFrom, 1, 3, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        //Taal To Label
		this.add(lblLangTo, 2, 2);
		GridPane.setConstraints(txtLangTo, 2, 2, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);
        this.add(txtLangTo, 2, 3);
        this.txtLangTo.setStyle("-fx-font-size: 15");
        GridPane.setConstraints(txtLangTo, 2, 3, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        // Labels above inputs
		this.add(lblQuestion, 1, 4);
		GridPane.setConstraints(lblQuestion, 1, 4, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);
		this.add(lblAnswer, 2, 4);
		GridPane.setConstraints(lblAnswer, 2, 4, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);
		this.add(lblAlternatives, 3, 4);
		GridPane.setConstraints(lblAlternatives, 3, 4, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

		// input fields
		// placed in the first free row, which is then incremented
		for (int i = 0; i < this.numberOfInputs; ++i) {
			for (int j = 0; j < 6; ++j) {
				// starting in column 1, so j+1
				this.add(this.questioninputs.get(i).get(j), j+1, firstFreeRow);
				GridPane.setConstraints(this.questioninputs.get(i).get(j), j+1, firstFreeRow, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

			}
			// increment first free row since this one is taken now
			++firstFreeRow;
		}

		// place submit and add row button after input fields
		// add row
		this.add(this.btnAddRow, 1, firstFreeRow);
		GridPane.setConstraints(this.btnAddRow,1,firstFreeRow,1,1,HPos.LEFT,VPos.CENTER,Priority.NEVER,Priority.NEVER);
		// submit
        this.add(sumbitButton,3,firstFreeRow);
        GridPane.setConstraints(sumbitButton,3,firstFreeRow,1,1,HPos.CENTER,VPos.CENTER,Priority.NEVER,Priority.NEVER);
        sumbitButton.setMinWidth(200);

        // first free row is not incremented here since the input fields that will be added will come in the row
		// where the button are now. They will be moved to the first row after the new input fields
    }

    public void addInputRow() {
    	++numberOfInputs;
    	// create new input fields row
		ArrayList<TextField> inputRow = new ArrayList<>();
		for (int j = 0; j < 6; ++j) {
			TextField textField = new TextField();
			inputRow.add(textField);
		}

		this.questioninputs.add(inputRow);
		// layout new input fields
		int inputRowIndex = this.questioninputs.size() - 1; // get the last item in the array list, which is the newly added row
		for (int j = 0; j < 6; ++j) {
			this.add(this.questioninputs.get(inputRowIndex).get(j), j+1, firstFreeRow);
			GridPane.setConstraints(this.questioninputs.get(inputRowIndex).get(j), j+1, firstFreeRow, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

		}
		// first free row moves one down now
		++firstFreeRow;

		// move submit and add row buttons
		GridPane.setConstraints(this.btnAddRow,1,firstFreeRow,1,1,HPos.LEFT,VPos.CENTER,Priority.NEVER,Priority.NEVER);
		GridPane.setConstraints(sumbitButton,3,firstFreeRow,1,1,HPos.CENTER,VPos.CENTER,Priority.NEVER,Priority.NEVER);
	}

}
