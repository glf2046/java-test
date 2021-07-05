package alg.tree;

import java.util.*;

/**
 * 深度优先DFS(中序遍历，前序遍历，后序遍历）
 * 广度优先BFS(队列或者栈（zigzag实现）
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/solution/
 */
public class Leet_103_ZigzagOrderTree {
    public static void main(String[] args) {
        Tree tree = buildTree();
        TreeNode root = tree.getRoot();

        dfs_pre(root);
        System.out.println();
//        dfs_mid(root);
//        System.out.println();
//        dfs_post(root);
//        System.out.println();
//        dfs_stack(root);
//        System.out.println();
//
//        zigzag(root);
//        System.out.println();
//        bfs_list(root);
//        System.out.println();
//
//        bfs_recursive_with_list(Collections.singletonList(root));
    }

    private static void zigzag(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        boolean flag = true;
        zigzag(list, flag);
    }

    private static void zigzag(List<TreeNode> levelList, boolean flag) {
        if (levelList == null || levelList.size() <= 0) {
            return;
        }

        List<TreeNode> tempList = new LinkedList<>();
        for (TreeNode treeNode : levelList) {

            if (treeNode.left != null) {
                tempList.add(treeNode.left);
            }

            if (treeNode.right != null) {
                tempList.add(treeNode.right);
            }
        }

        if (!flag) {
            Collections.reverse(levelList);
        }

        for (TreeNode treeNode : levelList) {
            System.out.print(treeNode.value);
        }
        System.out.println();

        zigzag(tempList, !flag);
    }

    //bfs列表实现
    //递归基本上都可以用while改写？ 比如二分搜索，bfs，dfs
    private static void bfs_list(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        TreeNode node;
        while ((node = list.poll()) != null) {
            System.out.print(node.value);
            if (node.left != null) {
                list.add(node.left);
            }

            if (node.right != null) {
                list.add(node.right);
            }
        }
    }
    
    //bfs递归实现
    private static void bfs_recursive_with_list(List<TreeNode> nodes) {
        if (nodes == null || nodes.size() == 0) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        for (TreeNode node : nodes) {
                System.out.print(node.value);
                if (node.left != null) {
                    list.add(node.left);
                }

                if (node.right != null) {
                    list.add(node.right);
                }
            }

        bfs_recursive_with_list(list);
    }

    private static void dfs_pre(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value);
        dfs_pre(root.left);
        dfs_pre(root.right);
    }

    private static void dfs_mid(TreeNode root) {
        if (null == root) {
            return;
        }

        dfs_mid(root.left);
        System.out.print(root.value);
        dfs_mid(root.right);
    }

    private static void dfs_post(TreeNode root) {
        if (null == root) {
            return;
        }

        dfs_post(root.left);
        dfs_post(root.right);
        System.out.print(root.value);
    }

    //使用栈实现dfs，但是顺序只能是先根遍历（root-left-right)或者（root-right-left),因为如论如何，都是在当前循环体访问节点值，并把子节点入栈，等待下次处理
    private static void dfs_stack(TreeNode node) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode current = node;
        deque.push(current);
        while (!deque.isEmpty()) {
            current = deque.pop();
            System.out.print(current.value);
            if (current.right != null) {
                deque.push(current.right);
            }
            if (current.left != null) {
                deque.push(current.left);
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
