public class ConvertBSTtoSortedDoublyLL {

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    static Node lastNode = null;

    static void buildLL (Node node) {
        if (node == null) return;
        buildLL(node.left);
        if (lastNode != null) lastNode.right = node;
        node.left = lastNode;
        lastNode = node;
        buildLL(node.right);
    }

    static public Node treeToDoublyList(Node root) {
        buildLL(root);

        Node firstNode = lastNode;
        while (firstNode.left != null) {
            firstNode = firstNode.left;
        }

        firstNode.left = lastNode;
        lastNode.right = firstNode;

        return lastNode.right;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(5);

        Node result = treeToDoublyList(root);

        for (int i = 0; i < 7; i++) {
            System.out.println(result.val);
            result = result.left;
        }
    }

}
