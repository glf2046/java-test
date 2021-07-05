package alg.dp;


import java.util.Arrays;

public class MaxSumContinousSubArray_recursive {

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
        int[] result = new int[a.length];

        max(a, a.length - 1, result);

        printResult(result);

        Arrays.sort(result);

        return result[a.length-1];
    }

    private static void printResult(int[] result) {
        System.out.println(Arrays.toString(result));
    }


    private static int max(int[] a, int endIndex, int[] result){
        if (endIndex == 0) {
            result[endIndex] = a[0];
            return a[0];
        }

        if (endIndex >= a.length) {
            return -1;
        }

        int max = Math.max(max(a, endIndex - 1, result) + a[endIndex], a[endIndex]);
        result[endIndex] = max;
        return max;
    }
}
