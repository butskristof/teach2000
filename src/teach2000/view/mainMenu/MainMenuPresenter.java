package teach2000.view.mainMenu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import teach2000.model.Login; /**
 * @author demacryx on 25.02.2018 7:12 PM.
 * @project teach20002
 */
public class MainMenuPresenter {
    private Login model;
    private MainMenuView view;

    public MainMenuPresenter(Login model, MainMenuView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        view.getOkButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }

    private void updateView() {

    }
}
