package utils.time;

import utils.Utils;

public class TimeUtils {
    public static String randomTime() {
        int hour = Utils.randomInt(0, 23);
        int minute = Utils.randomInt(0, 59);
        return (hour < 10 ? "0" + hour : hour) + ":" + (minute < 10 ? "0" + minute : minute);
    }
}
