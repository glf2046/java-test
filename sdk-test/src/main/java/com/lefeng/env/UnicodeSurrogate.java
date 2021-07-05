package com.lefeng.env;

public class UnicodeSurrogate {
    public static void main(String[] args) {
        char c1 = '\udd6b';
        System.out.println(c1);
        System.out.println("Z");
        System.out.println("#########");
        String s1 = "\uD835\uDD6B";
        System.out.println(s1);
        System.out.println("#########");
        testSurrogate();
    }

    private static void testSurrogate(){
        String str = new String(Character.toChars(0x1D56B));
        System.out.println(str.codePointCount(0, str.length()));
        System.out.println("length: " + str.length());
        System.out.println("################");
        System.out.println(str);
        int cp=str.codePointAt(0);
        System.out.println(Integer.toHexString(cp));
        if(Character.isSupplementaryCodePoint(cp)) {//判断Unicode 代码点是否在附加级别字符范围内。
            System.out.println(Integer.toHexString(str.codePointAt(1)));
            System.out.println(true);
        }
    }
}
