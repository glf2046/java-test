package alg.slide_window.max_length_norepeat_substring;

import java.util.HashMap;

public class lengthOfLongestSubstring_Rework1 {
    public static void main(String[] args) {
        String s1 = "ggububgvfk";
        System.out.println(maxSubStringWithoutRepeat(s1));
    }

    private static int maxSubStringWithoutRepeat(String str) {
        char[] s = str.toCharArray();
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        int res = 0;

        while (right < s.length) {
            char c1 = s[right];
            if (window.containsKey(c1)) {
                window.put(c1, window.get(c1) + 1);
            } else {
                window.put(c1, 1);
            }
            right++;

            if (window.get(c1) > 1) {
                //不断从左侧缩小窗口，找到和当前c1重复的值所在的位置，然后设置重复的位置为新的窗口左侧起点
                while (left <= right) {
                    char c2 = s[left];
                    window.put(c2, window.get(c2) - 1);
                    if (s[left] == c1) {
                        break;
                    }

                    left++;
                }

                left++;
            }

            res = Math.max(res, right - left);
        }

        return res;
    }
}
