package alg.num_add;

import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode-cn.com/problems/3sum
public class Leet_15_ThreeSum {

    public static void main(String[] args) {
        int[] nums1 = {-1, 2, 6, 1, 0, -3, 2};
        int[] nums2 = {0, 1, 2, 2, 2, 3};
        List<List<Integer>> list = threeSum3(nums1);
        for (List<Integer> subList : list) {
            subList.forEach(System.out::print);
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum3(int[] nums){

        if (nums == null || nums.length < 3) {
            return null;
        }

        Arrays.sort(nums);

        if (nums[0] > 0) {
            return null;
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int k = 0; k < nums.length - 2; k++) {
            if (k > 0 && nums[k] == nums[k - 1]) {
                break;
            }

            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]);
                } else if (sum > 0) {
                    while(i < j && nums[j] == nums[--j]);
                } else {
                    ans.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }

        return ans;
    }

    //https://leetcode-cn.com/problems/3sum/solution/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/
    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0)
                break;
            if (k > 0 && nums[k] == nums[k - 1])
                continue;
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) ;
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
//                    ????????????++i,--j????????????????????????i???j?????????????????????????????????i???j????????????????????????????????????????????????????????????
//                    ++i;
//                    --j;
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // ??????nums
        for (int firstIndex = 0; firstIndex < n; ++firstIndex) {
            // ???????????????????????????????????????
            if (firstIndex > 0 && nums[firstIndex] == nums[firstIndex - 1]) {
                continue;
            }
            // c ?????????????????????????????????????????????
            int thirdIndex = n - 1;
            int target = -nums[firstIndex];
            // ?????? b
            for (int secondIndex = firstIndex + 1; secondIndex < n; ++secondIndex) {
                // ??????????????????????????????????????????????????????
                if (secondIndex > firstIndex + 1 && nums[secondIndex] == nums[secondIndex - 1]) {
                    continue;
                }
                // ???????????? b ???????????? c ??????????????????
                while (secondIndex < thirdIndex && nums[secondIndex] + nums[thirdIndex] > target) {
                    --thirdIndex;
                }
                // ??????????????????????????? b ???????????????
                // ?????????????????? a+b+c=0 ?????? b<c ??? c ????????????????????????
                if (secondIndex == thirdIndex) {
                    break;
                }
                if (nums[secondIndex] + nums[thirdIndex] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[firstIndex]);
                    list.add(nums[secondIndex]);
                    list.add(nums[thirdIndex]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
