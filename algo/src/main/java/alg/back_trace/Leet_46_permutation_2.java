package alg.back_trace;

import java.util.*;

public class Leet_46_permutation_2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> list = permute(nums);
        list.forEach(System.out::println);
    }

    //https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);

        dfs(nums, used, 0, new ArrayDeque<>(), result);

        return result;
    }

    public static void dfs(int[] nums, boolean[] used, int depth, Deque<Integer> path, List<List<Integer>> result) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.addLast(nums[i]);
            depth++;
            dfs(nums, used, depth, path, result);
            used[i] = false;
            path.removeLast();
        }
    }
}
