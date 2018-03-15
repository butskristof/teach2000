package teach2000.view.mainMenu;


import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import teach2000.model.lists.List;

/**
 * @author demacryx on 25.02.2018 7:11 PM.
 */
public class MainMenuView extends VBox {
    ///////////////////Attributes/////////////////////
    private TableView<List> table;
    private Label label;
    private MenuItem afsluiten, add, remove, edit, importList, exportList, deleteUser, logoutUser, userConfiguration, about;

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

    public MenuItem getDeleteUser() {
        return deleteUser;
    }

    public MenuItem getLogoutUser() {
        return logoutUser;
    }

    public MenuItem getAdd() {
        return add;
    }

    public MenuItem getEdit() {
        return edit;
    }

    public MenuItem getExportList() {
        return exportList;
    }

    public MenuItem getUserConfiguration() {
        return userConfiguration;
    }

    public MenuItem getAbout() {
        return about;
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
        this.importList = new MenuItem("Import list");
        this.exportList = new MenuItem("Export list");
        this.deleteUser = new MenuItem("Delete user");
        this.logoutUser = new MenuItem("Log out user");
        this.userConfiguration = new MenuItem("Configure");
        this.about = new MenuItem("About");

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

        final Menu userMenu = new
                Menu("User");

        bestandMenu.getItems().addAll(importList, exportList, about, afsluiten);
        editMenu.getItems().addAll(edit, add, remove);
        userMenu.getItems().addAll(deleteUser, logoutUser, userConfiguration);

        //MenuBar
        final MenuBar menuBar = new MenuBar(bestandMenu, editMenu, userMenu);

        //Vbox Settings
        this.getChildren().addAll(menuBar, label, table);
        label.setPadding(new Insets(10, 0, 0, 20));
        setMargin(table, new Insets(10));
    }
}