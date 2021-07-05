package alg.dp;

/**
 * 1143. 最长公共子序列
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 */
public class Longest_common_string_dp {
    public static void main(String[] args) {
        String s1 = "abc12323bac";
        String s2 = "ab123bc";
        System.out.println(lcs(s1, s2));
    }

    private static int lcs(String s1, String s2){
        if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) {
            return 0;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int len1 = c1.length;
        int len2 = c2.length;

        int[][] dp = new int[len1+1][len2+1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                dp[i][j] = 0;
            }
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                //注意这里状态图的索引和字符数组的索引的下标区别
                if (c1[i-1] == c2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[len1][len2];
    }
}
