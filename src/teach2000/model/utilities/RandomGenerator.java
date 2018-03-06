package teach2000.model.utilities;

import java.util.Random;

/**
 * @author Kristof Buts
 */
public class RandomGenerator {
	private static Random rnd = new Random();
	private final static char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

	public static String getRandomId() {
		StringBuilder ret = new StringBuilder(32);
		for (int i = 0; i < 20; i++) {
			char c = chars[rnd.nextInt(chars.length)];
			ret.append(c);
		}

		return ret.toString();
	}
}
