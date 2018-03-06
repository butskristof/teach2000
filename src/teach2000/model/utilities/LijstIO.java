package teach2000.model.utilities;

import teach2000.model.Lijst;
import teach2000.model.Vraag;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * @author Kristof Buts
 */
public class LijstIO {
	/*
	format:
	LANG_FROM	LANG_TO
	NO_OF_QUESTIONS
	QUESTION	ANSWER	NO_OF_ALTERNATIVES	ALTERNATIVES
	 */
	private static final String userlistfile_prefix = "resources/lists";

	public static ArrayList<Lijst> readAllLists(String userid) {
		Path userfolder = Paths.get(userlistfile_prefix, userid);
		if (!Files.exists(userfolder)) {
			try {
				Files.createDirectory(userfolder);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		File[] files = new File(userfolder.toString()).listFiles();

		ArrayList<Lijst> ret = new ArrayList<>();

		for (File f: files) {
			if (f.isFile()) {
//				System.out.println(f.getName());
				ret.add(readList(userid, f.getName()));
			}
		}

		return ret;
	}

	public static Lijst readList(String userid, String listid) {
		Lijst ret = null;
		Path userfolder = Paths.get(userlistfile_prefix, userid);
		Path file = userfolder.resolve(listid);

		try (DataInputStream is = new DataInputStream(new BufferedInputStream(new FileInputStream(file.toString())))) {
			ret = new Lijst(is.readUTF(), is.readUTF());
			int no_questions = is.readInt();
			for (int i = 0; i < no_questions; ++i) {
				String question = is.readUTF();
				String answer = is.readUTF();
				int no_alternatives = is.readInt();
				String[] alternatives = new String[no_alternatives];
				for (int j = 0; j < no_alternatives; ++j) {
					alternatives[j] = is.readUTF();
				}

				Vraag v = new Vraag(question, answer, alternatives);
				ret.addVraag(v);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return ret;
	}

	public static void writeList(String userid, Lijst list) {
		Path userfolder = Paths.get(userlistfile_prefix, userid);
		try {
			Files.createDirectories(userfolder);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Path file = userfolder.resolve(list.getId());

		ArrayList<Vraag> vragen = list.getVragen();
		try (DataOutputStream os = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file.toString())))) {
			// write meta information
			os.writeUTF(list.getLang_from());
			os.writeUTF(list.getLang_to());
			os.writeInt(vragen.size());

			for (Vraag v: vragen) {
				int no_alternatives = v.getAlternatives().length;
				os.writeUTF(v.getQuestion());
				os.writeUTF(v.getAnswer());
				os.writeInt(no_alternatives);
				for (int i = 0; i < no_alternatives; ++i) {
					os.writeUTF(v.getAlternatives()[i]);
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
