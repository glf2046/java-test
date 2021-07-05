package alg.slide_window;

//https://www.cnblogs.com/labuladong/p/12320475.html

/**
 * 滑动窗口算法的思路是这样：
 *
 * 1、我们在字符串 S 中使用双指针中的左右指针技巧，初始化 left = right = 0，
 * 把索引闭区间 [left, right] 称为一个「窗口」。
 *
 * 2、我们先不断地增加 right 指针扩大窗口 [left, right]，
 * 直到窗口中的字符串符合要求（包含了 T 中的所有字符）。
 *
 * 3、此时，我们停止增加 right，转而不断增加 left 指针缩小窗口 [left, right]，
 * 直到窗口中的字符串不再符合要求（不包含 T 中的所有字符了）。同时，每次增加 left，我们都要更新一轮结果。
 *
 * 4、重复第 2 和第 3 步，直到 right 到达字符串 S 的尽头。
 *
 * 这个思路其实也不难，第 2 步相当于在寻找一个「可行解」，然后第 3 步在优化这个「可行解」，
 * 最终找到最优解。左右指针轮流前进，窗口大小增增减减，窗口不断向右滑动。
 */
public class minimum_size_subarray_sum_2 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,4,5};
        System.out.println(minSubArrayLen(7, nums));
    }
    public static int minSubArrayLen(int s, int[] nums) {
        int i = 0;
        int sum = 0;
        int len = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= s) {
                len = len == 0 ? j - i + 1 : Math.min(len, j - i + 1);
                sum -= nums[i++];
            }
        }
        return len;
    }
}
