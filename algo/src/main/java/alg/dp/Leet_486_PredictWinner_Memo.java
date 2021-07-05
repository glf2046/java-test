package alg.dp;

import java.util.Arrays;

/**
 * 486. 预测赢家
 * 给定一个表示分数的非负整数数组。 玩家 1 从数组任意一端拿取一个分数，随后玩家 2 继续从剩余数组任意一端拿取分数，然后玩家 1 拿，…… 。
 * 每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
 *
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 *
 */
public class Leet_486_PredictWinner_Memo {
    public static void main(String[] args) {
        int[] nums = new int[]{1,5,2};
        System.out.println(PredictTheWinner(nums));
    }

    public static boolean PredictTheWinner(int[] nums) {
        int[][] memo = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }

        return predict(nums, 0, nums.length-1, memo) >= 0;
    }

    public static int predict(int[] nums, int start, int end, int[][] memo) {
        if (end == start) {
            return nums[start];
        }

        if (memo[start][end] >= 0){
            return memo[start][end];
        }

        int chooseLeft = nums[start] - predict(nums, start + 1, end, memo);
        int chooseRight = nums[end] - predict(nums, start, end - 1, memo);
        return Math.max(chooseLeft, chooseRight);
    }
}
