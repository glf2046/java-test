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
            //���ʱ��toProcess�Ѿ�ָ���processed��ͬ��Ԫ����

            //���µĲ�ͬ��Ԫ�طŽ�����processed����һ��λ��
            nums[++processed] = nums[toProcess];
        }

        //���ز��ظ���Ԫ�ظ���
        return processed+1;
    }
}
