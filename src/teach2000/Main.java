package teach2000;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import teach2000.model.Login;
import teach2000.view.add.AddView;
import teach2000.view.login.LoginPresenter;
import teach2000.view.login.LoginView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // We start by building the login screen
        Login model = new Login();
        LoginView view = new LoginView();
        LoginPresenter presenter = new LoginPresenter(model, view);

        primaryStage.setScene(new Scene(view));
        primaryStage.setTitle("Teach2000");
        primaryStage.setHeight(300);
        primaryStage.setWidth(500);
        primaryStage.setResizable(false);
        presenter.addWindowEventHandlers();
        // stylesheet not found
//        view.getStylesheets().add("css/main.css");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
