package alg.array;

/**
 * 寻找旋转排序数组中的最小值 II
 */
public class Offer_11_RevolveSubArray {
    public static void main(String[] args) {
        System.out.println(7/2);
        int[] nums = {2,3,4,0,1};
        System.out.println(new Offer_11_RevolveSubArray().findMin(nums));
    }

    //利用数组特征从左右不断缩小搜索范围（类似二分法）
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else if (nums[pivot] > nums[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return nums[low];
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/solution/xun-zhao-xuan-zhuan-pai-xu-shu-zu-zhong-de-zui--16/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
