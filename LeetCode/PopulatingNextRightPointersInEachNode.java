public class PopulatingNextRightPointersInEachNode {

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    private static Node connect(Node root) {
        if (root == null) return null;

        int treeHeight = -1;
        Node temp = root;
        while (temp != null) {
            treeHeight++;
            temp = temp.left;
        }

        traverse(root, treeHeight);

        return root;
    }

    private static void traverse(Node root, int currentHeight) {
        if (root.left != null) {
            root.left.next = root.right;
        } else {
            return;
        }
        for (int i = 1; i < currentHeight; i++) {
            Node left = getNodeAtHeightToLeft(i, root.left);
            Node right = getNodeAtHeightToRight(i, root.right);

            left.next = right;
        }
        if (root.left != null) {
            traverse(root.left, currentHeight-1);
            traverse(root.right, currentHeight-1);
        }
    }

    private static Node getNodeAtHeightToLeft(int currentHeight, Node root) {
        if (currentHeight == 0) return root;

        return getNodeAtHeightToLeft(currentHeight-1, root.right);
    }

    private static Node getNodeAtHeightToRight(int currentHeight, Node root) {
        if (currentHeight == 0) return root;

        return getNodeAtHeightToRight(currentHeight-1, root.left);
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);

        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);

        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);

        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);

        root = connect(root);

        System.out.println(root);
    }

}
