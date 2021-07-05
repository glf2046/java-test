package alg.slide_window;

public class minimum_size_subarray_sum {
    public static void main(String[] args) {
        int[] nums = {2,3,1,4,5};
        System.out.println(minSubArrayLen(7, nums));
    }
    public static int minSubArrayLen(int s, int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }

        int minLength = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    int tempLength = j - i + 1;
                    if (minLength == 0) {
                        minLength = tempLength;
                    } else if (tempLength < minLength) {
                        minLength = tempLength;
                    }

                    break;
                }
            }
        }

        return minLength;
    }
}
