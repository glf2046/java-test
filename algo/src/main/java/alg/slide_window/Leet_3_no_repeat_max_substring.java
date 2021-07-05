package alg.slide_window;

import java.util.HashMap;
import java.util.Map;

/**
 * ���ظ��ַ�����Ӵ�(��������+˫ָ�룩
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
        int res = 0; // ��¼�����

        while (right < s.length) {
            char c1 = s[right];
            window.put(c1, window.getOrDefault(c1, 0) + 1);
            right++;
            // ��� window �г����ظ��ַ�
            // ��ʼ�ƶ� left ��С���ڣ���Ϊ��whileѭ��������left�������ƶ����ظ���λ�õ���һ��λ��
            //�ϵ�left���µ�left֮����ַ�����������0��
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
