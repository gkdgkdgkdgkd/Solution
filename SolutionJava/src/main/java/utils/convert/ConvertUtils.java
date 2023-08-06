package utils.convert;

import java.util.Iterator;
import java.util.LinkedList;

public class ConvertUtils {
    public static int[][] strToArray2(String str) {
        char[] c = str.toCharArray();
        int n = c.length;
        LinkedList<LinkedList<Integer>> list = new LinkedList<>();
        int base = 0;
        for (int i = 1; i < n - 2; ++i) {
            if (c[i] == '[') {
                LinkedList<Integer> temp = new LinkedList<>();
                for (++i; c[i] != ']'; ++i) {
                    if (isDigit(c[i])) {
                        base *= 10;
                        base += c[i] - '0';
                    }
                    if (c[i] == ',') {
                        temp.addLast(base);
                        base = 0;
                    }
                }
                temp.addLast(base);
                base = 0;
                list.addLast(new LinkedList<>(temp));
                temp.clear();
            }
        }
        int m = list.size();
        n = list.get(0).size();
        int[][] res = new int[m][n];
        var iterator = list.iterator();
        for (int i = 0; i < m; i++) {
            var arr = iterator.next().iterator();
            for (int j = 0; j < n; j++) {
                res[i][j] = arr.next();
            }
        }
        return res;
    }

    public static int[] strToArray(String str) {
        char[] c = str.toCharArray();
        int n = c.length;
        LinkedList<Integer> list = new LinkedList<>();
        int base = 0;
        for (int i = 1; i < n - 1; ++i) {
            if (c[i] == ']' || c[i] == '[') {
                continue;
            }
            if (isDigit(c[i])) {
                base *= 10;
                base += c[i] - '0';
            }
            if (c[i] == ',') {
                list.addLast(base);
                base = 0;
            }
        }
        list.addLast(base);
        n = list.size();
        int[] res = new int[n];
        Iterator<Integer> iterator = list.iterator();
        for (int i = 0; i < n; i++) {
            res[i] = iterator.next();
        }
        return res;
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
