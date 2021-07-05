package alg.dp;

/**
 * 最长公共子序列
 * https://leetcode-cn.com/problems/longest-common-subsequence/solution/dong-tai-gui-hua-tu-wen-jie-xi-by-yijiaoqian/
 */
public class Leet_1143_LCS {
    public static void main(String[] args) {
        String str1 = "abcde", str2 = "ace";
        System.out.println(lcs(str1, str2));
    }

    public static int lcs(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int len1 = c1.length;
        int len2 = c2.length;

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (c1[i] == c2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        print(dp);

        return dp[len1][len2];
    }

    private static void print(int[][] dp) {
        for (int[] ints : dp) {
            for (int anInt : ints) {
                System.out.print(anInt + ",  ");
            }
            System.out.println("");
        }
    }
}
