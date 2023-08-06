package utils.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtils {
    @SafeVarargs
    public static <T> List<T> listOf(T... v) {
        return new ArrayList<>(v.length) {
            {
                addAll(Arrays.asList(v));
            }
        };
    }

    public static List<List<Integer>> list2(int k, int... v) {
        int n = v.length / k;
        List<List<Integer>> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            List<Integer> arr = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                arr.add(v[i * k + j]);
            }
            list.add(arr);
        }
        return list;
    }
}
