package teach2000.view.add;

import teach2000.model.User; /**
 * @author demacryx on 12.03.2018 11:10 PM.
 * @project teach20002
 */
public class AddPresenter {
    private User model;
    private AddView view;

    public AddPresenter(User model, AddView view) {
        this.model = model;
        this.view = view;
    }
}
