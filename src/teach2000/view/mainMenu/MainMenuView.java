package teach2000.view.mainMenu;


import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import teach2000.model.lists.List;

/**
 * @author demacryx on 25.02.2018 7:11 PM.
 * @project teach20002
 */
public class MainMenuView extends VBox {
    ///////////////////Attributes/////////////////////
    private TableView<List> table;
    private Label label;
    private MenuItem afsluiten, add, remove, edit, importList, exportList, deleteUser;

    ///////////////////Constructor/////////////////////
    public MainMenuView() {
        this.initializeNodes();
        this.layoutNodes();
    }

    ///////////////////Getters/////////////////////
    public MenuItem getAfsluiten() {
        return afsluiten;
    }

    public TableView<List> getTable() {
        return table;
    }

	public MenuItem getImportList() {
		return importList;
	}

	public MenuItem getRemove() {
		return remove;
	}

	public MenuItem getDeleteUser(){
        return deleteUser;
    }

    public MenuItem getAdd() {
        return add;
    }

    public MenuItem getEdit() {
        return edit;
    }

    ///////////////////Initializer/////////////////////
    private void initializeNodes() {
        label = new Label("Lijsten");
        label.setFont(new Font("Arial", 20));

        //Menu Settings
        this.afsluiten = new MenuItem("Exit");
        this.edit = new MenuItem("Edit");
        this.add = new MenuItem("Add");
        this.remove = new MenuItem("Remove");
        this.importList = new MenuItem("Import List");
        this.exportList = new MenuItem("Export list");
        this.deleteUser = new MenuItem("Delete User");

        //Table Items
        table = new TableView<>();
        table.setEditable(true);

        //Table Settings
        TableColumn titlecolumn = new TableColumn("Title");
        titlecolumn.setCellValueFactory(
                new PropertyValueFactory<List, String>("title")
        );

        TableColumn namecolumn = new TableColumn("Name");
        namecolumn.setCellValueFactory(
                new PropertyValueFactory<List, String>("name")
        );

        table.getColumns().addAll(titlecolumn, namecolumn);

        // column are divided equally and resized when necessary
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    private void layoutNodes() {
        //Menu
        final Menu bestandMenu = new
                Menu("File");

        final Menu editMenu = new
                Menu("Edit");

        final Menu aboutMenu = new
                Menu("About");

        final Menu userMenu = new
                Menu("User");

        bestandMenu.getItems().addAll(importList, exportList, afsluiten);
        editMenu.getItems().addAll(edit, add, remove);
        userMenu.getItems().add(deleteUser);

        //MenuBar
        final MenuBar menuBar = new
                MenuBar(bestandMenu, editMenu, userMenu, aboutMenu);

        //Vbox Settings
        this.getChildren().addAll(menuBar, label, table);
        label.setPadding(new Insets(10, 0, 0, 20));
        setMargin(table, new Insets(10));
    }
}