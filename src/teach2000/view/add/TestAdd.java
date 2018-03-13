package teach2000.view.add;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import teach2000.model.User;

/**
 * @author Kristof Buts
 * @version 1.0 13/03/18 16:59
 */
public class TestAdd extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		AddView view = new AddView();
		AddPresenter presenter = new AddPresenter(new User("test"), view);

		primaryStage.setScene(new Scene(view));
		primaryStage.setTitle("Teach2000");
//		primaryStage.setHeight(300);
//		primaryStage.setWidth(500);
		primaryStage.setResizable(false);
//		presenter.addWindowEventHandlers();
		// stylesheet not found
//        view.getStylesheets().add("css/main.css");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
