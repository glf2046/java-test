package alg.array;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
public class Offer_21_AdjustEvenOldNum {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int i = 0;
        int j = nums.length - 1;

        //跟exchange方法相比，这里不需要很多的检查i/j是否越界，只要每次修改完i/j的值，还保证i<j即可，因为i初始化为0，j初始化为length-1，
        //所以只要过程中保证i<j，那么i和j不断相向移动，i和j肯定都是在0和length-1之间的。
        while (i < j) {
            //这种内层（外面有while循环）循环中改变判断条件值的，都要对外层的限定条件进行再次限定，因为当i++之后，不知道i是否还满足i<j；
            // 换句话说，当你改变了指针，就要防止有可能越界的情况，除非内层循环不依赖这个越界条件，那么外层i<j就已经保证了i<nums.length,因为j=nums.length;
            while (i < j && nums[i] % 2 == 1) {
                i++;
            }

            while (i < j && nums[j] % 2 == 0) {
                j--;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }

        return nums;
    }


    public static void main(String[] args) {
//        int[] nums = {1, 3, 5};
//        System.out.println(Arrays.toString(new Offer_21_AdjustEvenOldNum().exchange(nums)));
//
//        int[] nums3 = {2, 4, 6};
//        System.out.println(Arrays.toString(new Offer_21_AdjustEvenOldNum().exchange(nums3)));
//
//        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8};
//        System.out.println(Arrays.toString(new Offer_21_AdjustEvenOldNum().exchange(nums2)));
//
//        int[] nums5 = {1, 2, 3, 8};
//        System.out.println(Arrays.toString(new Offer_21_AdjustEvenOldNum().exchange(nums5)));

        int[] nums4 = {8, 10, 3, 20, 12, 4, 10, 8, 4, 0, 5, 17, 7, 20, 3};
        System.out.println(Arrays.toString(new Offer_21_AdjustEvenOldNum().exchange(nums4)));

    }
}
