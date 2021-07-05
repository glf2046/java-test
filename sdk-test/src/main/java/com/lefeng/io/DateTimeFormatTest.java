package com.lefeng.io;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class DateTimeFormatTest {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();

        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, Locale.GERMAN);
        String result = df.format(date);
        System.out.println(result);

        df = DateFormat.getTimeInstance(DateFormat.FULL, Locale.CHINA);
        result = df.format(date);
        System.out.println(result);

        df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG, Locale.CHINA);
        result = df.format(date);
        System.out.println(result);

        String s = "10-9-26";
        df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG, Locale.CHINA);
        Date d = df.parse(s);
        System.out.println(d);
    }
}
