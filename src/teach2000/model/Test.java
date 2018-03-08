package teach2000.model;


import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import teach2000.model.lists.List;
import teach2000.model.lists.ListIO;
import teach2000.model.questions.Question;

import java.io.File;
import java.util.Scanner;

/**
 * @author Kristof Buts
 * @version 1.0 22/02/18 01:24
 */
public class Test {

	public static void main(String[] args) {
//		Scanner keyboard = new Scanner(System.in);
//		MultipleChoice mc = new MultipleChoice();
//		mc.test();
//
//		AntwoordInvullen ai = new AntwoordInvullen();
//		ai.test();

		// create user and users file
		UserList users = new UserList();
		User buts = new User("Buts");
		Test.setup(buts);
		users.addUser(buts);
//
//		ListIO.writeList(buts.getId(), buts.getList(0));
//		ArrayList<Lijst> lists = LijstIO.readAllLists(buts.getId());
//		for (Lijst l: lists) {
//			System.out.println(l);
//		}
//		Lijst l = LijstIO.readList(buts.getId(), buts.getLijst(0).getId());
//		System.out.println(l.toString());

//		for (int i = 0; i < buts.getLijsten().size(); ++i) {
//			System.out.printf("\t%d: %s", i, buts.getLijsten().get(i).getTitle());
//		}
//		System.out.printf("%n");
//		System.out.print("Kies een lijst: ");
//		int choice = keyboard.nextInt();
//		Lijst l = buts.getLijst(choice);
//
//		System.out.printf("\t0: multiple choice%n\t1: antwoord invullen%n");
//		System.out.print("Kies een type overhoring: ");
//		choice = keyboard.nextInt();
//		Overhoring ov;
//		if (choice == 0) {
//			ov= new MultipleChoice(l);
//		} else if (choice == 1) {
//			ov= new AntwoordInvullen(l);
//		} else {
//			return;
//		}
//		ov.test();
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
