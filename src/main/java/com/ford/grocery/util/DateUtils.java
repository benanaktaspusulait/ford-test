package com.ford.grocery.util;


import java.util.Calendar;
import java.util.Date;

public class DateUtils {


    public static Date daysAfter(Integer dayNumber) {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, dayNumber);
        return cal.getTime();
    }

    public static Date getEndOfMonth() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return c.getTime();
    }


}