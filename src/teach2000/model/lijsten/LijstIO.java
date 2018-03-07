package teach2000.model.lijsten;

import teach2000.model.vragen.Vraag;
import teach2000.model.vragen.VraagIO;

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
	This class handles the importing and exporting of the user's lists
	In the resources, there's a folder which contains a directory for each user
	 */

	/*
	format for storing lists:
	LANG_FROM	LANG_TO
	NO_OF_QUESTIONS
	QUESTION	ANSWER	NO_OF_ALTERNATIVES	ALTERNATIVES
	 */

	// each user has a folder with its id as name that contains all his lists
	private static final String userlistfile_prefix = "resources/lists";

	public static ArrayList<Lijst> readAllLists(String userid) {
		// function to read all the lists in the user's folder and return them as an ArrayList

		// generate path to user's folder
		Path userfolder = Paths.get(userlistfile_prefix, userid);

		// Check if user's folder exists and create it if necessary
		if (!Files.exists(userfolder)) {
			try {
				Files.createDirectory(userfolder);
			} catch (IOException e) {
				// TODO
				// should be extended
				e.printStackTrace();
			}
		}
		// Create list of files in user's folder
		File[] files = new File(userfolder.toString()).listFiles();

		// initialise return variable
		ArrayList<Lijst> ret = new ArrayList<>();

		// loop over all files and read them
		// TODO add exception handling
		for (File f: files) {
			// check if it's a file
			if (f.isFile()) {
				// read list and add to return var
				ret.add(readList(userid, f.getName()));
			}
		}

		return ret;
	}

	public static Lijst readList(String userid, String listid) {
		// Read in a list and return it to the calling function
		// TODO exception handling
		Lijst ret = null; // initialise return variable
		// Generate path to file
		Path userfolder = Paths.get(userlistfile_prefix, userid);
		Path file = userfolder.resolve(listid);

		// open buffered input stream to file
		try (DataInputStream is = new DataInputStream(new BufferedInputStream(new FileInputStream(file.toString())))) {
			// create new list
			// read languages from and to
			ret = new Lijst(is.readUTF(), is.readUTF());
			// read number of questions stored
			int no_questions = is.readInt();
			// loop over all questions
			for (int i = 0; i < no_questions; ++i) {
				// Read data and build question
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
		// write list to file in user's folder
		// generate path to user's folder
		Path userfolder = Paths.get(userlistfile_prefix, userid);
		// Check if user's folder exists and create it if necessary
		if (!Files.exists(userfolder)) {
			try {
				Files.createDirectory(userfolder);
			} catch (IOException e) {
				// TODO
				// should be extended
				e.printStackTrace();
			}
		}
		Path file = userfolder.resolve(list.getId()); // path to specific file

		// Get questions
		ArrayList<Vraag> vragen = list.getVragen();
		try (DataOutputStream os = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file.toString())))) {
			// write meta information
			os.writeUTF(list.getLang_from());
			os.writeUTF(list.getLang_to());
			os.writeInt(vragen.size());

			// write away each question
			for (Vraag v: vragen) {
				// writing the question is handled by a separate class for security reasons
				VraagIO.writeVraag(v, os);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
