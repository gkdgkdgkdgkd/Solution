package utils.check;

public class CheckUtils {
    public static boolean checkSorted(int [] v){
        int n = v.length;
        for (int i = 1; i < n; i++) {
            if(v[i] < v[i-1]) {
                return false;
            }
        }
        return true;
    }
}
