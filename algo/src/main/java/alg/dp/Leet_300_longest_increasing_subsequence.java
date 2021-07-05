package alg.dp;

import java.util.Arrays;

public class Leet_300_longest_increasing_subsequence {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 2, 3};
        System.out.println(lengthOfLIS(arr));
    }

    //https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                //依次拿当前的nums[i]和所有前面的值nums[j]比较，得出在所有的j的当前长度再算上nums[i]的可能长度，
                // 如果nums[i]大，就可以分别跟在后面，否则不行
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
