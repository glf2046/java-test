package com.lefeng.string;

import java.util.StringTokenizer;

/**
 * @author guff
 * @since 2020-05-21 19:14
 */
public class StringTokenizerTest {
    public static void main(String[] args) {
        StringTokenizer stringTokenizer = new StringTokenizer("a b c", " ");
        while (stringTokenizer.hasMoreElements()) {
            System.out.println(stringTokenizer.nextElement());
        }
    }
}
