package alg.dp;

import java.util.Arrays;

/**
 * 1143. 最长公共子序列
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 */
public class Longest_common_string_dp_2 {
    public static void main(String[] args) {
        String s1 = "abc12323bac";
        String s2 = "ab123bc";
        System.out.println(lcs(s1, s2));
    }

    private static int lcs(String s1, String s2){
        if (s1 == null || s2 == null) {
            return 0;
        }

        if (s1.length() == 0 || s2.length() == 0) {
            return 0;
        }

        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        int len1 = a1.length;
        int len2 = a2.length;

        int[][] dp = new int[len1+1][len2+1];
        for (int[] ints : dp) {
            Arrays.fill(ints, 0);
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                //考虑到dp[i-1][j-1]的索引最小是0，i,j要从1开始，这样为了能访问到数组中的所有字符，这里的索引下标就-1,所以外面的循环是<=len1, <=len2;
                if (a1[i-1] == a2[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[len1][len2];
    }
}
