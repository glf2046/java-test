package com.lefeng.date;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 * @author guff
 * @since 2019-11-18 2:08 PM
 */
public class SimpleDateFormatTest {

    public static void main(String[] args) {
        long d1 = new Date().getTime();
        Date date1 = Date.from(Instant.ofEpochMilli(d1));

        System.out.println(new SimpleDateFormat().format(d1));

    }
}
