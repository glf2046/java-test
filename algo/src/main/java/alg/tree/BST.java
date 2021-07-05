package alg.tree;

import java.time.Period;

//二叉搜索/排序树 (顺序输入的序列导致建树会退化为链表）
public class BST {

    public static void main(String[] args) {
        //退化为链表
//        int[] nums = {1,2,3,4,5,6,7,8,9};
        int[] nums = {10, 6, 8, 15, 13, 17, 11, 14};
        TreeNode root = buildBST(nums);
        TreeNode node = search(root, 11);
        System.out.println(node.value);
    }

    private static TreeNode search(TreeNode node, int n) {
        if (node == null) {
            return null;
        }

        if (node.value == n) {
            return node;
        } else if (n > node.value) {
            return search(node.right, n);
        } else {
            return search(node.left, n);
        }
    }

    private static TreeNode buildBST(int[] nums) {
        if (nums == null) return null;
        TreeNode root = new TreeNode(null, null, nums[0]);
        if (nums.length == 1) return root;
        for (int i = 1; i < nums.length; i++) {
            findPlace(nums[i], root);
        }

        return root;
    }

    private static void findPlace(int n, TreeNode parent) {
        if (n > parent.value) {
            if (parent.right == null) {
                parent.right = new TreeNode(null, null, n);
            } else {
                findPlace(n, parent.right);
            }
        } else {
            if (parent.left == null) {
                parent.left = new TreeNode(null, null, n);
            } else {
                findPlace(n, parent.left);
            }
        }
    }

    static class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int value;

        public TreeNode(TreeNode left, TreeNode right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }
}

