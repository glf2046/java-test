package alg.recursive;

/**
 * 走楼梯
 */
public class StaircaseClimb {

    public static void main(String[] args) {
        System.out.println(new StaircaseClimb().climbStaircase(4));
    }

    public int climbStaircase(int n){
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        //这种由两个分支递归计算得到的结果，类似：f(k）= f(k-1) + f(k-2)
        //实质上就是一个二叉树，这道题目如果抽象成二叉树，那么其实就是：
        //一个二叉树，对于给定的总权重w，所有叶子节点到根节点路径上的权重之和小于w,
        // 问二叉树可以有多少个叶子节点（叶子节点有多少，那么从叶子节点一路回到根节点就是一种台阶走法。
        return climbStaircase(n - 1) + climbStaircase(n - 2);
    }
}
