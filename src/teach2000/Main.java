package teach2000;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import teach2000.model.Login;
import teach2000.view.login.LoginPresenter;
import teach2000.view.login.LoginView;
import teach2000.view.mainMenu.MainMenuView;
import teach2000.view.mcTest.McView;
import teach2000.view.writeTest.WriteView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

		// We start by building the login screen
        Login model = new Login();
        LoginView view = new LoginView();
        LoginPresenter presenter = new LoginPresenter(model, view);

        primaryStage.setScene(new Scene(view));
		primaryStage.setTitle("Teach2000");
        primaryStage.setHeight(400);
        primaryStage.setWidth(800);
        primaryStage.setResizable(true);
		/*presenter.addWindowEventHandlers();*/
		// stylesheet not found
//        view.getStylesheets().add("css/main.css");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
