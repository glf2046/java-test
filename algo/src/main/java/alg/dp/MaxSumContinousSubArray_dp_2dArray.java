package alg.dp;

public class MaxSumContinousSubArray_dp_2dArray {

    public static void main(String[] args) {
//        int[] a = {-5, 2, 100, -50, 100};
//        int[] a = {-2, -1};
//        int[] a = {-1000,-1000,1,2,3,-1,100};
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = max(a);
        System.out.println(max);
    }

    //»¬¶¯´°¿Ú
    private static int max(int[] a) {
        if (a == null) {
            return 0;
        }

        if (a.length == 1) {
            return a[0];
        }

        int[][] dp = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            dp[i][i] = a[i];
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < 0) {
                    dp[i][j] = Math.max(dp[i][j - 1], a[j]);
                } else {
                    if (dp[i][j - 1] < 0) {
                        dp[i][j] = a[j];
                    } else {
                        dp[i][j] = dp[i][j - 1] + a[j];
                    }
                }
            }
        }

        return dp[0][a.length - 1];
    }
}
