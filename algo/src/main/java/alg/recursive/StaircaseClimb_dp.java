package alg.recursive;

/**
 * 走楼梯
 */
public class StaircaseClimb_dp {

    public static void main(String[] args) {
        System.out.println(new StaircaseClimb_dp().climbStaircase(4));
    }

    public int climbStaircase(int n){
        if (n == 1){
            return 1;
        }

        if (n == 2){
            return 2;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        //边界值是阶梯为1和2，已经设定好对应的值为1，2，所以这里应该从3开始，如果从2开始会导致边界值会被覆盖，数据不对。
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
