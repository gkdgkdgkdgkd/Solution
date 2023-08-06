package utils;

import node.ListNode;
import node.TreeNode;
import utils.chararray.CharArrayUtils;
import utils.convert.ConvertUtils;
import utils.intarray.IntArrayUtils;
import utils.list.ListUtils;
import utils.listnode.ListNodeUtils;
import utils.longarray.LongArrayUtils;
import utils.print.PrintInterface;
import utils.print.PrintUtils;
import utils.random.RandomUtils;
import utils.simulation.SimulationUtils;
import utils.str.StrUtils;
import utils.strarray.StrArrayUtils;
import utils.time.TimeUtils;
import utils.treenode.TreeNodeUtils;

import java.util.List;

public class Utils {
    public static int[] array(int... v) {
        return IntArrayUtils.array(v);
    }

    public static int[][] array(int[]... v) {
        return IntArrayUtils.array(v);
    }

    public static int[][] array2(int k, int... v) {
        return IntArrayUtils.array2(k, v);
    }

    public static char[] array(char... v) {
        return CharArrayUtils.array(v);
    }

    public static char[][] array(char[]... v) {
        return CharArrayUtils.array(v);
    }

    public static char[][] array2(int k, char... v) {
        return CharArrayUtils.array2(k, v);
    }

    public static String[] array(String... v) {
        return StrArrayUtils.array(v);
    }

    public static int randomInt(int start, int end) {
        return RandomUtils.randomInt(start, end);
    }

    public static long randomLong(long start, long end) {
        return RandomUtils.randomLong(start, end);
    }

    public static char[] randomLowercaseArray(int len) {
        return CharArrayUtils.randomLowercaseArray(len);
    }

    public static char[] randomUppercaseArray(int len) {
        return CharArrayUtils.randomUppercaseArray(len);
    }

    public static int[] randomArray(int len, int start, int end) {
        return IntArrayUtils.randomArray(len, start, end);
    }

    public static int[] randomArraySorted(int len, int start, int end) {
        return IntArrayUtils.randomArraySorted(len, start, end);
    }

    public static int[] randomArrayNoRepeated(int len, int start, int end) {
        return IntArrayUtils.randomArrayNoRepeated(len, start, end);
    }

    public static int[] randomArraySortedNoRepeated(int len, int start, int end) {
        return IntArrayUtils.randomArraySortedNoRepeated(len, start, end);
    }

    public static int[] randomArray01(int len) {
        return IntArrayUtils.randomArray01(len);
    }

    public static void print(Object data) {
        PrintUtils.print(data, false);
    }

    public static void print(Object data, boolean split) {
        PrintUtils.print(data, split);
    }

    public static String[] randomStrArray(int arrayLen, int strLen) {
        return StrArrayUtils.randomStrArray(arrayLen, strLen);
    }

    public static String randomLowercaseStr(int len) {
        return StrUtils.randomLowercaseStr(len);
    }

    public static String[] randomLowercaseStr(int len, int count) {
        return StrUtils.randomLowerCaseStr(len, count);
    }

    public static String randomUppercaseStr(int len) {
        return StrUtils.randomUppercaseStr(len);
    }

    public static String randomLetterStr(int len) {
        return StrUtils.randomLetterStr(len);
    }

    public static String randomStr(int len, char... ch) {
        return StrUtils.randomStr(len, ch);
    }

    public static String randomDigitStr(int len) {
        return StrUtils.randomDigitStr(len);
    }

    public static String randomDigitStrWithout0(int len) {
        return StrUtils.randomDigitStrWithout0(len);
    }

    public static String randomDigitStr01(int len) {
        return StrUtils.randomDigitStr01(len);
    }

    public static ListNode listNode(int... val) {
        return ListNodeUtils.listNode(val);
    }

    @SafeVarargs
    public static <T> List<T> listOf(T... val) {
        return ListUtils.listOf(val);
    }

    public static List<List<Integer>> list2(int k, int... v) {
        return ListUtils.list2(k, v);
    }

    public static TreeNode treeNode(int... v) {
        return TreeNodeUtils.deserialize(v);
    }

    public static int[] strToArray(String str) {
        return ConvertUtils.strToArray(str);
    }

    public static int[][] strToArray2(String str) {
        return ConvertUtils.strToArray2(str);
    }

    public static int[][] randomArray2(int m, int n, int start, int end) {
        return IntArrayUtils.randomArray2(m, n, start, end);
    }

    public static String randomTime() {
        return TimeUtils.randomTime();
    }

    public static SimulationUtils getSimulation(Class<?> cls, int total) {
        return new SimulationUtils(cls, total);
    }

    public static long[] randomArray(int len, long start, long end) {
        return LongArrayUtils.randomArray(len, start, end);
    }

    public static void printTestData(int count, PrintInterface printInterface) {
        for (int i = 0; i < count; i++) {
            printInterface.print();
        }
    }
}