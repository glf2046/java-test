package alg.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最长回文串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class Leet_5_longest_palindromic_substring_Center {

    public static void main(String[] args) {
        String s = "abb";
//        String s = "cbbd";

        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {

        List<String> list = new ArrayList<>();
        char[] oldChars = s.toCharArray();
        for (char aChar : oldChars) {
            list.add(String.valueOf(aChar));
        }

        String t = String.join(",", list);
        char[] chars = t.toCharArray();

        String result = "";

        for (int i = 0; i < chars.length; i++) {
            int k = 1;
            char currentChar = chars[i];
            System.out.println("char: " + currentChar);
            StringBuilder tempResult = new StringBuilder(String.valueOf(currentChar));
            while (i - k >= 0 && i + k < chars.length && chars[i - k] == chars[i + k]) {
                tempResult = new StringBuilder(chars[i - k] + tempResult.toString() + chars[i + k]);
                k++;
            }

            if (tempResult.toString().replace(",", "").length() > result.replace(",", "").length()) {
                result = tempResult.toString().replace(",", "");
            }
        }

        return result;
    }
//
//    作者：reedfan
//    链接：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-fa-he-dong-tai-gui-hua-by-reedfa/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
