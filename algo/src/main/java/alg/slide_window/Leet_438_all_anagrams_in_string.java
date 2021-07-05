package alg.slide_window;

import java.util.ArrayList;
import java.util.List;

/**
 * �ҵ��ַ�����������ĸ��λ��
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
        // �����ַ���p�и�Ԫ�صĳ��ִ���
        int[] pFreq = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
        }
        // ��������Ϊ[start,end]
        int start = 0, end = -1;
        while (start < s.length()) {
            // ����ʣ��Ԫ��δ���죬�Ҵ������ַ�������С���ַ���p�ĳ���
            // �����󴰿��Ҳ�߽�
            if (end + 1 < s.length() && end - start + 1 < p.length()) {
                end++;
            } else {
            // �Ҳ�߽粻�ܼ�������򴰿����ַ������ȵ����ַ���p�ĳ���
            // ����С���߽�
                start++;
            }
            // ���������ַ������ȵ����ַ���p�ĳ���ʱ�����ж����ǲ����ַ���p����ĸ��λ���Ӵ�
            if (end - start + 1 == p.length() && isAnagrams(s.substring(start, end + 1), pFreq)) {
                resultList.add(start);
            }
        }
        return resultList;
    }

    // �жϵ�ǰ�Ӵ��ǲ����ַ���p����ĸ��λ��
    private static boolean isAnagrams(String window, int[] pFreq) {
        // ���㴰�����ַ�����Ԫ�صĳ��ִ���
        int[] windowFreq = new int[26];
        for (int i = 0; i < window.length(); i++) {
            windowFreq[window.charAt(i) - 'a']++;
        }
        // �Ƚϴ����ڸ�Ԫ�صĳ��ִ������ַ���p�и�Ԫ�صĳ��ִ����Ƿ�һ��
        // �����һ������˵�������ڵ��ַ������ַ���p����ĸ��λ���Ӵ�
        // �����һ������˵���������Ӵ�
        for (int j = 0; j < 26; j++) {
            if (windowFreq[j] != pFreq[j]) {
                return false;
            }
        }
        return true;
    }
//    ���ߣ�hardcore-aryabhata
//    ���ӣ�https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/hua-dong-chuang-kou-438-zhao-dao-zi-fu-c-ut38/
//    ��Դ�����ۣ�LeetCode��
//    ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
}
