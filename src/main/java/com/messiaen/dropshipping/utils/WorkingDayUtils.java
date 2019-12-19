package com.messiaen.dropshipping.utils;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class WorkingDayUtils {

    private final static List<Integer> OFF_DAYS = Arrays.asList(Calendar.SATURDAY, Calendar.SUNDAY);
    private final static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");

    public static String deliveryDate(Integer min, Integer max) {
        if (max == null)
            return deliveryDate(min);
        return "Entre le " + nextWorkingDays(min) + " et le " + nextWorkingDays(max);

    }

    private static String deliveryDate(Integer min) {
        return "Le " + nextWorkingDays(min);
    }

    private static String nextWorkingDays(Integer days) {
        Calendar calendar = Calendar.getInstance();
        while (days > 0) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            if (!OFF_DAYS.contains(calendar.get(Calendar.DAY_OF_WEEK)))
                days --;
        }
        return sdf.format(calendar);
    }
}
