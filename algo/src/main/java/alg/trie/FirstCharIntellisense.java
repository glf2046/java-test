package alg;

public class FirstCharIntellisense {
    public static void main(String[] args) {

        String[] strArr = {"a", "ab", "ac", "ad", "abc", "abd", "abe", "acd", "ace", "abcde", "bc", "bd", "bcd", "bce", "bde", "bcde"};
        Node root = new Node(null, null,'a', true);
        for(String item : strArr){
            buildNode(item, root);
        }
        print(root);
    }

    private static void print(Node node) {
        Node startingNode = node;
        do {
            System.out.print(node.value + "         ");
        } while ((node = node.next) != null);
        System.out.println();
        System.out.println("#######");

        do {
            print(startingNode.childNode);
        } while ((startingNode = startingNode.next) != null);
        System.out.println("#######");
    }


    /*
    1. Get the string e.g. "abc",
    2. If length < 1, return; else go to 3#
    3. Loop through all the nodes starting from input starting 'node', if added, get the node and point 'node' to its child node and go to 2#
    4. If not added, then loop to the end of this level, add current char to end, then get current node and point 'node to its child node and go to 2#
    */

    private static void buildNode(String s, Node node) {
        int len = s.length();
        if (len < 1)
            return;

        boolean added = false;
        char c = s.charAt(0);
        Node lastValidNode = null;

        do {
            if (node.value == c) {
                added = true;
                if(len > 1){
                    if(node.childNode == null){
                        node.childNode = new Node(null, null, s.charAt(1), len == 2);
                    }
                    buildNode(s.substring(1, len), node.childNode);
                }
                break;
            }
            lastValidNode = node;
            node = node.next;
        } while (node!= null);

        node = lastValidNode;

        if (!added) {
            Node newNode;
            if (len == 1) {
                newNode = new Node(new Node(), null, c, true);
            } else {
                newNode = new Node(new Node(null, null, s.charAt(1), len == 2), null, c, false);
            }
            node.next = newNode;
            if(len > 1){
                if(node.childNode == null){
                    node.childNode = new Node(null, null, s.charAt(1), len == 2);
                }
                buildNode(s.substring(1, len), node.childNode);
            }
        }
    }

    private static void search(){

    }

    static class Node{
        Node childNode;
        Node next;
        char value;
        boolean complete;

        public Node() {
        }

        public Node(Node childNode, Node next, char value, boolean complete) {
            this.childNode = childNode;
            this.next = next;
            this.value = value;
            this.complete = complete;
        }
    }
}
