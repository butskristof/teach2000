package teach2000;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import teach2000.model.Teach2000Model;
import teach2000.view.Teach2000Presenter;
import teach2000.view.Teach2000View;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

		Teach2000Model model = new Teach2000Model();
		Teach2000View view = new Teach2000View();
		Teach2000Presenter presenter = new Teach2000Presenter(model, view);

        primaryStage.setTitle("Teach2000");
        primaryStage.setScene(new Scene(view));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
