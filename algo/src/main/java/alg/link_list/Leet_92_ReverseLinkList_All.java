package alg.link_list;

/**
 * 反转链表
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
public class Leet_92_ReverseLinkList_All {
    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
//        Node cursor = reverse_iterate(head, 3);
//        while (cursor != null) {
//            System.out.println(cursor.value);
//            cursor = cursor.next;
//        }


//        Node cursor2 = reverseKNode_iterate(head, 1, 4);
//        while (cursor2 != null) {
//            System.out.println(cursor2.value);
//            cursor2 = cursor2.next;
//        }

//        Node newHead = reverse_recursive(head, null);
        Node newHead3 = reverseKNode_recursive(head, 1,5);
        Node cursor3 = newHead3;
        while (cursor3 != null) {
            System.out.println(cursor3.value);
            cursor3 = cursor3.next;
        }
    }

    //https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/bu-bu-chai-jie-ru-he-di-gui-di-fan-zhuan-lian-biao/
    public static Node reverseKNode_recursive(Node head, int left, int right) {
        if (left == 1) {
            return reverse_iterate(head, right);
        }

        //因为窗口整体整体向后递归了，边界同时都变了，但是窗口大小不变
        //这个递归的作用就是不断从当前链表往后找，知道找到开始反转的开始位置，这时候再调用reverse_iterate(head, n);去完成子列表的前n个反转
        head.next = reverseKNode_recursive(head.next, left - 1, right-1);

        return head;
    }

    public static Node reverseKNode_iterate(Node head, int left, int right) {
        if (left == right) {
            return head;
        }
        //prev初始的时候最为链表尾巴，所以初始化成null
        Node prev = null;
        Node curr = head;
        int count = 1;
        Node leftTail = null;
        Node reversedSubTail = null;

        while (count < left) {
            leftTail = curr;
            curr = curr.next;
            count++;
        }

        while (curr != null && count <= right){
            if (count == left) {
                Node next = curr.next;
                curr.next = null;
                reversedSubTail = curr;
                prev = curr;
                curr = next;
            } else if (count >= left && count <= right) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            count++;
        }

        if (curr != null) {
            reversedSubTail.next = curr;
        }

        if (leftTail != null) {
            leftTail.next = prev;
            return head;
        } else {
            return prev;
        }

    }

    public static Node reverse_iterate(Node head, int k) {
        //prev初始的时候最为链表尾巴，所以初始化成null
        Node prev = null;
        Node curr = head;
        int count = 1;
        while (curr != null && count <= k){
            Node next = curr.next;
            curr.next = prev;
            //每次处理完一个，prev变成当前的，当前的变成下一个，下一个如果是null就结束了（到了链表尾部）。
            //所以上面有判断 curr != null
            prev = curr;
            curr = next;
            count++;
        }

        if (curr != null) {
            head.next = curr;
        }

        return prev;
    }

    public static Node reverse_recursive(Node head, Node prev) {
        //prev初始的时候最为链表尾巴，所以初始化成null
        Node curr = head;
        if (curr == null) {
            return prev;
        }
        Node next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        return reverse_recursive(curr, prev);
    }

    static class Node{
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
