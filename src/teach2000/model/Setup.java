package teach2000.model;

import teach2000.model.lists.List;
import teach2000.model.questions.Question;
import teach2000.model.users.User;
import teach2000.model.users.UserList;

/**
 * This class provides an easy way to load some preconfigured users and lists into the model.
 * It creates a user list and two users one list.
 * These will be saved to the file system to the main application will load them in when started.
 *
 * @author Kristof Buts
 * @version 1.0 14/03/18 18:44
 */

public class Setup {
	public static void main(String[] args) {
		UserList users = new UserList();
		User buts = new User("Buts");
		buts.enableStopword("STOP", 10);
		User jos = new User("Jos");
		Setup.setup(buts);
		Setup.setup(jos);
		users.addUser(buts);
		users.addUser(jos);
	}

	private static void setup(User u) {
		Question v = new Question("tafel", "table", new String[]{"tabel", "taple"});
		Question v2 = new Question("toetsenbord", "keyboard", new String[]{"typboard", "kyboard"});
		List list;
		list = new List("NL", "EN", "Test1");
		list.addQuestion(v);
		list.addQuestion(v2);
		u.addList(list);
	}
}
