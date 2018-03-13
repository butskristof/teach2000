package teach2000.view.add;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

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
    private Button sumbitButton;

    public AddView() {
        initialiserNodes();
        layoutNodes();
    }

    //GETTERS

    public TextField getLeft1() {
        return left1;
    }

    public TextField getLeft2() {
        return left2;
    }

    public TextField getLeft3() {
        return left3;
    }

    public TextField getLeft4() {
        return left4;
    }

    public TextField getLeft5() {
        return left5;
    }

    public TextField getLeft6() {
        return left6;
    }

    public TextField getLeft7() {
        return left7;
    }

    public TextField getLeft8() {
        return left8;
    }

    public TextField getLeft9() {
        return left9;
    }

    public TextField getLeft10() {
        return left10;
    }

    public TextField getRight1() {
        return right1;
    }

    public TextField getRight2() {
        return right2;
    }

    public TextField getRight3() {
        return right3;
    }

    public TextField getRight4() {
        return right4;
    }

    public TextField getRight5() {
        return right5;
    }

    public TextField getRight6() {
        return right6;
    }

    public TextField getRight7() {
        return right7;
    }

    public TextField getRight8() {
        return right8;
    }

    public TextField getRight9() {
        return right9;
    }

    public TextField getRight10() {
        return right10;
    }

    public TextField getTitle() {
        return title;
    }

    public TextField getTaalFrom() {
        return taalFrom;
    }

    public TextField getTaalTo() {
        return taalTo;
    }

    public MenuItem getAfsluiten() {
        return afsluiten;
    }

    public Button getSumbitButton() {
        return sumbitButton;
    }


    //LAYOUT

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
        sumbitButton = new Button("SUMBIT");

        Separator separator1 = new Separator();
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
        menuBar.setPadding(new Insets(0));



        ///////////////////Grid Settings/////////////////////
        this.setGridLinesVisible(false);
        this.setAlignment(Pos.TOP_LEFT);

        //Vertical Gap
        this.setVgap(5);

        //Horizontal Gap
        this.setHgap(5);

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
        this.add(title, 1, 1);
        this.title.setStyle("-fx-font-size: 20");
        GridPane.setConstraints(title, 1, 1, 1, 1, HPos.LEFT, VPos.BOTTOM, Priority.NEVER, Priority.NEVER);

        //Taal From Label
        this.add(taalFrom, 1, 3);
        this.taalFrom.setStyle("-fx-font-size: 15");
        GridPane.setConstraints(taalFrom, 1, 3, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        //Taal To Label
        this.add(taalTo, 1, 5);
        this.taalTo.setStyle("-fx-font-size: 15");
        GridPane.setConstraints(taalTo, 2, 3, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        //TextFields LEFT
        this.add(left1, 1, 6);
        GridPane.setConstraints(left1, 1, 6, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        this.add(left2, 1, 7);
        GridPane.setConstraints(left2, 1, 7, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        this.add(left3, 1, 8);
        GridPane.setConstraints(left3, 1, 8, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        this.add(left4, 1, 9);
        GridPane.setConstraints(left4, 1, 9, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        this.add(left5, 1, 10);
        GridPane.setConstraints(left5, 1, 10, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        this.add(left6, 1, 11);
        GridPane.setConstraints(left6, 1, 11, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        this.add(left7, 1, 12);
        GridPane.setConstraints(left7, 1, 12, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        this.add(left8, 1, 13);
        GridPane.setConstraints(left8, 1, 13, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        this.add(left9, 1, 14);
        GridPane.setConstraints(left9, 1, 14, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        this.add(left10, 1, 15);
        GridPane.setConstraints(left10, 1, 15, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        //TextField RIGHT
        this.add(right1, 1, 6);
        GridPane.setConstraints(right1, 2, 6, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        this.add(right2, 1, 7);
        GridPane.setConstraints(right2, 2, 7, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        this.add(right3, 1, 8);
        GridPane.setConstraints(right3, 2, 8, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        this.add(right4, 1, 9);
        GridPane.setConstraints(right4, 2, 9, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        this.add(right5, 1, 10);
        GridPane.setConstraints(right5, 2, 10, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        this.add(right6, 1, 11);
        GridPane.setConstraints(right6, 2, 11, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        this.add(right7, 1, 12);
        GridPane.setConstraints(right7, 2, 12, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        this.add(right8, 1, 13);
        GridPane.setConstraints(right8, 2, 13, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        this.add(right9, 1, 14);
        GridPane.setConstraints(right9, 2, 14, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        this.add(right10, 1, 15);
        GridPane.setConstraints(right10, 2, 15, 1, 1, HPos.LEFT, VPos.CENTER, Priority.NEVER, Priority.NEVER);

        this.add(sumbitButton,1,17);
        GridPane.setConstraints(sumbitButton,1,17,2,1,HPos.CENTER,VPos.CENTER,Priority.NEVER,Priority.NEVER);
        sumbitButton.setMinWidth(200);
    }
}
