package alg.dp;

/**
 * ���������������
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 */
public class MaxSumContinousSubArray_dp_rollingArray {

    public static void main(String[] args) {
//        int[] a = {-5, 2, 100, -50, 100};
//        int[] a = {-2, -1};
//        int[] a = {-1000,-1000,1,2,3,-1,100};
//        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] a = {-2, -3, 1, 4, -1, 2, 1, -5, 4};
        int max = max(a);
        System.out.println(max);
    }


    private static int max(int[] a) {
        if (a == null) {
            return 0;
        }

        if (a.length == 1) {
            return a[0];
        }

        int pre = 0, maxAns = a[0];
        for (int i = 0; i < a.length; i++) {
            pre = Math.max(pre + a[i], a[i]);
            maxAns = Math.max(maxAns, pre);
            System.out.println(i + ", " + maxAns);
        }
        return maxAns;
    }
}
