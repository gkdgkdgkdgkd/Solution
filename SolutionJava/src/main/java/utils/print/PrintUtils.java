package utils.print;

import node.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class PrintUtils {
    private static final Map<Class<?>, Consumer<Object>> separatedInterface = new HashMap<>();
    private static final Map<Class<?>, Consumer<Object>> notSeparatedInterface = new HashMap<>();

    static {
        separatedInterface.put(String[].class, o -> {
            String[] str = (String[]) o;
            for (String s : str) {
                System.out.println(s);
            }
        });
        separatedInterface.put(int[][].class, o -> {
            int[][] arr = (int[][]) o;
            for (int[] a : arr) {
                System.out.println(Arrays.toString(a));
            }
        });

        notSeparatedInterface.put(char[].class, o -> {
            char[] c = (char[]) o;
            int n = c.length;
            System.out.print("[");
            for (int i = 0; i < n - 1; i++) {
                System.out.print("\"" + c[i] + "\",");
            }
            System.out.println("\"" + c[n - 1] + "\"]");
        });
        notSeparatedInterface.put(String[].class, o -> {
            String[] str = (String[]) o;
            System.out.print("[");
            int n = str.length;
            for (int i = 0; i < n; i++) {
                System.out.print("\"" + str[i] + "\"" + (i == n - 1 ? "" : ","));
            }
            System.out.println("]");
        });
        notSeparatedInterface.put(int[].class, o -> System.out.println(Arrays.toString((int[]) o)));
        notSeparatedInterface.put(long[].class, o -> System.out.println(Arrays.toString((long[]) o)));
        notSeparatedInterface.put(double[].class, o -> System.out.println(Arrays.toString((double[]) o)));
        notSeparatedInterface.put(ListNode[].class, o -> System.out.println(Arrays.toString((ListNode[]) o)));
        notSeparatedInterface.put(int[][].class, o -> System.out.println(Arrays.deepToString((int[][]) o)));
        notSeparatedInterface.put(char[][].class, o -> System.out.println(Arrays.deepToString((char[][]) o)));
        notSeparatedInterface.put(byte[].class, o -> System.out.println(Arrays.toString((byte[]) o)));
        notSeparatedInterface.put(String.class, o -> System.out.println("\"" + o + "\""));
    }

    public static void print(Object obj, boolean split) {
        if (obj == null) {
            System.out.println("null");
            return;
        }
        if (split) {
            separatedInterface.getOrDefault(obj.getClass(), System.out::println).accept(obj);
        } else {
            notSeparatedInterface.getOrDefault(obj.getClass(), System.out::println).accept(obj);
        }
    }
}