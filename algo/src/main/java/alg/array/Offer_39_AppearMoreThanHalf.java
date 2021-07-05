package alg.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出出现次数超过数组长度一半的数字（摩尔计数）
 */
public class Offer_39_AppearMoreThanHalf {
    public static void main(String[] args) throws Exception {
        int[] nums = {1,2,3,2,2};
        System.out.println(new Offer_39_AppearMoreThanHalf().hashCount(nums));
        System.out.println(new Offer_39_AppearMoreThanHalf().moer(nums));
    }
    //1. 哈希计数
    public int hashCount(int[] nums) throws Exception {
        if (nums == null || nums.length == 0)
            throw new Exception("no nums");

        if (nums.length == 1) {
            return nums[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }

        throw new Exception("not found");
    }

    //2.摩尔计数
    public int moer(int[] nums) throws Exception {
        if (nums == null || nums.length == 0)
            throw new Exception("no nums");

        if (nums.length == 1) {
            return nums[0];
        }

        int count = 0;
        int current = 0;

        for (int i : nums) {
            if (count == 0) {
                current = i;
            }

            if (i == current) {
                count++;
            } else {
                count--;
            }
        }

        return current;
    }
}
