package alg.slide_window.max_length_norepeat_substring;


import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 */
public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcba";
        char[] chars = s.toCharArray();
        System.out.println(lengthOfLongestSubstring(chars));
    }

    static int lengthOfLongestSubstring(char[] s) {
        int left = 0, right = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        int res = 0; // 记录最长长度

        while (right < s.length) {
            char c1 = s[right];
            window.put(c1, window.getOrDefault(c1, 0) + 1);
            right++;
            // 如果 window 中出现重复字符
            // 开始移动 left 缩小窗口,直到window.get(c1) == 1,
            // 也就是left移动到了和这次right指向的值c1具有同样值的位置
            // （也就是前部分和当前c1值重复的位置），这样之后c1就不重复了
            // 或者用指针记录重复的位置也可以
            while (window.get(c1) > 1) {
                char c2 = s[left];
                window.put(c2, window.get(c2) - 1);
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
