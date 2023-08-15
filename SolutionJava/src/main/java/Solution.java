import java.util.*;

public class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = indices.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = indices[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        StringBuilder res = new StringBuilder();
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] v:arr){
            if (s.indexOf(sources[v[1]]) == v[0]) {
                list.add(v);
            }
        }
        int lastBegin = 0;
        for (int[] v : list) {
            // last begin
            // v[0] is
            res.append(s.substring(lastBegin, v[0]));
            res.append(targets[v[1]]);
            // abc
            // 0123
            lastBegin = v[0] + sources[v[1]].length();
        }
        res.append(s.substring(lastBegin));
        return res.toString();
    }
}
