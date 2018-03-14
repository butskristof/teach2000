package teach2000.model.utilities;

import java.util.Random;

/**
 * Class offering a static method with a Random generator for generating ID's to use with Lists, Users, Questions, ...
 *
 * @author Kristof Buts
 */
public class RandomGenerator {
	// class with static functions to generate object ID's
	// TODO convert to Singleton pattern with lazy loading?
	private static Random rnd = new Random();
	private final static char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

	/**
	 * Static method returning a random String of length 32 containing numbers and lowercase letters.
	 * @return Random String of length 32
	 */
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
