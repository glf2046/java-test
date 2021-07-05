package alg.two_pointers.flow_fast_pointer;

/**
 * 141.�����л�������
 */
public class Leet_141_CycleLinkedList {
    public static void main(String[] args) {
        //1. ����ָ�뷨��Floyd ��Ȧ�㷨��
        /**
         * Ҫ�ж��б����Ƿ��л������Զ���һ����ָ��slowָ�������ͷ��㣬��ָ��fastָ��ͷ������һ����㡣Ȼ����ָ��slowÿ����ǰ�ƶ�һ��λ�ã���ָ��fastÿ����ǰ�ƶ�����λ�á���������������д��ڻ�����ָ��ͻ��Ƚ��뻷��Ȼ��׷����ָ�롣����˼·���ɿ����µĶ�����ʾ
         * ���ӣ�https://leetcode-cn.com/problems/linked-list-cycle/solution/dong-hua-yan-shi-141huan-xing-lian-biao-b99vd/
         */

        //2. ��ϣ��
        /**
         * �������뵽�ķ����Ǳ������нڵ㣬ÿ�α�����һ���ڵ�ʱ���жϸýڵ��ǰ�Ƿ񱻷��ʹ���
         *
         * ����أ����ǿ���ʹ�ù�ϣ�����洢�����Ѿ����ʹ��Ľڵ㡣ÿ�����ǵ���һ���ڵ㣬����ýڵ��Ѿ������ڹ�ϣ���У���˵���������ǻ�����������ͽ��ýڵ�����ϣ���С��ظ���һ���̣�ֱ�����Ǳ��������������ɡ�
         * ���ӣ�https://leetcode-cn.com/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode-solution/
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
