package teach2000.view.selector;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.input.MouseEvent;
import teach2000.model.AntwoordInvullen;
import teach2000.model.McChoice;
import teach2000.model.WtChoice;
import teach2000.view.mainMenu.MainMenuView;
import teach2000.view.mcTest.McPresenter;
import teach2000.view.mcTest.McView;
import teach2000.view.writeTest.WritePresenter;
import teach2000.view.writeTest.WriteView;


/**
 * @author demacryx on 12.03.2018 12:14 AM.
 * @project teach20002
 */
public class SelectorPresenter {
    private McChoice model1;
    private AntwoordInvullen model2;
    private SelectorView view;

    public SelectorPresenter(SelectorView view, McChoice model1, AntwoordInvullen model2) {
        this.view = view;
        this.model1=model1;
        this.model2=model2;
        this.addEventHandlers();
        this.updateView();
    }



    private void addEventHandlers() {
        view.getGroup().selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
                // Has selection.
                if (view.getGroup().getSelectedToggle() != null) {
                    McView mcView = new McView();
                    McPresenter mcPresenter = new McPresenter(model1, mcView);
                    view.getScene().setRoot(mcView);

                }
            }
        });

        //Multiple Choice Handler


        view.getWt().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                WriteView writeView = new WriteView();
                WritePresenter writePresenter = new WritePresenter(model2,writeView);
                view.getScene().setRoot(writeView);
            }
        });
    }

    private void callbackMainMenu() {
        MainMenuView mainMenuView = new MainMenuView();
        view.getScene().setRoot(mainMenuView);
//		loginview.getScene().getWindow().sizeToScene();
    }

    private void updateView() {
        // not applicable here
    }
}
