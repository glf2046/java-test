package alg.link_list;

public class Leet_25_reverse_nodes_in_k_group {
    public static void main(String[] args) {
        Node head = new Node(new Node(new Node(new Node(new Node(null, 5), 4), 3), 2), 1);
        Node current;
        current = reverseKGroup(head, 2);
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    private static Node reverseKGroup(Node head, int k) {
        //当前处理的节点
        Node current = head;

        //已经临时处理好的逆序前部分的尾巴
        Node tempTail = head;

        //已经临时处理好的逆序前部分的头
        Node tempHead = head;

        int i = 0;
        Node tempNext = null;
        while (i++ < k && current != null) {
            if (i % k == 0) {
                tempTail = current;
            }

            if (current != tempHead) {
                tempHead = current;
                tempNext = current.next;
                tempTail.next = tempNext;
                current.next = tempTail;
                head = tempHead;
                current = tempNext;
            }
        }
        return head;
    }

    static class Node {
        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        Node next;

        int value;

        public Node(Node next, int value) {
            this.next = next;
            this.value = value;
        }
    }
}
