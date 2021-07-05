package alg.two_pointers;

public class Leet_26_remove_duplicates_from_sorted_array_rework1 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 5};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 1) {
            return 0;
        }

        int len = nums.length;
        int processed = 0;
        int toProcess = 0;

        for (;toProcess < len; toProcess++) {
            while (toProcess < len && nums[toProcess] == nums[processed]) {
                toProcess++;
            }
            //这个时候toProcess已经指向跟processed不同的元素了

            //把新的不同的元素放进紧靠processed的下一个位置
            nums[++processed] = nums[toProcess];
        }

        //返回不重复的元素个数
        return processed+1;
    }
}
