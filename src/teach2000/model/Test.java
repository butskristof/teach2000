package teach2000.model;


import teach2000.model.utilities.LijstIO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Kristof Buts
 * @version 1.0 22/02/18 01:24
 */
public class Test {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
//		MultipleChoice mc = new MultipleChoice();
//		mc.test();
//
//		AntwoordInvullen ai = new AntwoordInvullen();
//		ai.test();

		User buts = new User("Buts");
		Test.setup(buts);
		UserList users = new UserList();
		users.addUser(buts);
//
		LijstIO.writeList(buts.getId(), buts.getLijst(0));
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
		Vraag v = new Vraag("tafel", "table", new String[]{"tabel", "taple"});
		Vraag v2 = new Vraag("toetsenbord", "keyboard", new String[]{"typboard", "kyboard"});
		Lijst list;
		list = new Lijst("NL", "EN");
		list.addVraag(v);
		list.addVraag(v2);
		u.addLijst(list);
	}
}
