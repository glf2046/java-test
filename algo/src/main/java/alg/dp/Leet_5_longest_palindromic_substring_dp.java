package alg.dp;

/**
 * 最长回文串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class Leet_5_longest_palindromic_substring_dp {

    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println(p3(s));
        System.out.println("##########");
        System.out.println(p4(s));
//        System.out.println(longestPalindrome(s));
    }

//    public static String isPalindrome(String s, int start, int end) {
//
//    }

    /**
     * 倒过来找到从high到low满足条件的子串，所以动态规划的状态转移公式为：P(i,j) = P(i-1, j+1) && s[i] == s[j];
     * 根据递推公式可以看出，外层循环i要从小到大(i依赖i-1)，内层循环要从大到小（j依赖j+1)
     * 因为外侧的计算要依赖内侧的：比如P(2,0)要依赖P(1,1), 所以外层循环i要从小到大开；内层要从大到小，这样就保证了先计算出来的结果会存到dp中，被后续利用。
     * @param s
     * @return
     */
    public static String p4(String s){
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j>=0; j--) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (i-j < 2 || dp[i - 1][j + 1]); //j - i 代表长度减去 1
                if (dp[i][j] &&  i-j + 1 > res.length()) {
                    System.out.println(i + ", " + j);
                    res = s.substring(j, i + 1);
                }
            }
        }
        return res;
    }

    /**
     * 倒过来找到从high到low满足条件的子串，所以动态规划的状态转移公式为：P(i,j) = P(i+1, j-1) && s[i] == s[j];
     * 根据递推公式可以看出，外层循环i要从大到小(i依赖i+1)，内层循环要从小到大（j依赖j-1)
     * 因为外侧的计算要依赖内侧的：比如P(0,2)要依赖P(1,1), 所以外层循环i要从大到小；内层要从小到大，这样就保证了先计算出来的结果会存到dp中，被后续利用。
     * @param s
     * @return
     */
    public static String p3(String s){
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]); //j - i 代表长度减去 1
                if (dp[i][j] &&  j - i + 1 > res.length()) {
                    System.out.println(i + ", " + j);
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    public static String p2(String s){
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    System.out.println("break: " + j);
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    System.out.println(i + ", " + j);
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }

        int len = s.length();

        int start = 0;
        int end = 0;

        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (i + 1 <= j - 1 && dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    System.out.println(i + ",," + j);
                    if ((j - i) > (end - start)) {
                        System.out.println(i + ":" + j);
                        start = i;
                        end = j;
                    }
                }
            }
        }

        return s.substring(start, end + 1);

    }
//
//    作者：reedfan
//    链接：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-fa-he-dong-tai-gui-hua-by-reedfa/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
