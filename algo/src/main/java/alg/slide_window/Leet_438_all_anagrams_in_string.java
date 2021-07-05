package alg.slide_window;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */
public class Leet_438_all_anagrams_in_string {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> resultList = new ArrayList<>();
        // 计算字符串p中各元素的出现次数
        int[] pFreq = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
        }
        // 窗口区间为[start,end]
        int start = 0, end = -1;
        while (start < s.length()) {
            // 还有剩余元素未考察，且窗口内字符串长度小于字符串p的长度
            // 则扩大窗口右侧边界
            if (end + 1 < s.length() && end - start + 1 < p.length()) {
                end++;
            } else {
            // 右侧边界不能继续扩大或窗口内字符串长度等于字符串p的长度
            // 则缩小左侧边界
                start++;
            }
            // 当窗口内字符串长度等于字符串p的长度时，则判断其是不是字符串p的字母异位词子串
            if (end - start + 1 == p.length() && isAnagrams(s.substring(start, end + 1), pFreq)) {
                resultList.add(start);
            }
        }
        return resultList;
    }

    // 判断当前子串是不是字符串p的字母异位词
    private static boolean isAnagrams(String window, int[] pFreq) {
        // 计算窗口内字符串各元素的出现次数
        int[] windowFreq = new int[26];
        for (int i = 0; i < window.length(); i++) {
            windowFreq[window.charAt(i) - 'a']++;
        }
        // 比较窗口内各元素的出现次数和字符串p中各元素的出现次数是否一样
        // 如果都一样，则说明窗口内的字符串是字符串p的字母异位词子串
        // 如果不一样，则说明不是其子串
        for (int j = 0; j < 26; j++) {
            if (windowFreq[j] != pFreq[j]) {
                return false;
            }
        }
        return true;
    }
//    作者：hardcore-aryabhata
//    链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/hua-dong-chuang-kou-438-zhao-dao-zi-fu-c-ut38/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
