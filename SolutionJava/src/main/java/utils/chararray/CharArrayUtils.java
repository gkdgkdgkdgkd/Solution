package utils.chararray;

import utils.random.RandomUtils;

public class CharArrayUtils {
    public static char[] array(char... v) {
        return v;
    }

    public static char[][] array(char[]... v) {
        return v;
    }

    public static char[][] array2(int k, char... v) {
        int n = v.length / k;
        char[][] arr = new char[n][k];
        for (int i = 0; i < n; i++) {
            System.arraycopy(v, i * k, arr[i], 0, k);
        }
        return arr;
    }

    public static char[] randomLowercaseArray(int len) {
        char[] arr = new char[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (char) ('a' + RandomUtils.randomInt(26));
        }
        return arr;
    }

    public static char[] randomUppercaseArray(int len) {
        char[] arr = new char[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (char) ('A' + RandomUtils.randomInt(26));
        }
        return arr;
    }
}
