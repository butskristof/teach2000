package teach2000.model;


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
//
//		mc.test();
//
//		AntwoordInvullen ai = new AntwoordInvullen();
//		ai.test();

		User buts = new User("Buts");
		Test.setup(buts);

		for (int i = 0; i < buts.getLijsten().size(); ++i) {
			System.out.printf("\t%d: %s", i, buts.getLijsten().get(i).getTitle());
		}
		System.out.printf("%n");
		System.out.print("Kies een lijst: ");
		int choice = keyboard.nextInt();
		Lijst l = buts.getLijst(choice);

		System.out.printf("\t0: multiple choice%n\t1: antwoord invullen%n");
		System.out.print("Kies een type overhoring: ");
		choice = keyboard.nextInt();
		if (choice == 0) {
			MultipleChoice mc = new MultipleChoice(l);
			mc.test();
		} else if (choice == 1) {
			AntwoordInvullen ai = new AntwoordInvullen(l);
			ai.test();
		}
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
