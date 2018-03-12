package teach2000.view.selector;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

/**
 * @author demacryx on 12.03.2018 12:14 AM.
 * @project teach20002
 */
public class SelectorView extends GridPane{
    private RadioButton mc,wt;
    private Label question;
    private final ToggleGroup group = new ToggleGroup();

    private Button multiplechoice, write;

    // CONSTRUCTOR

    public SelectorView() {
        this.initializeNodes();
        this.layoutNodes();
    }

    // GETTERS

    public RadioButton getMc() {
        return mc;
    }

    public RadioButton getWt() {
        return wt;
    }

    public ToggleGroup getGroup() {
        return group;
    }

	public Button getMultiplechoice() {
		return multiplechoice;
	}

	public Button getWrite() {
		return write;
	}

	private void initializeNodes() {
        this.mc=new RadioButton("Multiple Choice");
        mc.setToggleGroup(group);
        this.wt=new RadioButton("Write Test");
        wt.setToggleGroup(group);
        this.question= new Label("What type of test do you want to do?");
        question.setFont(new Font("Arial",20));

		this.multiplechoice = new Button("Multiple choice");
		this.write = new Button("Fill in the answer");
    }

    private void layoutNodes() {
        ///////////////////Grid Settings/////////////////////
        this.setGridLinesVisible(true);
        this.setAlignment(Pos.CENTER);

        //Horizontal Gap
        this.setHgap(10);

        //Vertical Gap
        this.setVgap(10);

        //Column Constraints
        ColumnConstraints column1 = new ColumnConstraints(300);
        ColumnConstraints column2 = new ColumnConstraints(300);
        this.getColumnConstraints().addAll(column1,column2);

        //Row Constraints
        RowConstraints rowConstraints = new RowConstraints(150);

        ///////////////////Elements Layout/////////////////////

        //Label
        this.add(question, 0, 0);
        GridPane.setConstraints(question, 0, 0, 2, 1,
                HPos.CENTER, VPos.CENTER,
                Priority.NEVER, Priority.NEVER);

        //OK Button
//        this.add(mc, 0, 1);
//        GridPane.setConstraints(mc, 0, 1, 1, 1,
//                HPos.RIGHT, VPos.CENTER,
//                Priority.NEVER, Priority.NEVER);

        //Cancel Button
//        this.add(wt, 1, 1);
//        GridPane.setConstraints(wt, 1, 1, 1, 1,
//                HPos.LEFT, VPos.CENTER,
//                Priority.NEVER, Priority.NEVER);

		this.add(multiplechoice, 0, 1);
		GridPane.setConstraints(multiplechoice, 0, 1, 1, 1, HPos.RIGHT, VPos.CENTER, Priority.NEVER, Priority.NEVER);
		this.add(write, 1, 1);
		GridPane.setConstraints(write, 1, 1, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);
    }
}
