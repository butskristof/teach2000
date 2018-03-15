package teach2000.model.lists;

import teach2000.Teach2000Exception;
import teach2000.model.questions.Question;
import teach2000.model.questions.QuestionIO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * This is a dedicated IO class for List with only static methods.
 * Everything IO-related is separated from the main List class.
 * By default, the location is a folder per user in the resources/lists/ directory.
 *
 * Lists are always written as a binary file in the following format:
 * LISTID
 * LANG_FROM	LANG_TO		NAME
 * NO_OF_QUESTIONS
 * QUESTION		ANSWER		NO_OF_ALTERNATIVES		ALTERNATIVES
 *
 * For the reading and writing of the questions themselves, QuestionIO must be used.
 *
 * @author Kristof Buts
 */

public class ListIO {
	// each user has a folder with its id as name that contains all his lists
	private static final String userlistfile_prefix = "resources/lists";

	/**
	 * This method reads all lists stored in the passed in user's folder.
	 * It loops through all the files and compiles one ArrayList that can be assigned to the user.
	 *
	 * @param userid ID of the user we want to read the lists for
	 * @return an ArrayList of List elements that contains all the lists stored for the user
	 */
	public static ArrayList<List> readAllLists(String userid) throws Teach2000Exception {
		// function to read all the lists in the user's folder and return them as an ArrayList

		// generate path to user's folder
		Path userfolder = Paths.get(userlistfile_prefix, userid);

		// Check if user's folder exists and create it if necessary
		if (!Files.exists(userfolder)) {
			try {
				Files.createDirectories(userfolder);
			} catch (IOException e) {
				// should be extended
//				e.printStackTrace();
				throw new Teach2000Exception("Unable to create user list folder");
			}
		}
		// Create list of files in user's folder
		File[] files = new File(userfolder.toString()).listFiles();

		// initialise return variable
		ArrayList<List> ret = new ArrayList<>();

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

	/**
	 * Reads in one list when given a User ID and List ID.
	 *
	 * @param userid ID of the user
	 * @param listid ID of the list
	 * @return List object that was read from disk
	 */
	public static List readList(String userid, String listid) throws Teach2000Exception {
		// Read in a list and return it to the calling function
		// TODO exception handling
		List ret = null; // initialise return variable
		// Generate path to file
		Path userfolder = Paths.get(userlistfile_prefix, userid);
		Path file = userfolder.resolve(listid);

		ret = readList(file.toFile());

		return ret;
	}

	// pass in the result of a FileChooser

	/**
	 *
	 * Reads in one list when given a File object, e.g. returned from a FileChooser.
	 *
	 * @param file File object representing the List file
	 * @return List object that was read from disk.
	 */
	public static List readList(File file) throws Teach2000Exception {
		// Read in a list and return it to the calling function
		// TODO exception handling
		List ret = null; // initialise return variable

		// open buffered input stream to file
		try (DataInputStream is = new DataInputStream(new BufferedInputStream(new FileInputStream(file.toString())))) {
			// create new list
			// read list id
			// read languages from and to
			ret = new List(is.readUTF(), is.readUTF(), is.readUTF(), is.readUTF());
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

				Question v = new Question(question, answer, alternatives);
				ret.addQuestion(v);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new Teach2000Exception(ex);
		}

		return ret;
	}

	/**
	 *
	 * Writes one List to disk in the default user folder.
	 *
	 * @param userid ID of the user
	 * @param list List item to be written to disk
	 */
	public static void writeList(String userid, List list) {
		// Generate path to file and pass on to overloaded function
		Path userfolder = Paths.get(userlistfile_prefix, userid);
		Path file = userfolder.resolve(list.getId());

		writeList(file.toFile(), list);
	}

	/**
	 * Writes one List to disk in the specified location. Can be used for exporting.
	 *
	 * @param file File object represented the path to the desired location.
	 * @param list List object to be written to disk.
	 */
	public static void writeList(File file, List list) throws Teach2000Exception {
		// export a list to a file

		// Check if parent folder exists and create if necessary
		// Check if path exists and create if necessary
		Path pathToFile = file.toPath();
		if (!Files.exists(pathToFile.getParent())) {
			try {
				Files.createDirectories(pathToFile.getParent());
			} catch (IOException e) {
				// TODO
				// should be extended
				e.printStackTrace();
			}
		}

		// Get questions
		ArrayList<Question> vragen = list.getVragen();
		try (DataOutputStream os = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file.toString())))) {
			// write meta information
			os.writeUTF(list.getId());
			os.writeUTF(list.getLang_from());
			os.writeUTF(list.getLang_to());
			os.writeUTF(list.getName());
			os.writeInt(vragen.size());

			// write away each question
			for (Question v: vragen) {
				// writing the question is handled by a separate class for security reasons
				QuestionIO.writeQuestion(v, os);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new Teach2000Exception(ex);
		}
	}

	/**
	 * Delete a List that's in the user's default folder.
	 *
	 * @param userid User ID
	 * @param listid List ID
	 */
	public static void removeList(String userid, String listid) throws Teach2000Exception {
		// write list to file in user's folder
		// generate path to user's folder
		Path userfolder = Paths.get(userlistfile_prefix, userid);
		// Check if user's folder exists and create it if necessary
		if (!Files.exists(userfolder)) {
			try {
				Files.createDirectory(userfolder);
			} catch (IOException e) {
				e.printStackTrace();
				throw new Teach2000Exception(e);
			}
		}
		Path file = userfolder.resolve(listid); // path to specific file

		// try to remove file
		if (Files.exists(file)) {
			try {
				Files.delete(file);
			} catch (IOException ex) {
				ex.printStackTrace();
				throw new Teach2000Exception(ex);
			}
		}
	}

}
