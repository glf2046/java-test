package alg.greedy;

public class Leet_674_longest_continous_increasing_subsequence {

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7,2};
        System.out.println(lcis(nums));
    }
    //https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/solution/hua-jie-suan-fa-674-zui-chang-lian-xu-di-zeng-xu-l/
    //类似于买卖股票的算法
    public static int lcis(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int currentMax = 1;
        int max = 1;
        for (int i = 0; i < len-1; i++) {
            if (nums[i + 1] > nums[i]) {
                currentMax++;
            } else {
                currentMax = 1;
            }
            max = Math.max(max, currentMax);
        }

        return max;
    }
}
