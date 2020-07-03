package Extras.HackerRank;

public class HeightOfBinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;
    }

    private static int height (Node root) {
        if (root == null) return -1;

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node();
        root.right = new Node();
        root.left = new Node();
        root.left.right = new Node();
        System.out.println(height(root));
    }

}
