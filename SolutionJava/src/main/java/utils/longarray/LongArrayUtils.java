package utils.longarray;

import utils.Utils;
import utils.random.RandomUtils;

import java.util.*;

import static utils.random.RandomUtils.randomInt;

public class LongArrayUtils {

    public static long[] array(long... v) {
        return v;
    }

    public static long[][] array(long[]... v) {
        return v;
    }

    public static long[][] array2(int k, long... v) {
        int n = v.length / k;
        long[][] arr = new long[n][k];
        for (int i = 0; i < n; i++) {
            System.arraycopy(v, i * k, arr[i], 0, k);
        }
        return arr;
    }

    public static long[] randomArray(int len, long start, long end) {
        long[] arr = new long[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Utils.randomLong(start, end);
        }
        return arr;
    }

    public static long[][] randomArray(int len, long start, long end, int count) {
        long[][] arr = new long[count][len];
        for (int i = 0; i < count; i++) {
            arr[i] = randomArray(len, start, end);
        }
        return arr;
    }

    public static long[] randomArraySorted(int len, long start, long end) {
        long[] arr = randomArray(len, start, end);
        Arrays.sort(arr);
        return arr;
    }

    public static long[] randomArrayNoRepeated(int len, long start, long end) {
        if (end - start + 1 < len) {
            return new long[0];
        }
        List<Long> list = new ArrayList<>(len);
        Set<Long> set = new HashSet<>(len);
        while (list.size() < len) {
            long num = Utils.randomLong(start, end);
            if (!set.contains(num)) {
                set.add(num);
                list.add(num);
            }
        }
        return list.stream().mapToLong(i -> i).toArray();
    }

    public static long[] randomArraySortedNoRepeated(int len, long start, long end) {
        long[] arr = randomArrayNoRepeated(len, start, end);
        Arrays.sort(arr);
        return arr;
    }
}
