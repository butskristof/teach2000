package teach2000.view.mainMenu;


import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import teach2000.model.DataSource;

/**
 * @author demacryx on 25.02.2018 7:11 PM.
 * @project teach20002
 */
public class MainMenuView extends VBox {
    ///////////////////Attributes/////////////////////
    private Label lijsten;
    private Button toevoegen, verweideren, bewerken;
    private TableView<DataSource> table;
    private Label label;

    ///////////////////Constructor/////////////////////
    public MainMenuView() {
        this.initializeNodes();
        this.layoutNodes();
    }

    ///////////////////Getters/////////////////////
    public ObservableList<DataSource> getList () {
        ObservableList<DataSource> lists = FXCollections.observableArrayList();
        lists.add(new DataSource("example1",251.51,55));
        return lists;
    }

    ///////////////////Initializer/////////////////////
    private void initializeNodes() {

        table = new TableView();
        label = new Label("Lijsten");


        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn<DataSource, String> talenColumn = new TableColumn<>("Talen");

        TableColumn titleColumn = new TableColumn("Titel");
        TableColumn scoreColumn = new TableColumn("Score");

        table.getColumns().addAll(talenColumn, titleColumn, scoreColumn);


    }


    private void layoutNodes() {
        this.setSpacing(5);
        this.setPadding(new Insets(10, 0, 0, 10));
        setMargin(table, new Insets(10));
        this.getChildren().addAll(label, table);
        setMargin(label, new Insets(0, 0, 0, 10));


    }
}