package alg.two_pointers.flow_fast_pointer;

/**
 * 876.单向链表的中间位置
 */
public class Leet_876_middle_of_link_list {
    public static void main(String[] args) {

    }

    /**
     *  快慢指针法
     * //    思路和算法
     * //
     * //    我们可以继续优化方法二，用两个指针 slow 与 fast 一起遍历链表。slow 一次走一步，fast 一次走两步。那么当 fast 到达链表的末尾时，slow 必然位于中间。
     * //
     * //    作者：LeetCode-Solution
     * //    链接：https://leetcode-cn.com/problems/middle-of-the-linked-list/solution/lian-biao-de-zhong-jian-jie-dian-by-leetcode-solut/
     * //    来源：力扣（LeetCode）
     * //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param
     * @return
     */


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
