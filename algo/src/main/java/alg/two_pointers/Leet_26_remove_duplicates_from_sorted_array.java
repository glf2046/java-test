package alg.two_pointers;

public class Leet_26_remove_duplicates_from_sorted_array {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int processedIndex = 0;

        int len = nums.length;

        for (int toProcessIndex = 0; toProcessIndex < len; toProcessIndex++) {
            while (toProcessIndex < len && nums[toProcessIndex] == nums[processedIndex]) {
                toProcessIndex++;
            }

            if (toProcessIndex == len) {
                break;
            }

            processedIndex++;
            nums[processedIndex] = nums[toProcessIndex];
        }

        return processedIndex + 1;
    }
}
