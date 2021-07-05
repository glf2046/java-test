package alg.array;

/**
 * 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 作者：画手大鹏
 * 链接：https://leetcode-cn.com/leetbook/read/illustrate-lcof/e2dts5/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Offer_53_2_MissingElement {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,5};
        System.out.println(new Offer_53_2_MissingElement().missingOne(nums));
    }
    public int missingOne(int[] nums){
        return binaryFind(nums, 0, nums.length - 1);
    }

    public int binaryFind(int[] nums, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (mid == nums[mid]) {
                left = mid+1;
            } else if (mid < nums[mid]) {
                right = mid -1;
            }
        }

        return left;
    }
}
