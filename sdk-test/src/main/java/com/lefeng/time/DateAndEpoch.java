package com.lefeng.time;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

/**
 * @author guff
 * @since 2019-10-04 12:46 PM
 */
public class DateAndEpoch {

    public static void main(String[] args) {
        //1. year is the amount - 1900
        Date date = new Date(9999-1900, 9,9);
        System.out.println(date);

        //Date.getTime() gets the milli seconds from Epoch, i.e. 1970-1-1 00:00:00 GMT
        System.out.println(date.getTime());

        //new Date(long) creates a Date from amount of milli seconds from Epoch, i.e. 1970-1-1 00:00:00 GMT
        System.out.println(new Date(253392422400000L));

        //System.currentTimeMillis() gets the milli seconds from Epoch, i.e. 1970-1-1 00:00:00 GMT, same as Date.getTime()
        System.out.println(System.currentTimeMillis());

        //used to get the relative nano time, the origin time point can vary and result can even be negative.
        System.out.println(System.nanoTime());
    }
}
