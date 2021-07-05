package alg.dp;

import java.util.Arrays;

public class MaxSumContinousSubArray_dp_1dArray_rolling {

    public static void main(String[] args) {
//        int[] a = {-5, 2, 100, -50, 100};
//        int[] a = {-2, -1};
//        int[] a = {-1000,-1000,1,2,3,-1,100};
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = max(a);
        System.out.println(max);
    }


    private static int max(int[] a){
        if (a == null) {
            return 0;
        }

        if (a.length == 1) {
            return a[0];
        }

        //dp[i]: 表示以第i个元素结尾的所有可能连续子串的最大和，比如i=3, 那么可能组合有：
        // 0，1，2，3；
        // 1，2，3；
        // 2,3;
        // 3；
        // 所以对于dp[i]他只要关注dp[i-1]和a[i]，对于a[i],有两个选择：
        // 1. 算入a[i]，那么这种和就是dp[i-1]+ a[i]，这时候之前的最大和子串和a[i]形成更长的连续子串。
        // 2. dp[i-1]+a[i]更小，那么dp[i-1]肯定是负的，这时候a[i]作为单独子串和最大，就保留a[i]作为当前最大值；
        int max = a[0];

        // 在 MaxSumContinousSubArray_dp_1dArray.java中用的是dp数组，但其实仔细看了会发现，当计算dp[i]的时候只会用dp[i-1]，
        // 这个时候dp[i-1]之前的元素全部用不上了，所以可以考虑用滚动数据来优化存储空间。
        // 但是注意这个时候没有dp[0]的初始化状态，所以下面的循环要从i=0开始。
        int maxOfEachIndex = 0;

        for (int i = 0; i < a.length; i++) {
            System.out.println("direct: " + i + ", max(" + maxOfEachIndex + " " + a[i] + "," + a[i] + ")");
            maxOfEachIndex = Math.max(maxOfEachIndex + a[i], a[i]);
//            System.out.println(i + ", max(" + dp[i] + "," + max + ")");
            max = Math.max(max, maxOfEachIndex);
        }

        return max;
    }

    private static void printDp(int[] dp) {
        System.out.println(Arrays.toString(dp));
    }
}
