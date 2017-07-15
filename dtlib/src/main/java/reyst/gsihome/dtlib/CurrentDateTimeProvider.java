package reyst.gsihome.dtlib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CurrentDateTimeProvider {
    public static String getDateTime(String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
            return sdf.format(new Date());
        } catch (Throwable ignored) {
            return null;
        }
    }
}
