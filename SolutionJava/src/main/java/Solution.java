import java.util.*;

public class Solution {
    public int[] circularGameLosers(int n, int k) {
        boolean[] visit = new boolean[51];
        List<Integer> list = new ArrayList<>();
        int cur = 1;
        visit[1] = true;
        int round = 1;
        while (true) {
            cur += k * round;
            if (cur > n) {
                cur %= n;
            }
            if (cur == 0) {
                cur = n;
            }
            if (visit[cur]) {
                break;
            }
            visit[cur] = true;
            ++round;
        }
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                list.add(i);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
