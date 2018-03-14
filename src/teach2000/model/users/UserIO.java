package teach2000.model.users;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * @author Kristof Buts
 * @version 1.0 14/03/18 17:03
 */
public class UserIO {

	/*
	FORMAT:
	USER ID
	USER NAME
	HAS_STOPWORD
		STOPWORD
		MIN_REQUIRED_SCORE
	 */

	private static final String FILE = "resources/users.bin";

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
						newuser.setStopword(is.readUTF());
						newuser.setMinimumRequiredScoreToStop(is.readInt());
					}

					ret.add(newuser);
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return ret;


	}

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
