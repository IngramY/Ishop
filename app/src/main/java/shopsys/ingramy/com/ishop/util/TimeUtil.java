package shopsys.ingramy.com.ishop.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by 大灯泡 on 2016/2/25.
 * 时间工具类
 */
public class TimeUtil {
    /**
     * <1分钟：刚刚
     * <1小时：N分钟前
     * 当天：N小时前
     * 昨天：昨天 HH:mm
     * N天前：MM-dd HH:mm
     * 去年：yyyy-MM-dd HH:mm
     */
    public static String getTimeString(long milliseconds){
        long dt = System.currentTimeMillis() - milliseconds;
        if (dt < 60000) {
            return "刚刚";
        } else if (dt < 3600000) {
            return (dt / 60000) + "分钟前";
        }

        Calendar nowCal = Calendar.getInstance();
        String theTimeStr = getTime("yyyy-MM-dd", milliseconds);

        String str = getTime("yyyy-MM-dd", nowCal.getTimeInMillis());
        if (theTimeStr.equals(str)) {
            return (dt / 3600000) + "小时前";
        }

        nowCal.add(Calendar.DATE, -1);
        str = getTime("yyyy-MM-dd", nowCal.getTimeInMillis());
        if (theTimeStr.equals(str)) {
            return "昨天" + " " + getTime("HH:mm", milliseconds);
        }

        nowCal.add(Calendar.DATE, 1);
        theTimeStr = getTime("yyyy", milliseconds);
        str = getTime("yyyy", nowCal.getTimeInMillis());
        if (theTimeStr.equals(str)) {
            return getTime("MM-dd HH:mm", milliseconds);
        }

        return getTime("yyyy-MM-dd HH:mm", milliseconds);
    }
    private static String getTime(String formatString, long milliseconds){
        return new SimpleDateFormat(formatString, Locale.getDefault()).format(new Date(milliseconds));
    }

    /**
     * 将字符串数据转化为毫秒数
     */
    public static Long stringToLong(String formatString, String dateTime) {
//        String dateTime="20121025112950";
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(new SimpleDateFormat(formatString).parse(dateTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return c.getTimeInMillis();
//        System.out.println("时间转化后的毫秒数为：" + c.getTimeInMillis());
    }

    /**
     *
     * @param dataString yyyy-MM-dd HH:mm:ss   格式的时间数据
     *
     * @return
     */
    public static String getTimeString(String dataString) {
        Long dataLong = stringToLong("yyyy-MM-dd HH:mm:ss", dataString);

        return getTimeString(dataLong);
    }
}
