package utils.intarray;

import utils.random.RandomUtils;

import java.util.*;

import static utils.random.RandomUtils.randomInt;

public class IntArrayUtils {

    public static int[] array(int... v) {
        return v;
    }

    public static int[][] array(int[]... v) {
        return v;
    }

    public static int[][] array2(int k, int... v) {
        int n = v.length / k;
        int[][] arr = new int[n][k];
        for (int i = 0; i < n; i++) {
            System.arraycopy(v, i * k, arr[i], 0, k);
        }
        return arr;
    }

    public static int[] randomArray(int len, int start, int end) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = randomInt(start, end);
        }
        return arr;
    }

    public static int[][] randomArray2(int m, int n, int start, int end) {
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            arr[i] = randomArray(n, start, end);
        }
        return arr;
    }

    public static int[] randomArraySorted(int len, int start, int end) {
        int[] arr = randomArray(len, start, end);
        Arrays.sort(arr);
        return arr;
    }

    public static int[] randomArrayNoRepeated(int len, int start, int end) {
        if (end - start + 1 < len) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>(len);
        Set<Integer> set = new HashSet<>(len);
        while (list.size() < len) {
            int num = RandomUtils.randomInt(start, end);
            if (!set.contains(num)) {
                set.add(num);
                list.add(num);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static int[] randomArraySortedNoRepeated(int len, int start, int end) {
        int[] arr = randomArrayNoRepeated(len, start, end);
        Arrays.sort(arr);
        return arr;
    }

    public static int[] randomArray01(int len) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = randomInt(2);
        }
        return arr;
    }
}
