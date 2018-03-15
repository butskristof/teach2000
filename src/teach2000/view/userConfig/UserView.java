package teach2000.view.userConfig;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;


/**
 * @author demacryx on 15.03.2018 8:36 PM.
 * @project teach20002
 */
public class UserView extends GridPane {
    private Label userName;
    private TextField nameText;
    private Label stopWord, minReq;
    private TextField stopWordField;
    private Slider slider;
    private CheckBox checkbox;
    private Button saveButton, cancelButtton;

    // CONSTRUCTOR
    public UserView() {
        initialiseNodes();
        layoutNodes();
    }

    //GETTERS
    public Label getUserName() {
        return userName;
    }

    public TextField getNameText() {
        return nameText;
    }

    public Label getStopWord() {
        return stopWord;
    }

    public CheckBox getCheckbox() {
        return checkbox;
    }

    public Label getMinReq() {
        return minReq;
    }

    public TextField getStopWordField() {
        return stopWordField;
    }

    public Slider getSlider() {
        return slider;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Button getCancelButtton() {
        return cancelButtton;
    }

    //LAYOUT
    private void initialiseNodes() {
        this.userName = new Label("Username:");
        this.nameText = new TextField();
        this.nameText.setPromptText("username");
        this.stopWord = new Label("Stopword:");
        this.stopWordField = new TextField();
        this.stopWordField.setPromptText("Stopword");
        this.checkbox = new CheckBox("Stopwoord?");
        this.minReq = new Label("Min. Req.\n \tScore:");
        this.slider = new Slider(0, 100, 10);
        this.slider.setMajorTickUnit(10);
        this.slider.setMinorTickCount(0);
        this.slider.setSnapToTicks(true);
		this.slider.setShowTickLabels(true);
		this.slider.setShowTickMarks(true);
//        this.slider.setBlockIncrement(10);

        this.saveButton = new Button("Save");
        this.cancelButtton = new Button("Cancel");
    }

    private void layoutNodes() {
        ///////////////////Grid Settings/////////////////////
        this.setGridLinesVisible(false);
        this.setAlignment(Pos.CENTER);

        //Vertical Gap
        this.setVgap(10);

        //Horizontal Gap
        this.setHgap(10);

        ///////////////////Elements Layout/////////////////////
        this.add(userName, 1, 1);
        this.userName.setStyle("-fx-font-size: 20");
        GridPane.setConstraints(userName, 1, 1, 1, 1,
                HPos.LEFT, VPos.CENTER,
                Priority.NEVER, Priority.NEVER);

        this.add(nameText, 2, 1);
        this.nameText.setPadding(new Insets(0, 10, 0, 0));
        this.nameText.setStyle("-fx-font-size: 20");
        GridPane.setConstraints(nameText, 2, 1, 1, 1,
                HPos.CENTER, VPos.CENTER,
                Priority.NEVER, Priority.NEVER);

        this.add(checkbox, 1, 2);
        this.checkbox.setStyle("-fx-font-size: 20");
        GridPane.setConstraints(checkbox, 1, 2, 1, 1,
                HPos.LEFT, VPos.CENTER,
                Priority.NEVER, Priority.NEVER);

        this.add(stopWord, 1, 3);
        this.stopWord.setPadding(new Insets(0, 0, 0, 38));
        this.stopWord.setStyle("-fx-font-size: 20");
        GridPane.setConstraints(stopWord, 1, 3, 1, 1,
                HPos.LEFT, VPos.CENTER,
                Priority.NEVER, Priority.NEVER);

        this.add(stopWordField, 2, 3);
        this.stopWordField.setPadding(new Insets(0, 10, 0, 0));
        this.stopWordField.setStyle("-fx-font-size: 20");
        GridPane.setConstraints(stopWordField, 2, 3, 1, 1,
                HPos.LEFT, VPos.CENTER,
                Priority.NEVER, Priority.NEVER);

        this.add(minReq, 1, 4);
        this.minReq.setPadding(new Insets(0, 0, 0, 38));
        this.minReq.setStyle("-fx-font-size: 20");
        GridPane.setConstraints(minReq, 1, 4, 1, 1,
                HPos.LEFT, VPos.CENTER,
                Priority.NEVER, Priority.NEVER);

        this.add(slider, 2, 4);
        this.slider.setPadding(new Insets(0, 10, 0, 0));
        GridPane.setConstraints(slider, 2, 4, 1, 1,
                HPos.CENTER, VPos.CENTER,
                Priority.NEVER, Priority.NEVER);

        this.add(saveButton, 1, 5);
        this.saveButton.setPrefWidth(120);
        this.saveButton.setPadding(new Insets(10));
        GridPane.setConstraints(saveButton, 2, 5, 1, 1,
                HPos.LEFT, VPos.CENTER,
                Priority.NEVER, Priority.NEVER);

        this.add(cancelButtton, 2, 5);
        this.cancelButtton.setPrefWidth(120);
        this.cancelButtton.setPadding(new Insets(10));
        GridPane.setConstraints(cancelButtton, 2, 5, 1, 1,
                HPos.RIGHT, VPos.CENTER,
                Priority.NEVER, Priority.NEVER);
    }
}
