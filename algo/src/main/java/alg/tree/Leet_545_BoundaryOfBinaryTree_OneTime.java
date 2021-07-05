package alg.tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Leet_545_BoundaryOfBinaryTree_OneTime {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        System.out.println(new Leet_545_BoundaryOfBinaryTree_OneTime().boundaryOfBinaryTree(root));
    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        LinkedList<Integer> list = new LinkedList<>();

        //1. root node
        list.add(root.val);

        //2. left boundary
        if (root.left != null) {
            list.addAll(leftSideBoundary(root.left));
        }
        System.out.println(list);

        //3. leaf nodes boundary
        if (root.left != null) {
            list.addAll(leafNodes(root.left));
        }
        if (root.right != null) {
            list.addAll(leafNodes(root.right));
        }
        
        System.out.println(list);


        //4. reverse order of right nodes boundary
        if (root.right != null) {
            List<Integer> rightList = rightSideBoundary(root.right);
            Collections.reverse(rightList);
            list.addAll(rightList);
        }

        return list;
    }

    //root node is not leaf node
    private List<Integer> leafNodes(TreeNode node) {
        List<Integer> list = new LinkedList<>();
        if (node.left == null && node.right == null) {
            list.add(node.val);
        }

        if (node.left != null) {
            list.addAll(leafNodes(node.left));
        }

        if (node.right != null){
            list.addAll(leafNodes(node.right));
        }

        return list;
    }


    private LinkedList<Integer> leftSideBoundary(TreeNode node) {
        LinkedList<Integer> list = new LinkedList<>();
        if (node.left != null || node.right != null) {
            list.add(node.val);
        }

        if (node.left != null) {
            list.addAll(leftSideBoundary(node.left));
        } else if (node.right != null) {
            list.addAll(leftSideBoundary(node.right));
        }

        return list;
    }

    private LinkedList<Integer> rightSideBoundary(TreeNode node) {
        LinkedList<Integer> list = new LinkedList<>();
        if (node.left != null || node.right != null) {
            list.add(node.val);
        }

        if (node.right != null) {
            list.addAll(rightSideBoundary(node.right));
        } else if (node.left != null) {
            list.addAll(rightSideBoundary(node.left));
        }

        return list;
    }

    static class TreeNode {
        public TreeNode(int value) {
            this.val = value;
        }

        int val;

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        TreeNode left;
        TreeNode right;
    }
}
