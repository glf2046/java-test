package alg.array;

import java.util.Arrays;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 */
public class Offer_17_NDigitsNumberPrint {
    public int[] printNumbers(int n) {
        int[] nums = new int[(int)Math.pow(10, n) -1];
        for (int i = 1; i < Math.pow(10, n); i++) {
            nums[i-1] = i;
        }

        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Offer_17_NDigitsNumberPrint().printNumbers(2)));
    }
}
