package com.messiaen.dropshipping.utils;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class WorkingDayUtils {

    private final static List<DayOfWeek> OFF_DAYS = Arrays.asList(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);
    private final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE d MMMM", Locale.FRANCE);

    public static String deliveryDate(Integer min, Integer max) {
        if (max == null)
            return deliveryDate(min);

        return "Livraison prévue entre le " + nextWorkingDays(min) + " et le " + nextWorkingDays(max);

    }

    private static String deliveryDate(Integer min) {
        return "Livraison prévue le " + nextWorkingDays(min);
    }

    private static String nextWorkingDays(Integer days) {
        LocalDateTime ldt = LocalDateTime.now();
        while (days > 0) {
            ldt = ldt.plusDays(1);
            if (!OFF_DAYS.contains(ldt.getDayOfWeek()))
                days --;
        }
        return dtf.format(ldt);
    }
}
