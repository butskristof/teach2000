package teach2000;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import teach2000.model.Login;
import teach2000.model.Teach2000Model;
import teach2000.model.User;
import teach2000.model.UserList;
import teach2000.view.login.LoginPresenter;
import teach2000.view.login.LoginView;
import teach2000.view.Teach2000Presenter;
import teach2000.view.Teach2000View;
import teach2000.view.mainMenu.MainMenuView;
import teach2000.view.mcTest.McView;
import teach2000.view.register.RegisterView;
import teach2000.view.writeTest.WriteView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
	/*	Scene scene = new Scene(new VBox(),400,350);
		MenuBar menuBar = new MenuBar();
		Menu menuFile=new Menu("File");
		Menu menuEdit=new Menu("Edit");
		Menu menuView=new Menu("View");
		menuBar.getMenus().addAll(menuFile,menuEdit,menuView);
        ((VBox) scene.getRoot()).getChildren().addAll(menuBar);*/

        Login model = new Login();
        LoginView view = new LoginView();
        LoginPresenter presenter = new LoginPresenter(model, view);

        primaryStage.setScene(new Scene(view));
		primaryStage.setTitle("Teach2000");
        primaryStage.setHeight(400);
        primaryStage.setWidth(800);
        primaryStage.setResizable(true);
		presenter.addWindowEventHandlers();
        view.getStylesheets().add("css/main.css");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
