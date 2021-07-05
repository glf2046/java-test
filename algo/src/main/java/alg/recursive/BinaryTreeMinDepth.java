package alg.recursive;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 二叉树叶子节点到根节点最短距离
 */
public class BinaryTreeMinDepth {

    public static void main(String[] args) {
        System.out.println(nodeCount(buildTree()));
        System.out.println(new BinaryTreeMinDepth().minDepth(buildTree()));
        System.out.println(new BinaryTreeMinDepth().bfs(buildTree()));
    }

    /**
     * 计算二叉树的节点个数
     * @param root
     * @return
     */
    public static int nodeCount(TreeNode root) {
        int sum = 0;
        if (root.left != null) {
            sum += nodeCount(root.left);
        }

        if (root.right != null) {
            sum += nodeCount(root.right);
        }

        sum += 1;

        return sum;
    }

    /**
     * 解法1：
     * 递归，每产生一次递归，都意味着深度加1，这些1累加起来之后就是当前节点到根节点的深度（也就是递归的层数）。
     * 然后对于每个当前节点，它下面所有的子节点到根节点的最小深度就是：当前节点到跟阶段的深度+min(左子节点到当前节点的最小距离，右子节点到当前节点的最小距离)
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    public int bfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        Queue<TreeNode> queue1 = new ArrayDeque<>();
        Queue<TreeNode> queue2 = new ArrayDeque<>();
        TreeNode temp;
        int depth = 0;

        queue1.add(node);

        while ((temp = queue1.poll()) != null) {
            if (temp.left == null && temp.right == null) {
                return depth;
            }

            if (temp.left != null) {
                queue2.add(temp.left);
            }
            if (temp.right != null) {
                queue2.add(temp.right);
            }

            if (queue1.isEmpty()) {
                depth++;
                swap(queue1, queue2);
            }
        }

        return depth;
    }

    private void swap(Queue<TreeNode> queue1, Queue<TreeNode> queue2) {
        Queue<TreeNode> temp = new ArrayDeque<>();
        queue1.forEach(item -> temp.add(item));

        queue1.clear();

        queue2.forEach(item -> queue1.add(item));
        queue2.clear();

        temp.forEach(item -> queue2.add(item));
    }

    private static TreeNode buildTree() {
        TreeNode t5 = new TreeNode(null, null, 5);
        TreeNode t6 = new TreeNode(null, null, 6);
        TreeNode t2 = new TreeNode(t5, t6, 2);
//        TreeNode t2 = new TreeNode(null, null, 2);

        TreeNode t7 = new TreeNode(null, null, 7);
        TreeNode t8 = new TreeNode(null, null, 8);
        TreeNode t9 = new TreeNode(null, null, 9);
        TreeNode t3 = new TreeNode(t7, t8, 3);
        TreeNode t4 = new TreeNode(t9, null, 4);
        TreeNode t1 = new TreeNode(t3, t4, 1);
        TreeNode t0 = new TreeNode(t1, t2, 0);
        TreeNode root = t0;

        return root;
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

}
