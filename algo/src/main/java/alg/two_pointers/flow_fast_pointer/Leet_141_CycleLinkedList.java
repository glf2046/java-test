package alg.two_pointers.flow_fast_pointer;

/**
 * 141.链表有环的问题
 */
public class Leet_141_CycleLinkedList {
    public static void main(String[] args) {
        //1. 快慢指针法（Floyd 判圈算法）
        /**
         * 要判断列表中是否有环，可以定义一个慢指针slow指向链表的头结点，快指针fast指向头结点的下一个结点。然后，慢指针slow每次向前移动一个位置，快指针fast每次向前移动两个位置。这样，如果链表中存在环，快指针就会先进入环，然后追上慢指针。具体思路，可看如下的动画演示
         * 链接：https://leetcode-cn.com/problems/linked-list-cycle/solution/dong-hua-yan-shi-141huan-xing-lian-biao-b99vd/
         */

        //2. 哈希表
        /**
         * 最容易想到的方法是遍历所有节点，每次遍历到一个节点时，判断该节点此前是否被访问过。
         *
         * 具体地，我们可以使用哈希表来存储所有已经访问过的节点。每次我们到达一个节点，如果该节点已经存在于哈希表中，则说明该链表是环形链表，否则就将该节点加入哈希表中。重复这一过程，直到我们遍历完整个链表即可。
         * 链接：https://leetcode-cn.com/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode-solution/
         */
        Node head = buildLinkedListWithCycle();
        Node head2 = buildLinkedListWithoutCycle();
        System.out.println(containsCycle(head));
        System.out.println(containsCycle(head2));
    }

    private static Node buildLinkedListWithoutCycle() {
        Node head = new Node(1);
        head.setNext(new Node(2));
        head.getNext().setNext(new Node(3));

        return head;
    }

    public static boolean containsCycle(Node head){
        if (head == null || head.getNext() == null) {
            return false;
        }

        Node slow = head;
        Node fast = head.getNext();

        while ( slow != fast) {
            if (slow == null || fast == null) {
                return false;
            }
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return true;
    }

    private static Node buildLinkedListWithCycle() {
        Node head = new Node(1);
        head.setNext(new Node(2));
        head.getNext().setNext(head);

        return head;
    }

    static class Node{
        int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        Node next;

        Node(int value){
            this.value = value;
            next = null;
        }
    }
}
