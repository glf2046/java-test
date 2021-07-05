package alg.sort;

import java.util.HashMap;

public class Leet_217_contains_duplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,6,7};
        System.out.println(containsDuplicate3(nums));
        //方案0：两个循环，O(n2)的复杂度，判断是否有相等的元素



        //方案3: 先排序，然后逐次判断相邻两个是否相等
    }

    //方案1：用hashmap
    public static boolean containsDuplicate(int[] nums) {
        int len = nums.length;

        if(len == 1){
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < len; i++){
            if(map.containsKey(nums[i])){
                return true;
            }

            map.put(nums[i], nums[i]);
        }

        return false;
    }

    //方案2：用26个int数组，对应字母位置计数
    public static boolean containsDuplicate3(int[] nums){
        int[] arr = new int[10];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
            if (arr[nums[i]] > 1){
                return true;
            }
        }

        return false;
    }
}
