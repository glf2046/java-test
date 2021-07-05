package alg.slide_window;

import java.util.HashMap;
import java.util.Map;

public class Leet_3_no_repeat_max_substring_2 {
    public static void main(String[] args) {
        String s = "abcba";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String str) {
        if (str == null) {
            return 0;
        }

        if (str.length() == 1) {
            return 1;
        }

        int max = 0;
        char[] chars = str.toCharArray();

        Map<Character, Integer> window = new HashMap<>();

        int right = 0;
        int left = 0;

        while (left <= right && left < chars.length && right < chars.length) {
            window.put(chars[right++], window.getOrDefault(chars[right], 0) + 1);
            if (window.get(chars[right]) > 1) {
                max = Math.max(max, window.size());
                while (window.get(chars[left++]) == 1) {
                    window.put(chars[right], window.get(chars[right]) - 1);
                }
            }
        }

        return 0;
    }
}
