package utils.random;

import java.util.Random;

public class RandomUtils {
    private static final Random random = new Random();

    public static int randomInt() {
        return random.nextInt();
    }

    public static int randomInt(int bound) {
        return random.nextInt(bound);
    }

    public static int randomInt(int start, int end) {
        if (start == Integer.MIN_VALUE && end == Integer.MAX_VALUE) {
            return random.nextInt();
        }
        return random.nextInt(end - start + 1) + start;
    }

    public static long randomLong(long start, long end) {
        if (start == Long.MIN_VALUE && end == Long.MAX_VALUE) {
            return random.nextLong();
        }
        return random.nextLong(end - start + 1) + start;
    }
}
