package alg.tree;

import java.util.*;

/**
 * 深度优先DFS(中序遍历，前序遍历，后序遍历）
 * 广度优先BFS(队列或者栈（zigzag实现）
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/solution/
 */
public class Leet_103_ZigzagOrderTree_2 {
    public static void main(String[] args) {
        Tree tree = buildTree();
        TreeNode root = tree.getRoot();

        dfs_pre_iteration(root);
        System.out.println();
        dfs_pre_recursive(root);
        System.out.println();
        System.out.println("##########");


        zigzag_iteration(root);
        System.out.println();

        zigzag_recursive(Collections.singletonList(root));
        System.out.println();
        System.out.println("##########");
        
//        bfs_list(root);
//        System.out.println();
//        dfs_pre(root);
//        System.out.println();
//        dfs_mid(root);
//        System.out.println();
//        dfs_post(root);
//        System.out.println();
//        dfs_stack(root);
//        System.out.println();
//        bfs_recursive_with_list(Collections.singletonList(root));
    }

    private static void zigzag_recursive(List<TreeNode> list) {
        List<TreeNode> newList = new ArrayList<>();
        if (list.isEmpty()) {
            return;
        }
        for (TreeNode item : list) {
            if (item != null) {
                System.out.print(item.value);
                newList.add(item.left);
                newList.add(item.right);
            }
        }

        zigzag_recursive(newList);
    }

    private static void zigzag_iteration(TreeNode root) {
        List<TreeNode> list = new LinkedList<>();
        List<TreeNode> list2 = new LinkedList<>();

        list.add(root);

        while (!list.isEmpty()) {
            for (TreeNode node : list) {
                if (node != null) {
                    System.out.print(node.value);
                    list2.add(node);
                }
            }

            list.clear();

            for (TreeNode node : list2) {
                list.add(node.left);
                list.add(node.right);
            }

            list2.clear();
        }
    }

    private static void dfs_pre_recursive(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value);

        dfs_pre_recursive(node.left);
        dfs_pre_recursive(node.right);
    }

    private static void dfs_pre_iteration(TreeNode node) {
        if (node == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            TreeNode item = stack.pop();
            if (item != null) {
                System.out.print(item.value);
                stack.push(item.right);
                stack.push(item.left);
            }
        }
    }

    private static Tree buildTree() {
        TreeNode t5 = new TreeNode(null, null, 5);
        TreeNode t6 = new TreeNode(null, null, 6);
        TreeNode t2 = new TreeNode(t5, t6, 2);

        TreeNode t7 = new TreeNode(null, null, 7);
        TreeNode t8 = new TreeNode(null, null, 8);
        TreeNode t9 = new TreeNode(null, null, 9);
        TreeNode t3 = new TreeNode(t7, t8, 3);
        TreeNode t4 = new TreeNode(t9, null, 4);
        TreeNode t1 = new TreeNode(t3, t4, 1);
        TreeNode t0 = new TreeNode(t1, t2, 0);
        TreeNode root = t0;

        return new Tree(root);
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(TreeNode left, TreeNode right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }

    static class Tree {
        public TreeNode getRoot() {
            return root;
        }

        public void setRoot(TreeNode root) {
            this.root = root;
        }

        TreeNode root;

        public Tree(TreeNode root) {
            this.root = root;
        }
    }
}
