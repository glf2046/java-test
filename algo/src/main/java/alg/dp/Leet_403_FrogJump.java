package alg.dp;

/**
 * 403. 青蛙过河
 * https://leetcode-cn.com/problems/frog-jump/
 */
public class Leet_403_FrogJump {
    public static void main(String[] args) {
//        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        int[] stones = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(canCross(stones));

    }

    private static boolean canCross(int[] stones) {
        int n = stones.length;
        //动规数组，其中行表示对应石子的编号，列表示上一跳的距离
        boolean[][] dp = new boolean[n][n];
        // 初始状态一定是为true
        dp[0][0] = true;

        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                int k = stones[i] - stones[j];
                // 相邻石子的距离大于其编号的时候，必然跳不过去(存在一个距离递增的关系)
                // 对于每次最大能跳的次数，它的增加的速度肯定没有j快，比如到了i这个位置，上一步在j，目前从j开始最大能跳跃的次数k肯定<=j
                // （除了0，1两个位置，对应可以跳跃的次数是1和2，这个时候k>j)
                // 所以如果k>j+1那么一定跳不到i的位置。
                if (k > j + 1) {
                    System.out.println("i=" + i + ", " + k + ">" + (j+1));
                    break;
                }
                // j对应的上一次所在的石子位置，判断在[k±1]的范围里面是否能够满足从j跳到i
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                printDp(dp);

                // 到了数组最末尾的时候，进行一个判断，判断是否能跳到最后一个石子
                if (i == n - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void printDp(boolean[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(convert(dp[i][j]) + ", ");
            }
            System.out.println();
        }
        System.out.println("##############################");
    }

    private static char convert(boolean b) {
        return b ? '1' : '0';
    }
}
