package teach2000.model.utilities;

import java.util.Random;

/**
 * @author Kristof Buts
 */
public class RandomGenerator {
	// class with static functions to generate object ID's
	private static Random rnd = new Random();
	private final static char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

	public static String getRandomId() {
		StringBuilder ret = new StringBuilder(32);

		// get 32 random elements from char array and append to stringbuilder
		for (int i = 0; i < 32; i++) {
			char c = chars[rnd.nextInt(chars.length)];
			ret.append(c);
		}

		return ret.toString();
	}
}
