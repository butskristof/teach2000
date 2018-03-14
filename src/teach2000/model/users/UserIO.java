package teach2000.model.users;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * This is a dedicated IO class for User object that only has static methods. It is used to separate all IO-related operations
 * from the main business logic and will take care of everything for importing and exporting users.
 *
 * Default location for the user's file is resources/users.bin .
 *
 * Users are written to disk as a binary file with the following format:
 * USERID
 * USERNAME
 * HAS_STOPWORD
 * 		STOPWORD
 * 		MIN_REQUIRED_SCORE
 *
 * @author Kristof Buts
 * @version 1.0 14/03/18 17:03
 */
public class UserIO {

	private static final String FILE = "resources/users.bin";

	/**
	 * This method will import all users in the users.bin file and return them as an ArrayList.
	 *
	 * @return ArrayList containing all the User objects that were read in from disk
	 */
	public static ArrayList<User> readUsers() {
		// Users are imported from binary file
		// try to open users file

		ArrayList<User> ret = new ArrayList<>();

		// if users file doesn't exist, stop
		if (Files.exists(Paths.get(FILE))) {
			try (DataInputStream is = new DataInputStream(new BufferedInputStream(new FileInputStream(FILE)))) {
				// loop over all entries
				while (is.available() > 0) {
					User newuser = new User(is.readUTF(), is.readUTF()); // user ID and name are read from stream
					boolean hasStopword = is.readBoolean();
					if (hasStopword) {
						newuser.enableStopword(is.readUTF(), is.readInt()); // stopword and min. req. score are passed in
					}

					ret.add(newuser);
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return ret;


	}

	/**
	 * This method writes all users to disk.
	 *
	 * @param users ArrayList containing all User objects to be saved
	 */
	public static void writeUsersToFile(ArrayList<User> users) {
		// Write user information to file
		// UserIO should be extracted to separate utility class
		try (DataOutputStream os = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(FILE)))) {
			for (User u: users) {
				os.writeUTF(u.getId());
				os.writeUTF(u.getName());

				os.writeBoolean(u.getHasStopword());
				if (u.getHasStopword()) {
					os.writeUTF(u.getStopword());
					os.writeInt(u.getMinimumRequiredScoreToStop());
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
