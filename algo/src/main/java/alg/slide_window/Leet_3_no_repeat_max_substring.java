package alg.slide_window;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串(滑动窗口+双指针）
 */
public class Leet_3_no_repeat_max_substring {
    public static void main(String[] args) {
        String s = "abcba";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String str) {
        char[] s = str.toCharArray();
        int left = 0, right = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        int res = 0; // 记录最长长度

        while (right < s.length) {
            char c1 = s[right];
            window.put(c1, window.getOrDefault(c1, 0) + 1);
            right++;
            // 如果 window 中出现重复字符
            // 开始移动 left 缩小窗口，因为是while循环，所以left会最终移动到重复的位置的下一个位置
            //老的left和新的left之间的字符数量都被清0了
            while (window.get(c1) > 1) {
                printMap(window);
                char c2 = s[left];
                window.put(c2, window.get(c2) - 1);
                left++;
            }
            res = Math.max(res, right - left);
            printMap(window);
        }
        printMap(window);
        return res;
    }

    private static void printMap(HashMap<Character, Integer> window) {
        for (Map.Entry<Character, Integer> entry : window.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }

        System.out.println("##################");
    }
}
