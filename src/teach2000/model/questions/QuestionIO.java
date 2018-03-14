package teach2000.model.questions;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * This is a dedicated Question IO class with only static methods. It is used to separate everything IO-related from
 * the main business logic, while keeping all information in the Question object package-private.
 *
 * Questions are written in binary format using the following layout:
 * QUESTION		ANSWER		NO_OF_ALTERNATIVES		ALTERNATIVES
 *
 * @author Kristof Buts
 * @version 1.0 07/03/18 21:35
 */
public class QuestionIO {
	/**
	 * This class is used to serialise a Question object and write it to a DataOutputStream.
	 * Only this class can read the necessary information because access is package-private.
	 *
	 * @param v Question to be written to output stream
	 * @param os Output stream to which the Question should be written.
	 */
	public static void writeQuestion(Question v, DataOutputStream os) {
		int no_alternatives = v.getAlternatives().length;
		try {
			os.writeUTF(v.getQuestion());
			os.writeUTF(v.getAnswer());
			os.writeInt(no_alternatives);
			for (int i = 0; i < no_alternatives; ++i) {
				os.writeUTF(v.getAlternatives()[i]);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
