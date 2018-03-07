package teach2000.model.questions;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author Kristof Buts
 * @version 1.0 07/03/18 21:35
 */
public class QuestionIO {
	/*
	This class can write questions.
	Only this class can read the answer and alternative answers separately, access is package-private
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
