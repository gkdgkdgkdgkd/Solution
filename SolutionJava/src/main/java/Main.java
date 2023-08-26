import utils.Utils;

import java.util.Base64;

public class Main {
    private static final Solution SOLUTION = new Solution();

    public static void main(String[] args) {
        Utils.printTestData(1,()->{
            int n = Utils.randomInt(500,1000);
            for (int i = 0; i < n; i++) {
                int start=  Utils.randomInt(0,9999) ;
                int end=  Utils.randomInt(0,9999) ;
            }
        });
    }
}