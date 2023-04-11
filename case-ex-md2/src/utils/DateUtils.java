package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm");
    public static String dateToString(Date date) {
        return format.format(date);
    }
    public static Date parseDate(String sDate) {
        try {
            return format.parse(sDate);
        } catch (ParseException parseException) {
            System.out.println("Lỗi định dạng");
        }
        return null;
    }
}
