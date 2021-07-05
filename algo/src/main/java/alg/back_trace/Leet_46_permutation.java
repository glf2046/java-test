package alg.back_trace;

import java.util.*;

public class Leet_46_permutation {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<Deque<Integer>> list = permute(nums);
        list.forEach(System.out::println);
    }

    //https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/
    public static List<Deque<Integer>> permute(int[] nums) {
        List<Deque<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        int len = nums.length;
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        int depth = 0;
        dfs(nums, len, depth, path, used, res);

        return res;
    }

    private static void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<Deque<Integer>> res) {
        System.out.println("enter, depth: " + depth + ", " + Arrays.toString(used));
        if (depth == len) {
            res.add(path);
            System.out.println("add : " + path + "to result");
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                System.out.println("continue, depth: " +depth + ", i: " + i);
                continue;
            }

            used[i] = true;
            System.out.println("depth: "+ depth + ", i: " + i + Arrays.toString(used));
            path.addLast(nums[i]);
            System.out.println("path: " + path);
            dfs(nums, len, depth + 1, path, used, res);
            used[i] = false;
            System.out.println("depth: "+ depth + ", i: " + i + Arrays.toString(used) + " after rest used");
            path.removeLast();
        }
    }
}
