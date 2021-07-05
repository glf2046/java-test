package alg.sort;

import java.util.HashMap;

public class Leet_217_contains_duplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,6,7};
        System.out.println(containsDuplicate3(nums));
        //����0������ѭ����O(n2)�ĸ��Ӷȣ��ж��Ƿ�����ȵ�Ԫ��



        //����3: ������Ȼ������ж����������Ƿ����
    }

    //����1����hashmap
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

    //����2����26��int���飬��Ӧ��ĸλ�ü���
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
