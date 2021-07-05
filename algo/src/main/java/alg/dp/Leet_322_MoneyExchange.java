package alg.dp;

import java.util.Arrays;

/**
 * 零钱兑换
 * 动态规划：从上到下递归思考，得出状态转移公式或者最佳子结构等；
 * 从下到上（0~n-1)思考状态积累过程，特别是确定边界状态，并从边界状态开始。
 */
public class Leet_322_MoneyExchange {
    public static void main(String[] args) {
        System.out.println(new Leet_322_MoneyExchange().moneyExchange(11, new int[]{1,2,5}));;
    }
    public int moneyExchange(int target, int[] coins) {
        //dp要从0开始到target，因为需要初始状态F(0) = 0, 构成0总额的硬币数目为0
        int max = target + 1;
        int[] dp = new int[max];
        //硬币的最小值是1，组成target总额的硬币个数最多是target，设置成target+1然后再逐次取小优化
        Arrays.fill(dp, max);
        //组成0总额的硬币个数肯定是0
        dp[0] = 0;
        for (int i = 1; i <= target; i++) {
            //逐个比较，以获得i-coins[]中所有组合中最小的个数
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i - coin], dp[i - coin]) + 1;
                }
            }
        }

        return dp[target]> target ? -1 : dp[target];
    }
}
