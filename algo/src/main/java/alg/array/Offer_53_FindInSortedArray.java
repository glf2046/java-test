package alg.array;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 */
public class Offer_53_FindInSortedArray {
    public static void main(String[] args) {
        int[] array = {5,7,7,8,8,10};
        System.out.println(new Offer_53_FindInSortedArray().search(array, 9));
    }

    public int search(int[] nums, int target) {
        return getRightMargin(nums, target) - getRightMargin(nums, target - 1);
    }

    //右边界（第一个比target大的值的索引）
    int getRightMargin(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //这面的<=保证了，即使左侧已经有跟目标相等元素，仍旧会继续移动左边界left的值，
        while(left <= right) {
            int mid = (left + right) / 2;
            //这面的<=保证了，即使左侧已经有跟目标相等元素，仍旧会继续移动左边界left的值，
            // 这样while退出的时候，就是右边界（第一个比target大的值的索引）
            if(nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("left: " + left + ", right: " + right);
        return left;
    }

//    作者：画手大鹏
//    链接：https://leetcode-cn.com/leetbook/read/illustrate-lcof/5yuwb1/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
