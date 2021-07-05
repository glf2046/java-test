package alg.search;

public class BinarySearch_rework1 {
    public static void main(String[] args) {
//        int[] nums = {13, 20, 15, 6, 3, 2, 8, 9, 1, 0, 7, 11};
        int[] nums = {1,3,2};
        //split by a element in nums
        int partition = partition(nums, 0, nums.length - 1, nums[0]);
        printNums(nums);

        //first quick sort
        quickSearch(nums, 0, nums.length - 1);
        printNums(nums);

        //second binary search recursive
        int position = binarySearch_recursive(nums, 0, nums.length -1, 9);
        System.out.println("position: " + position);

        //second binary search iterate
        position = binarySearch_recursive(nums, 0, nums.length -1, 9);
        System.out.println("position: " + position);
    }

    private static void quickSearch(int[] nums, int low, int high) {
        if (nums == null || nums.length == 0) {
            return;
        }

        if (low == high) {
            return;
        }
//        int mid = (low + high) /2;
        int mid = low + (high - low) / 2;

        int partition = partition(nums, low, high, nums[mid]);
        printNums(nums);
        quickSearch(nums, low, partition);
        quickSearch(nums, partition + 1, high);
    }

    private static int partition(int[] nums, int low, int high, int num) {
        while (low < high) {
            while (nums[low] < num) {
                low++;
            }

            while (nums[high] > num) {
                high--;
            }

            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
        }

        nums[low] = num;

        return low;
    }

    //递归二分搜索
    private static int binarySearch_recursive(int[] nums, int low, int high, int k) {
        if (nums == null) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        if (nums[mid] > k) {
            return binarySearch_recursive(nums, low, mid, k);
        } else if(nums[mid] < k) {
            return binarySearch_recursive(nums, mid + 1, high, k);
        } else {
            return mid;
        }
    }

    //迭代二分搜索
    private static int binarySearch_iterate(int[] nums, int low, int high, int k) {
        if (nums == null) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        while (low < high) {
            if (nums[mid] > k) {
                high = mid;
            } else if (nums[mid] < k) {
                low = mid;
            } else {
                return mid;
            }
        }

        return low;
    }

    private static void printNums(int[] nums) {
        for (int num : nums) {
            System.out.print(num + ", ");
        }
        System.out.println();
    }
}
